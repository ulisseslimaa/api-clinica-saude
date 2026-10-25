package com.example.clinica.controller

import com.example.clinica.dto.NovoMedicoRequest
import com.example.clinica.model.Medico
import com.example.clinica.service.MedicoService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/medicos")
class MedicoController(
    private val medicoService: MedicoService
) {

    @GetMapping
    fun listar(): List<Medico> {
        return medicoService.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(
        @PathVariable id: Long
    ): Medico {
        return medicoService.buscarPorId(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun cadastrar(
        @RequestBody @Valid request: NovoMedicoRequest
    ): Medico {
        return medicoService.cadastrar(request)
    }
}