package leecode.n27;

public class Container {

    public static void main(String[] args) {
//        int result = removeElement(new int[]{3, 2, 2, 3}, 3);
//        int result = removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2);
        int result = removeElementV2(new int[]{1, 2, 3, 5}, 3);
        System.out.printf("result " + result);
    }

    public static int removeElement(int[] nums, int val) {
        int elementSize = nums.length;
        for (int i = 0; i < elementSize; i++) {
            int current = nums[i];
            if (current == val) {
                for (int j = i + 1; j < elementSize; j++) {
                    nums[i] = nums[j];
                }
                i--;
                elementSize--;
            }
        }
        return elementSize;
    }


    public static int removeElementV2(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
