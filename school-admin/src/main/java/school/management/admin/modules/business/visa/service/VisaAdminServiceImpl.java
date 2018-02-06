package school.management.admin.modules.business.visa.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import school.management.admin.modules.business.visa.dao.BaseInformationAdminDao;
import school.management.business.visa.service.VisaServiceImpl;
import school.management.business.visa.entity.BaseInformation;

import java.util.List;

@Slf4j
@Service(value = "visaAdminServiceImpl")
public class VisaAdminServiceImpl {

    @Autowired
    VisaServiceImpl visaServiceImpl;
    @Autowired
    BaseInformationAdminDao baseInformationAdminDao;

    @Transactional(readOnly = true)
//    @DataSource(name = DataSourceNames.BUSINESS_SYSTEM)
    public BaseInformation getBaseInformation(Integer baseInformationId){
        return visaServiceImpl.get(baseInformationId);
    }
    public BaseInformation saveBaseInformation(BaseInformation baseInformation){
        return visaServiceImpl.save(baseInformation);
    }
    @Transactional(readOnly = true)
    public List<BaseInformation> getBaseInformationList(){
        return baseInformationAdminDao.getBaseInformationList();
    }




/**
 * JPA 测试
 */
//    @Autowired
//    BaseInformationRepository baseInformationRepository;
//
//    @Transactional(readOnly = true)
//    public BaseInformation getBaseInformationForJpa(Integer baseInformationId){
//        return baseInformationRepository.findOne(baseInformationId);
//    }
//    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
//    public BaseInformation saveBaseInformationForJpa(BaseInformation baseInformation){
//        return baseInformationRepository.saveAndFlush(baseInformation);
//    }

}
