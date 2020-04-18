package lab5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class PrintHex {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        Queue<String> q = new LinkedList<>();
        q.add("1");
        q.add("2");
        q.add("3");
        q.add("4");
        q.add("5");
        q.add("6");
        q.add("7");
        q.add("8");
        q.add("9");
        q.add("A");
        q.add("B");
        q.add("C");
        q.add("D");
        q.add("E");
        q.add("F");

        while (N-- > 0) {
            String num = q.poll();
            q.add(num + "0");
            q.add(num + "1");
            q.add(num + "2");
            q.add(num + "3");
            q.add(num + "4");
            q.add(num + "5");
            q.add(num + "6");
            q.add(num + "7");
            q.add(num + "8");
            q.add(num + "9");
            q.add(num + "A");
            q.add(num + "B");
            q.add(num + "C");
            q.add(num + "D");
            q.add(num + "E");
            q.add(num + "F");
            sb.append(num + " ");
        }
        System.out.println(sb);

    }
}