package task_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_002 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int prevNumber = Integer.parseInt(reader.readLine());
        System.out.println(prevNumber);

        for (int i = 1; i < n; i++) {
            int currentNumber = Integer.parseInt(reader.readLine());

            if (currentNumber != prevNumber) {
                System.out.println(currentNumber);
                prevNumber = currentNumber;
            }
        }

        reader.close();
    }
}
