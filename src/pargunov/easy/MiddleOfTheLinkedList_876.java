package pargunov.easy;

public class MiddleOfTheLinkedList_876 {
    public static void main(String[] args) {

    }
    public <T> ListNode<T> middleNode(ListNode<T> head) {
        ListNode slow = head;
        var fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
