package day161;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class day161exercise_1 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead  = new ListNode(0);
        newHead.next = head;
        ListNode cur = head;
        ListNode pre = newHead;
        while(cur != null){
            if(cur.val == val){
                pre.next = cur.next;
            }
            else{
                pre = cur;
            }
            cur = cur.next;
        }
        return newHead.next;
    }
}

