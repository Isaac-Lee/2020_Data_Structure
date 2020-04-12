package lab4;

import java.util.Scanner;
import java.util.Stack;

public class Brackets {
    public static void main(String[] args) throws NumberFormatException {
        Scanner sc = new Scanner(System.in);

        StringBuilder str = new StringBuilder();
        while(sc.hasNext()){
            String line = sc.nextLine();
            str.append(line);
        }

        boolean isPal = true;
        boolean isString = false;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);
            if (c == '(') {
                if (isString) {
                    continue;
                }
                stack.push(c);
            } else if (c == ')') {
                if (isString) {
                    continue;
                }
                if (stack.isEmpty()) {
                    isPal = false;
                    break;
                }
                char temp = stack.peek();
                if (temp == '(') {
                    stack.pop();
                } else {
                    isPal = false;
                    break;
                }
            }

            if (c == '{') {
                if (isString) {
                    continue;
                }
                stack.push(c);
            } else if (c == '}') {
                if (isString) {
                    continue;
                }
                if (stack.isEmpty()) {
                    isPal = false;
                    break;
                }
                char temp = stack.peek();
                if (temp == '{') {
                    stack.pop();
                } else {
                    isPal = false;
                    break;
                }
            }

            if (c == '[') {
                if (isString) {
                    continue;
                }
                stack.push(c);
            } else if (c == ']') {
                if (isString) {
                    continue;
                }
                if (stack.isEmpty()) {
                    isPal = false;
                    break;
                }
                char temp = stack.peek();
                if (temp == '[') {
                    stack.pop();
                } else {
                    isPal = false;
                    break;
                }
            }
            if (c == '"') {
                isString = !isString;
            }

        }

        if (isPal && stack.isEmpty()) {
            System.out.println("No Error");
        } else {
            System.out.println("Compile Error");
        }
    }
}

