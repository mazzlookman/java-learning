package com.tutorial;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchSqlStatement {

    @Test
    void testStatementBatch() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String sql = "insert into comments(email, comment) values('aqib@test.com','hai')";

        for (int i=0; i<1000; i++){
            statement.addBatch(sql);
        }

        statement.executeBatch();

        statement.close();
        connection.close();
    }

    @Test
    void testPreparedStatementBatch() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();

        String sql = "insert into comments(email, comment) values(?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        for (int i = 0; i < 1000; i++) {
            preparedStatement.clearParameters();
            preparedStatement.setString(1, "aqibmoh@test.com");
            preparedStatement.setString(2, "hai");
            preparedStatement.addBatch();
        }

        preparedStatement.executeBatch();

        preparedStatement.close();
        connection.close();
    }
}
