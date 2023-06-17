package firstWeek;
// Вася занимается строительством лесенок из блоков.
// Лесенка состоит из ступенек, при этом i-ая ступенька должна состоять ровно из i блоков.
// По заданному числу блоков n определите максимальное количество ступенек в лесенке,
// которую можно построить из этих блоков.

// Формат ввода
// Вводится одно число n (1 ≤ n ≤ 231 - 1)

// Формат вывода
// Выведите одно число — количество ступенек в лесенке.

import java.util.Scanner;

public class ConstructionStairs {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); // кол-во блоков для построения лестницы

        // лестница начинается с 1 блока
        // каждая следующая ступень должна быть на 1 больше предыдущего

        int countOfUsingBlocks = 1;
        int countOfStairs = 1;
        if (n == 0) {
            System.out.println(0);
        }
        while (countOfUsingBlocks < n) {
            if (n - countOfUsingBlocks < countOfStairs + 1) {
                break;
            }
            countOfStairs++;
            countOfUsingBlocks = countOfUsingBlocks + countOfStairs;
        }
        System.out.println(countOfStairs);
        input.close();
    }
}
