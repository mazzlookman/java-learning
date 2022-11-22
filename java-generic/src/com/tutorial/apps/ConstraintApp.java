package com.tutorial.apps;

public class ConstraintApp {
    public static void main(String[] args) {

        NumberData<Integer> integerNumberData = new NumberData<>(900);
        NumberData<Long> longNumberData = new NumberData<>(9L);

        //tidak bisa selain tipe data number
    }

    public static class NumberData<T extends Number>{

        private T data;

        public NumberData(T data){
            this.data = data;
        }

        public void setData(T data){
            this.data = data;
        }

        public T getData(){
            return data;
        }
    }
}
