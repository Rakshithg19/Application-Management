package raksh.app.project.info.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@ToString
@Slf4j

public class AppInfoDTO implements Serializable{
	private Integer id;
	private String projectName;
	private String teamManagerName;
	private String teamContactEmail;
	private Boolean isDeCommissioned;
	private Date developedDate;
	private String version;
	private Date lastRelease;
	private Date nextRelease;
	
	
	
	ArrayList<EnvironmentDTO> environmentList;
	
	public AppInfoDTO() {
		log.info(this.getClass().getSimpleName()+" is created");
	}

}
