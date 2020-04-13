package lecture3;

import java.util.Scanner;
import java.util.StringTokenizer;

public class prob1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int k = input.nextInt();
 		input.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
 		
		StringTokenizer st = new StringTokenizer(input.nextLine());
		String[] number = new String[k];
		for (int i = 0; i < k; i++) {
			number[i] = st.nextToken();
		}
		for (int j = k-1; j > -1; j--) {
			if (j == 0) {
				System.out.print(number[j]+"\n");
			} else {
				System.out.print(number[j]+" ");
			}
			
		}
		
		
	}
}
