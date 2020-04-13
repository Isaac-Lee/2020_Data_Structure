package lab2;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class prob2 {
	public static void main(String[] args) throws NumberFormatException, IOException{
		InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(r);
		
		int n = Integer.parseInt(br.readLine());
		int length = 0;
		
		for (int i = 0; i < n; i++) {
			length += br.readLine().replace(" ", "").replace("\t", "").length();
		}
		System.out.println(length);
	}
}