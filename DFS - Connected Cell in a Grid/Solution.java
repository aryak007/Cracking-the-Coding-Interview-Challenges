import java.io.*;
import java.util.*;
class Solution {
	int count = 0;
	public static void main (String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Solution S = new Solution();
		
        StringTokenizer st;
		
			
			int m =  Integer.parseInt(br.readLine());
			int n =  Integer.parseInt(br.readLine());

			int matrix[][] = new int[m][n];

			
			for (int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++)
					matrix[i][j] = Integer.parseInt(st.nextToken());
            }
				

			System.out.println(S.countConnectedComponents(matrix, m, n));
		

	}
	int countConnectedComponents(int matrix[][], int m, int n) {
		boolean visited[][] = new boolean[m][n];
		int maxCount=Integer.MIN_VALUE;
		for (int i = 0; i < m; ++i)
			for (int j = 0; j < n; ++j)
				if (matrix[i][j] == 1 && !visited[i][j]) {
					count = 1;
					DFS(matrix, i, j, visited, m, n);
					maxCount = Math.max(maxCount,count);
					//System.out.println(maxCount);
				}
		return maxCount;
	}

	void DFS(int matrix[][], int row, int col, boolean visited[][], int m, int n) {
		visited[row][col] = true;
		for(int i = row-1;i<=row+1;i++){
			for(int j = col-1;j<=col+1;j++){
				if(checkValidity(matrix,m,n,i,j,visited) && (i!=row || j!=col)){

					count++;
					//System.out.println(count);
					DFS(matrix, i, j, visited,m,n);
				}
			}
		}
	}



	boolean checkValidity(int matrix[][], int m, int n, int row, int col, boolean visited[][]) {
		if (row >= m || col >= n || row < 0 || col < 0)
			return false;
		if (matrix[row][col] == 0 || visited[row][col])
			return false;
		return true;
	}
}