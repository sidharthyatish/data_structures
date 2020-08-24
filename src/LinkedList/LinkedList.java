package LinkedList;

class Node{
    int data;
    Node next;
    
    Node(int value){
        data=value;
        next= null;
    }
}
public class LinkedList
{
    Node head;
    
    void printList(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("NULL");
    }
    
    void insertAtEnd(Node newNode){
        if(head == null){
            head=newNode;
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp=temp.next;
        }
        temp.next=newNode;
    }
    
    void insertAtBeginning(Node newNode){
        newNode.next=head;
        head=newNode;
    }
    void reverseList()
    {
        if(head==null) return;
        Node prevNode = null;
        Node currNode = head;
        Node nextNode = null;
    
        while(currNode.next != null){
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode=currNode;
            currNode=nextNode;
        }
        currNode.next = prevNode;
        head = currNode;
    }
    
    void insertAtPosition(int position,int value){
        if(head==null||position<0) return;
        Node newNode = new Node(value);
        if(position==0){
            newNode.next=head;
            head=newNode;
            return;
        }
        Node temp = head;
        Node prev = null;
        
        while(temp!=null&&position-->0){
            prev=temp;
            temp=temp.next;
        }
        if(temp!=null||position==0){
            prev.next=newNode;
            newNode.next=temp;
        }
        
    }
    
    int getAtPosition(int position){
        if(head==null||position<0) return -1;
        Node temp = head;
        while(temp!=null && position>0){
            temp=temp.next;
            position--;
        }
        if(temp!=null) return temp.data;
        return -1;
        
    }
    
    void deleteNodeAtPosition(int position){
        if(head == null) return;
        if(position == 0){
            head=head.next;
            return;
        }
        Node currNode = head;
        Node prevNode = null;
        
        while(currNode!=null && position > 0){
            prevNode = currNode;
            currNode = currNode.next;
            position--;
        }
        if(currNode!=null){
            prevNode.next = currNode.next;
        }
    }
    static int getLength(Node node){
        if(node==null)
            return 0;
        return 1+getLength(node.next);
    }
}
