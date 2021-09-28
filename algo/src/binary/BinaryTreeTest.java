/**
 * @author trinapal
 */
public class BinaryTreeTest {

    private Node node;


    BinaryTreeTest(){
        node = null;
    }

    static class Node{
        private Node left;
        private Node right;
        private int root;

        Node(int root){
            this.left =null;
            this.right = null;
            this.root = root;
        }
    }

    public static void main(String[] args) {
        int [] inputArray = {3,5,8,12,15,26,28};
        BinaryTreeTest binaryTreeTest = new BinaryTreeTest();
        binaryTreeTest.node = new Node(3);
        binaryTreeTest.node.left = new Node(5);
        binaryTreeTest.node.right = new Node(8);
        binaryTreeTest.node.left.left = new Node(12);
        binaryTreeTest.node.left.right = new Node(15);
        binaryTreeTest.node.right.left = new Node(26);
        binaryTreeTest.node.right.right = new Node(28);
        makeBinaryTree(inputArray, binaryTreeTest.node, 0 );
        binaryTreeTest.inOrder(binaryTreeTest.node);

        // find minimum value
        minValue(binaryTreeTest.node);
        maxValue(binaryTreeTest.node);


    }
 //right most has maxvalue
    private static int maxValue(Node node) {
        Node current = node;
        while(current.right != null){
            current = current.right;
        }
        System.out.print("max value " + current.root);
        return current.root;
    }

    //left most has min value
    private static int minValue(Node node) {
        Node current = node;
        /*int min = 0;
        if(node.root < min ){
            min = node.root;
        }
        minValue(node.left);
        minValue(node.right);
        System.out.print("min value " + node.root); */
        while(current.left != null){
            current = current.left;
        }
        System.out.print("min value " + current.root);
    return current.root;
    }

    private void inOrder(Node node) {
        if(node != null){
            inOrder(node.left);
            System.out.print(node.root + " ");
            inOrder(node.right);
        }
    }

    private static void makeBinaryTree(int[] inputArray, Node node, int i) {
        if(i < inputArray.length){
            Node temp = new Node(inputArray[i]);
            node = temp;

            //insert left child
            makeBinaryTree(inputArray, node.left, 2*i+1);

            //insert right child
            makeBinaryTree(inputArray, node.right,
                    2 * i + 2);

            System.out.print("-------------     "+ node.root + " ");

        }
    }



}
