package alrorithm.queue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class TopKFrequent {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,3,3};
        int k = 2;
        int[] result = topKFrequent(nums, k);
        for (int i = 0; i <result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        //将数组中的元素值以及出现的次数保存到hashmap中
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i],hashMap.getOrDefault(nums[i],0)+1);
        }
        //建立大根堆
        PriorityQueue<int[]> pq = new PriorityQueue<>((arr1,arr2)->arr2[1]-arr1[1]);
        //遍历hashmap，添加到大根堆中
        Set<Map.Entry<Integer, Integer>> entries = hashMap.entrySet();
        for(Map.Entry<Integer,Integer> entry:entries){
            pq.add(new int[]{entry.getKey(),entry.getValue()});
        }
        int [] result = new int[k];
        for (int i = 0; i <k; i++) {
            result[i] = pq.poll()[0];
        }
        return result;
        }
    }
