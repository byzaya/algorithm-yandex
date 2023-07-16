package fourthWeek;

// Имеется стол длины L. На столе разложено N носков так, что никакой носок не вылезает за границы стола.
// Далее имеется умный мальчик Васька, который хочет замерить толщину покрытия стола носками в M точках.

// Формат ввода
// Во входном файле даны сначала L, N, M (1 ≤ L ≤ 10000, 1 ≤ N ≤ 10000, 1 ≤ M ≤ 100000).
// Далее идут N пар чисел l ≤ r от 1 до L – левые и правые концы носков.
// Затем идут M чисел от 1 до L интересующие Васька точки.
// Все числа целые.

// Формат вывода
// Выведите M чисел – толщину носкового покрытия в каждой точке.

//import java.util.*;
//
//public class Socks {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int L = in.nextInt(); // длина стола
//        int N = in.nextInt(); // количество носков
//        int M = in.nextInt(); // количество проверок
//        int[] socksBegin = new int[N];
//        int[] socksEnd = new int[N];
//        for (int i = 0; i < N; i++) {
//            socksBegin[i] = in.nextInt();
//            socksEnd[i] = in.nextInt();
//        }
//        int[] points = new int[M];
//        for (int i = 0; i < M; i++) {
//            points[i] = in.nextInt();
//        }
//
//        List<Map.Entry<Integer, Integer>> events = new ArrayList<>(2 * N + M);
//        for (int i = 0; i < N; i++) {
//            events.add(new AbstractMap.SimpleEntry<>(socksBegin[i], -1)); // начало носка
//            events.add(new AbstractMap.SimpleEntry<>(socksEnd[i], 1)); // конец носка
//        }
//        for (int i = 0; i < M; i++) {
//            events.add(new AbstractMap.SimpleEntry<>(points[i], 0)); // проверка Васи
//        }
//        events.sort(Map.Entry.comparingByKey());
//        List<Map.Entry<Integer, Integer>> solution = new ArrayList<>(M);
//
//        int width = 0;
//        for (int i = 0; i < 2 * N + M; i++) {
//            if (events.get(i).getValue() == -1) {
//                width++;
//            } else if (events.get(i).getValue() == 1) {
//                width--;
//            } else {
//                solution.add(new AbstractMap.SimpleEntry<>(events.get(i).getKey(), width));
//            }
//        }
//
//        for (int i = 0; i < M; i++) {
//            for (int j = 0; j < M; j++) {
//                if (points[i] == solution.get(j).getKey()) {
//                    System.out.println(solution.get(j).getValue());
//                    break;
//                }
//            }
//        }
//    }
//}


import java.util.Scanner;

public class Socks {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int L = input.nextInt();
        int N = input.nextInt();
        int M = input.nextInt();
        int[] socks = new int[L + 2];

        for (int i = 0; i < N; i++) {
            int start = input.nextInt();
            int end = input.nextInt();
            socks[start] += 1; // добавляем к индексу, равному началу носка = + 1
            socks[end + 1] -= 1; // добавляем к индексу, равному концу носка +1 = - 1
        }
        // как итог получаем массив длины стола + 2 (так как 0 у нас не используется, а end + 1) => от 0 до L+1

        // точки, в которых проверяется толщина
        int[] points = new int[M];
        for (int i = 0; i < M; i++) {
            points[i] = input.nextInt();
        }

        for (int point : points) {
            int sum = 0;
            for (int i = 0; i <= point; i++) {
                sum += socks[i];
            }
            System.out.println(sum);
        }
    }
}

// решение на с++ (проходит по времени)

// #include <iostream>
//#include <vector>
//#include <algorithm>
//
//int main() {
//    int desk_len, socks_num, points_num;
//    std::cin >> desk_len >> socks_num >> points_num;
//
//    std::vector<int> socks_lst(desk_len + 2, 0);
//
//    for (int i = 0; i < socks_num; i++) {
//        int start, end;
//        std::cin >> start >> end;
//        socks_lst[start] += 1;
//        socks_lst[end + 1] -= 1;
//    }
//
//    std::vector<int> points_lst(points_num);
//    for (int i = 0; i < points_num; i++) {
//        std::cin >> points_lst[i];
//    }
//
//    for (int point : points_lst) {
//        int sum = 0;
//        for (int i = 0; i <= point; i++) {
//            sum += socks_lst[i];
//        }
//        std::cout << sum << std::endl;
//    }
//
//    return 0;
//}
