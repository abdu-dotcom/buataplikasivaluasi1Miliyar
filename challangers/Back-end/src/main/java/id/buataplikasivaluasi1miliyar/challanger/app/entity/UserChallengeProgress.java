package id.buataplikasivaluasi1miliyar.challanger.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

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
    @Column(name = "proof_url")
    private String proofUrl;
    @Column(name = "last_point_gain")
    private Integer lastPointGain;
    @Column(name = "create_at")
    private LocalDateTime createAt;
}
