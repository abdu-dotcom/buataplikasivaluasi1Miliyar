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
    @Column(name = "challenge_sub_name")
    private String challengeSubName;
    @Column(name = "challenge_sub_point")
    private Integer challengeSubPoint;
    @Column(name = "challenge_sub_tipe_deadline")
    private String challengeSubTipeDeadline;
    @Column(name = "challenge_sub_deadline_time")
    private Integer challengeSubDeadlineTime;

    @ManyToOne
    @JoinColumn(name = "challenge_id", nullable = false)
    private Challenge challenge_id;
}
