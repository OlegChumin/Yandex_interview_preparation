package task_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = 0;
        try {
            n = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        generateBrackets(n);
    }

    private static void generateBrackets(int n) {
        List<String> results = new ArrayList<>();
        generateHelper(n, n, "", results);

        for (String sequence : results) {
            System.out.println(sequence);
        }
    }

    private static void generateHelper(int openCount, int closeCount, String sequence, List<String> results) {
        if (openCount == 0 && closeCount == 0) {
            results.add(sequence);
            return;
        }

        if (openCount > 0) {
            generateHelper(openCount - 1, closeCount, sequence + "(", results);
        }

        if (closeCount > openCount) {
            generateHelper(openCount, closeCount - 1, sequence + ")", results);
        }
    }
}
