package com.example.clinica.service

import com.example.clinica.dto.NovoMedicoRequest
import com.example.clinica.exception.NotFoundException
import com.example.clinica.mapper.toModel
import com.example.clinica.model.Medico
import com.example.clinica.repository.MedicoRepository
import org.springframework.stereotype.Service

@Service
class MedicoService(
    private val medicoRepository: MedicoRepository
) {

    fun listar(): List<Medico> = medicoRepository.findAll()

    fun cadastrar(request: NovoMedicoRequest): Medico {
        val medico = request.toModel()
        return medicoRepository.save(medico)
    }

    fun buscarPorId(id: Long): Medico {
        return medicoRepository.findById(id)
            .orElseThrow { NotFoundException("Médico com ID $id não encontrado.") }
    }
}