package algotest;

public class doublyLinkedList {

    Node head;
    static class Node{
        Node prev, next;
        int val;

        Node(int val){
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        doublyLinkedList dll  = new doublyLinkedList();
        // Insert 6. So linked list becomes 6->NULL
        dll.append(6);

        // Insert 7 at the beginning. So
        // linked list becomes 7->6->NULL
        dll.push(7);

        // Insert 1 at the beginning. So
        // linked list becomes 1->7->6->NULL
        dll.push(1);

        // Insert 4 at the end. So linked
        // list becomes 1->7->6->4->NULL
        dll.append(4);

        // Insert 8, after 7. So linked
        // list becomes 1->7->8->6->4->NULL
        dll.InsertAfter(dll.head.next, 8);

        // Insert 5, before 8.So linked
        // list becomes 1->7->5->8->6->4
        // dll.InsertBefore(dll.head.next.next, 5);

        System.out.println("Created DLL is: ");
        dll.printlist(dll.head);
    }

    private void InsertAfter(Node next, int element) {
    }

    private void printlist(Node head) {
        Node last = null;
        if(head == null){
            System.out.println(" no element is present");
        }
        while(head != null){
            System.out.print(" " +  head.val);
            last = head;
            head = head.next;
        }
        System.out.println();
        System.out.println(
                "Traversal in reverse direction");

        while(last != null){
            System.out.print(" " + last.val + " ");
            last = last.prev;
        }
    }

    private void push(int element) { // at the beginning
        /* 1. allocate node
         * 2. put in the data */
        Node new_Node = new Node(element);

        /* 3. Make next of new node as head and previous as
         * NULL */
        new_Node.next = head;
        new_Node.prev = null;

        /* 4. change prev of head node to new node */
        if (head != null)
            head.prev = new_Node;

        /* 5. move the head to point to the new node */
        head = new_Node;
    }

    private void append(int element) {
        /* 1. allocate node
         * 2. put in the data */
        Node new_node = new Node(element);

        Node last = head;

        /* 3. This new node is going to be the last node, so
         * make next of it as NULL*/
        new_node.next = null;

        /* 4. If the Linked List is empty, then make the new
         * node as head */
        if (head == null) {
            new_node.prev = null;
            head = new_node;
            return;
        }

        /* 5. Else traverse till the last node */
        while (last.next != null)
            last = last.next;

        /* 6. Change the next of last node */
        last.next = new_node;

        /* 7. Make last node as previous of new node */
        new_node.prev = last;
    }
}
