package lab4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

interface Stack<T> {
    void push(T obj);
    T pop();
}

class MyStack<T> implements Stack<T> {
    ArrayList<T> stack = new ArrayList<>();
    int top;

    public MyStack() {
        this.top = -1;
    }

    @Override
    public void push(T obj) {
        stack.add(obj);
        top++;
    }

    @Override
    public T pop() {
        T re = stack.get(top);
        stack.remove(top--);
        return re;
    }
    public T peek() {
        return stack.get(top);
    }
}

// FILL HERE (Class)
class Status {
    public int top;
    public int min;
    public int max;

    public Status(int top, int min, int max) {
        this.top = top;
        this.min = min;
        this.max = max;
    }
}



public class CallStack {

    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        MyStack<Status> stack = new MyStack<>();

        // FILL HERE (Operations)
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String oper = st.nextToken();
            if (oper.equals("push")) {
                int k = Integer.parseInt(st.nextToken());
                if (k > max) {
                    max = k;
                }
                if (k < min) {
                    min = k;
                }
                Status s = new Status(k, min, max);
                stack.push(s);
            }
            else if (oper.equals("pop")) {
                Status s = stack.pop();
                max = stack.peek().max;
                min = stack.peek().min;
                System.out.println(String.format("%d %d %d", s.top, s.min, s.max));
            }
        }

        scanner.close();
    }
}