package com.zhouc.config.ds;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by Administrator on 2017/9/15.
 */
@Configuration
// 扫描 Mapper 接口并容器管理
@MapperScan(basePackages = GirlDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "girlSqlSessionFactory")
public class GirlDataSourceConfig {
    static final String PACKAGE = "com.zhouc.dao.girl";
    static final String MAPPER_LOCATION = "classpath:mapper/girl/*.xml";

    @Value("${girl.datasource.driver}")
    private String driverClass;
    @Value("${girl.datasource.url}")
    private String url;
    @Value("${girl.datasource.username}")
    private String username;
    @Value("${girl.datasource.password}")
    private String password;

    @Bean(name = "girlDataSource")
    @Primary
    public DataSource girlDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return  dataSource;
    }

    @Bean(name = "girlTransactionManager")
    @Primary
    public DataSourceTransactionManager girlTransactionManager() {
        return new DataSourceTransactionManager(girlDataSource());
    }

    @Bean(name = "girlSqlSessionFactory" )
    @Primary
    public SqlSessionFactory girlSqlSessionFactory(@Qualifier("girlDataSource") DataSource girlDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(girlDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(GirlDataSourceConfig.MAPPER_LOCATION));
        return  sessionFactory.getObject();
    }

}
