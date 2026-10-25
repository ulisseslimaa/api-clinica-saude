package com.example.clinica.model

import jakarta.persistence.*

@Entity
@Table(name = "medicos")
data class Medico(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    val nome: String,
    val email: String,
    val crm: String,
    @Enumerated(EnumType.STRING)
    val especialidade: Especialidade
) {
    constructor() : this(null, "", "", "", Especialidade.CARDIOLOGIA)
}