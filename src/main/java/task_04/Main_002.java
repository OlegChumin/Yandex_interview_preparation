package task_04;

import java.io.*;

public class Main_002 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        generateBrackets("", 0, 0, n);
    }

    private static void generateBrackets(String current, int openCount, int closeCount, int n) {
        if (current.length() == 2 * n) {
            System.out.println(current);
            return;
        }

        if (openCount < n) {
            generateBrackets(current + "(", openCount + 1, closeCount, n);
        }

        if (closeCount < openCount) {
            generateBrackets(current + ")", openCount, closeCount + 1, n);
        }
    }
}
