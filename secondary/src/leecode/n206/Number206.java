package leecode.n206;

import java.util.ArrayList;
import java.util.List;

public class Number206 {


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

    /**
     * https://mp.weixin.qq.com/s/pnvVP-0ZM7epB8y3w_Njwg
     *
     * @param head
     */
    public static ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode pre = null;
        while (current != null) {
            ListNode temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }
        return pre;
    }

//

    public static void main(String[] args) {

    }


}
