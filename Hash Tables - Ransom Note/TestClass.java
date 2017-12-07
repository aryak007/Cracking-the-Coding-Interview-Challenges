import java.io.*;
import java.util.*;
class TestClass {
	public static void main (String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TestClass T = new TestClass();


		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		String[] magazine = new String[m];
		String[] note = new String[n];

		st = new StringTokenizer(br.readLine());
		for(int i =0;i<m;i++)
			magazine[i] = st.nextToken();
		st = new StringTokenizer(br.readLine());

		for(int i =0;i<n;i++)
			note[i] = st.nextToken();
		
		System.out.println(T.checkIfReplicable(magazine,m,note,n));
	}

	String checkIfReplicable(String magazine[],int m, String note[],int n) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int i;
		for (i = 0; i <m; i++) {
			if (map.containsKey(magazine[i]))
				map.put(magazine[i], map.get(magazine[i]) + 1);
			else
				map.put(magazine[i], 1);
		}

		for (i = 0; i < n; i++) {
			if(map.containsKey(note[i]))
				if(map.get(note[i])>0)
					map.put(note[i],map.get(note[i])-1);
				else
					return "No";
			else
				return "No";
		}

		return "Yes";
	}

}