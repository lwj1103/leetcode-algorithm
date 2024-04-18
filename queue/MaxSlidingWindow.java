package alrorithm.queue;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {
    public  static int[] maxSlidingWindow(int[] nums, int k) {
        if(k==1) return nums;
        MyDeque myDeque = new MyDeque();
        int resultLength = nums.length-k+1;
        int[] result = new int[resultLength];
        for (int i = 0; i < k; i++) {
            myDeque.add(nums[i]);
        }
        result[0] = myDeque.front();
        for (int i = k; i <nums.length; i++) {
            myDeque.pop(nums[i-k]);
            myDeque.add(nums[i]);
            result[i-k+1] = myDeque.front();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i] + " ");
        }
    }
}
class MyDeque{
    Deque<Integer> deque = new LinkedList<>();
    public  void add(int value){
        while (!deque.isEmpty() && value>deque.peekLast()){
            deque.pollLast();
        }
        deque.addLast(value);
    }
    public void pop(Integer value){
        if(value == deque.getFirst()){
            deque.pollFirst();
        }
    }
    public int front(){
        return deque.peekFirst();
    }
}
