package meta;

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(-1);
            ListNode current = dummy;
            ListNode t1 = l1;
            ListNode t2 = l2;
            int carry = 0;
            while(t1!=null || t2!=null) {
                int sum = carry;
                if(t1!=null) sum += t1.val;
                if(t2!=null) sum += t2.val;

                ListNode newNode = new ListNode(sum%10);
                carry = sum/10;

                current.next = newNode;
                current = current.next;
                if(t1!=null) t1 = t1.next;
                if(t2!=null) t2 = t2.next;
            }

            if(carry!=0) {
                current.next = new ListNode(carry);
            }

            return dummy.next;
    }

    static class ListNode {
        int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
