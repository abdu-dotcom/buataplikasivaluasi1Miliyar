package id.buataplikasivaluasi1miliyar.challanger.app.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // Handle Resource Not Found (e.g., User, Challenge, etc.)
    @ExceptionHandler(CustomExceptionHandler.ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(CustomExceptionHandler.ResourceNotFoundException ex) {
        logger.error("Resource not found: {}", ex.getMessage());
        return buildErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    // Handle Business Logic Errors (e.g., Challenge deadline missed)
    @ExceptionHandler(CustomExceptionHandler.BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(CustomExceptionHandler.BusinessException ex) {
        logger.warn("Business error: {}", ex.getMessage());
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

        logger.warn("Validation errors: {}", errors);
        return buildErrorResponse(HttpStatus.BAD_REQUEST, "Validation Error", errors);
    }

    // Handle Unauthorized Access (e.g., User trying to complete challenge without permission)
    @ExceptionHandler(CustomExceptionHandler.UnauthorizedException.class)
    public ResponseEntity<ErrorResponse> handleUnauthorizedException(CustomExceptionHandler.UnauthorizedException ex) {
        logger.warn("Unauthorized access: {}", ex.getMessage());
        return buildErrorResponse(HttpStatus.UNAUTHORIZED, ex.getMessage());
    }

    // Handle Generic Errors (e.g., Unexpected exceptions)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex) {
        logger.error("Unhandled exception: ", ex);
        return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
    }

    // Utility method to build API error responses
    private ResponseEntity<ErrorResponse> buildErrorResponse(HttpStatus status, String message) {
        return new ResponseEntity<>(new ErrorResponse(status.value(), message), status);
    }

    private ResponseEntity<ErrorResponse> buildErrorResponse(HttpStatus status, String message, List<String> details) {
        return new ResponseEntity<>(new ErrorResponse(status.value(), message, details), status);
    }
}
