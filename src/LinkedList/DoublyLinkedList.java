package LinkedList;

public class DoublyLinkedList
{
    Node head;
    
    void printList(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"<->");
            temp=temp.next;
        }
        System.out.println("NULL");
    }
    
    void insertAtBeginning(int value){
        Node newNode = new Node(value);
        if(head==null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head.prev=newNode;
        head = newNode;
    }
    
    void insertAtEnd(int value){
        Node newNode = new Node(value);
        if(head==null){
            head = newNode;
            return;
        }
        Node temp = head;
        while(temp.next!=null) temp=temp.next;
        temp.next = newNode;
        newNode.prev = temp;
    }
    
    int getAtPosition(int pos){
        if(head==null || pos<0) return -1;
        Node temp = head;
        while(temp!=null && pos>0){
            temp=temp.next;
            pos--;
        }
        if(temp!=null) return temp.data;
        return -1;
    }
    
    void addAtIndex(int index,int value){
        Node newNode = new Node(value);
        if(index==0){
            newNode.next = head;
            if(head!=null){
                head.prev=newNode;
            }
            head = newNode;
            return;
        }
        Node temp = head;
        Node prev = null;
        while(temp!=null&&index>0){
            prev = temp;
            temp = temp.next;
            index--;
        }
        if(temp!=null){
            newNode.prev = prev;
            newNode.next = temp;
            prev.next = newNode;
            temp.prev = newNode;
            
        }
        else if(index==0){
            prev.next = newNode;
            newNode.prev=prev;
        }
        
    }
    
    void deleteAtIndex(int index){
        if(head==null || index<0) return;
        if(index==0){
            head=head.next;
            return;
        }
        Node temp = head;
        while(temp!=null&&index>0){
            temp = temp.next;
            index--;
        }
        if(temp!=null){
            temp.prev.next = temp.next;
            if(temp.next!=null) //Missing this condition led to one big failed test case
                temp.next.prev=temp.prev;
        }
    }
    Node constructLinkedList(int nums[]){
        int length = nums.length;
        if(nums.length>0){
            int index=length-1;
            while(index>=0){
                insertAtBeginning(nums[index--]);
            }
        }
        return this.head;
    }
}
