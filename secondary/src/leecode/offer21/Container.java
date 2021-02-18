package leecode.offer21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Container {
    public static void main(String[] args) {

    }

//    public static int[] exchange(int[] nums) {
//        List<Integer> temple = new ArrayList<>();
//        for (int num : nums) {
//            if (num % 2 != 0) {
//                temple.add(num);
//            }
//        }
//        for (int num : nums) {
//            if (num % 2 == 0) {
//                temple.add(num);
//            }
//        }
//        int[] resultData = new int[temple.size()];
//        for (int i = 0; i < resultData.length; i++) {
//            resultData[i] = temple.get(i);
//        }
//        return resultData;
//    }

//    public static int[] exchange(int[] nums) {
//        int slow = 0;
//        for (int fast = 0; fast < nums.length; fast++) {
//            int num = nums[fast];
//            //fast为基数数交换且提高慢指针
//            if (num % 2 != 0) {
//                int temple = nums[slow];
//                nums[slow] = num;
//                nums[fast] = temple;
//                slow++;
//            }
//        }
//        return nums;
//    }

    public static int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            //左边只关心偶数，否则++
            if (nums[left] % 2 != 0) {
                left++;
                continue;
            }
            if (nums[right] % 2 == 0) {
                right--;
                continue;
            }
            int temple = nums[left];
            nums[left] = nums[right];
            nums[right] = temple;
        }
        return nums;
    }
}
