package pargunov.easy;

public class PalindromeLinkedList_234 {
    public static void main(String[] args) {

    }

    // Runtime Beats 56.82% Memory Beats 66.15%
    public boolean isPalindrome(ListNode<Integer> head) {
        var reversed = reverseLinkledList(middleOfLinkedList(head));

        while(reversed != null) {
            if(head.val != reversed.val) return false;
            reversed = reversed.next;
            head = head.next;
        }

        return true;
    }

    public <T> ListNode<T> middleOfLinkedList(ListNode<T> head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public <T> ListNode<T> reverseLinkledList(ListNode<T> head) {
        ListNode prev = null;

        while(head != null) {
            var right = head.next;
            head.next = prev;
            prev = head;
            head = right;
        }

        return prev;
    }
}
