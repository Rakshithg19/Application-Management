package raksh.app.project.info.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@Entity
@Table(name = "project_details")
public class AppInfoEntity implements Serializable{
	@Id
	@GenericGenerator(name = "ref", strategy = "increment")
	@GeneratedValue(generator = "ref")
	@Column(name = "ID")
	private Integer id;
	@Column(name="PROJECT_NAME")
	private String projectName;
	@Column(name="TEAM_MANAGER_NAME")
	private String teamManagerName;
	@Column(name="TEAM_CONTACT_EMAIL")
	private String teamContactEmail;
	@Column(name="IS_DECOMMISSIONED")
	private Boolean isDeCommissioned;
	@Column(name="DEVELOPED_DATE")
	private Date developedDate;
	@Column(name="PROJECT_VERSION")
	private String version;
	@Column(name="LAST_RELEASE")
	private Date lastRelease;
	@Column(name="NEXT_RELEASE")
	private Date nextRelease;
	
	@OneToMany(mappedBy="appInfo",cascade = CascadeType.ALL)
	private  List<EnvironmentEntity> environmentList;
	
	
	public AppInfoEntity() {
		log.info(this.getClass().getSimpleName()+" is created");
	}


	@Override
	public String toString() {
		return "AppInfoEntity [id=" + id + ", projectName=" + projectName + ", teamManagerName=" + teamManagerName
				+ ", teamContactEmail=" + teamContactEmail + ", isDeCommissioned=" + isDeCommissioned
				+ ", developedDate=" + developedDate + ", version=" + version + ", lastRelease=" + lastRelease
				+ ", nextRelease=" + nextRelease + "]";
	}
	
	
}
