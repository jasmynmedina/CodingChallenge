package com.revature;

import java.util.LinkedList;

/*
 * Intersection: Given two (singly) linked lists, determine if the two lists intersect. 
 * Return the intersecting node. Note that the intersection is defined based on reference, 
 * not value. That is, if the kth node of the first linked list is the exact same node 
 * (by reference) as the jth node of the second linked list, then they are intersecting. 
*/
//Java program to get intersection point of two linked list

public class Intersection {

	static ListNode head1, head2;

	public static class ListNode {

		int data;
		ListNode next;

		ListNode(int d) {
			data = d;
			next = null;
		}
	}

	public ListNode getIntersectionNode(ListNode head1, ListNode head2) {

		int len1 = 0;
		ListNode temp1 = head1;
		while (temp1 != null) {
			len1++;
			temp1 = temp1.next;
		}
		int len2 = 0;
		ListNode temp2 = head2;
		while (temp2 != null) {
			len2++;
			temp2 = temp2.next;

		}
		int diff = Math.abs(len1 - len2);
		temp1 = head1;
		temp2 = head2;

		if (len1 > len2) {
			while (diff-- > 0)
				temp1 = temp1.next;

		} else {
			while (diff-- > 0)
				temp2 = temp2.next;
		}
		while (temp1 != temp2) {
			temp1 = temp1.next;
			temp2 = temp2.next;
			if (temp1 == null || temp2 == null)
				return null;
		}
		return temp1;
	}
//    public static void main (String[] args) {
//		LinkedList list = new LinkedList();		
//		list.add("A");
//		list.add("B");
//		list.add("C");
//		list.add("D");
//		list.add("C");
//
//    }

}