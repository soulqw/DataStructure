package sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] data = {1, 4, 9, 10, 22, 13, 3, 7};
        int[] data2 = {2, 3, 4, 5, 6, 7, 8, 1};
        sort(4, data2);
        System.out.println(Arrays.toString(data2));
    }

    public static void sort(int type, int[] data) {
        long startTime = System.nanoTime();
        switch (type) {
            default:
            case 1:
                bubbleSortV1(data);
                break;
            case 2:
                bubbleSortV2(data);
                break;
            case 3:
                bubbleSortV3(data);
                break;
            case 4:
                cocktailSort(data);
                break;
        }

        long endTime = System.nanoTime();
        long all = endTime - startTime;
        System.out.println("time:" + all);
    }

    public static void bubbleSortV1(int[] data) {
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
    }

    public static void bubbleSortV2(int[] data) {
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
    }

    public static void bubbleSortV3(int[] data) {
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
    }

    public static void cocktailSort(int[] data) {
        for (int i = 0; i < data.length / 2; i++) {

            boolean isSorted = true;
            for (int j = i, size = data.length - 1 - i; j < size; j++) {
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

            isSorted = true;
            for (int j = data.length - 1 - i; j > i; j--) {
                if (data[j] < data[j - 1]) {
                    data[j] ^= data[j - 1];
                    data[j - 1] ^= data[j];
                    data[j] ^= data[j - 1];
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }
}
