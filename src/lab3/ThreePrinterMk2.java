package lab3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ThreePrinterMk2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		String[] LengthCase = br.readLine().split(" ");
		int[] height = new int[Integer.parseInt(LengthCase[0])];
		for (int i = 0; i < Integer.parseInt(LengthCase[1]); i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			
			if (a > b) {
				int temp = a;
				b = a;
				a = temp;
			}
			height[a-1] += h;
			if (b != height.length) {
				height[b] += -h;
			}
		}
		long sum = 0;
		long max = 0;
		for (int i = 0; i < Integer.parseInt(LengthCase[0]); i++) {
			sum += height[i];
			if (sum > max) {
				max = sum;
			}
		}
		
		System.out.println(max);
	}
}
