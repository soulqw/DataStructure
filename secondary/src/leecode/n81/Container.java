package leecode.n81;

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

    public ListNode deleteDuplicates(ListNode head) {
        ListNode originNode = new ListNode(-1);
        originNode.next = head;

        ListNode pre = originNode;
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.    val == current.next.val) {
                pre.next = getDifferentNextNode(current, current.next);
                current = pre;
            } else {
                pre = current;
                current = current.next;
            }
        }
        return originNode.next;
    }

    private ListNode getDifferentNextNode(ListNode current, ListNode next) {
        if (next != null && current.val == next.val) {
            return getDifferentNextNode(current, next.next);
        }
        return next;
    }

}
