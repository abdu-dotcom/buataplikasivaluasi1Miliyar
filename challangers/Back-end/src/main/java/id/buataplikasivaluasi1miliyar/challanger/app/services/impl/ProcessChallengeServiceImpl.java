package id.buataplikasivaluasi1miliyar.challanger.app.services.impl;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeProcessFlow.ActionProcessFlow;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeProcessFlow.ProcessChallengeDto;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.UserChallengeProgress;
import id.buataplikasivaluasi1miliyar.challanger.app.mapper.ProcessChallengeMapper;
import id.buataplikasivaluasi1miliyar.challanger.app.repository.ProcessChallengeRepository;
import id.buataplikasivaluasi1miliyar.challanger.app.services.ProcessChallengeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProcessChallengeServiceImpl implements ProcessChallengeService {

    private ProcessChallengeRepository processChallengeRepository;
    private ProcessChallengeMapper processChallengeMapper;

    @Override
    public ProcessChallengeDto startChallenge(ProcessChallengeDto request) {
        // dto to entity
        UserChallengeProgress userChallengeProgressData = processChallengeMapper.toEntity(request);

        userChallengeProgressData.setStatus("on_prgoress");
        userChallengeProgressData.setStartedAt(LocalDateTime.now());
        // save
        UserChallengeProgress saved = processChallengeRepository.save(userChallengeProgressData);

        // entity to dto
        ProcessChallengeDto startChallengeDto =  processChallengeMapper.toDto(saved);
        // set actionProcessFlow
        ActionProcessFlow actionProcessFlow = new  ActionProcessFlow();
        actionProcessFlow.setTextActionProcess("sub challenge is start!");

        startChallengeDto.setActionProcessFlow(actionProcessFlow);
        return startChallengeDto;
    }

    @Override
    public ProcessChallengeDto updateUserChallengeProgress(Integer progressId, ProcessChallengeDto requestComplateProgress) {
        Optional<UserChallengeProgress> existingProgressOpt = processChallengeRepository.findById(progressId);
        UserChallengeProgress existingProgress = null;

        UserChallengeProgress saved = null;
        if (existingProgressOpt.isPresent()) {
            existingProgress = existingProgressOpt.get();
            existingProgress.setStatus(requestComplateProgress.getStatus());
            existingProgress.setCaption("Custom Caption");
            existingProgress.setProofUrl("https:google.com");
            existingProgress.setStatus("Complate");

            saved = processChallengeRepository.save(existingProgress);
        } else {
            throw new RuntimeException("UserChallengeProgress not found");
        }

        // set actionProcessFlow
        ActionProcessFlow actionProcessFlow = new  ActionProcessFlow();
        actionProcessFlow.setTextActionProcess("sub challenge is complated!");

        ProcessChallengeDto processChallengeDto = processChallengeMapper.toDto(existingProgress);
        processChallengeDto.setActionProcessFlow(actionProcessFlow);
        return processChallengeDto;
    }


}
