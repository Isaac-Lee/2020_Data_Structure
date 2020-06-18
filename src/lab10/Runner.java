package lab10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Runner {
    static int group = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n, k;
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        ArrayList<person> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int position = Integer.parseInt(st.nextToken());
            int velocity = Integer.parseInt(st.nextToken());
            arr.add(new person(position, velocity, (k-position)/velocity));
        }

        Collections.sort(arr);

        for (int i = 0; i < n-1; i++) {
            if (arr.get(i).arrivaltime >= arr.get(i+1).arrivaltime) {
                arr.get(i+1).arrivaltime = arr.get(i).arrivaltime;
            } else {
                group++;
            }
        }

        System.out.println(group);
    }
}

class person implements Comparable{
    int position;
    int velo;
    int arrivaltime;

    public person(int p, int v, int ar) {
        this.position = p;
        this.velo = v;
        this.arrivaltime = ar;
    }

    @Override
    public int compareTo(Object o) {
        person R = (person) o;
        if (this.position < R.position) {
            return 1;
        } else if (this.position > R.position) {
            return -1;
        }
        return 0;
    }
}