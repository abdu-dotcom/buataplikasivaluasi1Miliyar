package id.buataplikasivaluasi1miliyar.challanger.app.mapper;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.ExploreMenu.ExploreMenuDto;
import id.buataplikasivaluasi1miliyar.challanger.app.projection.ExploreMenuProjection;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExploreMenuMapper {
    // Mapping satu objek dari ExploreMenuProjection ke ExploreMenuDto
    ExploreMenuDto toExploreMenuDto(ExploreMenuProjection source);

    // Mapping list menggunakan method di atas
    List<ExploreMenuDto> toExploreMenuDto(List<ExploreMenuProjection> sourceList);
}
