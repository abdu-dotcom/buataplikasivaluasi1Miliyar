package id.buataplikasivaluasi1miliyar.challanger.app.services;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeProcessFlow.ChallengeJoin.ChallengeJoinRequestDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeProcessFlow.ChallengeJoin.ChallengeJoinResponseDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeProcessFlow.ChallengeSubCompletion.ChallengeSubCompletionRequest;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeProcessFlow.ChallengeSubCompletion.ChallengeSubCompletionResponse;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeProcessFlow.ChallengeSubFailed.ChallengeSubFailedRequest;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeProcessFlow.ChallengeSubFailed.ChallengeSubFailedResponse;

public interface ChallengeProgressService {

    // accept challenge
    ChallengeJoinResponseDto acceptChallenge(ChallengeJoinRequestDto dto);

    // Menyelesaikan satu sub-challenge dengan mengunggah proof & caption.
    ChallengeSubCompletionResponse completeSubChallenge(ChallengeSubCompletionRequest challengeSubCompletionRequest);

    /** Mengubah status challenge secara keseluruhan (misalnya: on_progress → failed).
     *  business flow:
     *  user membuka halaman user detail challenge. langsung hit api untuk check deadline.
     *  apabila sudah melewati deadline akan mengubah status menjadi failed dan lanjut ke
     *  challenge selanjutnya
     *
     * @param challengeSubFailedRequest
     */
     ChallengeSubFailedResponse markSubChallengeAsFailed(ChallengeSubFailedRequest challengeSubFailedRequest);

    // Mengembalikan data progress challenge berdasarkan jumlah sub-challenge yang selesai.
    // getChallengeProgress(String challengeId);
}
