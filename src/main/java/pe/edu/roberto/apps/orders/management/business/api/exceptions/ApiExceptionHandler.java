package pe.edu.roberto.apps.orders.management.business.api.exceptions;

import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class ApiExceptionHandler {

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler({
            BadRequestException.class
    })
    @ResponseBody
    public ErrorMessage badRequest(Exception exception){
        return new ErrorMessage(exception.toString(), exception.getMessage(), BAD_REQUEST.value());
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler({
            MethodArgumentNotValidException.class
    })
    @ResponseBody
    public ValidationErrorMessage handlerValidationExceptions(MethodArgumentNotValidException ex){
        var errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> new ValidationError(error.getField(),error.getDefaultMessage()))
                .collect(Collectors.toList());

        return new ValidationErrorMessage("Validation failed", errors);
    }
}
