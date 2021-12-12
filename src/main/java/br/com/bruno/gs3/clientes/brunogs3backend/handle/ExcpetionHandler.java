package br.com.bruno.gs3.clientes.brunogs3backend.handle;

import br.com.bruno.gs3.clientes.brunogs3backend.dto.RetornoErroDTO;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.ws.rs.NotFoundException;

@ControllerAdvice
public class ExcpetionHandler {

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<RetornoErroDTO> notFound(NotFoundException e) {
        return new ResponseEntity<>(new RetornoErroDTO(HttpStatus.NOT_FOUND.value(), e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = DuplicateKeyException.class)
    public ResponseEntity<RetornoErroDTO> notFound(DuplicateKeyException e) {
        return new ResponseEntity<>(new RetornoErroDTO(HttpStatus.BAD_REQUEST.value(), e.getMessage()), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<RetornoErroDTO> notFound(MethodArgumentNotValidException e) {
        return new ResponseEntity<>(new RetornoErroDTO(HttpStatus.BAD_REQUEST.value(), e.getBindingResult().getAllErrors().get(0).getDefaultMessage()), HttpStatus.BAD_REQUEST);
    }


}
