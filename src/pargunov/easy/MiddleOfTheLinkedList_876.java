package pargunov.easy;

public class MiddleOfTheLinkedList_876 {
    public static void main(String[] args) {

    }
    public ListNode middleNode(ListNode head) {
        var slow = head;
        var fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
  }
}
