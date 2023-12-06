package pargunov.medium;

import pargunov.easy.ListNode;

import java.util.Arrays;

public class AddTwoNumbers_2 {
    public static void main(String[] args) {
        // for int < 10 : int / 10 = 0;   int >= 10 = 1;
        // for int < 10 : int % 10 = int; int > 10 = int - 10; int == 10 = 0;

        //case:
        // 99
        // 9
        // 8 0 1
        //case:
        // 9 9 8
        // 9
        // 8 0 9

        System.out.println(Arrays.toString("a##d#c".split("")));
    }
    private static ListNode<Integer> addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {
        ListNode<Integer> dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while(l1 != null || l2 != null) {
            int sum = 0 + carry;

            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            sum = sum % 10;
            current.next = new ListNode(sum);
            current = current.next;
        }

        if(carry == 1) current.next = new ListNode(carry);

        return dummy.next;
    }
}
