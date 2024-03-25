package br.com.challenge.corretora.exception;

import br.com.challenge.corretora.dto.ErrorDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
@Getter
@Setter
@ControllerAdvice(basePackages = "br.com.challenge.corretora.controller")
public class ClienteControllerAdvice {
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ClienteNotFoundException.class)
    public ErrorDTO handleUserNotFound(ClienteNotFoundException clienteNotFoundException) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
        errorDTO.setMessage("Cliente não encontrado." + clienteNotFoundException.getMessage());
        errorDTO.setTimestamp(LocalDateTime.now());
        return errorDTO;
    }
}
