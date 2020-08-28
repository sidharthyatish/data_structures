package LinkedList;

public class MainClass
{
    public static Node oddEvenLL(Node head){
        if(head==null||head.next==null) return null;
        Node oddHead = head;
        Node tempOdd = head;
        Node evenHead = head.next;
        Node tempEven = head.next;
        //If odd & even are traversed separately, then leads to wrong result as links are already changed
        while(tempOdd!=null&&tempOdd.next!=null&&tempEven!=null&&tempEven.next!=null){
            tempOdd.next=tempEven.next;
            tempOdd=tempOdd.next;
            tempEven.next=tempOdd.next;
            tempEven=tempEven.next;
        }
        tempOdd.next=evenHead;
        return oddHead;
    }
    
    public static Node reverseAtIndex(Node head,int index){
        if(head==null||head.next==null) return head;
        
        Node temp = head;
        while(temp!=null&&temp.next!=null&&index-->0){
            Node next = temp.next;
            temp.next=temp.next.next;
            next.next = head;
            head = next;
        }
        return head;
    }
    
    public static boolean checkIfPalindrome(Node head){
        if(head==null||head.next==null) return true;
        Node fastNode = head;
        Node midNode = head;
        int midPosition=0;
        while(fastNode!=null&&fastNode.next!=null){
            fastNode=fastNode.next.next;
            midNode=midNode.next;
            midPosition++;
        }
        //if fastNode.next==null it means there were odd number of nodes. if fastNode == null it means there were odd number of nodes
        //Move the mid node if odd number of nodes are present
        if(fastNode!=null){
            midNode=midNode.next;
        }
        
        head = reverseAtIndex(head,midPosition-1); //have to reverse just before the mid (reverse)mid(rest-half)
        Node temp = head;
        
        while(midNode!=null){
            
            if(temp.data!=midNode.data) return false;
            temp=temp.next;
            midNode=midNode.next;
        }
        return true;
    }
    public static void main(String[] args)
    {
//        testBasicOperations();
//        testOddEvenLL();
        LinkedList linkedList = new LinkedList();
        linkedList.constructLinkedList(new int[]{1,2,1});
        linkedList.printList();
        System.out.println(checkIfPalindrome(linkedList.head));
        
    }
    
    private static void testBasicOperations()
    {
        LinkedList linkedList = new LinkedList();
        linkedList.head = new Node(1);
        linkedList.insertAtEnd(new Node(2));
        linkedList.insertAtEnd(new Node(3));
        linkedList.insertAtEnd(new Node(4));
        linkedList.printList();
        linkedList.insertAtPosition(0,5);
        linkedList.printList();
        System.out.println(linkedList.getAtPosition(2));
        System.out.println(linkedList.getAtPosition(0));
        System.out.println(linkedList.getAtPosition(3));
        System.out.println(linkedList.getAtPosition(5));
        linkedList.deleteNodeAtPosition(0);
        linkedList.deleteNodeAtPosition(2);
        linkedList.deleteNodeAtPosition(3);
        linkedList.printList();
        linkedList.getAtPosition(3);
        linkedList.insertAtPosition(3,10);
        linkedList.printList();
    }
    
    private static void testOddEvenLL()
    {
        LinkedList oddEvenList = new LinkedList();
        oddEvenList.head = new Node(1);
        oddEvenList.insertAtEnd(new Node(2));
        oddEvenList.insertAtEnd(new Node(3));
        oddEvenList.insertAtEnd(new Node(4));
        oddEvenList.insertAtEnd(new Node(5));
        oddEvenList.insertAtEnd(new Node(6));
        oddEvenList.printList();
        oddEvenList.head = oddEvenLL(oddEvenList.head);
        oddEvenList.printList();
    }
}
