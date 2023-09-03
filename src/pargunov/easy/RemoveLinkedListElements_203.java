package pargunov.easy;

public class RemoveLinkedListElements_203 {
    public static void main(String[] args) {
        var head = createLinkedList(1, 6, 6);
        var updated = removeElements(head, 6);
    }

    private static <T> ListNode<T> removeElements(ListNode<T> head, T val) {
        if (head == null) return head;

        ListNode newHead = new ListNode(val);
        newHead.next = head;
        var current = newHead;

        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return newHead.next;
    }

    private static class ListNode<T> {
        T val;
        ListNode<T> next;

        public ListNode(T value) {
            this.val = value;
        }
    }

    private static <T> ListNode<T> createLinkedList(T ...values) {
        ListNode<T> head = new ListNode<>(values[0]);
        ListNode current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode<>(values[i]);
            current = current.next;
        }

        return head;
    }
}
