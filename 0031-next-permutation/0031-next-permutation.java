import java.util.*;

public class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        
        int i = n - 1;
        while (i > 0 && nums[i] <= nums[i - 1]) {
            i--;
        }
        
        if (i != 0) {
            int index = i;
            for (int j = n - 1; j >= i; j--) {
                if (nums[j] > nums[i - 1]) {
                    index = j;
                    break;
                }
            }
            // Swap
            int temp = nums[i - 1];
            nums[i - 1] = nums[index];
            nums[index] = temp;
        }
        
        // Reverse the part after index i
        int left = i, right = n - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
