package com.tutorial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class DriverTest {

    @Test
    void testRegister(){
        try{
            Driver mysqlDriver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(mysqlDriver);
        }catch(SQLException exception){
            Assertions.fail(exception);
        }
    }
}
