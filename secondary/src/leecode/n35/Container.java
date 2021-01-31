package leecode.n35;

public class Container {

    public static int searchInsert(int[] nums, int target) {
        int resultIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (target == current) {
                return i;
            }
            if (current < target) {
                resultIndex = i + 1;
            }
        }
        return resultIndex;
    }

    public static int searchInsertV2(int[] nums, int target) {
        int resultIndex = nums.length;
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        while (leftIndex <= rightIndex) {
            int midIndex = (leftIndex + rightIndex) >> 1;
            if (target <= nums[midIndex]) {
                resultIndex = midIndex;
                rightIndex = midIndex - 1;
            } else {
                leftIndex = midIndex + 1;
            }
        }
        return resultIndex;
    }

    /**
     * office
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsertV3(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] testData = new int[]{1, 3, 5, 6};
        int result = searchInsertV2(testData, 7);
        System.out.printf(result + " ");
    }
}
