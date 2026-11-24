package pe.edu.roberto.apps.orders.management.business.api.exceptions;

public record ValidationError(
        String field,
        String message
) {
}
