package leecode.n234;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Container {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {

    }

    public boolean isPalindrome(ListNode head) {
        if (null == head) {
            return true;
        }
        ListNode pre = head;
        ListNode current = head;
        List<ListNode> set = new ArrayList<>();
        while (current != null) {
            set.add(0, current);
            ListNode temple = current.next;
            current.next = pre;
            pre = current;
            current = temple;
        }
        int loopCount = set.size() - 1;
        while (loopCount != 0) {
            if (set.get(loopCount).val != pre.val) {
                return false;
            }
            pre = pre.next;
            loopCount--;
        }
        return true;
    }
}
