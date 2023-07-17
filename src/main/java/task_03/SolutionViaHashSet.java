package task_03;

import java.io.*;
import java.util.HashSet;


/**
 * Для решения данной задачи можно использовать принципы алгоритма "Считывание итератора".
 * Вот один из способов решения задачи на языке Java:
 * */
public class SolutionViaHashSet {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        HashSet<Integer> uniqueElements = new HashSet<>();

        // Читаем n чисел и добавляем их в HashSet для удаления повторений
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(reader.readLine());
            uniqueElements.add(number);
        }

        // Выводим уникальные элементы, сохраненные в HashSet
        for (int element : uniqueElements) {
            System.out.println(element);
        }
    }
}

/*
  В этом решении мы используем HashSet для хранения уникальных элементов. Мы считываем числа по одному из входного
  потока и добавляем их в HashSet. HashSet автоматически отбрасывает повторяющиеся элементы, поэтому в итоге в нем
  останутся только уникальные элементы. Затем мы просто выводим их на экран.
  Обратите внимание, что этот код считывает входной поток (стандартный ввод) и выводит результат в выходной поток
  (стандартный вывод). Вы можете изменить его, чтобы считывать из файла или записывать результат в файл, если требуется.
  */
