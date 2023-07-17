package task_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_006 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        generateBrackets("", 0, 0, n);
    }

    private static void generateBrackets(String sequence, int openCount, int closeCount, int n) {
        if (sequence.length() == 2 * n) {
            System.out.println(sequence);
            return;
        }

        if (openCount < n) {
            generateBrackets(sequence + "(", openCount + 1, closeCount, n);
        }

        if (closeCount < openCount) {
            generateBrackets(sequence + ")", openCount, closeCount + 1, n);
        }
    }
}
