package task_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        generateBrackets(n);
    }

    private static void generateBrackets(int n) {
        Stack<Character> stack = new Stack<>();
        stack.push('(');

        int openCount = 1;
        int closeCount = 0;

        while (!stack.isEmpty()) {
            if (openCount < n) {
                stack.push('(');
                openCount++;
            } else if (closeCount < openCount) {
                stack.push(')');
                closeCount++;
            } else {
                printStack(stack);
                stack.pop();

                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                    openCount--;
                    closeCount++;
                    stack.push(')');

                    continue;
                }
            }

            if (openCount + closeCount == 2 * n) {
                printStack(stack);
                stack.pop();
            }
        }
    }

    private static void printStack(Stack<Character> stack) {
        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }
        System.out.println(sb.toString());
    }
}
