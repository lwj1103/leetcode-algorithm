package alrorithm.queue;

import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((num1,num2)-> num2-num1);
        pq.offer(3);
        pq.offer(4);
        pq.offer(6);
        pq.offer(7);
        pq.offer(1);
        pq.offer(2);
        System.out.println(pq);
    }
}
