package firstWeek;
// Каждые сутки на вокзал прибывает n электричек.
// По заданному расписанию прибытия электричек определите минимальное время между прибытием двух разных электричек.

//Формат ввода
//В первой строке задано число n (1 ≤ n ≤ 2 × 104) — количество электричек.
//Во второй строке задано n моментов времени в формате HH:MM (0 ≤ HH ≤ 23, 0 ≤ MM ≤ 59) через пробел.

//Формат вывода
//Выведите одно число — минимальное время в минутах между прибытием двух электричек.

import java.util.*;

public class DifferenceInTime {
    static final int MAX_MINUTES = 1440;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int numberTrain = Integer.parseInt(line);
        String lineTrains = scanner.nextLine();
        String[] stringTimeTrains = lineTrains.split(" ");
        List<Integer> timeTrains = new ArrayList<>();
        for (String time : stringTimeTrains) {
            String[] temp = time.split(":");
            timeTrains.add(Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]));
        }

        // если электричка всего одна
        if (timeTrains.size() == 1) {
            System.out.println(0);
        } else {
            timeTrains.sort(Comparator.naturalOrder());
            int min = Math.min((timeTrains.get(1) - timeTrains.get(0)),
                    Math.abs(MAX_MINUTES - (timeTrains.get(1) - timeTrains.get(0))));
            for (int i = 1; i < timeTrains.size(); i++) {
                int diff = timeTrains.get(i) - timeTrains.get(i - 1);
                if (diff < min) {
                    min = diff;
                } else if (Math.abs(MAX_MINUTES - diff) < min) {
                    min = Math.abs(MAX_MINUTES - diff);
                }
            }
            int tempDiff = Math.min((timeTrains.get(timeTrains.size() - 1) - timeTrains.get(0)), Math.abs(MAX_MINUTES -
                    (timeTrains.get(timeTrains.size() - 1) - timeTrains.get(0))));
            if (tempDiff < min) {
                min = tempDiff;
            }
            System.out.println(min);
        }
        scanner.close();
    }
}
