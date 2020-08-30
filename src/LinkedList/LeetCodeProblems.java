package LinkedList;

public class LeetCodeProblems
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
    
    public static Node reverseAtIndex(Node head, int index){
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
    
    public static Node mergeSortedLists(Node l1, Node l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        
        Node mergedList = new Node(Integer.MAX_VALUE);
        Node temp = mergedList;
        while(l1!=null&&l2!=null){
            if(l1.data<l2.data){
                temp.next=l1;
                temp=temp.next;
                l1=l1.next;
            }
            else{
                temp.next=l2;
                temp=temp.next;
                l2=l2.next;
            }
        }
        while(l1!=null){
            temp.next=l1;
            temp=temp.next;
            l1=l1.next;
        }
        while (l2!=null){
            temp.next=l2;
            temp=temp.next;
            l2=l2.next;
        }
        return mergedList.next;
    }
    
    public static Node addTwoNumbers(Node l1,Node l2){
        //The two lists are reverse of each numbers. The result will be the reverse of the sum
        //can be optimised in a single loop by (l1!=null ||l2!=null)
        // int x = l1!=null? l1.data:0; int y = l2!=null? l2.data : 0 //Do ops with x and y now
        if(l1==null) return l2;
        if(l2==null) return l1;
        
        int sum = 0;
        int carry = 0;
        Node result = new Node(Integer.MIN_VALUE);
        Node resultHead = result;
        while(l1!=null&&l2!=null){
            sum = (l1.data+l2.data+carry)%10;
            carry = (l1.data+l2.data+carry)/10;
            result.next=new Node(sum);
            result=result.next;
            l1=l1.next;
            l2=l2.next;
        }
        
        while(l1!=null){
            sum = (l1.data+carry)%10;
            carry = (l1.data+carry)/10;
            result.next=new Node(sum);
            result=result.next;
            l1=l1.next;
        }
        while(l2!=null){
            sum = (l2.data+carry)%10;
            carry = (l2.data+carry)/10;
            result.next=new Node(sum);
            result=result.next;
            l2=l2.next;
        }
        if(carry>0) result.next=new Node(carry);
        
        return resultHead.next;
    }
}
