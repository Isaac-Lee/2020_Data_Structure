package lecture11;

import java.util.Scanner;

public class prob1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int bucket = sc.nextInt();
        String[] my_hash = new String[bucket];
        int entry = sc.nextInt();

        for (int i = 0; i < entry; i++) {
            int hash = sc.nextInt() % bucket;
            String content = sc.next();
            my_hash[hash] = content;
        }

        for (String s: my_hash) {
            if (s != null) {
                System.out.print(s+ " ");
            }
        }
        System.out.println("");
    }
}
