package thirdWeek;

// Площадка для выгула собак — место, где собираются и общаются люди разных возрастов.
// На одной из площадок Восточного Бирюлева хозяева собак очень дружны и приглашают друг-друга на день рождения.
// Человек x не приглашает на день рождения человека y если выполнено хотя бы одно из условий:
// - (Возраст человека y) <= 0.5 * (Возраст человека x) + 7
// - (Возраст человека y) > (Возраст человека x)
// - (Возраст человека y) > 100 и одновременно с этим (Возраст человека x) < 100
// Во всех остальных случаях человек x приглашает человека y на день рождения.
// Определите суммарное количество приглашений на день рождения.

// Формат ввода
// В первой строке вводится число n (1 ≤ n ≤ 100000).
// Во второй строке вводится n чисел — возраст людей. Возраст находится в промежутке от 1 до 120.

// Формат вывода
// Выведите одно число — суммарное количество приглашений.

import java.util.*;

public class BumerZumer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        List<Long> ageList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ageList.add(scanner.nextLong());
        }
        Collections.sort(ageList);
        long result = countInvites(ageList);
        System.out.println(result);
    }

    public static long countInvites(List<Long> ageList) {
        int l = 0;
        int r = 0;
        long count = 0;
        for (long age : ageList) {
            while (l < ageList.size() && ageList.get(l) <= 0.5 * age + 7) {
                l++;
            }
            while (r < ageList.size() && ageList.get(r) <= age) {
                r++;
            }
            if (r > l + 1) {
                count += r - l - 1;
            }
        }
        return count;
    }
}