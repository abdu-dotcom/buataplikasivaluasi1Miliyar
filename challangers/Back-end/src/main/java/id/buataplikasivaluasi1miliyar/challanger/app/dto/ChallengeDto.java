package id.buataplikasivaluasi1miliyar.challanger.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChallengeDto {
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
