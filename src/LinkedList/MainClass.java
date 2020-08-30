package LinkedList;

public class MainClass
{
    
    public static void main(String[] args)
    {
        LinkedList l1 = new LinkedList();
        l1.constructLinkedList(new int[]{0,0,9});
        LinkedList l2 = new LinkedList();
        l2.constructLinkedList(new int[]{0,0,9});
        LinkedList sum = new LinkedList();
        l1.printList();
        l2.printList();
        sum.head = LeetCodeProblems.addTwoNumbers(l1.head,l2.head);
        sum.printList();
        
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
        oddEvenList.head = LeetCodeProblems.oddEvenLL(oddEvenList.head);
        oddEvenList.printList();
    }
}
