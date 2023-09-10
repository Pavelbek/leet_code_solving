package pargunov.easy;

public class ReverseLinkedList_206 {

    public static void main(String[] args) {

    }

    // Runtime Beats 100.00% Memory Beats 82.46%
    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;

        while(head != null) {
            var right = head.next;
            head.next = prev;
            prev = head;
            head = right;
        }

        return prev;
    }

    private static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
}
