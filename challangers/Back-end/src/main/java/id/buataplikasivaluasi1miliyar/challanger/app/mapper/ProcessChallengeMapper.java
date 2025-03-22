package id.buataplikasivaluasi1miliyar.challanger.app.mapper;

import id.buataplikasivaluasi1miliyar.challanger.app.entity.UserChallengeProgress;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProcessChallengeMapper {
    ProcessChallengeMapper INSTANCE = Mappers.getMapper(ProcessChallengeMapper.class);
}
