package school.admin.common.config.druid.dynamic.tabswitch;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import school.admin.common.exception.base.SystemException;
import school.db.datasource.tabswitch.DynamicSwitchDataSource;

import javax.sql.DataSource;

/**
 * 配置多数据源
 */
@Configuration
public class DynamicDataSourceConfig {

    @Primary
    @Bean(name = "managementDataSource")
    @ConfigurationProperties("spring.datasource.management")
    public DataSource  managementDataSource(){
        return new DruidDataSource();
    }

    @Bean(name = "businessDataSource")
    @ConfigurationProperties("spring.datasource.business")
    public DataSource  businessDataSource(){
        return DruidDataSourceBuilder.create().build();  // 一样的
    }

    @Bean(name = "dynamicSwitchDataSource")
    public DataSource dataSource() {
        DynamicSwitchDataSource dynamicSwitchDataSource = new DynamicSwitchDataSource();
        dynamicSwitchDataSource.setManagementDataSource(managementDataSource());
        dynamicSwitchDataSource.setBusinessDataSource(businessDataSource());
        return dynamicSwitchDataSource;
    }

    /**
     * Dynamic transaction manager data source transaction manager.
     * @param dynamicDataSource the dynamic data source
     * @return the data source transaction manager
     */
    @Bean(name = "dynamicTransactionManager")
    public DataSourceTransactionManager dynamicTransactionManager(@Qualifier("dynamicSwitchDataSource") DataSource dynamicDataSource) {
        return new DataSourceTransactionManager(dynamicDataSource);
    }

    /**
     * Dynamic sql session factory sql session factory.
     * @param dynamicDataSource the dynamic data source
     * @param properties        the properties
     * @return the sql session factory
     */
    @Bean
    @ConfigurationProperties(prefix = MybatisProperties.MYBATIS_PREFIX)
    public SqlSessionFactory dynamicSqlSessionFactory(@Qualifier("dynamicSwitchDataSource") DataSource dynamicDataSource, MybatisProperties properties) {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dynamicDataSource);
        sessionFactory.setConfigLocation(new DefaultResourceLoader().getResource(properties.getConfigLocation()));
        sessionFactory.setMapperLocations(properties.resolveMapperLocations());
        try {
            return sessionFactory.getObject();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
