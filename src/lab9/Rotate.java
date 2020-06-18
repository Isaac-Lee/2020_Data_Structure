package lab9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Rotate {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> arr = new ArrayList<>();

        while (st.hasMoreTokens()) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        int mindex = 0;

        int left = 0;
        int right = arr.size()-1;

        while (left <= right) {
            if (arr.get(left) <= arr.get(right)) {
                mindex = left;
                break;
            }

            int mid = (left + right)/2;
            int next = (mid+1) % arr.size();
            int prev = (mid-1 + arr.size())%arr.size();

            if (arr.get(mid) <= arr.get(next) && arr.get(mid) <= arr.get(prev)) {
                mindex = mid;
                break;
            } else if (arr.get(mid) <= arr.get(right)) {
                right = mid - 1;
            } else if (arr.get(mid) >= arr.get(left)) {
                left = mid + 1;
            }
        }

        if (mindex > arr.size()/2) {
            int answer = arr.size() - mindex;
            System.out.println(answer);
        } else {
            System.out.println(mindex);
        }
    }
}
