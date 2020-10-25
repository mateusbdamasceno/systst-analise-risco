package br.com.tst.web.rest.errors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.tst.web.rest.vm.ErrorVM;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorVM handleConstraintViolationException(
            ConstraintViolationException ex, HttpServletRequest request) {
        ErrorVM vm = new ErrorVM(HttpStatus.BAD_REQUEST);
        vm.setMessage("Validation Failed");
        vm.setPath(request.getRequestURI());
        vm.setTrace(ex.toString());

        ex.getConstraintViolations()
                .forEach(v -> vm.addViolation(v.getPropertyPath().toString(), v.getMessage()));

        return vm;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorVM handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex, HttpServletRequest request) {
        ErrorVM vm = new ErrorVM(HttpStatus.BAD_REQUEST);
        vm.setMessage("Validation Failed");
        vm.setPath(request.getRequestURI());
        vm.setTrace(ex.toString());

        ex.getBindingResult()
                .getGlobalErrors()
                .forEach(e -> vm.addViolation(e.getObjectName(), e.getDefaultMessage()));

        ex.getBindingResult()
                .getFieldErrors()
                .forEach(e -> vm.addViolation(e.getField(), e.getDefaultMessage()));

        return vm;
    }
}
