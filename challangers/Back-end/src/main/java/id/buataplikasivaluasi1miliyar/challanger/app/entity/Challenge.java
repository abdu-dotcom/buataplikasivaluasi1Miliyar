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
    private String challengeName;
    private String challengeDescription;
    private String challengeLevel;
    private Integer challengeParticipation;
    private Integer challengeParticipationOnprogress;
    private Integer challengeParticipationFinished;
    private Integer challengeParticipationFailed;

    @Column(name = "categori_id")
    private Integer categoryId;
    private Timestamp createAt;
    private Timestamp updateAt;

    @OneToMany(mappedBy = "challenge_id", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<ChallengeSub> subChallenges;
}
