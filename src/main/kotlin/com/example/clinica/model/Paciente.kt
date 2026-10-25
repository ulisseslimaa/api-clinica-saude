package com.example.clinica.model

import jakarta.persistence.*

@Entity
@Table(name = "pacientes")
data class Paciente(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    val nome: String,
    val email: String,
    val cpf: String,
    val telefone: String
) {
    constructor() : this(null, "", "", "", "")
}