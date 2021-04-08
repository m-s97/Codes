package linkedList;
/*
 * leetcode - 234
 * https://leetcode.com/problems/palindrome-linked-list/
 */
public class LinkedListPalindrome {
	class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) {
			this.val = val;
		}
		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
	// O(N); N - size of linkedlist
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        if(head.next.next == null) return head.val == head.next.val;
        // Getting the Central Node
        ListNode centre = getCentreNode(head);
        // Reversing the half way linkedlist
        ListNode tempHead = reverse(centre);
        ListNode end = tempHead;
        // Iterating through nodes to check if palindrome or not
        while(tempHead != null && head.next != end){
            if(head.val == tempHead.val) {
                head = head.next;
                tempHead = tempHead.next;
            }else{
                return false;
            }
        }
        return true;
    }
    public ListNode reverse(ListNode head){
        if(head == null) return null;
        
        ListNode current = head;
        ListNode prev = null;
        ListNode next = head;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    public ListNode getCentreNode(ListNode head){
        if(head == null) return null;
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            //System.out.println("fast "+fast.val+" slow "+slow.val);
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
