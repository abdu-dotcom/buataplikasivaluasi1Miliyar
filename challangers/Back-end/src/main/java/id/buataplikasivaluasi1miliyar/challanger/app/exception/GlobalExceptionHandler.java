package id.buataplikasivaluasi1miliyar.challanger.app.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handle Resource Not Found (e.g., User, Challenge, etc.)
    @ExceptionHandler(CustomExceptionHandler.ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(CustomExceptionHandler.ResourceNotFoundException ex) {
        log.error("❌ Resource Not Found: {}", ex.getMessage());
        return buildErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    // Handle Business Logic Errors (e.g., Challenge deadline missed)
    @ExceptionHandler(CustomExceptionHandler.BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(CustomExceptionHandler.BusinessException ex) {
        log.warn("⚠️ Business Exception: {}", ex.getMessage());
        return buildErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    // Handle Validation Errors (e.g., Invalid input format)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

        log.warn("⚠️ Validation Error: {}", errors);
        return buildErrorResponse(HttpStatus.BAD_REQUEST, "Validation Error", errors);
    }

    // Handle Unauthorized Access (e.g., User trying to complete challenge without permission)
    @ExceptionHandler(CustomExceptionHandler.UnauthorizedException.class)
    public ResponseEntity<ErrorResponse> handleUnauthorizedException(CustomExceptionHandler.UnauthorizedException ex) {
        log.warn("🔒 Unauthorized Access: {}", ex.getMessage());
        return buildErrorResponse(HttpStatus.UNAUTHORIZED, ex.getMessage());
    }

    // Handle Database Errors (e.g., Connection Issues)
    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<ErrorResponse> handleDatabaseException(DataAccessException ex) {
        log.error("❌ Database Error: {}", ex.getMessage());
        return buildErrorResponse(HttpStatus.SERVICE_UNAVAILABLE, "Database Connection Error");
    }

    // Handle Generic Errors (e.g., Unexpected exceptions)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex) {
        log.error("🔥 Unhandled Exception: ", ex);
        return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
    }

    // Utility method to build API error responses
    private ResponseEntity<ErrorResponse> buildErrorResponse(HttpStatus status, String message) {
        return ResponseEntity.status(status).body(new ErrorResponse(status.value(), status.getReasonPhrase(), message));
    }

    private ResponseEntity<ErrorResponse> buildErrorResponse(HttpStatus status, String message, List<String> details) {
        return ResponseEntity.status(status).body(new ErrorResponse(status.value(), status.getReasonPhrase(), message, details));
    }
}
