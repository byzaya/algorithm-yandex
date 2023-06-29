package thirdWeek;

// Дана последовательность чисел и запросы вида "определите сколько положительных чисел на отрезке с индексами от L до R".

// Формат ввода
// В первой строке вводится число n (1 ≤ n ≤ 100000) — длина последовательности.
// Во второй строке вводится последовательность из n целых чисел, все числа по модулю не превосходят 100000.
// Нумерация в последовательности начинается с единицы.
// В первой строке вводится число q (1 ≤ q ≤ 100000) — количество запросов.
// В каждой из следующих q строк вводятся запросы — два индекса l и r (1 ≤ l ≤ r ≤ n)

// Формат вывода
// Для каждого запроса выведите количество положительных на отрезке.

import java.util.Scanner;

public class NumOfPositive {
    public static void main(String[] args) {
        // ввод данных
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] numbers = new int[n + 1];
        numbers[0] = 0;
        for (int i = 1; i <= n; i++) {
            numbers[i] = input.nextInt();
        }
        int q = input.nextInt();
        int[] first = new int[q];
        int[] second = new int[q];
        for (int i = 0; i < q * 2 - 1; i = i + 2) {
            first[i / 2] = input.nextInt();
            second[(i + 1) / 2] = input.nextInt();
        }
        int a;
        int b;
        int solution = 0;
        for (int i = 0; i < q; i++) {
            a = first[i];
            b = second[i];
            for (int j = a; j <= b; j++) {
                if(numbers[j] > 0) {
                    solution++;
                }
            }
            System.out.println(solution);
            solution = 0;
        }
    }
}
