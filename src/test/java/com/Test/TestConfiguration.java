package com.Test;

import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author YXS
 * @PackageName: com.Test
 * @ClassName: TesConfiguration
 * @Desription:
 * @date 2023/3/6 21:44
 */
@Configuration
@ComponentScan("DatabaseFrameworkIntegration.mybatisTransaction.Service.impl")
@MapperScan("DatabaseFrameworkIntegration.mybatisTransaction.mapper")
@EnableTransactionManagement
public class TestConfiguration {

    @Bean
    public DataSource dataSource() {

        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test?serverTimezone=Asia/Shanghai");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        return dataSource;

    }
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {

        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean;

    }
    @Bean
    public TransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
