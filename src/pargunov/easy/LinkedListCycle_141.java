package pargunov.easy;

public class LinkedListCycle_141 {
    public static void main(String[] args) {

    }

    private static boolean hasCycle(ListNode head) {
        var fast = head;
        var slow = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) return true;
        }
        return false;
    }

    private static class ListNode<T> {
        T val;
        ListNode<T> next;

        public ListNode(T value) {
            this.val = value;
        }
    }
}
