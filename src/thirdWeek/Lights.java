package thirdWeek;

// На завод по изготовлению гирлянд пришел срочный заказ: изготовить как можно больше одинаковых гирлянд, состоящих из n лампочек.
// На складе завода есть лампочки k различных цветов, цвета занумерованы от 1 до k.
// Определите, сколько гирлянд сможет изготовить завод и из каких лампочек должна состоять каждая гирлянда.

// Формат ввода
// В первой строке задаются два числа n (1 ≤ n ≤ 40000) и k (1 ≤ k ≤ 50000).
// В следующих k строках задается количество лампочек каждого из k цветов.
// Суммарное количество лампочек на складе не превосходит 2 × 10^9.

// Формат вывода
// В первой строке выведите максимальное количество гирлянд.
// В следующих n строках выведите описание гирлянды: в каждой строке выведите номер цвета лампочки, находящейся в гирлянде на очередном месте.
// Если возможных ответов несколько — выведите любой из них.


// Используем бинарный поиск по ответу

import java.util.*;

public class Lights {
    public static boolean good(int m, int n, int k, int[] cntLamp) {
        int inGarland = 0;
        for (int i = 0; i < k; i++) {
            inGarland += cntLamp[i] / m;
        }
        return inGarland >= n;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] cntLamp = new int[k];
        for (int i = 0; i < k; i++) {
            cntLamp[i] = scanner.nextInt();
        }

        int l = 0;
        int r = (int) Math.pow(10, 9) * 2;
        while (l < r) {
            int m = (l + r + 1) / 2;
            if (good(m, n, k, cntLamp)) {
                l = m;
            } else {
                r = m - 1;
            }
        }

        System.out.println(l);
        int usedLamps = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < Math.min(cntLamp[i] / l, n - usedLamps); j++) {
                System.out.println(i + 1);
                usedLamps++;
            }
        }
    }
}
