package id.buataplikasivaluasi1miliyar.challanger.app.dto;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    @Id
    private String user_id;
    private String username;
}
