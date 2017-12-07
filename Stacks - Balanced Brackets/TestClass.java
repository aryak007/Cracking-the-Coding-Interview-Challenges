/*
A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].

Two brackets are considered to be a matched pair if the an opening bracket (i.e., (, [, or {) occurs to the left of a closing bracket (i.e., ), ], or }) of the exact same type. There are three types of matched pairs of brackets: [], {}, and ().

A matching pair of brackets is not balanced if the set of brackets it encloses are not matched. For example, {[(])} is not balanced because the contents in between { and } are not balanced. The pair of square brackets encloses a single, unbalanced opening bracket, (, and the pair of parentheses encloses a single, unbalanced closing square bracket, ].

By this logic, we say a sequence of brackets is considered to be balanced if the following conditions are met:

It contains no unmatched brackets.
The subset of brackets enclosed within the confines of a matched pair of brackets is also a matched pair of brackets.
Given  strings of brackets, determine whether each sequence of brackets is balanced. If a string is balanced, print YES on a new line; otherwise, print NO on a new line.

Input Format

The first line contains a single integer, , denoting the number of strings. 
Each line  of the  subsequent lines consists of a single string, , denoting a sequence of brackets.

Constraints

, where  is the length of the sequence.
Each character in the sequence will be a bracket (i.e., {, }, (, ), [, and ]).
Output Format

For each string, print whether or not the string of brackets is balanced on a new line. If the brackets are balanced, print YES; otherwise, print NO.

Sample Input

3
{[()]}
{[(])}
{{[[(())]]}}
Sample Output

YES
NO
YES
Explanation

The string {[()]} meets both criteria for being a balanced string, so we print YES on a new line.
The string {[(])} is not balanced, because the brackets enclosed by the matched pairs [(] and (]) are not balanced. Thus, we print NO on a new line.
The string {{[[(())]]}} meets both criteria for being a balanced string, so we print YES on a new line.
*/
import java.io.*;
import java.util.*;

class Node {
	char item;
	Node next;
	Node(char item) {
		this.item = item;
		next = null;
	}
}

class TestClass {
	Node first;

	public static void main (String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TestClass T = new TestClass();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String expression = br.readLine();
			System.out.println(T.isBalanced(expression));
		}
	}


	public void push(char item) {
		Node oldFirst = first;
		first = new Node(item);
		first.next = oldFirst;
	}

	public char pop() {
		if (isEmpty())
			throw new NoSuchElementException("Stack underflow");
		char item = first.item;
		first = first.next;
		return item;

	}

	public boolean isBalanced(String expression) 
	{

		int n = expression.length();
		if ((n & 1) == 1) {
			//System.out.println("AAAA");
			return false;
		}
			

		TestClass stack = new TestClass();
		int i;
		char item;
		for (i  = 0; i < n; i++) 
		{
			item = expression.charAt(i);
			if(item=='{')
				stack.push('}');
			else if(item=='(')
				stack.push(')');
			else if(item=='[')
				stack.push(']');
			else
			{
			
				if(stack.isEmpty()||item!=stack.peek())
				{
					return false;
				}
				stack.pop();
			}
		}
		return stack.isEmpty();
	}

	public char peek(){
		return first.item;
	}

	public boolean isEmpty() {
		return (first == null);
	}


	public void printList() {
		Node ptr = first;
		while (ptr.next != null) {
			System.out.print(ptr.item + "-->");
			ptr = ptr.next;
		}
		System.out.print(ptr.item);
	}
}