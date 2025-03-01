package id.buataplikasivaluasi1miliyar.challanger.app.dto;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    @Id
    private String user_id;

    private String username;
    private String email;
    private Timestamp create_at;
    private Timestamp update_at;
}
