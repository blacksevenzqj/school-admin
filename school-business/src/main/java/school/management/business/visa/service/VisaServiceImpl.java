package school.management.business.visa.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import school.management.business.visa.dao.BaseInformationDao;
import school.management.business.visa.entity.BaseInformation;
import school.management.db.datasource.tabswitch.DataSourceNames;
import school.management.db.datasource.tabswitch.annotation.DataSource;
import school.management.db.service.CrudService;


@Slf4j
@Service(value = "visaServiceImpl")
public class VisaServiceImpl extends CrudService<BaseInformationDao, BaseInformation, Integer> {

    @DataSource(name = DataSourceNames.BUSINESS_SYSTEM)
    public BaseInformation getBaseInformation(Integer baseInformationId){
        return getDao().getById(baseInformationId);
    }

}
