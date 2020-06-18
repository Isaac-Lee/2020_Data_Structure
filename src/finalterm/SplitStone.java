package finalterm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SplitStone {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        Queue<Integer> rocks = new LinkedList<>();

        int answer = 0;
        int cnt = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int rockSize = Integer.parseInt(st.nextToken());
            if (rockSize > target) {
                int big = (int) Math.round(rockSize/3.0 * 2.0);
                int small = (int) Math.round(rockSize/3.0 * 1.0);

                if (big > target) {
                    rocks.add(big);
                } else {
                    answer += 1;
                }
                if (small > target) {
                    rocks.add(small);
                } else {
                    answer += 1;
                }
                cnt++;
            } else {
                answer ++;
            }

        }
        while (rocks.size() != 0) {
            int size = rocks.poll();

            int big = (int) Math.round(size/3.0 * 2.0);
            int small = (int) Math.round(size/3.0 * 1.0);

            if (big > target) {
                rocks.add(big);
            } else {
                answer += 1;
            }
            if (small > target) {
                rocks.add(small);
            } else {
                answer += 1;
            }
            cnt++;
        }

        System.out.println(cnt + " " + answer);
    }
}
