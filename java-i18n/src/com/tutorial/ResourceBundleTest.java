package com.tutorial;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleTest {

    public static void main(String[] args) {
        testResourceBundle();
        testResourceBundleIndo();
        testResourceBundleNotFound();
    }

    static void testResourceBundle(){
        var resourceBundle = ResourceBundle.getBundle("message");

        System.out.println(resourceBundle.getString("hello"));
        System.out.println(resourceBundle.getString("goodbye"));
    }

    static void testResourceBundleIndo(){
        var indo = new Locale("in","ID");
        var resourceBundle = ResourceBundle.getBundle("message",indo);

        System.out.println(resourceBundle.getString("hello"));
        System.out.println(resourceBundle.getString("goodbye"));
    }

    static void testResourceBundleNotFound() {

        var indonesia = new Locale("en", "US");
        var resourceBundle = ResourceBundle.getBundle("message", indonesia);

        System.out.println(resourceBundle.getString("hello"));
        System.out.println(resourceBundle.getString("goodbye"));

    }

}
