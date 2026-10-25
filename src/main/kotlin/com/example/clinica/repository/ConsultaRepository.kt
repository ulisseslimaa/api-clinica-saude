package com.example.clinica.repository

import com.example.clinica.model.Consulta
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ConsultaRepository : JpaRepository<Consulta, Long>