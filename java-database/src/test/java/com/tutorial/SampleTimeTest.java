package com.tutorial;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class SampleTimeTest {

    @Test
    void testSampleTime() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();

        String sql = "insert into sample_time(sample_date, sample_time, sample_timestamp) values (?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setDate(1,new Date(System.currentTimeMillis()));
        preparedStatement.setTime(2,new Time(System.currentTimeMillis()));
        preparedStatement.setTimestamp(3,new Timestamp(System.currentTimeMillis()));

        preparedStatement.executeUpdate();

        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        if (resultSet.next()){
            System.out.println(resultSet.getInt(1));
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }

    @Test
    void testPutDateFromDB() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String sql = "select * from sample_time";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            int id = resultSet.getInt("id");
            System.out.println(id);
            Time time = resultSet.getTime("sample_time");
            System.out.println("time: "+time);
            Date date = resultSet.getDate("sample_date");
            System.out.println("date: "+date);
            Timestamp timestamp = resultSet.getTimestamp("sample_timestamp");
            System.out.println("timestamp: "+timestamp);
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
