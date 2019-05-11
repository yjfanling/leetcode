package leetcode;

public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode res = new ListNode(-1);
		res.next = head;
		ListNode fast = res;
		for (int i = 0; i < m - 1; i++)
			fast = fast.next;
		ListNode cur = fast.next;
		for (int i = m; i < n; i++) {
			ListNode tmp = cur.next;
			cur.next = tmp.next;
			tmp.next = fast.next;
			fast.next = tmp;
		}

		return res.next;
	}
}
