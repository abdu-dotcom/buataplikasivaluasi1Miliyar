package id.buataplikasivaluasi1miliyar.challanger.app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@Data
@Entity
@Table(name = "leaderboard")
@NoArgsConstructor
@AllArgsConstructor
public class Leaderboard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer leaderboard_id;
    private String user_id;
    private Integer score;
    private Timestamp record_at;
}
