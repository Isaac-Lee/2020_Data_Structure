package lab11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class SumOfArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int target = Integer.parseInt(br.readLine());
        int index = 0;
        Map<Integer, Integer> map = new HashMap<>();
        String s = br.readLine();
        String[] tokens = s.split(" ");
        for (int i = 0; i < tokens.length; i++) {
            String token1 = tokens[i];
            for (int j = 0; j < tokens.length; j++) {
                String token2 = tokens[j];
                map.put(Integer.parseInt(token1) + Integer.parseInt(token2), Integer.valueOf(index));
                index++;
            }
        }

        boolean answer = false;

        for (int i = 0; i < tokens.length; i++) {
            int remain = target - Integer.parseInt(tokens[i]);
            for (int j = 0; j < tokens.length; j++) {
                int seond_remain = remain - Integer.parseInt(tokens[j]);
                if (map.containsKey(seond_remain)) {
                    answer = true;
                    break;
                }
            }
        }


        System.out.println(answer);
    }
}
