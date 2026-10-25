package com.example.clinica.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

data class NovoPacienteRequest(
    @field:NotBlank(message = "O nome é obrigatório.")
    @field:Size(min = 3, max = 150, message = "O nome deve ter entre 3 e 150 caracteres.")
    val nome: String,

    @field:NotBlank(message = "O e-mail é obrigatório.")
    @field:Email(message = "Formato de e-mail inválido.")
    val email: String,

    @field:NotBlank(message = "O CPF é obrigatório.")
    @field:Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "Formato de CPF inválido. Utilize o padrão 000.000.000-00.")
    val cpf: String,

    @field:NotBlank(message = "O telefone é obrigatório.")
    val telefone: String
)