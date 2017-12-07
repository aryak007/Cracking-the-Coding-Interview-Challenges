/*
Alice is taking a cryptography class and finding anagrams to be very useful. We consider two strings to be anagrams of each other if the first string's letters can be rearranged to form the second string. In other words, both strings must contain the same exact letters in the same exact frequency For example, bacdc and dcbac are anagrams, but bacdc and dcbad are not.

Alice decides on an encryption scheme involving two large strings where encryption is dependent on the minimum number of character deletions required to make the two strings anagrams. Can you help her find this number?

Given two strings,  and , that may or may not be of the same length, determine the minimum number of character deletions required to make  and  anagrams. Any characters can be deleted from either of the strings.

This challenge is also available in the following translations:

Chinese
Russian
Input Format

The first line contains a single string, .
The second line contains a single string, .

Constraints

It is guaranteed that  and  consist of lowercase English alphabetic letters (i.e.,  through ).
Output Format

Print a single integer denoting the number of characters you must delete to make the two strings anagrams of each other.

Sample Input

cde
abc
Sample Output

4
Explanation

We delete the following characters from our two strings to turn them into anagrams of each other:

Remove d and e from cde to get c.
Remove a and b from abc to get c.
We must delete  characters to make both strings anagrams, so we print  on a new line.
*/
import java.io.*;
import java.util.*;
class TestClass {
	public static void main (String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TestClass T = new TestClass();


		//StringTokenizer st = new StringTokenizer(br.readLine());
		String a =  br.readLine();
		String b =  br.readLine();

		//System.out.println(T.countMinDeletionsHashMap(a, b));
		System.out.println(T.countMinDeletions(a, b));
	}

	int countMinDeletions(String a, String b) {
		int count[] = new int[26];
		int deletions = 0, i;
		for (i = 0; i < a.length(); i++) {
			count[a.charAt(i) - 'a']++;
		}
		for (i = 0; i < b.length(); i++) {
			count[b.charAt(i) - 'a']--;
		}
		for (i = 0; i < 26; i++) {
			if (count[i] != 0)
				deletions+=Math.abs(count[i]);
		}

		// for (i = 0; i < 26; i++) {
		// 	System.out.print(count[i] + " ");
		// }

		return deletions;
	}
	int countMinDeletionsHashMap(String a, String b) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int deletions = 0, i;
		for (i = 0; i < a.length(); i++) {
			char ch = a.charAt(i);
			if (map.containsKey(ch))
				map.put(ch, map.get(ch) + 1);
			else
				map.put(ch, 1);
		}

		for (i = 0; i < b.length(); i++) {
			char ch = b.charAt(i);
			if (map.containsKey(ch))
				map.put(ch, map.get(ch) - 1);
			else
				map.put(ch, -1);
		}

		for (int value : map.values()) {
			if (value != 0) {
				deletions += Math.abs(value);
			}
		}

		return deletions;
	}

}