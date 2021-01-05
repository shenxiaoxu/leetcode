import java.util.LinkedList;
public class MergeSortedLinkedList
{

    public static void main(String[] args)
    {
    	ListNode result;
    	//ListNode l1 = null;
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        result = sortedLinkedList(l1, l2);
        while(result != null){
        	System.out.println(result.val);
        	result = result.next;
        }        
    }
    public static ListNode sortedLinkedList(ListNode l1, ListNode l2){
        if(l1 == null){
        	return l2;
        }
        if(l2 == null){
        	return l1;
        }
        ListNode start, result;
        if(l1.val < l2.val){
        	result = new ListNode(l1.val);
        	l1 = l1.next;
        }else{
        	result = new ListNode(l2.val);
        	l2 = l2.next;
        }
        start = result;
        while(l1 != null || l2 != null){
        	if(l1 == null){
        		while(l2 != null){
        			result.next = new ListNode(l2.val);
        			result =result.next;
        			l2 = l2.next;
        		}
        	}
        	if(l2 == null){
        		while(l1 != null){
        			result.next = new ListNode(l1.val);
        			result = result.next;
        			l1 = l1.next;
        		}
        		break;
        	}
        	if(l1.val <= l2.val){
        		ListNode next = new ListNode(l1.val);
        		result.next = next;
        		result = result.next;
        		//System.out.println(l1.val);
        		l1 = l1.next;
        	}else{
				ListNode next = new ListNode(l2.val);
        		result.next = next;
        		result = result.next;
        		//System.out.println(l2.val);
        		l2 = l2.next;        		
        	}
        }
        return start;
    }
    
}