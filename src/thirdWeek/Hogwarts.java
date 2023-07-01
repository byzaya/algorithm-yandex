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

//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int n = input.nextInt();
//        int k = input.nextInt();
//        Integer[] ingr = new Integer[n];
//        for (int i = 0; i < n; i++) {
//            ingr[i] = input.nextInt();
//        }
//
//        Arrays.sort(ingr, Collections.reverseOrder()); // сортировка по убыванию
//
//        ArrayList<Integer> solutions = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            for (int j = i; j < n; j++) {
//                if (i == j) {
//                    solutions.add(ingr[i]);
//                } else {
//                    solutions.add(ingr[i] + ingr[j]);
//                }
//            }
//        }
//        solutions.sort(Collections.reverseOrder());
//        long solution = 0;
//        for (int i = 0; i < k; i++) {
//            solution += solutions.get(i);
//        }
//        System.out.println(solution);
//    }