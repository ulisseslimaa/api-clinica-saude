package com.example.clinica.service

import com.example.clinica.dto.NovoPacienteRequest
import com.example.clinica.exception.NotFoundException
import com.example.clinica.mapper.toModel
import com.example.clinica.model.Paciente
import com.example.clinica.repository.PacienteRepository
import org.springframework.stereotype.Service

@Service
class PacienteService(
    private val pacienteRepository: PacienteRepository
) {

    fun listar(): List<Paciente> = pacienteRepository.findAll()

    fun cadastrar(request: NovoPacienteRequest): Paciente {
        val paciente = request.toModel()
        return pacienteRepository.save(paciente)
    }

    fun buscarPorId(id: Long): Paciente {
        return pacienteRepository.findById(id)
            .orElseThrow { NotFoundException("Paciente com ID $id não encontrado.") }
    }
}