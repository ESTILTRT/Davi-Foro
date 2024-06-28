package com.david.foro.Infra.Errors;

import com.david.foro.Infra.Errors.Excepciones.ReglasException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TrataDeErrores {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErrpr404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity tratarErrores(Exception e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(ReglasException.class)
    public ResponseEntity reompeReles(Exception e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarErrpr400(MethodArgumentNotValidException e){
        var errores = e.getFieldErrors().stream()
                .map(DatosErrorValidacion::new).toList();

        return ResponseEntity.badRequest().body(errores);
    }

    private record DatosErrorValidacion(String campo, String error){
        public DatosErrorValidacion(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
