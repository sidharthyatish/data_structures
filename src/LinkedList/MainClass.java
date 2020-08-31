package LinkedList;

import sun.awt.image.ImageWatched;

public class MainClass
{
    
    public static void main(String[] args)
    {
        LinkedList ll = new LinkedList();
        ll.constructLinkedList(new int[]{0,1,2});
        ll.printList();
        ll.head = LeetCodeProblems.rotateRightByK2(ll.head,4);
        ll.printList();
        
    }
    
    private static void flattenMultiLevelLL()
    {
        MultiLevelDoulyLL mLL = new MultiLevelDoulyLL();
        mLL.head = new ListNode(1);
        mLL.head.next = new ListNode(2);
        mLL.head.next.prev= mLL.head;
        mLL.head.next.next = new ListNode(3);
        mLL.head.next.next.prev = mLL.head.next;
        mLL.head.next.next.next = new ListNode(4);
        mLL.head.next.next.next.prev = mLL.head.next.next;
        mLL.head.next.next.next.next = new ListNode(5);
        mLL.head.next.next.next.next.prev = mLL.head.next.next.next;
        mLL.head.next.next.child = new ListNode(6);
        mLL.head.next.next.child.next = new ListNode(7);
        mLL.head.next.next.child.next.prev = mLL.head.next.next.child;
        mLL.head.next.next.child.next.next = new ListNode(8);
        mLL.head.next.next.child.next.next.prev = mLL.head.next.next.child.next;
        mLL.head.next.next.child.next.child = new ListNode(9);
        mLL.head.next.next.child.next.child.next = new ListNode(10);
        mLL.head.next.next.child.next.child.next.prev = mLL.head.next.next.child.next.child;
        mLL.printList();
        
        MultiLevelDoulyLL flattenedList = new MultiLevelDoulyLL();
        flattenedList.head = mLL.flattenList();
        flattenedList.printList();
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
