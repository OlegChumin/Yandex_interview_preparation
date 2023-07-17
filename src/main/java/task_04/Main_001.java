package task_04;

import java.io.*;

public class Main_001 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        generateBrackets("", 0, 0, n);
    }

    private static void generateBrackets(String current, int openCount, int closeCount, int n) {
        if (current.length() == 2 * n) {
            System.out.println(current);
            return;
        }

        if (openCount < n) {
            generateBrackets(current + "(", openCount + 1, closeCount, n);
        }

        if (closeCount < openCount) {
            generateBrackets(current + ")", openCount, closeCount + 1, n);
        }
    }
}

/**
 * В этом решении мы используем рекурсивную функцию generateBrackets(), которая принимает текущую скобочную
 * последовательность current, количество открытых скобок openCount, количество закрытых скобок closeCount и общую длину
 * последовательности n.
 *
 * Мы начинаем с пустой строкой current и проверяем два условия:
 *
 * Если длина current становится равной 2n, это означает, что мы получили правильную скобочную последовательность.
 * Выводим ее и возвращаемся из рекурсии.
 *
 * Если количество открытых скобок openCount меньше n, мы можем добавить открывающую скобку "(" и вызвать рекурсивно
 * generateBrackets() с увеличенным openCount.
 *
 * Если количество закрытых скобок closeCount меньше openCount, мы можем добавить закрывающую скобку ")" и вызвать
 * рекурсивно generateBrackets() с увеличенным closeCount.
 *
 * Программа рекурсивно генерирует все правильные скобочные последовательности и выводит их на консоль в
 * лексикографическом порядке.
 *
 * Обратите внимание, что данное решение использует рекурсию, и объем памяти, занимаемый программой, пропорционален n.
 * Однако, время выполнения может быть экспоненциальным относительно общего количества правильных скобочных
 * последовательностей, так как их число растет быстро с увеличением n.
 * */
