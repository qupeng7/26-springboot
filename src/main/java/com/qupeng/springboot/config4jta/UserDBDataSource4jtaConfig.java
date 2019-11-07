/**
 * @项目名：zjsProject
 * @创建人： qupeng
 * @创建时间： 2019-11-06
 * @公司： www.bjpowernode.com
 * @描述：TODO
 */

package com.qupeng.springboot.config4jta;

import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * <p>NAME: UserDBDataSource4jtaConfig</p>
 * @author qupeng
 * @date 2019-11-06 17:07:32
 * @version 1.0
 */
@Configuration
@MapperScan(basePackages = {"com.qupeng.springboot.mapper.users"},sqlSessionFactoryRef = "userdbSqlSessionFactory")
public class UserDBDataSource4jtaConfig {

    @Value("${spring.datasource.userdb.username}")
    private String  username;

    @Value("${spring.datasource.userdb.password}")
    private String  password;

    @Value("${spring.datasource.userdb.driverClassName}")
    private String driverClassName;

    @Value("${spring.datasource.userdb.jdbcUrl}")
    private String  jdbcUrl;

    /**
     * 配置一个数据源的bean
     */
    @Bean("userdbDataSource")
    public DataSource userdbDataSource(){
        //创建一个XA数据源
        MysqlXADataSource xaDataSource = new MysqlXADataSource();
        xaDataSource.setUrl(jdbcUrl);
        xaDataSource.setUser(username);
        xaDataSource.setPassword(password);

        AtomikosDataSourceBean atomikosDataSourceBean=new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(xaDataSource);
        atomikosDataSourceBean.setUniqueResourceName("userdbDataSource");
        atomikosDataSourceBean.setMaxPoolSize(30);
        atomikosDataSourceBean.setMinPoolSize(5);
        return atomikosDataSourceBean;
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
}
