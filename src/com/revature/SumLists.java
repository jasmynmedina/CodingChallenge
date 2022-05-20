package com.revature;

import java.util.LinkedList;

/*
 * 1) Sum Lists: You have two numbers represented by a linked list, where each node contains a single
digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
function that adds the two numbers and returns the sum as a linked list.

EXAMPLE
Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295.
Output: 2 -> 1 -> 9. That is, 912.

FOLLOW UP
Suppose the digits are stored in forward order. Repeat the above problem.
Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295.
Output: 9 -> 1 -> 2. That is, 912.
 */

public class SumLists {
	static Node head1, head2;
	
	static class Node {
		int data;
		Node next;
		
		Node(int d) {
			data = d;
			next = null;
		}
	}
	
	void addTwoLists(Node first, Node second) {
		Node start1 = new Node(0);
		start1.next = first;
		Node start2 = new Node(0);
		start2.next = second;
		
		addPrecedingZeros(start1, start2);
		Node result = new Node(0);
		if (sumTwoNodes(start1.next, start2.next, result) == 1) {
			Node node = new Node(1);
			node.next = result.next;
			result.next = node;
		}
		printList(result.next);
	}
	
	void printList(Node head) {
		while(head != null) {
			System.out.println(head.data + " ");
			head = head.next; 
		}
		System.out.println("");
	}
	
	 private int sumTwoNodes(Node first, Node second, Node result) {
	        if (first == null) {
	            return 0;
	        }
	        int number = first.data + second.data + sumTwoNodes(first.next, second.next, result);
	        Node node = new Node(number % 10);
	        node.next = result.next;
	        result.next = node;
	        return number / 10;
	    }
	
	private void addPrecedingZeros(Node start1, Node start2) {
        Node next1 = start1.next;
        Node next2 = start2.next;
        while (next1 != null && next2 != null) {
            next1 = next1.next;
            next2 = next2.next;
        }
        if (next1 == null && next2 != null) {
            while (next2 != null) {
                Node node = new Node(0);
                node.next = start1.next;
                start1.next = node;
                next2 = next2.next;
            }
        } else if (next2 == null && next1 != null) {
            while (next1 != null) {
                Node node = new Node(0);
                node.next = start2.next;
                start2.next = node;
                next1 = next1.next;
            }
        }
    }

	public static void main(String[] args) {
		SumLists list = new SumLists();
		
		//Output in forward order
		list.head1 = new Node(6);
		list.head1.next = new Node(1);
		list.head1.next.next = new Node(7);
		System.out.println("First List is ");
		list.printList(head1);
		
		list.head2 = new Node(2);
		list.head2.next = new Node(9);
		list.head2.next.next = new Node(5);
		System.out.println("Second List is ");
		list.printList(head2);
		
		System.out.println("Output List is ");
		
		list.addTwoLists(head1, head2);
	}

}
