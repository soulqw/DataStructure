package leecode.n141;

import java.util.*;

public class Container {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
    }

//    public static boolean hasCycle(ListNode head) {
//        if (null == head) {
//            return false;
//        }
//        ListNode current = head;
//        List<ListNode> set = new ArrayList<>();
//        set.add(current);
//        while (current.next != null) {
//            ListNode next = current.next;
//            if (!set.contains(next)) {
//                set.add(next);
//                current = next;
//                continue;
//            }
//            return true;
//        }
//        return false;
//    }

    public static boolean hasCycle(ListNode head) {
        if (null == head || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}
