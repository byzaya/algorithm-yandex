package fivthWeek;

// Недавно Глеб катался в горах. Как известно, горный хребет - такой набор гор с высотами h1…hn,
// что в нем больше 3 гор и существует такая основная гора с индексом i, что 1 < i < n и h1 < h2 < ⋯ < hi > hi + 1 > ⋯ > hn.
// Глеб помнит высоты всех гор, более того он даже помнит, что это был горный хребет, вам требуется вывести индекс любой основной горы.

// Формат ввода
// В первой строчке дается одно число n - количество гор. Затем в следующей строчке дается n чисел:
// высоты гор hi.
// 3 ≤ n ≤ 10^4, 1 ≤ hi ≤ 10^9.

// Формат вывода
// Вам требуется вывести одно число - индекс любой основной горы.

import java.util.Scanner;

public class Mountains {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] mounts = new int[n];
        int max = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            mounts[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if (mounts[i] > max ) {
                max = mounts[i];
                index = i;
            }
            if (mounts[i] > mounts[i + 1]) {
                break;
            }
        }
        System.out.println(index + 1);
    }
}

// решение на python
// n = int(input())
// mounts = list(map(int, input().split()))
// max = 0
// index = 0
// for i in range(n):
//     if mounts[i] > max:
//         max = mounts[i]
//         index = i
//     if i < n - 1 and mounts[i] > mounts[i + 1]:
//         break
//
// print(index + 1)