package school.admin.modules.business.visa.service;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseInformationRepository extends JpaRepository<BaseInformation, Integer> {
	
	BaseInformation findByBaseInformationId(Integer baseInformationId);

}
