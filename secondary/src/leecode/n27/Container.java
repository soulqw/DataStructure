package leecode.n27;

public class Container {

    public static void main(String[] args) {
//        int result = removeElement(new int[]{3, 2, 2, 3}, 3);
        int result = removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2);
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
}
