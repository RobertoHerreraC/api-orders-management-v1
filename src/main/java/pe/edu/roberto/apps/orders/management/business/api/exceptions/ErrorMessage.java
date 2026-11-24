package pe.edu.roberto.apps.orders.management.business.api.exceptions;

import lombok.Builder;

@Builder
public record ErrorMessage(
        String error,
        String message,
        Integer code
) {
}
