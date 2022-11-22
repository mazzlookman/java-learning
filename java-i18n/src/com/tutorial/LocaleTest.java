package com.tutorial;

import java.util.Locale;

public class LocaleTest {

    public static void main(String[] args) {
        testNewLocale();
        testNewLocaleUS();
    }

    static void testNewLocale(){
        var language = "id";
        var country = "ID";
        var locale = new Locale(language,country);

        System.out.println(locale.getLanguage());
        System.out.println(locale.getCountry());

        System.out.println(locale.getDisplayLanguage());
        System.out.println(locale.getDisplayCountry());
    }

    static void testNewLocaleUS(){
        var language = "en";
        var country = "US";
        var locale = new Locale(language,country);

        System.out.println(locale.getLanguage());
        System.out.println(locale.getCountry());

        System.out.println(locale.getDisplayLanguage());
        System.out.println(locale.getDisplayCountry());
    }

}
