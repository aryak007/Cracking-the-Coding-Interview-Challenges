/*
A left rotation operation on an array of size  shifts each of the array's elements  unit to the left. For example, if left rotations are performed on array , then the array would become .

Given an array of  integers and a number, , perform  left rotations on the array. Then print the updated array as a single line of space-separated integers.

Input Format

The first line contains two space-separated integers denoting the respective values of  (the number of integers) and  (the number of left rotations you must perform).
The second line contains  space-separated integers describing the respective elements of the array's initial state.

Constraints

Output Format

Print a single line of  space-separated integers denoting the final state of the array after performing  left rotations.

Sample Input

5 4
1 2 3 4 5
Sample Output

5 1 2 3 4
Explanation

When we perform  left rotations, the array undergoes the following sequence of changes:

Thus, we print the array's final state as a single line of space-separated values, which is 5 1 2 3 4.
*/

import java.io.*;
import java.util.*;
class TestClass {
	public static void main (String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TestClass T = new TestClass();


		StringTokenizer st = new StringTokenizer(br.readLine());
		int n =  Integer.parseInt(st.nextToken());
		int d =  Integer.parseInt(st.nextToken());

		int arr[] = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] =  Integer.parseInt(st.nextToken());

		for (int i = 0;i<d;i++)
			T.rotateArrayByOne(arr, n);

		T.printArray(arr,n);


	}

	void printArray(int arr[],int n){
		for(int i = 0;i<n;i++)
			System.out.print(arr[i]+" ");
	}

	void rotateArrayByOne(int arr[], int n) {
		int temp = arr[0];
		int i;
		for (i = 0; i < n - 1; i++) {
			arr[i] = arr[i + 1];
		}
		arr[i] = temp;
	}
	
}

