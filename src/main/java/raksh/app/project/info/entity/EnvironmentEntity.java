package raksh.app.project.info.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "environment_details")
@Data
public class EnvironmentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ENVIRONMENT_ID")
	private Integer id;
	@Column(name = "ENVIRONMENT")
	private String environment;
	@Column(name = "URL")
	private String url;
	@Column(name = "IS_ACCESSIBLE")
	private Boolean isAccessible;

	@ManyToOne
	@JoinColumn(name = "APP_ID", nullable = false)
	private AppInfoEntity appInfo;

	@Override
	public String toString() {
		return "EnvironmentEntity [id=" + id + ", environment=" + environment + ", url=" + url + ", isAccessible="
				+ isAccessible + "]";
	}

}
