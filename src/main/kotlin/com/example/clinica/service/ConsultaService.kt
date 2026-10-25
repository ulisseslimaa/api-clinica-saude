package com.example.clinica.service

import com.example.clinica.dto.AgendamentoConsultaRequest
import com.example.clinica.dto.CancelamentoConsultaRequest
import com.example.clinica.dto.ConsultaResponse
import com.example.clinica.exception.AgendamentoException
import com.example.clinica.exception.NotFoundException
import com.example.clinica.mapper.toResponse
import com.example.clinica.model.Consulta
import com.example.clinica.model.StatusConsulta
import com.example.clinica.repository.ConsultaRepository
import org.springframework.stereotype.Service

@Service
class ConsultaService(
    private val consultaRepository: ConsultaRepository,
    private val medicoService: MedicoService,
    private val pacienteService: PacienteService
) {

    fun listar(): List<ConsultaResponse> {
        return consultaRepository.findAll().map { it.toResponse() }
    }

    fun agendar(request: AgendamentoConsultaRequest): ConsultaResponse {
        if (request.hora < 8 || request.hora > 18) {
            throw AgendamentoException("A consulta deve ser agendada entre 8h e 18h.")
        }

        val medico = medicoService.buscarPorId(request.medicoId)
        val paciente = pacienteService.buscarPorId(request.pacienteId)

        val consultasExistentes = consultaRepository.findAll()

        val medicoOcupado = consultasExistentes.any {
            it.medico.id == medico.id &&
                    it.data == request.data &&
                    it.hora == request.hora &&
                    it.status == StatusConsulta.AGENDADA
        }
        if (medicoOcupado) {
            throw AgendamentoException("O médico já possui uma consulta agendada nesse horário.")
        }

        val pacienteTemConsultaNoDia = consultasExistentes.any {
            it.paciente.id == paciente.id &&
                    it.data == request.data &&
                    it.status == StatusConsulta.AGENDADA
        }
        if (pacienteTemConsultaNoDia) {
            throw AgendamentoException("O paciente já possui uma consulta agendada nesta mesma data.")
        }

        val consulta = Consulta(
            medico = medico,
            paciente = paciente,
            data = request.data,
            hora = request.hora,
            status = StatusConsulta.AGENDADA
        )

        val salva = consultaRepository.save(consulta)
        return salva.toResponse()
    }

    fun cancelar(request: CancelamentoConsultaRequest) {
        val consulta = consultaRepository.findById(request.consultaId)
            .orElseThrow { NotFoundException("Consulta com ID ${request.consultaId} não encontrada.") }

        consulta.status = StatusConsulta.CANCELADA
        consulta.motivoCancelamento = request.motivo
        consultaRepository.save(consulta)
    }
}