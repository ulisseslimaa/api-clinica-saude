package com.example.clinica.dto

import com.example.clinica.model.Especialidade
import com.example.clinica.model.StatusConsulta

data class ConsultaResponse(
    val id: Long?,
    val nomeMedico: String,
    val especialidadeMedico: Especialidade,
    val nomePaciente: String,
    val data: String,
    val hora: Int,
    val status: StatusConsulta
)