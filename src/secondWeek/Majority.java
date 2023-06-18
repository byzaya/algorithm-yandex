package secondWeek;

// Majority (в дословном переводе "большинство") — это значение элемента, который в массиве длиной n встречается более чем n / 2 раз.
// Определите majority массива, если гарантируется, что такой элемент существует.

// Формат ввода
// В первой строке вводится число n (1 ≤ n ≤ 5 × 104).
// Во второй строке вводится n чисел через пробел, числа не превосходят 109 по модулю.

// Формат вывода
// Выведите majority массива.

import java.util.Arrays;
import java.util.Scanner;

public class Majority {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        Arrays.sort(nums);
        int count = 1;
        int maxCount = 1;
        int result = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                if (count > maxCount) {
                    maxCount = count;
                    result = nums[i - 1];
                }
                count = 1;
            }
        }
        if (count > maxCount) {
            result = nums[nums.length - 1];
        }
        System.out.println(result);
    }
}
