package com.example.clinica.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(ex: NotFoundException): ProblemDetail {
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.message ?: "Recurso não encontrado")
            .apply {
                title = "Recurso Não Encontrado"
            }
    }

    @ExceptionHandler(AgendamentoException::class)
    fun handleAgendamentoException(ex: AgendamentoException): ProblemDetail {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.message ?: "Erro na regra de negócio")
            .apply {
                title = "Erro de Validação de Agendamento"
            }
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationExceptions(ex: MethodArgumentNotValidException): ProblemDetail {
        val erros = mutableMapOf<String, String?>()
        ex.bindingResult.fieldErrors.forEach { error ->
            erros[error.field] = error.defaultMessage
        }

        val problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "Erro de validação nos campos da requisição")
        problemDetail.title = "Dados Inválidos"
        problemDetail.setProperty("erros", erros)
        return problemDetail
    }

    @ExceptionHandler(Exception::class)
    fun handleGenericException(ex: Exception): ProblemDetail {
        return ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, "Ocorreu um erro interno inesperado no servidor.")
            .apply {
                title = "Erro Interno"
            }
    }
}