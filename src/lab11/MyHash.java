package lab11;

import java.util.Scanner;

public class MyHash {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int bucket = sc.nextInt();
        String[] my_hash = new String[bucket];
        int entry = sc.nextInt();

        for (int i = 0; i < entry; i++) {
            int hash = sc.nextInt() % bucket;
            String content = sc.next();
            if (my_hash[hash] != null && !my_hash[hash].equals(content)) {
                boolean isDone = false;
                for (int j = hash+1; j < bucket; j++) {
                    if (my_hash[j] == null) {
                        my_hash[j] = content;
                        isDone = true;
                        break;
                    }
                }
                if (!isDone) {
                    for (int j = 0; j < hash; j++) {
                        if (my_hash[j] == null) {
                            my_hash[j] = content;
                            break;
                        }
                    }
                }
            } else {
                my_hash[hash] = content;
            }
        }

        for (String s: my_hash) {
            if (s != null) {
                System.out.print(s+ " ");
            }
        }
        System.out.println("");
    }
}
