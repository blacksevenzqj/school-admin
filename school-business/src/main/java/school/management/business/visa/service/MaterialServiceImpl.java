package school.management.business.visa.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import school.management.business.visa.dao.mybatis.MaterialDao;
import school.management.business.visa.entity.Material;
import school.management.db.service.CrudService;


@Slf4j
@Service(value = "materialServiceImpl")
public class MaterialServiceImpl extends CrudService<MaterialDao, Material, Integer> {

}
