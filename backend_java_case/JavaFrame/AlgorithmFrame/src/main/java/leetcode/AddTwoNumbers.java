package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

import org.junit.Test;

/**
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list. Input: (2 -> 4
 * ->3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 * 
 * @author Administrator
 * 
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class AddTwoNumbers {

	@Test
	public void acturally() {

		/*int[] a1 = {1,8};
		int[] a2 = {0};*/
		
		int[] a1 = {2,4,3};
		int[] a2 = {5,6,4};
		List<ListNode> data1 = new ArrayList<ListNode>();
		List<ListNode> data2 = new ArrayList<ListNode>();

		for (int i = 0; i < a1.length; i++) {

			ListNode l = new ListNode(a1[i]);
			data1.add(l);
		}

		for (int i = 0; i < a2.length; i++) {

			ListNode l = new ListNode(a2[i]);
			data2.add(l);
		}

		for (int i = 0; i < data1.size(); i++) {

			if ((i + 1) < data1.size()) {
				data1.get(i).next = data1.get(i + 1);
			}
		}

		for (int i = 0; i < data2.size(); i++) {

			if ((i + 1) < data2.size()) {
				data2.get(i).next = data2.get(i + 1);
			}
		}

		ListNode l = addTwoNumbers(data1.get(0), data2.get(0));
		
		while(l != null){
			System.out.print(l.val + ",");
			l = l.next;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		Queue<Integer> q1 = new LinkedList<Integer>();

		while (l1 != null) {

			q1.add(l1.val);
			l1 = l1.next;
		}

		Queue<Integer> q2 = new LinkedList<Integer>();

		while (l2 != null) {

			q2.add(l2.val);
			l2 = l2.next;
		}

		List<ListNode> s3 = new ArrayList<ListNode>();
		int overflow = 0;

		while (!q1.isEmpty() || !q2.isEmpty() || overflow != 0) {

			int i1 = 0;
			int i2 = 0;
			
		    if(!q1.isEmpty()){
		    	i1 = q1.poll();
		    }
			
			if(!q2.isEmpty()){
				i2 = q2.poll();
			}
			
			int i = i1 + i2 + overflow;
			overflow = 0;

			if (i >= 10) {
				i = i - 10;
				overflow = overflow + 1;
			}

			ListNode l = new ListNode(i);
			s3.add(l);
		}

		for (int i = 0; i < s3.size(); i++) {

			if ((i + 1) < s3.size()) {
				s3.get(i).next = s3.get(i + 1);
			}
		}

		return s3.get(0);
	}
}
