package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node{
    int data;
    Node left;
    Node right;
    protected Node(int value){
        data=value;
        left=right=null;
    }
}
public class BinaryTree
{
    Node root;
    
    void printInOrder(Node node){
        if(node == null) return;
        printInOrder(node.left);
        System.out.print(node.data+" ");
        printInOrder(node.right);
    }
    void printPreOrder(Node node){
        if(node == null) return;
        System.out.print(node.data+" ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }
    void printPostOrder(Node node){
        if(node == null) return;
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.data+" ");
    }
    
    void printLevelOrder(Node node){
        Queue<Node> levelQueue = new LinkedList<>();
        levelQueue.add(node);
        
        while(levelQueue.size()>0){
            Node poppedNode = levelQueue.poll();
            System.out.print(poppedNode.data+" ");
            if(poppedNode.left != null) levelQueue.add(poppedNode.left);
            if(poppedNode.right != null) levelQueue.add(poppedNode.right);
        }
        
    }
    
    void printInOrderIterative(Node root){
        //Inorder is Left,Root,Right
        //Since right is printed last, it must be put first into stack
        
        Stack<Node> inOrderStack = new Stack<>();
        if(root == null) return;
        Node leftNode = root.left;
        Node rightNode = root.right;
        root.left=null;
        root.right=null;
        if(rightNode!=null)
            inOrderStack.push(rightNode);
        
        inOrderStack.push(root);
        
        if(leftNode!=null)
            inOrderStack.push(leftNode);
        
        while(!inOrderStack.empty()){
            Node poppedNode = inOrderStack.pop();
            leftNode = poppedNode.left;
            rightNode = poppedNode.right;
            if (leftNode == null && rightNode == null)
            {
                System.out.print(poppedNode.data+" ");
                poppedNode=null;
            }
            else{
                poppedNode.left=null;
                poppedNode.right=null;
            }
            if(rightNode!=null) inOrderStack.push(rightNode);
            if(poppedNode!=null) inOrderStack.push(poppedNode);
            if(leftNode!=null) inOrderStack.push(leftNode);
        }
        System.out.println();
        
    }
}
