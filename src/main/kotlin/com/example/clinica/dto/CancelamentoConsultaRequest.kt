package com.example.clinica.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class CancelamentoConsultaRequest(
    @field:NotNull(message = "O ID da consulta é obrigatório.")
    val consultaId: Long,

    @field:NotBlank(message = "O motivo do cancelamento é obrigatório.")
    val motivo: String
)