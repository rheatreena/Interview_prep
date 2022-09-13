package algotest;

public class CircularLinkedList {
    Node head;

    static class Node{

        Node next;
        int val;

        /*Node(int val ){
            this.val = val;
        }*/
    }
    public static void main(String[] args) {
        //q1. insert
        // insert at beginning
        Node last = null;
        last = addToEmpty(last, 3);
        //printCircularLinkedList(last);
        last = addbegin(last, 6);
        last = addbegin(last, 4);
        last = addEnd(last, 10);
        last = addAfter(last, 6, 8);

        //q2. traverse
        printCircularLinkedList(last);
        //q3. delete
        last = deleteNode(last, 4);
        printCircularLinkedList(last);
        //q4.
    //check circular list
        System.out.print(isCircular(last) ? "Yes\n"
                : "No\n");




    }

    private static boolean isCircular(Node last) {
        Node temp = last.next;
        if (last == null){
            return true;
        }
        while(temp != null  &&  temp != last){
            temp = temp.next;

        }

        return temp == last;
    }

    private static Node deleteNode(Node last, int element) {
        if(last == null){
            return null;
        }
        Node curr = last, prev = new Node();
        //
        while(curr.val != element){
            if(curr.next == last){
            System.out.println(" element not found");
            break;
            }
            prev = curr;
            curr = curr.next;

        }

        // Check if node is only node
        if(curr.next == last &&  curr == last){
            last = null;
            return last;
        }

        // If more than one node, check if
        // it is first node

        if(curr == last){
            prev = last;
            while(prev.next != last){
                prev = prev.next;
            }
            last = curr.next;
            prev.next = last;
        }
// check if node is last node
        else if (curr.next == last)
        {
            prev.next = last;
        }
        else
        {
            prev.next = curr.next;
        }

        return last;


    }

    private static Node addAfter(Node last, int target, int element) {
        if(last == null){
            return null;
        }
       Node temp = new Node();
        Node p;
       temp.val = element;
       p = last.next;
        do {
            if (p.val == target) {
                temp = new Node();
                temp.val = element;
                temp.next = p.next;
                p.next = temp;
                if (p == last)
                    last = temp;
                return last;
            }
            p = p.next;
        } while (p != last.next);
        return last;
    }

    private static Node addEnd(Node last, int element) {
        if(last == null){
            return addToEmpty(last, element);
        }
        Node temp = new Node();
        temp.val = element;
        temp.next = last.next;
        last.next = temp;
        last = temp;
        return last;

    }

    private static void printCircularLinkedList(Node last) {
        Node node;
        if(last == null ){
            System.out.println(" List is empty " );
            return;
        }
        node = last.next;
        do{
        System.out.print( " " +  node.val + " ");
        node = node.next;
        }while(node != last.next);
    }

    private static Node addToEmpty(Node last, int element) {
        if(last != null){
            return last;
        }
        Node temp = new Node();
        temp.val = element;
        last = temp;
        last.next = last;
        return last;

    }

    private static Node addbegin(Node last, int element) {
        if(last == null){
            return addToEmpty(last, element);
        }
            Node prev = new Node();
            prev.val = element;
            prev.next = last.next;
            last.next = prev;
    return last;
    }
}
