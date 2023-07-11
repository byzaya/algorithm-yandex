package fourWeek;

// Вася переехал из своего родного города и очень скучает по старым друзьям.
// К сожалению, Вася снимает маленькую квартиру и одновременно в гости к нему может приехать только один друг.
// Каждый друг сказал Васе два числа A и B — с какого по какой день он может приехать в гости.
// Каждый друг приезжает и уезжает в полдень. Каждый друг может приехать к Васе только один раз и остаться у него на несколько дней.
// Вася хотел бы, чтобы суммарное количество дней, когда у него в гостях есть кто-нибудь из друзей, было максимальным.
// Помогите ему определить даты приезда для каждого из друзей так, чтобы они не пересекались
// (допустима ситуация, что в один день один из друзей приезжает, а другой — уезжает) и суммарное время,
// когда у Васи в гостях есть кто-то из друзей, было максимальным.

// Формат ввода
// В первой строке записаны целое число N (1 ≤ N ≤ 100000) - количество друзей Васи.
// В следующих N строках записано по два целых числа Ai и Bi (оба числа от 1 до 10^9) — возможное время приезда i-го друга.

// Формат вывода
// Выведите N пар чисел Li и Ri - номера дней, в которые приедет и уедет i-й друг соответственно (Ai ≤ Li ≤ Ri ≤ Bi).
// Если i-го друга приглашать не нужно, выведите пару чисел -1 -1. Если правильных ответов несколько - выведите любой из них.

import java.util.*;

public class Guests {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] intervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            intervals[i][0] = scanner.nextInt();
            intervals[i][1] = scanner.nextInt();
        }
        int[][] intervalsCopy = intervals.clone();
        // Сортируем интервалы по возрастанию левой границы (заезда гостей)
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int[] lastInterval = new int[]{-1, -1};
        int[][] result = new int[n][2];
        int resultSize = 0;
        for (int[] interval : intervals) {
            // Если текущий интервал начинается после окончания последнего интервала, то выбираем его
            if (interval[0] > lastInterval[1]) {
                result[resultSize++] = interval;
                lastInterval = interval;
            }
            // Иначе, если текущий интервал пересекается с последним интервалом, то выбираем тот, который заканчивается раньше
            else if (interval[1] <= lastInterval[1]) {
            } else {
                interval[0] = lastInterval[1] + 1;
                result[resultSize++] = interval;
                lastInterval = interval;
            }
        }

        Set<int[]> resultSet = new HashSet<>(Arrays.asList(result));
        for (int[] interval : intervalsCopy) {
            if (resultSet.contains(interval)) {
                System.out.println(interval[0] + " " + interval[1]);
            } else {
                System.out.println("-1 -1");
            }
            resultSet.remove(interval);
        }
    }
}

// решение на python

// n = int(input())
//intervals = []
//for i in range(n):
//    intervals.append(list(map(int, input().split())))
//
//intervalsCopy = intervals.copy()
//intervals.sort(key=lambda x: x[0])
//
//lastInterval = [-1, -1]
//result = []
//resultSize = 0
//for interval in intervals:
//    if interval[0] > lastInterval[1]:
//        result.append(interval)
//        lastInterval = interval
//    elif interval[1] <= lastInterval[1]:
//        pass
//    else:
//        interval[0] = lastInterval[1] + 1
//        result.append(interval)
//        lastInterval = interval
//
//resultSet = set(map(tuple, result))
//for interval in intervalsCopy:
//    if tuple(interval) in resultSet:
//        print(interval[0], interval[1])
//    else:
//        print("-1 -1")
//    resultSet.discard(tuple(interval))