package pargunov.easy;

public class RemoveDuplicatesFromSortedList_83 {

    // Runtime Beats 100.00% Memory Beats 23.15%
    public ListNode deleteDuplicates(ListNode head) {
        var current = head;

        while(current != null && current.next != null) {
            if(current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

    // Recursive solution Runtime Beats 100.00% Memory Beats 40.14%
    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        if(head.val == head.next.val) head.next = head.next.next;
        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
