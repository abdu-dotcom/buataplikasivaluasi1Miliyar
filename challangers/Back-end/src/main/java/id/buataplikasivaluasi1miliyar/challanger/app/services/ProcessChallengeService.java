package id.buataplikasivaluasi1miliyar.challanger.app.services;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeProcessFlow.ProcessChallengeDto;

public interface ProcessChallengeService {

    // start sub challenge progress - insert data to tabel user_challenge_progress
    ProcessChallengeDto startChallenge(ProcessChallengeDto startChallengeDto);
    // complete sub challenge progress - update adta tabel user_challenge_progress status

    ProcessChallengeDto complateUserChallengeProgress(Integer progressId, ProcessChallengeDto complateProgress);
    // failed sub challenge progress - update data tabel user_challenge_progress status
}
