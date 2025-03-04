package id.buataplikasivaluasi1miliyar.challanger.app.services;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeProcessFlow.StartChallengeDto;

public interface ProcessChallengeService {

    // start sub challenge progress - insert data to tabel user_challenge_progress
    StartChallengeDto startChallenge(StartChallengeDto startChallengeDto);
    // complete sub challenge progress - update adta tabel user_challenge_progress status

    // failed sub challenge progress - update data tabel user_challenge_progress status
}
