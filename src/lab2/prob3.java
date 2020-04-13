package lab2;

import java.util.Scanner;
import java.util.Arrays;

public class prob3{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n, k;
		n = input.nextInt();
		k = input.nextInt();
		input.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		
		Participant[] pr = new Participant[n];
		for (int i = 0; i < n; i++) {
			String name = input.next();
			int score = input.nextInt();
			int tries = input.nextInt();
			int time = input.nextInt();
			pr[i] = new Participant(name, score, tries, time);
		}
		Arrays.parallelSort(pr);
		System.out.println(pr[k-1].name);
	}
}

class Participant implements Comparable<Participant>{
	public String name;
	public int score;
	public int tries;
	public int time;
	
	public Participant(String name, int score, int tries, int time) {
		this.name = name;
		this.score = score;
		this.tries = tries;
		this.time = time;
	}

	@Override
	public int compareTo(Participant o) {
		if (this.score == o.score) {
			if (this.tries == o.tries) {
				if (this.time == o.time) {
					if (this.name.equals(o.name)) {
						
					} else {
						return (this.name.compareTo(o.name));
					}
				} else {
					return -(this.time - o.time);
				}
			} else {
				return (this.tries - o.tries);
			}
		} else {
			return -(this.score - o.score);
		}
		return 0;
	}
}
