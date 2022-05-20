package com.revature;

import java.util.*;

/*
 * 2) Stack Min: How would you design a stack which, 
 * in addition to push and pop, has a function min which 
 * returns the minimum element? Push, pop and min should
 *  all operate in 0(1) time.
 */

public class StackMin {
	
	Stack<Integer> s;
    Integer minEle;
  
    StackMin() { s = new Stack<Integer>(); }
  
    void getMin() {
        if (s.isEmpty())
            System.out.println("Stack is empty");
          else
            System.out.println("Minimum Element in the " + " stack is: " + minEle);
    }
    
    void pop() {
        if (s.isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
  
        System.out.print("Top Most Element Removed: ");
        Integer t = s.pop();
  
        if (t < minEle) {
            System.out.println(minEle);
            minEle = 2*minEle - t;
        }
        else
            System.out.println(t);
    }
    
    void push(Integer x) {
        if (s.isEmpty()) {
            minEle = x;
            s.push(x);
            System.out.println("Number Inserted: " + x);
            return;
        }
        if (x < minEle) {
            s.push(2*x - minEle);
            minEle = x;
        }
        else
        	s.push(x);
        System.out.println("Number Inserted: " + x);
    }

	public static void main(String[] args) {
		StackMin s = new StackMin();
        s.push(7);
        s.push(4);
        s.getMin();
        s.push(3);
        s.push(5);
        s.getMin();
        s.pop();
        s.getMin();
        s.pop();

	}

}
