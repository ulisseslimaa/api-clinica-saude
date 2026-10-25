package com.example.clinica.dto

import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class AgendamentoConsultaRequest(
    @field:NotNull(message = "O ID do médico é obrigatório.")
    val medicoId: Long,

    @field:NotNull(message = "O ID do paciente é obrigatório.")
    val pacienteId: Long,

    @field:NotBlank(message = "A data é obrigatória.")
    val data: String, // Formato "AAAA-MM-DD"

    @field:NotNull(message = "A hora é obrigatória.")
    @field:Min(value = 0, message = "A hora mínima é 0.")
    @field:Max(value = 23, message = "A hora máxima é 23.")
    val hora: Int
)