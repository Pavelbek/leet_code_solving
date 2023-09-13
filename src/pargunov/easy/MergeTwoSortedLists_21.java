package pargunov.easy;

public class MergeTwoSortedLists_21 {

    public ListNode<Integer> mergeTwoLists(ListNode<Integer> list1, ListNode<Integer> list2) {
        var dummy = new ListNode(0);
        var current = dummy;

        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                current.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                current.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            current = current.next;
        }

        while(list1 != null) {
            current.next = new ListNode(list1.val);
            list1 = list1.next;
            current = current.next;
        }

        while(list2 != null) {
            current.next = new ListNode(list2.val);
            list2 = list2.next;
            current = current.next;
        }

        return dummy.next;
    }
}
