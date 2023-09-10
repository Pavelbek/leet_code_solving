package pargunov.easy;

public class PalindromeLinkedList_234 {
    public static void main(String[] args) {

    }

    // Runtime Beats 56.82% Memory Beats 66.15%
    public boolean isPalindrome(ListNode head) {
        var reversed = reverseLinkledList(middleOfLinkedList(head));

        while(reversed != null) {
            if(head.val != reversed.val) return false;
            reversed = reversed.next;
            head = head.next;
        }

        return true;
    }

    public ListNode middleOfLinkedList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode reverseLinkledList(ListNode head) {
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
