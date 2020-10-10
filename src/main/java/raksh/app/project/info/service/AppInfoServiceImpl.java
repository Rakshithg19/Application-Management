package raksh.app.project.info.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import raksh.app.project.info.dto.AppInfoDTO;
import raksh.app.project.info.entity.AppInfoEntity;
import raksh.app.project.info.entity.EnvironmentEntity;
import raksh.app.project.info.repository.IAppInfoRepository;
import raksh.app.project.info.util.IAppInfoMapper;
import raksh.app.project.info.util.IEnvironmentMapper;

@Slf4j
@Service
public class AppInfoServiceImpl implements IAppInfoService{
	@Autowired
	private IAppInfoRepository appInfoRepository;

	@Autowired
	private IAppInfoMapper iAppInfoMapper;
	@Autowired
	private IEnvironmentMapper iEnvironmentMapper;
	
	public AppInfoServiceImpl() {
		log.info(this.getClass().getSimpleName() + " is created");
	}

	public AppInfoDTO validateAndSaveAppInfoDetails(AppInfoDTO appInfoDTO) {

		log.info("invoking validateAndSaveAppInfoDetails()" + this.getClass().getSimpleName());
		try {
			AppInfoEntity appInfoEntity = iAppInfoMapper.convertDTOToEntity(appInfoDTO);
			
			
			
			List<EnvironmentEntity> environmentList =  iEnvironmentMapper.convertDTOToEntity(appInfoDTO.getEnvironmentList());
			
			for(int i = 0 ;i<environmentList.size();i++) {
				environmentList.get(i).setAppInfo(appInfoEntity);
			}
			appInfoEntity.setEnvironmentList(environmentList);
			
			
			appInfoEntity = appInfoRepository.save(appInfoEntity);
			log.error("Error :::::>>>>> {}",appInfoEntity.getEnvironmentList());
			if (appInfoEntity.getId() != null) {
				appInfoDTO.setId(appInfoEntity.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return appInfoDTO;
	}

}
