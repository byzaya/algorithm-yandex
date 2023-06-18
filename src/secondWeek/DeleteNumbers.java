package secondWeek;

// Дан массив a из n чисел.
// Найдите минимальное количество чисел, после удаления которых попарная разность оставшихся чисел по модулю не будет превышать 1,
// то есть после удаления ни одно число не должно отличаться от какого-либо другого более чем на 1.

// Формат ввода
// Первая строка содержит одно целое число n (1 ≤ n ≤ 2⋅10^5) — количество элементов массива a.
// Вторая строка содержит n целых чисел a1,a2,…,an (0 ≤ ai ≤ 10^5) — элементы массива a.

// Формат вывода
// Выведите одно число — ответ на задачу.

import java.util.Arrays;
import java.util.Scanner;

public class DeleteNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        Arrays.sort(nums);
        int[] countNum = new int[nums[n - 1] + 1];
        for (int i = 0; i < n; i++) {
            countNum[nums[i]]++;
        }

        int max = countNum[1] + countNum[2];
        for (int i = 3; i < countNum.length; i++) {
            int max1 = countNum[i] + countNum[i - 1];
            if (max1 > max) {
                max = max1;
            }
        }
        System.out.println(n - max);
    }
}
