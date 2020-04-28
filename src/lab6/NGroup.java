package lab6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N, M;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<Set<String>> setArr = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            setArr.add(new HashSet<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            setArr.get(n).add(st.nextToken());
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            String[] order = br.readLine().split(" ");
            int a = Integer.parseInt(order[1]);
            int b = Integer.parseInt(order[2]);
            int c = Integer.parseInt(order[3]);
            if (order[0].equals("U")) {
                Set<String> u = new HashSet<>();
                u.addAll(setArr.get(a));
                u.addAll(setArr.get(b));
                u.addAll(setArr.get(c));
                System.out.println(u.size());

            } else if (order[0].equals("I")) {
                Set<String> I = new HashSet<>(setArr.get(a));
                I.retainAll(setArr.get(b));
                I.retainAll(setArr.get(c));
                System.out.println(I.size());

            } else if (order[0].equals("D")) {
                Set<String> d = new HashSet<>(setArr.get(a));
                d.removeAll(setArr.get(b));
                d.removeAll(setArr.get(c));
                System.out.println(d.size());
            }
        }
    }
}
