package algotest;

import java.util.Stack;

public class StackTest {
    static final int MAX = 1000;
    int top;
    //int [] a = new int[MAX];
    char [] a = new char[MAX];

    Node root;


    boolean isEmpty(){

        // for array
       // return  (top < 0);

        // for linkedlist
        if( root == null){
            return true;
        }
        return false;
    }

    StackTest(){
        top =-1;
    }


    static class Node{
        Node next;
        int val;

        Node(int val){
            this.val = val;
        }

    }

    public static void main(String[] args) {
        //q1. using array
        StackTest s = new StackTest();
        /*s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.pop() + " Popped from stack");
        System.out.println("Top element is :" + s.peek());
        System.out.print("Elements present in stack :");
        s.print();*/

        // q2. using linked list
        /*StackTest sll = new StackTest();
        sll.push1(100);
        sll.push1(200);
        sll.push1(300);

        System.out.println(sll.pop1()
                + " popped from stack");

        System.out.println("Top element is " + sll.peek1());*/

        //q3. large  Rectangular area in a histogram

        int hist[] = { 6, 2, 5, 4, 5, 1, 6 };
        System.out.println("Maximum area is " + getMaxArea(hist, hist.length));

        //q4. reverse a string using stack
        // create a new string
        StringBuffer input = new StringBuffer("GeeksQuiz");

        // call reverse method
        reverse(input);

        // print the reversed string
        System.out.println("Reversed string is " + input);
    }

    private static void reverse(StringBuffer input) {
        int n = input.length();
        StackTest obj = new StackTest();
        for(int i =0;i<n;i++){
            obj.push(input.charAt(i));

        }

        for(int i =0; i<n ; i++){
            char pop = obj.pop();
            input.setCharAt(i, pop);
        }
    }

    private void popElement(StringBuffer input) {

    }

    private void pushElement(StringBuffer input) {


    }

    private static int getMaxArea(int[] hist, int length) {
        Stack<Integer> stack = new Stack<>();
        int max_area =0;
        int top;
        int area_with_top;
        int i =0;
        while(i < length){
            //System.out.print(" hist peek "+ hist[stack.peek()] + "  hist [i] " + hist[i]);
            if(stack.empty() || hist[stack.peek()] <= hist[i]){
                stack.push(i++);
        }else{
            //store the top index
            top = stack.peek();
            stack.pop();
            // Calculate the area with hist[tp] stack as smallest bar
            area_with_top = hist[top]*(stack.empty() ? i : i-stack.peek()-1);

            if (max_area < area_with_top)
                max_area = area_with_top;
        }
        }
        while (stack.empty() == false)
        {
            top = stack.peek();
            stack.pop();
            area_with_top = hist[top] * (stack.empty() ? i : i - stack.peek() - 1);

            if (max_area < area_with_top)
                max_area = area_with_top;
        }

        return  max_area;
    }

    private int peek1() {
        int popped = Integer.MIN_VALUE;
        if( root == null){
            System.out.print(" stack is empty");
            return 0;
        }else{
            popped = root.val;
        }
        return popped;
    }

    private int pop1() {
        int popped = Integer.MIN_VALUE;
        if( root == null){
            System.out.print(" stack is empty");
            return 0;
        }else{
            popped = root.val;
            root = root.next;
        }
        return  popped;
    }

    private void push1(int element) {
        Node new_node = new Node(element);
        if( root == null){
            root = new_node;
        }
        else{
            //root.next = new_node;
            Node temp = root;
            root = new_node;
            new_node.next = temp;

        }
        System.out.println(element + " pushed into stack");
    }

    private void print() {
        for(int i = top; i>=0;i--){
            System.out.print(" "+ a[i] + " ");
        }
    }

    private int peek() {
        if(top < 0){
            System.out.print(" stack empty");
            return 0;
        }
        return a[top];
    }

    private char pop() {
        if(top < 0){
            System.out.print(" stack empty");
            return 0;
        }
        char removedElement = a[top--];
        return removedElement;
    }

    private boolean push(char element) {
        //check overflow
        if(top >= MAX-1){
            System.out.print(" stack overflow");
            return false;
        }
            a[++top] = element;
        System.out.println(element + " pushed into stack");
           return true;

    }

}
