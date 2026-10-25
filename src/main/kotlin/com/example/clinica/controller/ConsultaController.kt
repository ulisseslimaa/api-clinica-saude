package com.example.clinica.controller

import com.example.clinica.dto.AgendamentoConsultaRequest
import com.example.clinica.dto.CancelamentoConsultaRequest
import com.example.clinica.dto.ConsultaResponse
import com.example.clinica.service.ConsultaService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/consultas")
class ConsultaController(
    private val consultaService: ConsultaService
) {

    @GetMapping
    fun listar(): List<ConsultaResponse> {
        return consultaService.listar()
    }

    @PostMapping
    fun agendar(
        @RequestBody @Valid request: AgendamentoConsultaRequest
    ): ConsultaResponse {
        return consultaService.agendar(request)
    }

    @PostMapping("/cancelar")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun cancelar(
        @RequestBody @Valid request: CancelamentoConsultaRequest
    ) {
        consultaService.cancelar(request)
    }
}