package id.buataplikasivaluasi1miliyar.challanger.app.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;
import java.util.List;

@Getter
@AllArgsConstructor
public class ErrorResponse {
    private final int status;
    private final long timestamp = Instant.now().toEpochMilli();
    private final String error;
    private final String message;
    private final List<String> details;

    // Constructor untuk error tanpa "details"
    public ErrorResponse(int status, String error, String message) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.details = null;
    }
}
