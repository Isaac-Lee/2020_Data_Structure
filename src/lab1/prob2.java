package lab1;

import java.util.Scanner;

public class prob2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int cases = input.nextInt();
		input.nextLine();
		int[] multi = new int[cases];
		String[] numbers = input.nextLine().split(" ");
		String[] words = new String[cases];
		
		for (int i = 0; i < cases; i++) {
			words[i] = input.nextLine();
			multi[i] = Integer.parseInt(numbers[i]);
		}
		
		for (int k = 0; k < cases; k++) {
			for (int i = 0; i < multi[k]; i++) {
				System.out.println(words[k]);
			}
		}
	}
}
