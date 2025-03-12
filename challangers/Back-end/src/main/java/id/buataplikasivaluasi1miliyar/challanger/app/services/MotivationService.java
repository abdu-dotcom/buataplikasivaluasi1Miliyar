package id.buataplikasivaluasi1miliyar.challanger.app.services;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.Motivation.MotivationDto;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.Motivation;

import java.util.List;

public interface MotivationService {
    List<MotivationDto> getAllMotivation();
}
