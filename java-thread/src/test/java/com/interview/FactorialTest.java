package com.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FactorialTest {

    int factorial(int value){
        if (value<=0){
            return 1;
        }

        int result = 1;

        for (int i = value; i >= 1; i--) {
            result *= i;
        }
        return result;
    }

    int factorialRecursive(int value){
        if (value<=0){
            return 1;
        }else{
            return value * factorialRecursive(value-1);
        }
    }

    int factorialTailRecursive(int total, int value){
        if (value<=0){
            return total;
        }else{
            return factorialTailRecursive(total*value,value-1);
        }
    }


    @Test
    void testFactorial(){
        Assertions.assertEquals(1,factorial(0));
        Assertions.assertEquals(1,factorial(1));
        Assertions.assertEquals(2,factorial(2));
        Assertions.assertEquals(6,factorial(3));
        Assertions.assertEquals(24,factorial(4));
        Assertions.assertEquals(120,factorial(5));
    }

    @Test
    void testFactorialRecursive(){
        Assertions.assertEquals(1,factorialRecursive(0));
        Assertions.assertEquals(1,factorialRecursive(1));
        Assertions.assertEquals(2,factorialRecursive(2));
        Assertions.assertEquals(6,factorialRecursive(3));
        Assertions.assertEquals(24,factorialRecursive(4));
        Assertions.assertEquals(120,factorialRecursive(5));
    }

    @Test
    void testFactorialTailRecursive(){
        Assertions.assertEquals(1,factorialTailRecursive(1,0));
        Assertions.assertEquals(1,factorialTailRecursive(1,1));
        Assertions.assertEquals(2,factorialTailRecursive(1,2));
        Assertions.assertEquals(6,factorialTailRecursive(1,3));
        Assertions.assertEquals(24,factorialTailRecursive(1,4));
        Assertions.assertEquals(120,factorialTailRecursive(1,5));
    }
}
