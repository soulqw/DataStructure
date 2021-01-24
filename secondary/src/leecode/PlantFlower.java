package leecode;

public class PlantFlower {


    public static void main(String[] args) {
        boolean result = canPlaceFlowers(new int[]{0, 0, 1, 0, 1}, 1);
        System.out.println("args = [" + result + "]");
    }

    /**
     * 种花问题
     * https://leetcode-cn.com/problems/can-place-flowers/
     * @param flowerbed
     * @param n
     * @return
     */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int canPlanSize = 0;
        int length = flowerbed.length;
        if (length == 1) {
            if (flowerbed[0] == 0) {
                canPlanSize++;
            }
            return canPlanSize >= n;
        }
        for (int i = 0; i < length; i++) {
            int element = flowerbed[i];
            if (element == 0) {
                if (i == 0 && flowerbed[1] == 0) {
                    flowerbed[i] = 1;
                    canPlanSize++;
                }
                if (i == length - 1 && flowerbed[i - 1] == 0) {
                    flowerbed[i] = 1;
                    canPlanSize++;
                }
                if (i > 0 && i < length - 1 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    canPlanSize++;
                }
            }
        }

        return canPlanSize >= n;
    }

}
