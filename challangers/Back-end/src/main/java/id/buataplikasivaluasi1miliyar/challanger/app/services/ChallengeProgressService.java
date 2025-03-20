package id.buataplikasivaluasi1miliyar.challanger.app.services;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeJoin.ChallengeJoinRequestDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeJoin.ChallengeJoinResponseDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeSubCompletion.ChallengeSubCompletionRequest;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeSubCompletion.ChallengeSubCompletionResponse;

public interface ChallengeProgressService {

    // accept challenge
    ChallengeJoinResponseDto acceptChallenge(ChallengeJoinRequestDto dto);

    // Menyelesaikan satu sub-challenge dengan mengunggah proof & caption.
    ChallengeSubCompletionResponse completeSubChallenge(ChallengeSubCompletionRequest challengeSubCompletionRequest);

    // Mengubah status challenge secara keseluruhan (misalnya: on_progress → failed).
    // updateChallengeStatus(String challengeId, String newStatus);

    // Mengembalikan data progress challenge berdasarkan jumlah sub-challenge yang selesai.
    // getChallengeProgress(String challengeId);
}
