package com.tutorial;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementTest {

    @Test
    void testPreparedStatement() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();

        String user, pass, sql;
        user = "admin';#";
        pass = "admi";

        sql = "select * from admin where user=? and pass=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,user);
        preparedStatement.setString(2,pass);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()){
            System.out.println("login sukses "+resultSet.getString("user"));
        }else{
            System.out.println("jangan harap");
        }
    }
}
