package leecode.n283;

public class Container {

//    public void moveZeroes(int[] nums) {
//        if (nums == null || nums.length < 2) {
//            return;
//        }
//
//        boolean isChanged = false;
//        int length = nums.length;
//        for (int i = 0; i < length - 1; i++) {
//            for (int j = 0; j < nums.length - 1 - i; j++) {
//                int temple = nums[j];
//                if (temple == 0) {
//                    nums[j] = nums[j + 1];
//                    nums[j + 1] = temple;
//                    isChanged = true;
//                }
//            }
//            if (!isChanged) {
//                break;
//            }
//        }
//    }

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int fast = 0, slow = 0, length = nums.length;
        while (fast < length) {
            if (nums[fast] != 0) {
                swap(nums, fast, slow);
                slow++;
            }
            fast++;
        }
    }

    private void swap(int[] nums, int fast, int slow) {
        int temple = nums[fast];
        nums[fast] = nums[slow];
        nums[slow] = temple;
    }
}
