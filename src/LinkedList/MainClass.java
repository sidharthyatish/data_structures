package LinkedList;

public class MainClass
{
    public static void main(String[] args)
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
}
