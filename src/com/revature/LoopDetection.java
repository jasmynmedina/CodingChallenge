package com.revature;

import java.util.LinkedList;

/*
 * Loop Detection: Given a circular linked list, implement an algorithm that 
 * returns the node at the beginning of the loop.
 * DEFINITION: Circular linked list: A (corrupt) linked list in which a node's 
 * next pointer points to an earlier node, so as to make a loop in the linked list.
 * EXAMPLE
 * Input: A -> B -> C -> D -> E -> C [the same C as earlier]
 * Output: C
 */
public class LoopDetection {
	static Node head;
	
	class Node {
		int data;
		Node next;
		
		Node(int d) {
			data = d;
			next = null;
			}
		}
	public void push(int newData) {
		Node newNode = new Node(newData);
		newNode.next = head;
		head = newNode;
		}

	static String detectLoop(LinkedList<String> list) {
		Node slow = head, fast = head;
		int flag = 0;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				flag = 1;
				break;
			}
		}
		if (flag == 1)
			return "Loop found";
		else
			 return "Loop not found";
		}

	public static void main(String args[]) {
		LinkedList list = new LinkedList();
		
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("C");
		System.out.println(detectLoop(list));

		}
	}
