package id.buataplikasivaluasi1miliyar.challanger.app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

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
    private Integer challenge_id;
    private String challenge_name;
    private String challenge_description;
    private String challenge_lavel;
    private Integer challenge_participation;
    private Integer challenge_participation_onprogress;
    private Integer challenge_participation_finished;
    private Integer challenge_participation_failed;
    private Integer categori_id;
    private Timestamp create_at;
    private Timestamp update_at;
}
