package task_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Чтение строки J
        String j = reader.readLine().trim();

        // Чтение строки S
        String s = reader.readLine().trim();

        // Закрытие BufferedReader
        reader.close();

        // Вызов функции для подсчета количества символов из S, входящих в J
        int count = countJewels(j, s);

        // Вывод результата
        System.out.println(count);
    }

    private static int countJewels(String j, String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (j.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }
}
