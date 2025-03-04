package id.buataplikasivaluasi1miliyar.challanger.app.services.impl;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeProcessFlow.ActionProcessFlow;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeProcessFlow.StartChallengeDto;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.UserChallengeProgress;
import id.buataplikasivaluasi1miliyar.challanger.app.mapper.ProcessChallengeMapper;
import id.buataplikasivaluasi1miliyar.challanger.app.repository.ProcessChallengeRepository;
import id.buataplikasivaluasi1miliyar.challanger.app.services.ProcessChallengeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProcessChallengeServiceImpl implements ProcessChallengeService {

    private ProcessChallengeRepository processChallengeRepository;
    private ProcessChallengeMapper processChallengeMapper;

    @Override
    public StartChallengeDto startChallenge(StartChallengeDto request) {
        // dto to entity
        UserChallengeProgress userChallengeProgressData = processChallengeMapper.toEntity(request);
        // save
        UserChallengeProgress saved = processChallengeRepository.save(userChallengeProgressData);

        // entity to dto
        StartChallengeDto startChallengeDto =  processChallengeMapper.toDto(saved);
        // set actionProcessFlow
        ActionProcessFlow actionProcessFlow = new  ActionProcessFlow();
        actionProcessFlow.setTextActionProcess("sub challenge is start!");

        startChallengeDto.setActionProcessFlow(actionProcessFlow);
        return startChallengeDto;
    }
}
