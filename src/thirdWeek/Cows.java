package thirdWeek;

// На прямой расположены стойла, в которые необходимо расставить коров так, чтобы минимальное расcтояние между коровами было как можно больше.

// Формат ввода
// В первой строке вводятся числа N (2 < N < 10001) – количество стойл и K (1 < K < N) – количество коров.
// Во второй строке задаются N натуральных чисел в порядке возрастания – координаты стойл (координаты не превосходят 10^9)

// Формат вывода
// Выведите одно число – наибольшее возможное допустимое расстояние.

import java.util.Arrays;
import java.util.Scanner;

public class Cows {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        long[] coor = new long[n];
        for (int i = 0; i < n; i++) {
            coor[i] = input.nextLong();
        }
        System.out.println(solve(coor, k));
    }

    static boolean check(long x, long[] coords, int k) {
        int cows = 1;
        long last_cow = coords[0];
        for (long c : coords) {
            if (c - last_cow >= x) {
                cows++;
                last_cow = c;
            }
        }
        return cows >= k;
    }

    static long solve(long[] coords, int k) {
        Arrays.sort(coords);
        long l = 0;
        long r = coords[coords.length-1] - coords[0] + 1;
        while (r - l > 1) {
            long m = (l + r) / 2;
            if (check(m, coords, k))
                l = m;
            else
                r = m;
        }
        return l;
    }
}
