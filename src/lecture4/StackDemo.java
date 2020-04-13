package lecture4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StackDemo {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Stack<String> s = new Stack<String>();
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(input.readLine());
			
		for (int i = 0; i < n; i++) {
			s.push(input.readLine());
		}
		
		int k = Integer.parseInt(input.readLine());
		for (int i = 0; i < k; i++) {
			System.out.println(s.pop());
		}
		input.close();
	}
}
