package task_03;

import java.util.HashSet;
import java.util.Scanner;

public class Main_003 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        HashSet<Integer> uniqueElements = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int number = scanner.nextInt();
            uniqueElements.add(number);
        }

        scanner.close();

        for (int element : uniqueElements) {
            System.out.println(element);
        }
    }
}
