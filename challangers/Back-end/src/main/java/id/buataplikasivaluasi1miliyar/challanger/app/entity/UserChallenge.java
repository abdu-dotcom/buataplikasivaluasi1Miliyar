package id.buataplikasivaluasi1miliyar.challanger.app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "user_challenges")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserChallenge {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_challange_id")
    private Integer userChallengeId;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "challenge_id")
    private Integer challengeId;
    @Column(name = "status")
    private String status; // joined, on_progress, completed, failed
    @Column(name = "joined_at")
    private LocalDateTime joinedat;
    @Column(name = "finished_at")
    private LocalDateTime finishedat;
    @Column(name = "deadline_at")
    private LocalDateTime deadlinedat;

}
