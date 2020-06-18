package midterm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MultiWaiting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, M;
        double answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>();
        int[] labor = new int[N];

        for (int i = 0; i < M; i++) {
            StringTokenizer sto = new StringTokenizer(br.readLine());
            int[] c = new int[2];

            c[0] = Integer.parseInt(sto.nextToken());
            c[1] = Integer.parseInt(sto.nextToken());

            int minLabor = Integer.MAX_VALUE;
            int index = 0;
            for (int l = 0; l < N; l++) {
                if (minLabor > labor[l]) {
                    minLabor = labor[l];
                    index = l;
                }
            }
            int waitTime = Math.max(0, minLabor - c[0]);
            labor[index] = waitTime + c[0] + c[1];
            answer += waitTime;
        }
        System.out.println(Math.round((100 * (answer / M)))/ 100.0);
    }
}