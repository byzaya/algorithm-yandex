package Yandex;

public class FindMinDistanceXY {
    public static int findMinDistance(String input) {
        int xIndex = -1; // Индекс символа 'X' в строке
        int yIndex = -1; // Индекс символа 'Y' в строке
        int minDistance = Integer.MAX_VALUE; // Начальное значение минимального расстояния

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (currentChar == 'X') {
                xIndex = i; // Найден символ 'X', запомним его индекс
            } else if (currentChar == 'Y') {
                yIndex = i; // Найден символ 'Y', запомним его индекс
            }

            // Если оба символа 'X' и 'Y' найдены, вычислим расстояние между ними
            if (xIndex != -1 && yIndex != -1) {
                int distance = Math.abs(xIndex - yIndex);
                if (distance < minDistance) {
                    minDistance = distance;
                }
            }
        }

        // Если символы 'X' и 'Y' не найдены, вернем -1, чтобы обозначить отсутствие пары
        if (minDistance == Integer.MAX_VALUE) {
            return -1;
        }

        return minDistance;
    }

    public static void main(String[] args) {
        String input = "XOXOY";
        int minDistance = findMinDistance(input);

        if (minDistance == -1) {
            System.out.println("Символы 'X' и 'Y' не найдены в строке.");
        } else {
            System.out.println("Минимальное расстояние между 'X' и 'Y' равно: " + minDistance);
        }
    }
}
