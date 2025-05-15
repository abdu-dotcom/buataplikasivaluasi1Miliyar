package id.buataplikasivaluasi1miliyar.challanger.app.mapper;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.Motivation.MotivationDto;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.Motivation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MotivationMapper {

    MotivationMapper INSTANCE = Mappers.getMapper(MotivationMapper.class);

    // Mapping satu object
    MotivationDto toMotivationDto(Motivation motivation);

    // Mapping list
    List<MotivationDto> toMotivationDto(List<Motivation> motivation);
}
