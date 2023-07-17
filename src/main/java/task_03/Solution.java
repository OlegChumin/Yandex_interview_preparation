package task_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        int prevNumber = Integer.parseInt(reader.readLine());
        System.out.println(prevNumber);

        for (int i = 1; i < n; i++) {
            int number = Integer.parseInt(reader.readLine());
            if (number != prevNumber) {
                System.out.println(number);
                prevNumber = number;
            }
        }
    }
}
