package leecode.n209;

public class Container {

    public static void main(String[] args) {

    }

    public int minSubArrayLen(int target, int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int result = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sun = 0;
        while (end < length) {
            sun = sun + nums[end];
            while (sun >= target) {
                result = Math.min(result, end - start + 1);
                sun = sun - nums[start];
                start++;
            }
            end++;
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
