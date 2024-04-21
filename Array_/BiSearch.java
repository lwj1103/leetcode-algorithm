package alrorithm.Array_;

/**
 * 二分查找
 */
public class BiSearch {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        BiSearch biSearch = new BiSearch();
        int search = biSearch.search(nums, 9);
        System.out.println(search);
    }
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] < target) left = mid+1;
            else if(nums[mid] > target) right = mid-1;
            else return mid;
        }
        return -1;
    }
}
