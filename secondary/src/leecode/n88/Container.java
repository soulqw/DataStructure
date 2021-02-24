package leecode.n88;

import java.util.Arrays;

public class Container {

    public static void main(String[] args) {


    }

//    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        int[] result;
//        if (nums1.length == (m + n)) {
//            for (int i = 0; i < n; i++) {
//                nums1[m + i] = nums2[i];
//            }
//            result = nums1;
//        } else {
//            for (int i = 0; i < m; i++) {
//                nums2[n + i] = nums1[i];
//            }
//            result = nums2;
//        }
//        Arrays.sort(result);
//    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sort = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sort[p1 + p2 - 1] = cur;
        }
        for (int i = 0, size = m + n; i < size; i++) {
            nums1[i] = sort[i];
        }
    }
}
