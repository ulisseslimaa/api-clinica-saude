package com.example.clinica.controller

import com.example.clinica.dto.NovoPacienteRequest
import com.example.clinica.model.Paciente
import com.example.clinica.service.PacienteService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/pacientes")
class PacienteController(
    private val pacienteService: PacienteService
) {

    @GetMapping
    fun listar(): List<Paciente> {
        return pacienteService.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(
        @PathVariable id: Long
    ): Paciente {
        return pacienteService.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(
        @RequestBody @Valid request: NovoPacienteRequest
    ): Paciente {
        return pacienteService.cadastrar(request)
    }
}