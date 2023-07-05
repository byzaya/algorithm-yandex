package thirdWeek;

// Богдан учится в Хогвартсе на факультете зельеварения.
// Завтра ему сдавать свой выпускной проект, но он ничего не успел подготовить.
// У него есть n ингредиентов, из которых можно сварить зелья.
// Зелье может состоять либо из одного ингредиента, либо из двух различных.
// Каждое зелье характеризуется его полезностью. Полезность — это целое число от −10^6 до 10^6.
// Богдану нужно сварить k зелий так, чтобы их суммарная полезность была максимальной
// (полезность зелья — это сумма полезностей ингредиентов, из которых оно состоит).
// Очень важно, чтобы все зелья в проекте были различны.
// Два зелья считаются различными, если найдется хотя бы один ингредиент, который отсутствует в одном зелье, но присутствует в другом.
// Помогите Богдану с проектом и подсчитайте максимальную суммарную полезность зелий, которую он может получить.

// Формат ввода
// В первой строке записано два числа n k - количество ингредиентов и количество зелий, которые нужно приготовить.
// В следующей строке заданы n целых чисел — полезность ингредиентов.

// Формат вывода
// Выведите одно целое число — максимальную суммарную полезность зелий.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Hogwarts {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        Integer[] ingr = new Integer[n];
        for (int i = 0; i < n; i++) {
            ingr[i] = input.nextInt();
        }

        Arrays.sort(ingr, Collections.reverseOrder()); // сортировка по убыванию

        ArrayList<Integer> solutions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (ingr[mid] + ingr[i] >= ingr[i + 1]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            for (int j = left; j < n; j++) {
                if (i == j) {
                    solutions.add(ingr[i]);
                } else {
                    solutions.add(ingr[i] + ingr[j]);
                }
            }
        }
        solutions.addAll(Arrays.asList(ingr).subList(0, n));
        solutions.sort(Collections.reverseOrder());
        long solution = 0;
        for (int i = 0; i < k; i++) {
            solution += solutions.get(i);
        }
        System.out.println(solution);
    }
}


// решение на python

// INF = int(1e18)
//MAX_ELEM = int(1e9)
//
//
//def check(minUs):
//    ans = 0
//    cnt = 0
//    for i in range(1, n + 1):
//        if usefullness[i] < minUs:
//            break
//        cnt += 1
//        ans += usefullness[i]
//    j = 2
//    while j <= n and usefullness[1] + usefullness[j] >= minUs:
//        j += 1
//
//    for i in range(1, n + 1):
//        if i + 1 >= j:
//            break
//        while j - 1 > i and usefullness[i] + usefullness[j - 1] < minUs:
//            j -= 1
//        cnt += (j - i - 1)
//        ans += prefSum[j - 1] - prefSum[i] + usefullness[i] * (j - i - 1)
//    if cnt >= k:
//        return ans - (cnt - k) * minUs
//    else:
//        return INF
//
//
//n, k = map(int, input().split())
//usefullness = list(map(int, input().split()))
//usefullness.sort()
//usefullness.append(0)
//usefullness.reverse()
//prefSum = [0] * (n + 1)
//for i in range(1, n + 1):
//    prefSum[i] = prefSum[i - 1] + usefullness[i]
//l = -MAX_ELEM
//r = MAX_ELEM
//while r > l:
//    m = (l + r + 1) // 2
//    if check(m) != INF:
//        l = m
//    else:
//        r = m - 1
//
//print(check(l))