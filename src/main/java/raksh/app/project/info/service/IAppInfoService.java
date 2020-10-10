package raksh.app.project.info.service;

import raksh.app.project.info.dto.AppInfoDTO;

public interface IAppInfoService {
	public AppInfoDTO validateAndSaveAppInfoDetails(AppInfoDTO appInfoDTO);
}
