class BinaryTreeToDoublyLinkedList{
    class Node {
        Node left;
        Node right;
        int val;
    }

    /* 
    Input:
                  10
                /    \
              12     15
            /   \    /
          25    30  36
    
    Output:
    25<->12<->30<->10<->36<->15

    so what is happening here is the left sub tree is a DLL, right sub tree is a DLL

    [leftSubTreeDLL] root [rightSubTreeDLL]

    we recursively solve each sub trees

    after solving,
    
    [leftSubTreeDLL]<->[]<->root<->[][rightSubTreeDLL]
                       |            |
   [rightMostChild]   <-             -> [leftMostChild]

   Solving leftSubTree alone means it becomes (25<->12<->30------> right most child of left sub tree)
   Solving rightSubTree alone means it becomes (left most child of right sub tree<-------36<->15)


   After constructing this, we should point to 25, i.e. left most child which is the head of the DLL now
 

    
    */
    Node convertToDLL(Node root){
        if(root == null) return root;
        
        if(root.left!=null){
            Node left = convertToDLL(root.left);
            //find inorder predecessor of root (or) right most child of left sub tree
            while(left.right!=null){
                left = left.right;
            }
            left.right=root;
            root.left = left;
            
        }
        if(root.right!=null){
            Node right = convertToDLL(root.right);
            //find inorder successor of root (or) left most child of left sub tree
            while(right.left!=null){
                right = right.left;
            }
            right.left=root;
            root.right = right;
        }
        
        return root;
    }
    Node bToDLL(Node root)
    {
	//  Your code here
	    root = convertToDLL(root);
	    
        //once construction is done, the head of the DLL is the left most element.
	    while(root!=null&&root.left!=null){
	        root=root.left;
	    }
	    
	    return root;
    }
}