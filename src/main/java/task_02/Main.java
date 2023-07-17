package task_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Чтение количества элементов массива
        int n = Integer.parseInt(reader.readLine());

        // Чтение массива
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        // Закрытие BufferedReader
        reader.close();

        // Вызов функции для поиска длины самой длинной последовательности единиц
        int maxLength = findLongestSequence(array);

        // Вывод результата
        System.out.println(maxLength);
    }

    private static int findLongestSequence(int[] array) {
        int maxLength = 0;
        int currentLength = 0;

        for (int num : array) {
            if (num == 1) {
                // Увеличиваем текущую длину последовательности
                currentLength++;
            } else {
                // Проверяем, является ли текущая последовательность самой длинной
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
                // Обнуляем текущую длину последовательности
                currentLength = 0;
            }
        }

        // Проверяем, является ли текущая последовательность самой длинной
        if (currentLength > maxLength) {
            maxLength = currentLength;
        }

        return maxLength;
    }
}
