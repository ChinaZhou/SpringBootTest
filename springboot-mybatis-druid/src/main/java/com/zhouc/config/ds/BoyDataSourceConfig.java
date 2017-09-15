package com.zhouc.config.ds;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by Administrator on 2017/9/15.
 */
@Configuration
@MapperScan(basePackages = BoyDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "boySqlSessionFactory")
public class BoyDataSourceConfig {

    static final String PACKAGE = "com.zhouc.dao.boy";
    static final String MAPPER_LACTION = "classpath:mapper/boy/*.xml";

    @Value("${boy.datasource.driver}")
    private String driverClass;
    @Value("${boy.datasource.url}")
    private String url;
    @Value("${boy.datasource.username}")
    private String username;
    @Value("${boy.datasource.password}")
    private String password;

    @Bean(name = "boyDataSource")
    public DataSource boyDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return  dataSource;
    }

    @Bean(name = "boyTransactionManager")
    public DataSourceTransactionManager boyTransactionManager() {
        return new DataSourceTransactionManager(boyDataSource());
    }

    @Bean(name = "boySqlSessionFactory")
    public SqlSessionFactory boySqlSessionFactory() throws Exception {
        final SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(boyDataSource());
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(BoyDataSourceConfig.MAPPER_LACTION));
        return  sqlSessionFactory.getObject();
    }

}
