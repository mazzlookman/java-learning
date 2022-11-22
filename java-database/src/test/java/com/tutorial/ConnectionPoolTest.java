package com.tutorial;

import com.zaxxer.hikari.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPoolTest {

    @Test
    void testDataSource(){
    HikariConfig config = new HikariConfig();
    config.setDriverClassName("com.mysql.cj.jdbc.Driver");
    config.setJdbcUrl("jdbc:mysql://localhost:3306/belajar_java_database");
    config.setUsername("root");
    config.setPassword("");

    config.setMaximumPoolSize(10);
    config.setMinimumIdle(5);
    config.setIdleTimeout(60_000);
    config.setMaxLifetime(10*60_000);

        try{
            HikariDataSource dataSource = new HikariDataSource(config);
            Connection connection = dataSource.getConnection();
            connection.close();
            dataSource.close();
        }catch(SQLException exception){
            Assertions.fail(exception);
        }
    }

    @Test
    void testUtilConnection() throws SQLException{
        Connection connection = ConnectionUtil.getDataSource().getConnection();
    }

}
