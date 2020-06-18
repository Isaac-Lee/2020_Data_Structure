package lecture11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class prob2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int target = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        String s = br.readLine();
        String[] tokens = s.split(" ");
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            map.put(Integer.parseInt(tokens[i]), Integer.valueOf(i));
        }

        boolean sum = false;
        for (int i = 0; i < tokens.length; i++) {
            int remain = target - Integer.parseInt(tokens[i]);
            if (map.containsKey(remain)) {
                sum = true;
                break;
            }
        }

        System.out.println(sum);
    }
}
