package task_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.HashSet;

public class SolutionViaSet {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        Set<Integer> uniqueElements = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(reader.readLine());
            uniqueElements.add(number);
        }

        for (int element : uniqueElements) {
            System.out.println(element);
        }
    }
}
