package lab9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ArrivalHall {
    static int m, max = Integer.MIN_VALUE;
    static List<Integer> time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        m = Integer.parseInt(br.readLine());

        time = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            int t = Integer.parseInt(st.nextToken());
            time.add(t);
            max = Math.max(max, t);
        }
        binarySearch();
    }

    private static void binarySearch() {
        int left = 1;
        int right = max*m + max*(m/10);
        int result = right;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;

            if (isPossible(mid)) {
                result = Math.min(result, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(result);
    }

    private static boolean isPossible(int t) {
        int sum = 0;
        int n = time.size();
        for (int i = 0; i < n; i++) {
            int temp = 0;
            temp += t / time.get(i);
            if (temp>10) {
                temp -= (temp/10);
            }
            sum += temp;
        }
        return sum >= m;
    }
}
