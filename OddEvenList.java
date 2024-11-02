// File: OddEvenList.java

/**
 * Definition for singly-linked list node.
 */
class ListNode {
    int val;
    ListNode next;

    // Constructor to initialize a node with a value
    public ListNode() {}

    // Constructor to initialize a node with a given value
    public ListNode(int val) {
        this.val = val;
    }

    // Constructor to initialize a node with a given value and a next pointer
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

/**
 * Class containing the solution for rearranging a linked list to group odd and even indexed nodes.
 */
public class OddEvenList {

    /**
     * Rearranges the linked list by grouping all odd-indexed nodes followed by even-indexed nodes.
     * The relative order among odd and even nodes is preserved.
     * 
     * @param head The head of the linked list.
     * @return The head of the modified linked list.
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head; // Return as-is if list has 0 or 1 node
        }

        ListNode odd = head; // Pointer to the start of the odd-indexed nodes
        ListNode even = head.next; // Pointer to the start of the even-indexed nodes
        ListNode temp = even; // Save the start of the even list to link later

        // Iterate while there are more even nodes in the list
        while (even != null && even.next != null) {
            odd.next = odd.next.next; // Link current odd node to the next odd node
            even.next = even.next.next; // Link current even node to the next even node
            odd = odd.next; // Move odd pointer forward
            even = even.next; // Move even pointer forward
        }

        // Link the end of the odd list to the start of the even list
        odd.next = temp;

        return head; // Return the modified list
    }

    /**
     * Utility function to print the linked list.
     * 
     * @param head The head of the linked list.
     */
    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        OddEvenList solution = new OddEvenList();

        // Creating a sample list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        solution.printList(head);

        // Applying oddEvenList operation
        head = solution.oddEvenList(head);

        System.out.println("\nList after odd-even arrangement:");
        solution.printList(head);
    }
}
