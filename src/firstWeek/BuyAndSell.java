package firstWeek;
// У вас есть 1000$, которую вы планируете эффективно вложить. Вам даны цены за 1000 кубометров газа за n дней.
// Можно один раз купить газ на все деньги в день i и продать его в один из последующих дней j, i < j.
// Определите номера дней для покупки и продажи газа для получения максимальной прибыли.

//Формат ввода:
// В первой строке вводится число дней n (1 ≤ n ≤ 100000).
// Во второй строке вводится n чисел — цены за 1000 кубометров газа в каждый из дней.
// Цена — целое число от 1 до 5000. Дни нумеруются с единицы.

// Формат вывода
// Выведите два числа i и j — номера дней для покупки и продажи газа.
// Если прибыль получить невозможно, выведите два нуля.

import java.util.Scanner;

public class BuyAndSell {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        if (n == 1) {
            System.out.println(0 + " " + 0);
        }
        int dayBuy = 0;
        int daySell = 0;
        int min = 0;
        for (int i = 1; i < n; i++) {
            if (nums[daySell] * nums[min] < nums[dayBuy] * nums[i]) {
                dayBuy = min;
                daySell = i;
            }
            if (nums[i] < nums[min]) {
                min = i;
            }
        }
        dayBuy += 1;
        daySell += 1;
        if (dayBuy == daySell) {
            dayBuy = daySell = 0;
        }
        System.out.println(dayBuy + " " + daySell);
    }
}
