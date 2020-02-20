package sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] data = {1, 4, 9, 10, 22, 13, 3, 7};
        bubbleSortV3(data);
        System.out.println(Arrays.toString(data));
    }

    public static void bubbleSortV1(int[] data) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - 1 - i; j++) {
//                int temp;
                if (data[j] > data[j + 1]) {
//                    temp = data[j];
//                    data[j] = data[j + 1];
//                    data[j + 1] = temp;
                    data[j] ^= data[j + 1];
                    data[j + 1] ^= data[j];
                    data[j] ^= data[j + 1];
                }
            }
        }

        long endTime = System.currentTimeMillis();
        long all = endTime - startTime;
        System.out.println("time:" + all);
    }

    public static void bubbleSortV2(int[] data) {
        long startTime = System.currentTimeMillis();
        boolean isSorted = true;
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j] > data[j + 1]) {
                    data[j] ^= data[j + 1];
                    data[j + 1] ^= data[j];
                    data[j] ^= data[j + 1];
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        long all = endTime - startTime;
        System.out.println("time:" + all);
    }

    public static void bubbleSortV3(int[] data) {
        long startTime = System.currentTimeMillis();
        boolean isSorted = true;
        int lastExchangedIndex = 0;
        int sortBorder = data.length - 1;
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < sortBorder; j++) {
                if (data[j] > data[j + 1]) {
                    data[j] ^= data[j + 1];
                    data[j + 1] ^= data[j];
                    data[j] ^= data[j + 1];
                    lastExchangedIndex = j;
                    isSorted = false;
                }
            }
            sortBorder = lastExchangedIndex;
            if (isSorted) {
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        long all = endTime - startTime;
        System.out.println("time:" + all);
    }
}
