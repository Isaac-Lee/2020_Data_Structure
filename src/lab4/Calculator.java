package lab4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Calculator {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String str = makePostfix();

        System.out.println(str);
        System.out.printf(String.valueOf(calPostfix(str)));
    }

    static String makePostfix() throws IOException {
        String[] str = br.readLine().split(" ");
        StringBuilder ans = new StringBuilder();
        Stack<String> ops = new Stack<>();

        for (int i = 0; i < str.length; i++) {
            String s = str[i];

            if (s.equals("(")) {
                ops.push(s);
            } else if (s.equals(")")) {
                while (!ops.isEmpty()) {
                    String op = ops.pop();
                    if (op.equals("(")) break;
                    ans.append(op + " ");
                }
            } else {
                while (!ops.isEmpty() && precedence(ops.peek()) >= precedence(s)) {
                    ans.append(ops.pop() + " ");
                }
                ops.push(s);
            }
        }
        while (!ops.isEmpty()) {
            ans.append(ops.pop() + " ");
        }
       return String.valueOf(ans);
    }
    static int precedence(String ch) {
        if (ch.equals("(")) return 0;
        if (ch.equals("+") || ch.equals("-")) return 1;
        if (ch.equals("*") || ch.equals("/") || ch.equals("%")) return 2;
        if (ch.equals("^")) return 3;
        else return 4;
    }

    static long calPostfix(String input) {
        StringTokenizer st = new StringTokenizer(input);
        Stack<Long> stack = new Stack<>();
        while (st.hasMoreTokens()) {
            String op = st.nextToken();
            boolean isnumber = true;

            try {
                Integer.parseInt(op);
            } catch (NumberFormatException e) {
                isnumber = false;
            }

            if (isnumber) {
                stack.push(Long.parseLong(op));
            } else {
                long op2 = stack.pop();
                long op1 = stack.pop();
                switch (op) {
                    case "+":
                        stack.push(op1 + op2);
                        break;
                    case "-":
                        stack.push(op1 - op2);
                        break;
                    case "*":
                        stack.push(op1 * op2);
                        break;
                    case "/":
                        stack.push(op1 / op2);
                        break;
                    case "%":
                        stack.push(op1 % op2);
                        break;
                    case "^":
                        stack.push(Math.round(Math.pow(op1, op2)));
                        break;
                }
            }
        }
        return stack.pop();
    }
}
