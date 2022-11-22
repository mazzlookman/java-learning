package com.tutorial;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesApp {
    public static void main(String[] args) {
        try{
            Properties properties = new Properties();
            properties.load(new FileInputStream("app.properties"));

            String host = properties.getProperty("db.host");
            String port = properties.getProperty("db.port");
            String user = properties.getProperty("db.user");
            String pass = properties.getProperty("db.pass");
            System.out.println(host);
            System.out.println(port);
            System.out.println(user);
            System.out.println(pass);

        }catch (FileNotFoundException exception){
            System.out.println("File tidak ketemu");
        }catch (IOException exception){
            System.out.println("Gagal load file");
        }

        try{

        Properties properties = new Properties();
        properties.put("name.first","Bella");
        properties.put("name.middel","Rizky");
        properties.put("name.last","Kharisma");

        properties.store(new FileOutputStream("name.properties"),"Name Configuration");
        }catch (FileNotFoundException exception){
            System.out.println("File tidak ketemu");
        }catch (IOException exception){
            System.out.println("Gagal menyimpan properties");
        }
    }
}
