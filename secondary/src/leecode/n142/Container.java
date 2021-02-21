package leecode.n142;

import java.util.ArrayList;
import java.util.List;

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

    public ListNode detectCycle(ListNode head) {
        if (null == head || null == head.next) {
            return null;
        }
        if (head.next == head) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next == null) {
                return null;
            } else {
                fast = fast.next.next;
            }
            //因此，当发现 \textit{slow}slow 与 \textit{fast}fast 相遇时，我们再额外使用一个指针 \textit{ptr}ptr。起始，它指向链表头部；随后，它和 \textit{slow}slow 每次向后移动一个位置。最终，它们会在入环点相遇。
            //
            //作者：LeetCode-Solution
            //链接：https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/huan-xing-lian-biao-ii-by-leetcode-solution/
            //来源：力扣（LeetCode）
            //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
            if (slow == fast) {
                ListNode pre = head;
                while (pre != slow) {
                    slow = slow.next;
                    pre = pre.next;
                }
                return pre;
            }
        }
        return null;
    }

//    public ListNode detectCycle(ListNode head) {
//        if (null == head || null == head.next) {
//            return null;
//        }
//        if (head.next == head) {
//            return head;
//        }
//        List<ListNode> list = new ArrayList<>();
//        while (head != null) {
//            if (list.contains(head)) {
//                return head;
//            } else {
//                list.add(head);
//            }
//            head = head.next;
//        }
//        return null;
//    }
}
