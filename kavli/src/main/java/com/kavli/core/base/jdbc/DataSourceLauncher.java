package com.kavli.core.base.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Created by Administrator on 2017/3/7.
 */
public class DataSourceLauncher extends JdbcTemplate{
    private DriverManagerDataSource dataSource;
    public DataSourceLauncher() {
        super();
        dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/vmdb_fygusp");
        dataSource.setUsername("root");
        dataSource.setPassword("6856735");
        this.setDataSource(dataSource);
    }
}
