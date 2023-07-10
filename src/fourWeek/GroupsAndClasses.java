package fourWeek;

// В университете есть n аудиторий и m учебных групп.
// Для каждой аудитории задана её вместимость, а для каждой группы — численность.
// Группа может заниматься в аудитории только если её численность не превосходит размера аудитории.
// Определите максимальное количество групп, которые можно рассадить по аудиториям.

// Формат ввода
// В первой строке вводится число n (1 ≤ n ≤ 100000).
// Во второй строке вводится n чисел — численность групп. Численность не превосходит 100000.
// В третьей строке вводится число m (1 ≤ m ≤ 100000).
// В четвертой строке вводится m чисел — вместимость аудиторий. Вместимость не превосходит 100000.

// Формат вывода
// Выведите ответ на задачу.

import java.util.Arrays;
import java.util.Scanner;

public class GroupsAndClasses {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] groups = new int[n];
        for (int i = 0; i < n; i++) {
            groups[i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] classes = new int[m];
        for (int i = 0; i < m; i++) {
            classes[i] = in.nextInt();
        }

        Arrays.sort(groups);
        Arrays.sort(classes);
        int maxCount = 0;
        int right = 0;
        for (int g : groups) {
            if (right >= classes.length) {
                break;
            }
            for (int i = right; i < classes.length; i++) {
                int room = classes[i];
                if (g <= room) {
                    maxCount++;
                    right = i + 1;
                    break;
                }
            }
        }

        System.out.println(maxCount);
    }
}
