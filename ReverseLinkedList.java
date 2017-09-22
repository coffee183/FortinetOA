package com.yishu;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ReverseLinkedList {
	class Node{
		 Node next;
		 int value;
		}
		// Assume n is the length of the list, the time complexity is O(n)
		// The space complexity is O(1)  
		public Node reverse(Node head){
			if (head == null || head.next == null) {
				return head;
			}
			Node pre = null;
			Node curr = head;
			while (curr != null) {
				Node next = curr.next;
				curr.next = pre;
				pre = curr;
				curr = next;
			}
			return pre;
		}
		public String toString(Node head) {
			String res = "";
			while (head != null) {
				res += head.value;
				head = head.next;
			}
			return res;
		}
		// JUnit test cases
		@Test
		public void test() {
			ReverseLinkedList test = new ReverseLinkedList();
			Node dummy = test.new Node();
			Node tail = dummy;			
			for (int i = 0; i < 5; i++) {
				Node temp = test.new Node();
				temp.value = i;
				tail.next = temp;
				tail = tail.next;			
			}			
			Node newHead = test.reverse(dummy.next);
			assertEquals("43210", test.toString(newHead));
		}
}
