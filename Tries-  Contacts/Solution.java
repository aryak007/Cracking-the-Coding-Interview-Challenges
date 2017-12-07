/*
We're going to make our own Contacts application! The application must perform two types of operations:

add name, where  is a string denoting a contact name. This must store  as a new contact in the application.
find partial, where  is a string denoting a partial name to search the application for. It must count the number of contacts starting with  and print the count on a new line.
Given  sequential add and find operations, perform each operation in order.

Input Format

The first line contains a single integer, , denoting the number of operations to perform. 
Each line  of the  subsequent lines contains an operation in one of the two forms defined above.

Constraints

It is guaranteed that  and  contain lowercase English letters only.
The input doesn't have any duplicate  for the  operation.
Output Format

For each find partial operation, print the number of contact names starting with  on a new line.

Sample Input

4
add hack
add hackerrank
find hac
find hak
Sample Output

2
0
Explanation

We perform the following sequence of operations:

Add a contact named hack.
Add a contact named hackerrank.
Find and print the number of contact names beginning with hac. There are currently two contact names in the application and both of them start with hac, so we print  on a new line.
Find and print the number of contact names beginning with hak. There are currently two contact names in the application but neither of them start with hak, so we print  on a new line.

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;



public class Solution {

	private class TrieNode{
		int count;
		Map<Character,TrieNode> child;
		boolean isEndOfWord;
		TrieNode(){
			child = new HashMap<Character,TrieNode>();
			isEndOfWord = false;
			count = 0;
		}
	}

	private TrieNode root;
	static int size;

	public void add(String word)
	{
		
		if(isEmpty()){
			//System.out.println("Empty");
			root = new TrieNode();
		}
		TrieNode current = root;
		//System.out.println(word);
		for(int i = 0;i<word.length();i++){
			char ch = word.charAt(i);
			TrieNode node = current.child.get(ch);
			if(node==null)
			{
				//size++;
				node = new TrieNode();
				current.child.put(ch,node);
			}
			
			
			
			current = node;
			current.count++;
			//System.out.println(ch+" "+current.count);
		}
		current.isEndOfWord = true;
	}


	public int search(String word)
	{
		if(isEmpty())
			return 0;
		TrieNode current = root;
		 
		//int count = 0;
		for(int i = 0;i<word.length();i++)
		{
			char ch = word.charAt(i);
			TrieNode node = current.child.get(ch);
			//System.out.print(ch+" "+current.count);
			//System.out.print(ch+" "+node);
			
			if(node==null){
				//System.out.println(ch);
				return 0;
			}
			current = node;
			// if(i!=word.length()-1)
			// 	current = node;

		}

		return current.count;
	}

	public boolean isEmpty(){
		return root==null;
	}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Solution trie = new Solution();
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            if(op.equals("add"))
            	trie.add(contact);
            else if(op.equals("find"))
            	System.out.println(trie.search(contact));
        }
        // trie.add("hack");
        // trie.add("hackerrank");
        // trie.add("kudnlccqbvkizsfdbwxy");
        // trie.add("pxmfimxotqanodwuuymt");
        // System.out.println(trie.search("hack"));
        // System.out.println(trie.search("yyr"));
        // System.out.println(trie.search("p"));
        //System.out.println(trie.search("hac"));
        //System.out.println(trie.search("hak"));
    }
}
