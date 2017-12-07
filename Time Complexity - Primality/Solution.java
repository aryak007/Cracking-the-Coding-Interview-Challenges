import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(checkPrimality(n));
		}
	}
	static String checkPrimality(int n) {
		
		if(n==2)
			return "Prime";

		if(n==1 || (n&1)==0)
			return "Not prime";

		for (int i = 3; i <= (int)(Math.sqrt(n)); i+=2)
			if (n % i == 0)
				return "Not prime";
		return "Prime";
	}
}

