package school.management.business.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import school.management.business.visa.dao.jpa.BaseInformationRepository;
import school.management.business.visa.dao.mybatis.BaseInformationDao;
import school.management.business.visa.entity.BaseInformation;
import school.management.db.service.CrudService;


@Slf4j
@Service(value = "visaServiceImpl")
public class VisaServiceImpl extends CrudService<BaseInformationDao, BaseInformation, Integer> {

//    @DataSource(name = DataSourceNames.BUSINESS_SYSTEM)
    public BaseInformation getBaseInformation(Integer baseInformationId){
        return getDao().getById(baseInformationId);
    }



    @Autowired
    BaseInformationRepository baseInformationRepository;

    public BaseInformation getBaseInformationForJpa(Integer baseInformationId){
        return baseInformationRepository.findOne(baseInformationId);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public BaseInformation saveBaseInformationForJpa(BaseInformation baseInformation){
        return baseInformationRepository.saveAndFlush(baseInformation);
    }




}
