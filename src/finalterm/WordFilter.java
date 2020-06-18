package finalterm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class WordFilter {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> filter = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String key = st.nextToken();
            String value = st.nextToken();

            filter.put(key, value);
        }
        String input = "";
        while((input = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                String word = st.nextToken();
                if (filter.containsKey(word)){
                    System.out.print(filter.get(word)+" ");
                } else {
                    System.out.print(word+" ");
                }
            }
            System.out.println("");
        }
    }
}
