package contest_intern_day_2023;

// Вася решил обработать логи с сервера, но обнаружил,
// что из-за ошибки разработчиков для каждого события в логе записывается только время этого события в формате HH:MM:SS,
// а дата не записывается.
// Известно, что все события записаны в хронологическом порядке и два события не могли произойти в одну и ту же секунду.
// Определите минимальное количество дней, в течение которых записывался лог.

// Формат ввода
// Первая строка входных данных содержит единственное число n (1≤n≤100000) — количество событий в логе.
// Следующие n строк описывают времена событий. Каждая строка имеет формат HH:MM:SS,
// где HH — число от 0 до 23, а MM и SS — числа от 0 до 59. Все записи чисел состоят ровно из двух цифр.

// Формат вывода
// Выведите одно целое число — минимальное количество дней, в течение которых записывался лог.

import java.util.Scanner;

public class Logs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String prevTime = scanner.nextLine();
        int days = 0;

        for (int i = 1; i < n; i++) {
            String currentTime = scanner.nextLine();
            if (currentTime.compareTo(prevTime) <= 0) {
                days++;
            }
            prevTime = currentTime;
        }
        System.out.println(days + 1);
    }
}
