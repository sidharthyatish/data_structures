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
        linkedList.deleteNodeAtPosition(3);
        linkedList.printList();
    }
}
