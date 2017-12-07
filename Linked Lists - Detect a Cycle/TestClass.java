/*
A linked list is said to contain a cycle if any node is visited more than once while traversing the list.

Complete the function provided in the editor below. It has one parameter: a pointer to a Node object named that points to the head of a linked list. Your function must return a boolean denoting whether or not there is a cycle in the list. If there is a cycle, return true; otherwise, return false.

Note: If the list is empty,  will be null.

Input Format

Our hidden code checker passes the appropriate argument to your function. You are not responsible for reading any input from stdin.

Constraints

Output Format

If the list contains a cycle, your function must return true. If the list does not contain a cycle, it must return false. The binary integer corresponding to the boolean value returned by your function is printed to stdout by our hidden code checker.

Sample Input

The following linked lists are passed as arguments to your function:

Sample Inputs
Sample Output

0
1
Explanation

The first list has no cycle, so we return false and the hidden code checker prints  to stdout.
The second list has a cycle, so we return true and the hidden code checker prints  to stdout.

*/
import java.io.*;
import java.util.*;

class Node {
	int item;
	Node next;
	Node(int item){
		this.item = item;
		next = null;
	}
}
class TestClass {
	Node head;
	Node pointer;
	public static void main (String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TestClass T = new TestClass();
		/*T.push(1);
		T.push(2);
		T.push(3);
		T.push(4);
		T.push(5);*/
		/*T.head = new Node(50);
        T.head.next = new Node(20);
        T.head.next.next = new Node(15);
        T.head.next.next.next = new Node(4);
        T.head.next.next.next.next = new Node(10);
 
        // Creating a loop for testing 
        T.head.next.next.next.next.next = T.head.next.next;
		System.out.println(T.detectCycle());*/
		T.head = new Node(1);
		T.head.next = null;
		System.out.println(T.detectCycle());
		//T.printList();
	}


	/*public void push(int item) {
		if (head == null) {
			head = new Node();
			head.item = item;
			head.next = null;
			pointer = head;
		} else {
			Node newNode = new Node();
			newNode.item = item;
			newNode.next = null;
			pointer.next = newNode;
			pointer = pointer.next;
		}
	}*/

	public boolean detectCycle() {
		if(head==null)
			return false;
		Node slow = head;
		Node fast = head;
		while (slow.next != null && fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				return true;
		}
		return false;
	}

	public void printList() {
		Node ptr = head;
		while (ptr.next != null) {
			System.out.print(ptr.item + "-->");
			ptr = ptr.next;
		}
		System.out.print(ptr.item);
	}
}
