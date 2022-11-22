package com.tutorial.test;

import com.tutorial.test.generator.SimpleDisplayNameGenerator;
import org.junit.jupiter.api.*;
import org.opentest4j.TestAbortedException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

@DisplayNameGeneration(SimpleDisplayNameGenerator.class)
public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @BeforeAll
    public static void beforeAll(){
        System.out.println("Before All");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("After All");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("Before Each");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("After Each");
    }

    @Test
    public void testAddSuccess(){
        var result = calculator.add(10, 10);
        assertEquals(20,result);
    }

    @Disabled
    @Test
    public void testComingSoon(){
        System.out.println("blablalba");
    }

    @Test
    public void testDivideSuccess(){
        var result = calculator.divide(100,10);
        assertEquals(10,result);
    }

    @Test
    public void testDivideError(){
        assertThrows(IllegalArgumentException.class,()->{
            calculator.divide(100,0);
        });
    }

    @Disabled
    @Test
    public void testAborted(){
        var profile = System.getenv("PROFILE");
        if (!"DEV".equals(profile)){
            throw new TestAbortedException("profile != DEV");
        }
    }

    @Test
    public void TestAssumption(){
        assumeTrue("DEV".equals(System.getenv("PROFILE")));
    }


}
