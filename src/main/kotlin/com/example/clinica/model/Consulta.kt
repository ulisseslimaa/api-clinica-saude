package com.example.clinica.model

import jakarta.persistence.*

@Entity
@Table(name = "consultas")
data class Consulta(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "medico_id")
    val medico: Medico,

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    val paciente: Paciente,

    val data: String,
    val hora: Int,

    @Enumerated(EnumType.STRING)
    var status: StatusConsulta = StatusConsulta.AGENDADA,

    var motivoCancelamento: String? = null
) {
    constructor() : this(null, Medico(), Paciente(), "", 0, StatusConsulta.AGENDADA, null)
}