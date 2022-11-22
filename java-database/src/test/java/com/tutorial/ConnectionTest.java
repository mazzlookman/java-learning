package com.tutorial;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class ConnectionTest {
    
    @BeforeAll
    static void beforeAll(){
        try{
            Driver mysqlDriver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(mysqlDriver);
            System.out.println("register sukses");
        }catch (SQLException exception){
            exception.printStackTrace();
        }
    }

    @Test
    void testConnection(){
        String url = "jdbc:mysql://localhost:3306/belajar_java_database";
        String user = "root";
        String pass = "";

        try(Connection connection = DriverManager.getConnection(url,user,pass)){
            System.out.println("koneksi sukses");
        }catch (SQLException exception){
            System.out.println(exception);
        }
    }
}
