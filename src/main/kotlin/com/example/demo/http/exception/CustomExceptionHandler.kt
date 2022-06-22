package com.example.demo.http.exception

import com.example.demo.http.dto.ErrorView
import com.example.demo.domain.exceptions.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class CustomExceptionHandler {

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun processNotFoundException(exception: NotFoundException, request: HttpServletRequest) = ErrorView(
        status = HttpStatus.NOT_FOUND.value(),
        error = HttpStatus.NOT_FOUND.name,
        message = exception.message,
        path = request.servletPath
    )

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun processServerErrorException(exception: Exception, request: HttpServletRequest) = ErrorView(
        status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
        error = HttpStatus.INTERNAL_SERVER_ERROR.name,
        message = exception.message,
        path = request.servletPath
    )

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun processBeanValidationExceptions(exception: MethodArgumentNotValidException, request: HttpServletRequest) = let {

        val errorMessage = HashMap<String, String?>()
        exception.bindingResult.fieldErrors.forEach {
            errorMessage[it.field] = it.defaultMessage
        }

        ErrorView(
            status = HttpStatus.BAD_REQUEST.value(),
            error = HttpStatus.BAD_REQUEST.name,
            path = request.servletPath,
            messageList = errorMessage
        )
    }
}