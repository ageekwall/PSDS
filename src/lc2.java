
public class lc2 {

    public static void main(String[] args) {

        /*
        Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
        Output: 7 -> 0 -> 8
        Explanation: 342 + 465 = 807.
        */

        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(9);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(2);
        ListNode l7 = null;

        l1.next = null;
        l2.next = l3;
        l3.next = null;
        l4.next = null;
        l5.next = null;
        l6.next = null;

        lc2 l = new lc2();
        l7 = l.addTwoNumbers(l1,l4);
        while(l7!= null) {
            System.out.println(l7.val);
            l7 = l7.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int rem = 0;
        ListNode node = null;
        ListNode head = null;
        while(l1!= null || l2 != null) {
            int x;
            if(l1 == null) x = l2.val+rem;
            else if(l2 == null) x = l1.val +rem;
            else {
                x = l1.val + l2.val + rem;
            }
            if(node == null) {
                node = new ListNode(x % 10);
                head = node;
            }
            else {
                node.next = new ListNode(x%10);
                node = node.next;
            }
            rem = x/10;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
            node.next = null;
        }
        if(rem > 0) {
            node.next = new ListNode(rem);
            node = node.next;
        }
        node.next = null;
        return head;
    }
}

