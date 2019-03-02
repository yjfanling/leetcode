package leetcode;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res=new ListNode(-1);
        ListNode cur=res;
        int carry=0;
        while(l1!=null||l2!=null)
        {
        	int p=l1==null?0:l1.val;
        	int q=l2==null?0:l2.val;
        	cur.next=new ListNode((p+q+carry)%10);
        	carry=(p+q+carry)/10;
        	l1=l1==null?l1:l1.next;
        	l2=l2==null?l2:l2.next;
        	cur=cur.next;
        }
        cur.next=carry==1?new ListNode(1):null;
        return res.next;
	}
}
