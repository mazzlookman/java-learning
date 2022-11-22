package com.tutorial.collection;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class DequeApp {

    public static void main(String[] args) {
        Deque<String> stack = new LinkedList<>();

        stack.offerLast("Otong");
        stack.offerLast("Ucup");
        stack.offerLast("Mario");

        for (var values:stack){
            System.out.println(values);
        }

        for (var last = stack.pollLast(); last != null; last = stack.pollLast()){
            System.out.println(last);
        }

        Deque<String> queue = new LinkedList<>();
        queue.offerLast("Otong");
        queue.offerLast("Ucup");
        queue.offerLast("Mario");

        for (var antri = queue.pollFirst(); antri != null; antri = queue.pollFirst()){
            System.out.println(antri);
        }
    }
}
