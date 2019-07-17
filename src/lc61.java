public class lc61 {
    public ListNode rotateRight(ListNode head, int k) {
        int s = 1;
        ListNode temp = head;
        if(temp == null) return null;
        while(temp.next != null) {
            s++;
            temp = temp.next;
        }
        System.out.println(s);
        if(s == 1 || k== 0) return head;
        ListNode tail = temp;
        if(s == k) return head;
        int dif = 0;
        if(s > k) {
            dif = s - k;
        }
        else {
            if(k%s ==0) return head;
            dif =s-k%s;
        }
        ListNode te = head;
        if(dif == 1) {
            tail.next = head;
            head = te.next;
            te.next = null;
            return head;
        }
        ListNode tempe = head;
        while(dif != 1 && tempe != null) {
            tempe = tempe.next;
            dif = dif-1;
        }
        if(tempe == null) return head;
        ListNode tt = tempe.next;
        tempe.next = null;
        tail.next = head;
        head = tt;
        return head;
    }
}
