package com.tutorial.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;


import java.util.Properties;

public class ConditionTest {

//    @Test
//    public void testSystemPropereties(){
//        Properties properties = System.getProperties();
//        properties.forEach((key,value));
//    }

    @Test
    @DisabledOnOs({OS.WINDOWS})
    public void testRunOnlyMac(){

    }
}
