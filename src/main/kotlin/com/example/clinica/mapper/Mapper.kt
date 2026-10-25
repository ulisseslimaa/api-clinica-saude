package com.example.clinica.mapper

import com.example.clinica.dto.NovoMedicoRequest
import com.example.clinica.dto.NovoPacienteRequest
import com.example.clinica.dto.ConsultaResponse
import com.example.clinica.model.Consulta
import com.example.clinica.model.Medico
import com.example.clinica.model.Paciente

fun NovoMedicoRequest.toModel(): Medico {
    return Medico(
        nome = this.nome,
        email = this.email,
        crm = this.crm,
        especialidade = this.especialidade
    )
}

fun NovoPacienteRequest.toModel(): Paciente {
    return Paciente(
        nome = this.nome,
        email = this.email,
        cpf = this.cpf,
        telefone = this.telefone
    )
}

fun Consulta.toResponse(): ConsultaResponse {
    return ConsultaResponse(
        id = this.id,
        nomeMedico = this.medico.nome,
        especialidadeMedico = this.medico.especialidade,
        nomePaciente = this.paciente.nome,
        data = this.data,
        hora = this.hora,
        status = this.status
    )
}