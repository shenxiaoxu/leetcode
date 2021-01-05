import java.util.LinkedList;
public class SortedLinkedList
{

    public static void main(String[] args)
    {
        ListNode result;
        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(2);
        l1.next.next.next = new ListNode(1);
        result = sortedLinkedList(l1);
        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }        
    }
    public static ListNode sortedLinkedList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode leftPart,rightPart;
        leftPart = head;
        ListNode pivotPoint = findPivotPoint(head);
        leftPart = sortedLinkedList(leftPart);
        rightPart = sortedLinkedList(pivotPoint);
        
        ListNode result = merge(leftPart,rightPart);
        return result;
    }
    public static ListNode findPivotPoint(ListNode head){
        ListNode p1,p2,result;
        p1 = head;
        p2 = head.next;
        while(p1 != null && p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next;
            p2 = p2.next;
        }
        result = p1.next;
        p1.next = null;
        return result;
        
    }
    public static ListNode merge(ListNode l1, ListNode l2){
        ListNode start = new ListNode(0);
        ListNode index = start;
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                index.next = l1;
                l1 = l1.next;
                index = index.next;
            }else{
                index.next = l2;
                l2 = l2.next;
                index = index.next;
            }
        }
        if(l1 == null){
            index.next = l2;
        }
        if(l2 == null){
            index.next = l1;
        }
        return start.next;       
    }

    
}