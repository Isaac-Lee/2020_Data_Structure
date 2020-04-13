package lab1;

import java.util.Arrays;
import java.util.Scanner;

public class prob3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		
		String[] LengthCase = input.nextLine().split(" ");
		
		int[] answer = new int[Integer.parseInt(LengthCase[0])];
		for (int i = 0; i < Integer.parseInt(LengthCase[1]); i++) {
			String[] c = input.nextLine().split(" ");
			int a = Integer.parseInt(c[0]);
			int b = Integer.parseInt(c[1]);
			int h = Integer.parseInt(c[2]);
			if (a > b) {
				int temp = a;
				b = a;
				a = temp;
			}
			for (int s = a-1; s < b; s++) {
				answer[s] += h;
			}
		}
		Arrays.sort(answer);
		System.out.println(answer[Integer.parseInt(LengthCase[0])-1]);
	}
}
