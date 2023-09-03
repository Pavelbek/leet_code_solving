package pargunov.other;

public class MyLinkedList {
    public static void main(String[] args) {
        Node<Integer> head = createLinkedList(1, 2, 3, 4, 5);
        System.out.println("--------- Print linked list -----------");
        printLinkedList(head);
        System.out.println();
        System.out.println("--------- Print reversed linked list -----------");
        printReversedLinkedList(head);
        System.out.println();
        System.out.println("--------- Reverse linked list and print -----------");
        printLinkedList(reverseLinkedList(head));
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    private static <T> Node<T> createLinkedList(T ...values) {
        Node<T> head = new Node<>(values[0]);
        Node<T> current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new Node<>(values[i]);
            current = current.next;
        }

        return head;
    }

    private static <T> void printLinkedList(Node<T> head) {
        final String arrow = " -> ";
        Node<T> current = head;

        while (current.next != null) {
            System.out.print(current.value + arrow);
            current = current.next;
        }
        System.out.print(current.value);
    }

    private static <T> void printReversedLinkedList(Node<T> head) {
        final String arrow = " -> ";
        if (head.next != null) {
            printReversedLinkedList(head.next);
            System.out.print(arrow + head.value);
        } else {
            System.out.print(head.value);
        }
    }

    private static <T> Node<T> reverseLinkedList(Node<T> head) { // 1 -> 2 -> 3 -> 4 -> 5
        Node<T> prev = head;
        Node<T> current = head.next;
        prev.next = null;

        while (current != null) {
                var tmp = current.next;
                current.next = prev;
                prev = current;
                current = tmp;
        }

        return prev;
    }

}
