package lab3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class RangeSum {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i ++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int j = Integer.parseInt(st2.nextToken());
			int k = Integer.parseInt(st2.nextToken());
			if (j > k) {
				int tmp = j;
				j = k;
				k = tmp;
			}
			int sum = 0;
			for (int s = j-1; s < k; s++) {
				sum += arr[s];
			}
			System.out.println(sum);
		}
	}
}
