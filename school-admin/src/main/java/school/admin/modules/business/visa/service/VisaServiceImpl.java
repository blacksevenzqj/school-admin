package school.admin.modules.business.visa.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.db.datasource.tabswitch.DataSourceNames;
import school.db.datasource.tabswitch.annotation.DataSource;



@Slf4j
@Service(value = "visaServiceImpl")
public class VisaServiceImpl {

    @Autowired
    BaseInformationDao baseInformationDao;

    @DataSource(name = DataSourceNames.BUSINESS_SYSTEM)
    public BaseInformation getBaseInformation(Integer baseInformationId){
        return baseInformationDao.findById(baseInformationId);
    }

}
