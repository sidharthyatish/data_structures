package LinkedList;

import java.util.ArrayList;
import java.util.List;
//This is also a leetcode problem. Worked on first submission
class ListNode{
    int val;
    ListNode next;
    ListNode prev;
    ListNode child;
    ListNode(int val){
        this.val=val;
        this.next=null;
        this.prev=null;
        this.child=null;
    }
}
class MultiLevelDoulyLL
{
    ListNode head;
    
    ListNode flattenList(){
        //If we find a child. Store the temp->next We make temp->next as child. Go to end of child and attach stored temp->next to child->next
        
        ListNode temp = head;
        while (temp!=null){
            if(temp.child!=null){
                //save the next
                ListNode next =temp.next;
                ListNode childHead = temp.child;
                //Set next to child
                childHead.prev=temp;
                temp.next=childHead;
                temp.child=null;
                //Go to end of child and attach the previously stored next
                ListNode tempChild = childHead;
                while (tempChild.next!=null) tempChild=tempChild.next;
                tempChild.next=next;
                if(next!=null) next.prev = tempChild;
            }
            temp=temp.next;
        }
        return head;
    }
    void printList(){
        
        //Each child's head is stored in a list. Each head is printed separately. Head is also a child
        List<ListNode> childList = new ArrayList<>();
        ListNode temp = head;
        childList.add(head);
        while(temp!=null){
            if(temp.child!=null){
                childList.add(temp.child);
                temp=temp.child;
            }
            else{
                temp=temp.next;
            }
        }
        System.out.println("Size of children : "+childList.size());
        
        for(ListNode childHead : childList){
            while(childHead!=null){
                String val=Integer.toString(childHead.val);
                if (childHead.child != null)
                {
                    //Means at this node there is a child
                    val=val+"|C|";
                }
                System.out.print(val+"->");
                childHead=childHead.next;
            }
            System.out.println("NULL");
        }
        
    }
}
