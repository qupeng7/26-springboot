/**
 * @项目名：zjsProject
 * @创建人： qupeng
 * @创建时间： 2019-11-06
 * @公司： www.qupeng.com
 * @描述：TODO
 */

package com.qupeng.springboot.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * <p>NAME: UserDBDataSourceConfig</p>
 * @author qupeng
 * @date 2019-11-06 16:07:12
 * @version 1.0
 */

//@Configuration
//@MapperScan(basePackages = {"com.qupeng.springboot.mapper.users"},sqlSessionFactoryRef = "userdbSqlSessionFactory")
public class UserDBDataSourceConfig {
    /**
     * 配置一个数据源的bean
     */
    @Bean("userdbDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.userdb")
    public DataSource userdbDataSource(){
        return DataSourceBuilder.create().build();
    }


    @Bean(name="userdbSqlSessionFactory")
    public SqlSessionFactory userdbSqlSessionFactory(@Qualifier("userdbDataSource") DataSource userdbDataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(userdbDataSource);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name="userdbSqlSessionTemplate")
    public SqlSessionTemplate userdbSqlSessionTemplate(@Qualifier("userdbSqlSessionFactory") SqlSessionFactory userdbSqlSessionFactory) throws Exception {
        return  new SqlSessionTemplate(userdbSqlSessionFactory);
    }

    /**
     * 如果需要对此数据源进行事务管理，需要配置该事务管理器
     *
     * @param userdbDataSource
     * @return
     */
    @Bean
    public DataSourceTransactionManager userdbDataSourceTransactionManager(@Qualifier("userdbDataSource") DataSource userdbDataSource) {
        return new DataSourceTransactionManager(userdbDataSource);
    }
}
