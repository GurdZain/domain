package com.kavli.core.base.jdbc;

import com.kavli.core.utils.PropertyUtil;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/3/7.
 */
public class DataSourceLauncher extends NamedParameterJdbcDaoSupport {
    private DriverManagerDataSource dataSource;
    public DataSourceLauncher() {
        super();
        dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://"+ PropertyUtil.get("datasource_ip")+"/"+PropertyUtil.get("datasource_database"));
        dataSource.setUsername(PropertyUtil.get("datasource_name"));
        dataSource.setPassword(PropertyUtil.get("datasource_password"));
        this.setJdbcTemplate(createJdbcTemplate(dataSource));
    }
}
