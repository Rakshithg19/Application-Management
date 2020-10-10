package raksh.app.project.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import raksh.app.project.info.entity.AppInfoEntity;

public interface IAppInfoRepository extends JpaRepository<AppInfoEntity, Integer> {

}
