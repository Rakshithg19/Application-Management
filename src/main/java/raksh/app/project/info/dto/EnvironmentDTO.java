package raksh.app.project.info.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@ToString
@Slf4j
public class EnvironmentDTO implements Serializable {
	private String environment;
	private String url;
	private Boolean isAccessible;
	
	public EnvironmentDTO() {
		log.info(this.getClass().getSimpleName()+" is created");
	}

}

