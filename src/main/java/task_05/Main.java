package task_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 = reader.readLine();
        String str2 = reader.readLine();

        boolean isAnagram = checkAnagram(str1, str2);

        if (isAnagram) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static boolean checkAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        int[] count = new int[26]; // Массив для подсчета частоты символов

        for (int i = 0; i < str1.length(); i++) {
            count[str1.charAt(i) - 'a']++; // Увеличиваем частоту символа из первой строки
            count[str2.charAt(i) - 'a']--; // Уменьшаем частоту символа из второй строки
        }

        for (int freq : count) {
            if (freq != 0) {
                return false; // Если частоты символов не совпадают, строки не являются анаграммами
            }
        }

        return true; // Все частоты символов совпадают, строки являются анаграммами
    }
}
