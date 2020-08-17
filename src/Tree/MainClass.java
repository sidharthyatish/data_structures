package Tree;

public class MainClass
{
    public static void main(String[] args)
    {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new Node(1);
        binaryTree.root.left = new Node(2);
        binaryTree.root.right = new Node(3);
        binaryTree.root.left.left = new Node(4);
        binaryTree.root.left.right = new Node(5);
        binaryTree.root.right.left = new Node(6);
        binaryTree.root.right.right = new Node(7);
        
        binaryTree.printInOrder(binaryTree.root);
        System.out.println();
        binaryTree.printPreOrder(binaryTree.root);
        System.out.println();
        binaryTree.printPostOrder(binaryTree.root);
        System.out.println();
        binaryTree.printLevelOrder(binaryTree.root);
    }
}
