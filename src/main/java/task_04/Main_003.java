package task_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_003 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        generateBrackets("", 0, 0, 0, n);
    }

    private static void generateBrackets(String current, int openCount, int closeCount, int index, int n) {
        if (index == 2 * n) {
            System.out.println(current);
            return;
        }

        if (openCount < n) {
            generateBrackets(current + "(", openCount + 1, closeCount, index + 1, n);
        }

        if (closeCount < openCount) {
            generateBrackets(current + ")", openCount, closeCount + 1, index + 1, n);
        }
    }
}
