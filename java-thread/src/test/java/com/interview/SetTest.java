package com.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SetTest {

    public static class Set{

        private int size = 0;
        String[] data = new String[10];

        private void dataGrowth(){
            if (size >= data.length){
                String[] temp = new String[data.length*2];
                for (int i = 0; i < data.length; i++) {
                    temp[i] = data[i];
                }

                data = temp;
            }
        }

        public boolean add(String value){
            if (contains(value)){
                return false;
            }else {
                dataGrowth();
                data[size] = value;
                size++;
                return true;
            }
        }

        public boolean contains(String value){
            for (String item : data) {
                if (value.equals(item)){
                    return true;
                }
            }
            return false;
        }

        public int size(){
            return size;
        }

        private int indexOf(String value){
            for (int i = 0; i < data.length; i++){
                if (value.equals(data[i])){
                    return i;
                }
            }
            return -1;
        }

        public boolean delete(String value){
            if (contains(value)){
                int indexDeleted = indexOf(value);

                for (int i = indexDeleted; i <= size; i++) {
                    data[i] = data[i+1];
                }

                size--;

            }

            return true;
        }
    }

    @Test
    void testAdd(){
        Set set = new Set();
        Assertions.assertTrue(set.add("Bella"));
        Assertions.assertFalse(set.add("Bella"));

        Assertions.assertTrue(set.add("Rizky"));
        Assertions.assertFalse(set.add("Rizky"));
    }

    @Test
    void testContains(){
        Set set = new Set();
        set.add("Bella");
        set.add("Rizky");
        Assertions.assertTrue(set.contains("Bella"));
        Assertions.assertTrue(set.contains("Rizky"));
    }

    @Test
    void testSize(){
        Set set = new Set();
        Assertions.assertEquals(0,set.size);
        set.add("Bella");
        Assertions.assertEquals(1,set.size);
        set.add("Bella");
        Assertions.assertEquals(2,set.size);
        set.add("Rizky");
        Assertions.assertEquals(2,set.size);
    }

    @Test
    void testDelete(){
        Set set =  new Set();
        set.add("Bella");
        set.add("Rizky");
        set.add("Kharisma");
        set.add("And");
        set.add("Aqib");
        set.add("Lukman");

        Assertions.assertEquals(6, set.size());

        set.delete("And");
        Assertions.assertEquals(5, set.size());

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
        for (int i = 0; i < 100; i++) {
            set.add("Item ke- "+i);
        }
    }
}
