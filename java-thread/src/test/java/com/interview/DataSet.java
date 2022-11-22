package com.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DataSet {

    public static class Set{

        private int size = 0;
        private String[] array = new String[10];

        public boolean add(String value){
            if (contains(value)){
                return false;
            }else{
                sizeGrowth();
                array[size] = value;
                size++;
                return true;
            }
        }

        public void sizeGrowth(){
            if (size >= array.length){
                String[] temp = new String[array.length*2];
                for (int i = 0; i < array.length; i++) {
                    temp[i] = array[i];
                }

                array = temp;
            }
        }
        
        public boolean contains(String value) {
            for (String item : array) {
                if (value.equals(item)) {
                    return true;
                }
            }

            return false;
        }

        public int size(){
            return size;
        }

        private int indexOf(String value){
            for (int i = 0; i < array.length; i++ ){
                if (value.equals(array[i])){
                    return i;
                }
            }
            return -1;
        }

        public boolean delete(String value){
            if (contains(value)){
                int indexRemoved = indexOf(value);
                for (int i = indexRemoved; i <= size; i++){
                    array[i] = array[i+1];
                }
                size--;
            }

            return true;
        }

    }

    @Test
    void testAdd(){
        Set set = new Set();
        Assertions.assertTrue(set.add("Aqib"));
        Assertions.assertFalse(set.add("Aqib"));

        Assertions.assertTrue(set.add("Lukman"));
        Assertions.assertFalse(set.add("Lukman"));

    }

    @Test
    void testContains(){
        Set set = new Set();
        set.add("Aqib");
        set.add("Lukman");

        Assertions.assertTrue(set.contains("Aqib"));
        Assertions.assertTrue(set.contains("Lukman"));
        Assertions.assertFalse(set.contains("me"));
    }

    @Test
    void testSize(){
        Set set = new Set();

        Assertions.assertEquals(0,set.size());

        set.add("Aqib");
        Assertions.assertEquals(1,set.size());
        set.add("Aqib");
        Assertions.assertEquals(1,set.size());

        set.add("Lukman");
        Assertions.assertEquals(2,set.size());
    }

    @Test
    void testDelete(){
        Set set = new Set();
        set.add("Bella");
        set.add("Rizky");
        set.add("Kharisma");
        set.add("And");
        set.add("Aqib");
        set.add("Lukman");

        Assertions.assertEquals(6,set.size());

        set.delete("And");

        Assertions.assertEquals(5,set.size());

        Assertions.assertTrue(set.contains("Bella"));
        Assertions.assertTrue(set.contains("Rizky"));
        Assertions.assertTrue(set.contains("Kharisma"));
        Assertions.assertTrue(set.contains("Aqib"));
        Assertions.assertTrue(set.contains("Lukman"));

        Assertions.assertFalse(set.contains("And"));
    }

    @Test
    void testGrowth(){
        Set set = new Set();
        for (int i=0; i<100; i++){
            set.add("Item ke- "+i);
        }
    }

}
