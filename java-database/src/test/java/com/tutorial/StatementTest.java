package com.tutorial;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.List;

public class StatementTest {

    @Test
    //statement tanpa return hasil
    //menggunakan sintax executeUpdate
    void testExecuteUpdate() throws SQLException{
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String sql = """
                INSERT INTO customers(id, name, email)
                VALUES ('aqib', 'aqib', 'aqib@test.com')
                """;

        int update = statement.executeUpdate(sql);
        System.out.println(update);

        statement.close();
        connection.close();
    }

    //Object ResultSet - object untuk menampung return hasil dari perintah query
    //menggunakan sintax .executeQuery
    @Test
    void testExecuteQuery() throws SQLException{
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String sql = """
                select * from customers
                """;

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");

            System.out.println("["+String.join(", ",id,name,email)+"]");
        }

        resultSet.close();
        statement.close();
        connection.close();

    }

}
