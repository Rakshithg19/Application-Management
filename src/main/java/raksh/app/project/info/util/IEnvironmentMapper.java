package raksh.app.project.info.util;

import java.util.List;

import org.mapstruct.Mapper;

import raksh.app.project.info.dto.EnvironmentDTO;
import raksh.app.project.info.entity.EnvironmentEntity;

@Mapper(componentModel = "spring")
public interface IEnvironmentMapper {
	public List<EnvironmentEntity> convertDTOToEntity(List<EnvironmentDTO> list) ;
}		
