package id.buataplikasivaluasi1miliyar.challanger.app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@Data
@Entity
@Table(name = "leaderboard")
@NoArgsConstructor
@AllArgsConstructor
public class Leaderboard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer leaderboard_id;
    @Column(name = "user_id") // Pastikan ini sesuai dengan database
    private String userId;
    private Integer score;
    private LocalDateTime record_at;
}
