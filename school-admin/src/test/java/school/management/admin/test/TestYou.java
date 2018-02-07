package school.management.admin.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import school.management.admin.modules.business.businesshelp.service.BusinessHelpAdminServiceImpl;
import school.management.admin.modules.business.visa.service.VisaAdminServiceImpl;
import school.management.admin.modules.sys.entity.SysLogEntity;
import school.management.admin.modules.sys.entity.SysRoleEntity;
import school.management.admin.modules.sys.entity.SysUserEntity;
import school.management.admin.modules.sys.service.SysLogServiceImpl;
import school.management.admin.modules.sys.service.SysRoleServiceImpl;
import school.management.admin.modules.sys.service.SysUserServiceImpl;
import school.management.business.businesshelp.entity.BusinessHeadlines;
import school.management.db.utils.PageUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestYou {

    @Autowired
    BusinessHelpAdminServiceImpl businessHelpAdminServiceImpl;

    @Test
    public void businessHelp() {
        Map map = new HashMap();
        PageUtils<BusinessHeadlines> pageUtils = businessHelpAdminServiceImpl.headlinesQueryPageMap(map);
        System.out.println(pageUtils);
        for(BusinessHeadlines bl : pageUtils.getList()){
            System.out.println(bl);
        }
    }


}
