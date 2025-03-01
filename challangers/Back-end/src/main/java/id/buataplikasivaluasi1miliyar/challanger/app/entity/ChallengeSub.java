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
    private Integer challenge_sub_id;
    private String challenge_sub_name;
    private Integer challenge_sub_point;

    @ManyToOne
    @JoinColumn(name = "challenge_id", nullable = false)
    private Challenge challenge_id;
}
