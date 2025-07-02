class Node {
    int data;
    Node next;
    
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkAddOne {
    public Node addOne(Node head) {
        head = reverse(head);
        Node c = head;
        int carry = 1;
        
        while (c != null) {
            int sum = c.data + carry;
            c.data = sum % 10;
            carry = sum / 10;
            if (c.next == null && carry > 0) {
                c.next = new Node(carry);
                carry = 0;
            }
            c = c.next;
        }
        
        return reverse(head);
    }

    private Node reverse(Node head) {
        Node prev = null, next = null, curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        LinkAddOne solution = new LinkAddOne();

        // Test Case 1: Normal Case
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        System.out.print("Input:  ");
        solution.printList(head1);
        head1 = solution.addOne(head1);
        System.out.print("Output: ");
        solution.printList(head1); // Expected: 1 2 4

        // Test Case 2: Carry Propagation
        Node head2 = new Node(1);
        head2.next = new Node(9);
        head2.next.next = new Node(9);
        System.out.print("\nInput:  ");
        solution.printList(head2);
        head2 = solution.addOne(head2);
        System.out.print("Output: ");
        solution.printList(head2); // Expected: 2 0 0

        // Test Case 3: All 9s (Extra Node Addition)
        Node head3 = new Node(9);
        head3.next = new Node(9);
        head3.next.next = new Node(9);
        System.out.print("\nInput:  ");
        solution.printList(head3);
        head3 = solution.addOne(head3);
        System.out.print("Output: ");
        solution.printList(head3); // Expected: 1 0 0 0
    }

}
