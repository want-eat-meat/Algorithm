import java.lang.reflect.Array;
import java.util.Arrays;

public class BinarySearch {
    public static int binarySearch(int[] nums, int start, int end,  int target){
        if (start == end) {
            return -1;
        }
        int mid = (start + end) / 2;

        if(nums[mid] == target){
            return mid;
        }
        if(nums[mid] > target){
            return binarySearch(nums, start, mid - 1, target);
        }else{
            return binarySearch(nums, mid + 1, end, target);
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 5, 6, 7, 8};
        Arrays.sort(a);
        System.out.println(binarySearch(a, 0, a.length, 4));
    }
}
