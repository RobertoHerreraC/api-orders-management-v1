package pe.edu.roberto.apps.orders.management.business.api.exceptions;

import java.util.List;

public record ValidationErrorMessage(
        String message,
        List<ValidationError> errors
) {
}
