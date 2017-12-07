import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int coins[] = new int[m];
		for (int coins_i = 0; coins_i < m; coins_i++) {
			coins[coins_i] = in.nextInt();
		}
		System.out.println(coinChange(coins, m, n));
	}
	static long coinChange(int[] coins, int m, int n) {
		Arrays.sort(coins);
		long dp[][] = new long[m + 1][n + 1];

		for (int i = 0; i < m; i++)
			dp[i][0] = 1;

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (j<coins[i-1])
					dp[i][j] = dp[i - 1][j];
				else
					dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
			}
		}
		return dp[m][n];
	}
}
