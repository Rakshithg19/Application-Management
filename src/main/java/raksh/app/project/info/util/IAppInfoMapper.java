package raksh.app.project.info.util;

import org.mapstruct.Mapper;

import raksh.app.project.info.dto.AppInfoDTO;
import raksh.app.project.info.entity.AppInfoEntity;

@Mapper(componentModel = "spring")
public interface IAppInfoMapper {
	AppInfoEntity convertDTOToEntity(AppInfoDTO dto);
}
