package secondWeek;

// Вам дана последовательность измерений некоторой величины.
// Требуется определить, повторялась ли какое-либо число, причём расстояние между повторами не превосходило k.

// Формат ввода
// В первой строке задаются два числа n и k (1 ≤ n, k ≤ 10^5).
// Во второй строке задаются n чисел, по модулю не превосходящих 10^9.

// Формат вывода
// Выведите YES, если найдется повторяющееся число и расстояние между повторами не превосходит k и NO в противном случае.

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RepeatNumbers {
    public static boolean hasRepeat(int[] sequence, int k) {
        Map<Integer, Integer> numbersIndex = new HashMap<>();
        for (int i = 0; i < sequence.length; i++) {
            if (numbersIndex.containsKey(sequence[i]) && i - numbersIndex.get(sequence[i]) <= k) {
                return true;
            }
            numbersIndex.put(sequence[i], i);
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numNumbers = input.nextInt();
        int k = input.nextInt();
        int[] nums = new int[numNumbers];
        for (int i = 0; i < numNumbers; i++) {
            nums[i] = input.nextInt();
        }
        System.out.println(hasRepeat(nums, k) ? "YES" : "NO");
    }
}
