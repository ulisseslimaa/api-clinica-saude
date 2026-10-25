package com.example.clinica.dto

import com.example.clinica.model.Especialidade
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

data class NovoMedicoRequest(
    @field:NotBlank(message = "O nome é obrigatório.")
    @field:Size(min = 3, max = 150, message = "O nome deve ter entre 3 e 150 caracteres.")
    val nome: String,

    @field:NotBlank(message = "O e-mail é obrigatório.")
    @field:Email(message = "Formato de e-mail inválido.")
    val email: String,

    @field:NotBlank(message = "O CRM é obrigatório.")
    @field:Pattern(regexp = "\\d+/[A-Z]{2}", message = "Formato de CRM inválido. Utilize o padrão (Ex: 123456/SP).")
    val crm: String,

    @field:NotNull(message = "A especialidade é obrigatória.")
    val especialidade: Especialidade
)