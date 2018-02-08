package school.management.business.visa.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import school.management.business.visa.dao.mybatis.VisaComboDao;
import school.management.business.visa.entity.VisaCombo;
import school.management.db.service.CrudService;


@Slf4j
@Service(value = "visaComboServiceImpl")
public class VisaComboServiceImpl extends CrudService<VisaComboDao, VisaCombo, Integer> {

}
