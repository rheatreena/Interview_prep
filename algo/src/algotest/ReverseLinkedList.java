package algotest;

import java.util.Stack;

public class ReverseLinkedList {
    static Node head;
    static class Node{
         Node next;
         int val;

         Node(int val){
           this.val = val;
         }
    }
    public static void main(String[] args) {
        push( 5);
        push( 4);
        push( 3);
        push( 2);
        push( 1);

        head = reverseList(head);

        printList(head);
    }

    private static void printList(Node head) {
        while(head != null){
            System.out.print(" "+ head.val + " ");
            head = head.next;
        }
    }

    private static Node reverseList(Node head) {
        Stack<Node> stack = new Stack<>();
        Node ptr = head;
        while (ptr.next != null){
            stack.push(ptr);
            ptr =ptr.next;
        }
        //pop
        head = ptr;
        while(!stack.isEmpty()){
            ptr.next = stack.peek();
            ptr = ptr.next;
            stack.pop();
        }
        ptr.next = null;

        return head;
    }

    private static void push(int element) {
        Node new_node = new Node(element);
        if(head == null){
            head = new_node;
        }else{

            //Node last = null;
           // while(head != null){
            //last = head;
                new_node.next = head;
                head = new_node;
            //}

        }

    }
}
