package id.buataplikasivaluasi1miliyar.challanger.app.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Data
@Entity
@Table(name = "challenges")
@NoArgsConstructor
@AllArgsConstructor

public class Challenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "challenge_id")
    private Integer challengeId;
    @Column(name = "challenge_name")
    private String challengeName;
    @Column(name = "challenge_description")
    private String challengeDescription;
    @Column(name = "challenge_level")
    private String challengeLevel;
    @Column(name = "challenge_participation")
    private Integer challengeParticipation;
    @Column(name = "challenge_participation_onprogress")
    private Integer challengeParticipationOnProgress;
    @Column(name = "challenge_participation_finished")
    private Integer challengeParticipationFinished;
    @Column(name = "challenge_participation_failed")
    private Integer challengeParticipationFailed;

    @Column(name = "categori_id")
    private Integer categoryId;
    @Column(name = "create_at")
    private Timestamp createdAt;
    @Column(name = "update_at")
    private Timestamp updatedAt;

    @OneToMany(mappedBy = "challenge_id", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<ChallengeSub> subChallenges;
}
