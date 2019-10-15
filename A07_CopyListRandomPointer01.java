package ama_online;

import java.util.*;

class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}

	void out() {
		System.out.println(this.label);
	}
};

public class A07_CopyListRandomPointer01 {
	public static void main(String[] args) {
		RandomListNode a = new RandomListNode(1);
		a.next = new RandomListNode(2);
		a.next.next = new RandomListNode(3);
		a.next.next.next = new RandomListNode(4);
		// 1's random points to 3
		a.random = a.next.next;
		// 2's random points to 4
		a.next.random = a.next.next.next;
		// 3's random points to 4
		a.next.next.random = a.next.next.next;
		// 4's random points to 2
		a.next.next.next.random = a.next;
//        RandomListNode d = copyRandomList(a);

//        while(a!=null) {
//            a.out();
//            a.random.out();
//            a = a.next;
//        }
		RandomListNode e = copy(a);
		System.out.println("==after===");
		while (e != null) {
			e.out();
//            System.out.println("==random===");
//            e.random.out();
			e = e.next;
		}

		return;
	}
	public static void print(RandomListNode r) {
		while(r!=null) {
			System.out.println("label: "+r.label);
			r = r.next;
		}
	}

	//1   1 2 3 4
	public static RandomListNode copy(RandomListNode head) {
		if (head == null)
			return head;
		RandomListNode c = head;
		while (c != null) {
			RandomListNode next = c.next;
			System.out.println("c.label: " + c.label);
			c.next = new RandomListNode(c.label);
			c.next.next = next;
			c = next;
		}
		System.out.println("==111=====");
		print(head);
		// 2 after 1 1 2 2 3 3 4 4
		c = head;
		while (c != null) {
			if (c.random != null) {
				c.next.random = c.random.next;
			}
			c = c.next.next;
		}
		System.out.println("===222=====");
		print(head);
		// 2 after 1 1 2 2 3 3 4 4
		c = head;
		RandomListNode copyHead = head.next;
		RandomListNode copy = copyHead;
		System.out.println("copy label: " + copy.label);
		while (copy.next != null) {
			System.out.println("c.next label: " + c.next.label);
			c.next = c.next.next;
			c = c.next;
			copy.next = copy.next.next;
			copy = copy.next;
		}

		c.next = c.next.next;
		System.out.println("last " + c.next.label+" "+c.next.next.label);
		System.out.println("===33=====");
		print(copyHead);
		return copyHead;
	}

	public static RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return null;
		RandomListNode headcp = head;
		while (head != null) {
			RandomListNode cp = new RandomListNode(head.label);
			cp.next = head.next;
			head.next = cp;
			head = cp.next;
		}
		head = headcp;
		while (headcp != null) {
			if (headcp.random != null)
				headcp.next.random = headcp.random.next;
			headcp = headcp.next.next;
		}
		RandomListNode ans = head.next;
		while (head != null) {
			RandomListNode tmpcp = head;
			head = head.next.next;
			if (head != null)
				tmpcp.next.next = head.next;
			else
				tmpcp.next.next = null;
			tmpcp.next = head;
		}
		return ans;
	}

}
