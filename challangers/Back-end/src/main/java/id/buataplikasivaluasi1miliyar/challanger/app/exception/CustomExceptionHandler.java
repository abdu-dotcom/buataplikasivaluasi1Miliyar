package id.buataplikasivaluasi1miliyar.challanger.app.exception;

import id.buataplikasivaluasi1miliyar.challanger.app.utils.DateFormatter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleBusinessException(BusinessException ex) {
        return createErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(InternalServerErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handleInternalServerError(InternalServerErrorException ex) {
        return createErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, Object> handleResourceNotFound(ResourceNotFoundException ex) {
        return createErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(DuplicateDataException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, Object> handleDuplicateDataException(DuplicateDataException ex) {
        return createErrorResponse(HttpStatus.CONFLICT, ex.getMessage());
    }

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Map<String, Object> handleUnauthorizedException(UnauthorizedException ex) {
        return createErrorResponse(HttpStatus.UNAUTHORIZED, ex.getMessage());
    }

    // Helper untuk membuat response error dengan urutan yang diinginkan
    private Map<String, Object> createErrorResponse(HttpStatus status, String message) {
        Map<String, Object> errorResponse = new LinkedHashMap<>(); // Pakai LinkedHashMap agar urutannya tetap
        errorResponse.put("status", status.value());
        errorResponse.put("timestamp", DateFormatter.formatDateTime(LocalDateTime.now()));
        errorResponse.put("error", status.getReasonPhrase());
        errorResponse.put("message", message);
        return errorResponse;
    }

    // Custom Exception Classes dengan Lombok
    @Getter
    @RequiredArgsConstructor
    public static class BusinessException extends RuntimeException {
        private final String message;
    }

    @Getter
    @RequiredArgsConstructor
    public static class InternalServerErrorException extends RuntimeException {
        private final String message;
    }

    @Getter
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public static class ResourceNotFoundException extends RuntimeException {
        private String resourceName;
        private String fieldName;

        // Constructor lama (masih bisa digunakan)
        public ResourceNotFoundException(String message) {
            super(message);
        }

        public ResourceNotFoundException(String resourceName, String fieldName) {
            super(resourceName + " not found with " + fieldName);
            this.resourceName = resourceName;
            this.fieldName = fieldName;
        }
    }

    @Getter
    @ResponseStatus(HttpStatus.CONFLICT) // 409 Conflict
    public static class DuplicateDataException extends RuntimeException {
        private final String userId;
        private final Integer challengeId;

        public DuplicateDataException(String userId, Integer challengeId) {
            super(String.format("userId %s has entered the challenge with id '%s'", userId, challengeId));
            this.userId = userId;
            this.challengeId = challengeId;
        }
    }

    @Getter
    @RequiredArgsConstructor
    public static class UnauthorizedException extends RuntimeException {
        private final String message;
    }

    @Getter
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public static class DatabaseException extends RuntimeException {
        public DatabaseException(String message) {
            super(message);
        }
    }
}
