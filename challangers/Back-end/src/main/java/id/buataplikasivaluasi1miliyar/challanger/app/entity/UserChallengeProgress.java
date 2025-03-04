package id.buataplikasivaluasi1miliyar.challanger.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "user_challenges_progress")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserChallengeProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "progress_id")
    private Integer progressId;
    @Column(name = "user_challange_id")
    private Integer userChallengeId;
    @Column(name = "challenge_sub_id")
    private Integer challengeSubId;
    @Column(name = "status")
    private String status; // joined, on_progress, completed, failed
    @Column(name = "caption")
    private String caption; // joined, on_progress, completed, failed
    @Column(name = "proof_url")
    private String proofUrl;
    @Column(name = "last_point_gain")
    private Integer lastPointGain;
    @Column(name = "create_at")
    private LocalDateTime createAt;
}
