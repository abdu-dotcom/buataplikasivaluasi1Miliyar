package id.buataplikasivaluasi1miliyar.challanger.app.services.impl;


import id.buataplikasivaluasi1miliyar.challanger.app.dto.Motivation.MotivationDto;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.Motivation;
import id.buataplikasivaluasi1miliyar.challanger.app.mapper.MotivationMapper;
import id.buataplikasivaluasi1miliyar.challanger.app.repository.MotivationRepository;
import id.buataplikasivaluasi1miliyar.challanger.app.services.MotivationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MotivationServiceImpl  implements MotivationService {

    private final MotivationRepository motivationRepository;
    private final MotivationMapper motivationMapper;
    @Override
    public List<MotivationDto> getAllMotivation() {

        List<Motivation> motivationList = motivationRepository.findAll();

        return motivationMapper.toMotivationDto(motivationList);
    }
}
