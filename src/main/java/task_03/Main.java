package task_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        int uniqueCount = removeDuplicates(array);

        for (int i = 0; i < uniqueCount; i++) {
            System.out.println(array[i]);
        }
    }

    private static int removeDuplicates(int[] array) {
        int n = array.length;
        if (n == 0) {
            return 0;
        }

        int uniqueCount = 1;
        for (int i = 1; i < n; i++) {
            if (array[i] != array[uniqueCount - 1]) {
                array[uniqueCount] = array[i];
                uniqueCount++;
            }
        }

        return uniqueCount;
    }
}
