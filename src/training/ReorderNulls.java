package training;

import java.util.Arrays;

public class ReorderNulls {
    public static void reorder(int[] A)
    {
        // `k` сохраняет индекс следующей доступной позиции
        int k = 0;
        // делаем для каждого элемента
        for (int i: A)
        {
            // если текущий элемент отличен от нуля, поместить элемент в
            // следующая свободная позиция в массиве
            if (i != 0) {
                A[k] = i;
                k++;
            }
        }

        // перемещаем все 0 в конец массива (оставшиеся индексы)
        for (int i = k; i < A.length; i++) {
            A[i] = 0;
        }
    }

    public static void main(String[] args)
    {
        int[] A = { 6, 0, 8, 2, 3, 0, 4, 0, 1 };

        reorder(A);
        System.out.println(Arrays.toString(A));
    }
}
