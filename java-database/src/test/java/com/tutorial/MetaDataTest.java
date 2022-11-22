package com.tutorial;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class MetaDataTest {

    @Test
    void testDatabaseMetaData() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        DatabaseMetaData metaData = connection.getMetaData();

        System.out.println(metaData.getDatabaseProductName());
        System.out.println(metaData.getDatabaseProductVersion());

        ResultSet resultSet = metaData.getTables("belajar_java_database",null,null,null);

        while (resultSet.next()){
            String table = resultSet.getString("table_name");
            System.out.println("table: "+table);
        }
        connection.close();
    }

    @Test
    void testParameterMetaData() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String sql = "INSERT INTO comments(email, comment) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ParameterMetaData metaData = preparedStatement.getParameterMetaData();
        System.out.println(metaData.getParameterCount());
        System.out.println(metaData.getParameterType(1));

        connection.close();
    }

    @Test
    void testResultSetMetaData() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM sample_time");
        ResultSetMetaData metaData = resultSet.getMetaData();

        for (int i=1; i<=metaData.getColumnCount(); i++){
            System.out.println("kolom: "+metaData.getColumnName(i));
            System.out.println("type: "+metaData.getColumnType(i));
            System.out.println("type name: "+metaData.getColumnTypeName(i));

            if (metaData.getColumnType(i) == Types.INTEGER){
                System.out.println("ini integer");
            }
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
