package finalterm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaximumNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String numbers = st.nextToken();
        int remove = Integer.parseInt(st.nextToken());

        if (numbers.length() == remove) {
            System.out.println(0);
        } else if (numbers.charAt(0) == '0') {
            System.out.println(0);
        } else {
            StringBuilder answer = new StringBuilder();
            int index = 0;
            for(int i = 0; i < numbers.length() - remove; i++) {
                int max = 0;
                for(int j = index; j < remove + i+1; j++) {
                    if(max < Integer.parseInt(numbers.charAt(j)+"")) {
                        max = Integer.parseInt(numbers.charAt(j)+"");
                        index = j + 1;
                    }
                }
                answer.append(max);
            }
            System.out.println(answer.toString());
        }
    }
}
