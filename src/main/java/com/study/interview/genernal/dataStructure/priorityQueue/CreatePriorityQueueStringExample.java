package com.study.interview.genernal.dataStructure.priorityQueue;

import java.util.PriorityQueue;

public class CreatePriorityQueueStringExample {
    public static void main(String[] args) {
        // Create a Priority Queue
        PriorityQueue<String> namePriorityQueue = new PriorityQueue<String>();

        // Add items to a Priority Queue (ENQUEUE)
        namePriorityQueue.add("Lisa");
        namePriorityQueue.add("Robert");
        namePriorityQueue.add("John");
        namePriorityQueue.add("Chris");
        namePriorityQueue.add("Angelina");
        namePriorityQueue.add("Joe");

        // Remove items from the Priority Queue (DEQUEUE)
        while (!namePriorityQueue.isEmpty()) {
            System.out.println(namePriorityQueue.remove());
        }
    }
}
