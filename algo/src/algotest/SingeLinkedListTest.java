package algotest;

public class SingeLinkedListTest {

    Node head;
    static class Node{
        Node next;
        int val;

        Node(int val){
            this.next = null;
            this.val = val;
        }
    }
    public static void main(String[] args) {
        //q1. add
        SingeLinkedListTest s1 = new SingeLinkedListTest();
        s1.head = new Node(5);
        s1.head.next = new Node(7);
        s1.head.next.next = new Node(10);
        s1.head.next.next.next = new Node(12);
        s1.head.next.next.next.next = new Node(13);
        insert(s1, 78);
        insert(s1, 39);

        //q2. search and traversal
       //printList(s1);

        //q3 deletion
        // Delete node with value 5
        // In this case the key is ***at head***
        deleteByKey(s1, 5);
        //printList(s1);
       // deleteByKey(s1, 12);
        //printList(s1);
        //q4. single linkedList to circular linkedlist
       circular(s1.head);

        displayList(s1.head);
    }

    private static void displayList(Node node) {

        Node start = node;

        while (node.next != start)
        {
            System.out.print(" "+ node.val);
            node = node.next;
        }

        // Display the last node of
        // circular linked list.
        System.out.print(" " + node.val);
    }

    private static Node circular(Node head) {
        // store primary head
        Node start = head;
        while (head.next != null) {
           head =  head.next;

        }
        head.next = start;
        return start;

    }

    private static SingeLinkedListTest deleteByKey(SingeLinkedListTest s1, int element) {
        Node prev = null;
        if(s1.head == null){
            return s1;
        }
        if(s1.head != null && s1.head.val == element){
            s1.head = s1.head.next;
            return s1;
        }
        while(s1.head != null && s1.head.val != element){
            prev = s1.head;
            s1.head = s1.head.next;
        }
        if(s1.head != null){
        prev.next = s1.head.next;
            System.out.println(element + " found and deleted");
        }
        return s1;
    }

    private static void insert(SingeLinkedListTest s1, int element) {

        if (s1.head == null) {
            s1.head =  new Node(element);
        } else {

            Node last = s1.head;
            while(last.next != null){
                last = last.next;
            }
            last.next = new Node(element);

        }
    }

    private static void printList(SingeLinkedListTest s1) {
        while(s1.head != null){
            System.out.print(" " + s1.head.val + " ");
            s1.head = s1.head.next;
        }
    }
}
