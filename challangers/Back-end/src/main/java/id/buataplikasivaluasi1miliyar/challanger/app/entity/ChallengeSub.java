package id.buataplikasivaluasi1miliyar.challanger.app.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Data
@Entity
@Table(name = "challenges_sub")
@NoArgsConstructor
@AllArgsConstructor
public class ChallengeSub {
    @Id
    @Column(name = "challenge_sub_id")
    private Integer challengeSubId;
    private String challengeSubName;
    private Integer challengePubPoint;
    private String challengeSubTipeDeadline;
    private Integer challengeSubDeadlineTime;

    @ManyToOne
    @JoinColumn(name = "challenge_id", nullable = false)
    private Challenge challenge_id;
}
