/**
 * Definition for singly-linked list node.
 */
class ListNode {
    int val;
    ListNode next;

    // Constructor to initialize a node with a value
    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    // Constructor to initialize a node with a value and next pointer
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

/**
 * A utility class to perform various operations on a singly-linked list.
 */
public class LinkedListOperations {

    /**
     * Inserts a new node at the end of the linked list.
     * @param head The head of the linked list.
     * @param val The value to insert.
     * @return The head of the updated linked list.
     */
    public ListNode insertEnd(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) return newNode; // if list is empty

        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode; // Link the last node to the new node
        return head;
    }

    /**
     * Deletes the middle node from the linked list.
     * @param head The head of the linked list.
     * @return The head of the updated linked list.
     */
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null; // If there's only one node, deleting it leaves an empty list
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        // Move fast pointer by 2 steps and slow by 1 step to find the middle
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Skip the middle node
        prev.next = slow.next;
        return head;
    }

    /**
     * Calculates the length of the linked list.
     * @param head The head of the linked list.
     * @return The length of the linked list.
     */
    public int length(ListNode head) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            current = current.next;
            length++;
        }
        return length;
    }

    /**
     * Reverses the linked list.
     * @param head The head of the linked list.
     * @return The head of the reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        
        // Iterate through the list and reverse pointers
        while (current != null) {
            ListNode nextNode = current.next; // Store the next node
            current.next = prev; // Reverse the link
            prev = current; // Move prev to the current node
            current = nextNode; // Move to the next node
        }
        
        return prev; // New head of the reversed list
    }

    /**
     * Prints all nodes in the linked list.
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
        LinkedListOperations listOps = new LinkedListOperations();

        // Creating and populating the list
        ListNode head = new ListNode(1);
        head = listOps.insertEnd(head, 2);
        head = listOps.insertEnd(head, 3);
        head = listOps.insertEnd(head, 4);
        head = listOps.insertEnd(head, 5);

        System.out.println("Original List:");
        listOps.printList(head);

        System.out.println("\nLength of List: " + listOps.length(head));

        System.out.println("\nDeleting the middle node:");
        head = listOps.deleteMiddle(head);
        listOps.printList(head);

        System.out.println("\nReversing the List:");
        head = listOps.reverse(head);
        listOps.printList(head);
    }
}
