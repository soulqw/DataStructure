package leecode.n160;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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


//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        if (null == headA || null == headB) {
//            return null;
//        }
//        Set<ListNode> set = new HashSet<>();
//        while (headA != null) {
//            set.add(headA);
//            headA = headA.next;
//        }
//        while (headB != null) {
//            if (set.contains(headB)) {
//                return headB;
//            }
//            headB = headB.next;
//        }
//        return null;
//    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (null == headA || null == headB) {
            return null;
        }
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

}
