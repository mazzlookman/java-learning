package com.tutorial;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLInjectionTest {

    @Test
    void testSqlInjection() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String user = "admin';#";
        String pass = "admi";

        String sql = " select * from admin where user='"+user+"' and pass='"+pass+"'";

        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()){
            System.out.println("login sukses "+resultSet.getString("user"));
        }else {
            System.out.println("jangan harap");
        }
    }
}
