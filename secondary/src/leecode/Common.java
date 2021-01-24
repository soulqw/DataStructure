package leecode;


import java.util.*;

public class Common {


    /**
     * 求和
     * https://leetcode-cn.com/problems/two-sum/
     * System.out.println(Arrays.toString(twoSum(12, new int[]{2, 10, 11, 7})));
     *
     * @param target
     * @param nums
     * @return
     */
    public static int[] twoSum(int target, int[] nums) {
        int[] result = new int[2];
        for (int i = 0, size = nums.length; i < size; i++) {
            int element = nums[i];
            result[0] = i;
            for (int j = i + 1, size2 = nums.length; j < size2; j++) {
                if (element + nums[j] == target) {
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }


    /**
     * 找到数组中重复的元素
     * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
     * System.out.printf(findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
     *
     * @param nums
     * @return
     */
    public static int findRepeatNumber(int[] nums) {
        if (nums.length < 3 || nums.length > 100000) {
            return -1;
        }
        for (int i = 0, size = nums.length; i < size; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] ^ nums[j]) == 0) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    public int findRepeatNumberV2(int[] nums) {
        if (nums.length < 3 || nums.length > 100000) {
            return -1;
        }
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

    /**
     * 两数相加
     * https://leetcode-cn.com/problems/add-two-numbers/submissions/
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        return head.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

    /**
     * https://leetcode-cn.com/problems/reverse-linked-list/
     *
     * @param head
     */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        return prev;
    }

    /**
     * 相交链表
     * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/submissions/
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null)
            return null;
        if (headB == null) {
            return null;
        }
        ListNode currA = headA;
        ListNode currB = headB;
        while (currA != currB) {
            currA = currA == null ? headB : currA.next;
            currB = currB == null ? headA : currB.next;
        }
        return currA;
    }

    /**
     * 第一个错误的版本
     * https://leetcode-cn.com/problems/first-bad-version/
     *
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) >> 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public boolean isBadVersion(int version) {
        if (version > 4) {
            return true;
        }
        return false;
    }

    /**
     * https://leetcode-cn.com/problems/3sum/
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 3) return ans;
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) L++; // 去重
                    while (L < R && nums[R] == nums[R - 1]) R--; // 去重
                    L++;
                    R--;
                } else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return ans;
    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int result = 0;
        Map<Integer, Integer> data = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                int sunAB = a + b;
                if (data.containsKey(sunAB)) {
                    data.put(sunAB, data.get(sunAB) + 1);
                } else {
                    data.put(sunAB, 1);
                }
            }
        }
        for (int c : C) {
            for (int d : D) {
                int sunCD = -(c + d);
                if (data.containsKey(sunCD)) {
                    result += data.get(sunCD);
                }
            }
        }
        return result;
    }

    /**
     *  删除排序数组中的重复项 II
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int i = 1, count = 1, length = nums.length;
        while (i < length) {
            if (nums[i] == nums[i - 1]) {
                count++;
                if (count > 2) {
                    remElement(nums, i);
                    i--;
                    length--;
                }
            } else {
                count = 1;
            }
            i++;
        }
        return length;
    }

    public static int[] remElement(int[] arr, int index) {
        for (int i = index + 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        return arr;
    }


    public static String[] findWords(String[] words) {
        List<String> line1 = Arrays.asList("Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P");
        List<String> line2 = Arrays.asList("A", "S", "D", "F", "G", "H", "J", "K", "L");
        List<String> line3 = Arrays.asList("Z", "X", "C", "V", "B", "N", "M");
        List<String> all = new ArrayList<>();
        for (String word : words) {
            String temple = word.toUpperCase();
            boolean isMatched = contains(temple, line1) || contains(temple, line2) || contains(temple, line3);
            if (isMatched) {
                all.add(word);
            }
        }
        String[] results = new String[all.size()];
        for (int i = 0; i < all.size(); i++) {
            results[i] = all.get(i);
        }
        return results;
    }

    public static boolean contains(String s, List<String> datas) {
        String[] all = s.split("");
        for (String s1 : all) {
            if (!datas.contains(s1)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3});
    }

}
