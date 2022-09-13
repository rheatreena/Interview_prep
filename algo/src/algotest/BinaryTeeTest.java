package algotest;

import java.util.List;
import java.util.Stack;

public class BinaryTeeTest {

    static class Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val = val;
        }

        Node(){

        }

        Node(int val, Node left, Node right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);


        //q1. validate BST
        System.out.print(validateBST(root));
        //q2. InOrder
        System.out.print(InOrderTraversal(root));

        //q3.
        System.out.print(PreOrderTraversal(root));

        //q4.
        System.out.print(NaryTreePreOrderTraversal());

        //q5.
        System.out.print(NaryTreeLevelOrderTraversal());

        //q6.

        System.out.print(checkValidParenthesis());

        //q7.
        System.out.print(checkValidString("(*))"));
    }

    private static boolean checkValidString(String s) {
        Stack<Integer> stack=new Stack<>();
        Stack<Integer> star=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
                stack.push(i);
            else if(s.charAt(i)=='*')
                star.push(i);
            else
            if(!stack.empty())
                stack.pop();
            else if(!star.empty())
                star.pop();
            else
                return false;
        }
        while(!stack.empty()){
            if(star.empty())
                return false;
            int leftover=stack.pop();
            int str=star.pop();
            if(str<leftover)
                return false;
        }
        return true;
    }

    private static boolean checkValidParenthesis() {
        return false;
    }

    private static List<List<Integer>> NaryTreeLevelOrderTraversal() {
        return null;
    }

    private static List<Integer> NaryTreePreOrderTraversal() {
        return null;
    }

    private static List<Integer> PreOrderTraversal(Node root) {
        //root, left, right
        return null;
    }

    private static List<Integer> InOrderTraversal(Node root) {
        //left, root, right
        return null;
    }

    private static boolean validateBST(Node root) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        return validate(root, min, max);
    }

    private static boolean validate(Node root, int min, int max) {

        if(root == null){
            return true;
        }
        if(root.val < min || root.val > max){
            return false;
        }

        return validate(root.left, min, root.val) && validate(root.right, root.val, max);
    }
}
