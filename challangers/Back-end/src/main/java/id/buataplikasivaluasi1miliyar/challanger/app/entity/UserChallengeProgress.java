package id.buataplikasivaluasi1miliyar.challanger.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "user_challenges_progress")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserChallengeProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @Column(name = "started_at")
    private Timestamp startedAt;
    @Column(name = "completed_at")
    private Timestamp completedAt;
    @Column(name = "deadline_at")
    private Timestamp deadlineAt;

}
