package Yandex;

import java.util.HashSet;
import java.util.Set;

public class LineReflection {
    public static boolean isReflected(int[][] points) {
        int minX = Integer.MAX_VALUE; // минимальное x
        int maxX = Integer.MIN_VALUE; // максимальное х
        Set<String> seen = new HashSet<>(); // сет из уже просмотренных

        for (int[] p : points) { // проходимся по массиву точек, чтобы найти минимальный и максимальный х в массиве точек
            int x = p[0];
            int y = p[1];
            minX = Math.min(minX, x);
            maxX = Math.max(maxX, x);
            seen.add(x + "," + y); // добавляем в просмотренные эти точки, разделяя запятой
        }

        int sum = minX + maxX; // сумма минимального и максимального х - это ось симметрии

        for (int[] p : points) // проходимся по массиву точек
            if (!seen.contains(sum - p[0] + "," + p[1])) // проверка на существование отраженной относительно оси симметрии точки
                                                         // если хотя бы одна не отражена, то false
                return false;
        return true;
    }

    public static void main(String[] args) {
        int[][] p = new int[][]{{1,1}, {-1, -1}};
        System.out.println(isReflected(p));
    }
}
