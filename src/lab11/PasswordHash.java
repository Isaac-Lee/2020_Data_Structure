package lab11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class PasswordHash {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> db = new HashMap<>();

        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String id = st.nextToken();
            String pass = st.nextToken();

            pass = (new StringBuffer(pass)).reverse().toString();
            String upper = pass.toUpperCase();
            String lower = pass.toLowerCase();
            int hash = upper.hashCode() + lower.hashCode();
            db.put(id, hash);
        }

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            String id = st.nextToken();
            String pass = st.nextToken();

            if (db.containsKey(id)) {
                if (db.get(id) == Integer.parseInt(pass)) {
                    System.out.println(true);
                } else {
                    System.out.println(false);
                }
            } else {
                System.out.println(false);
                continue;
            }
        }
    }
}
