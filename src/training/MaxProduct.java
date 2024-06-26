package training;

public class MaxProduct {
    // Функция для нахождения максимального произведения двух целых чисел в массиве
    public static void findMaximumProduct(int[] A)
    {
        // для хранения максимального и второго максимального элемента в массиве
        int max1 = A[0], max2 = Integer.MIN_VALUE;

        // для хранения минимального и второго минимального элемента в массиве
        int min1 = A[0], min2 = Integer.MAX_VALUE;

        for (int i = 1; i < A.length; i++)
        {
            // если текущий элемент больше максимального элемента,
            // обновить максимальный и второй максимальный элемент
            if (A[i] > max1)
            {
                max2 = max1;
                max1 = A[i];
            }

            // если текущий элемент меньше максимального, но больше заданного
            // второй максимальный элемент, обновить второй максимальный элемент
            else if (A[i] > max2) {
                max2 = A[i];
            }

            // если текущий элемент меньше минимального элемента,
            // обновляем минимум и второй минимум
            if (A[i] < min1)
            {
                min2 = min1;
                min1 = A[i];
            }

            // если текущий элемент больше минимального, но меньше заданного
            // второй минимальный элемент, обновить второй минимальный элемент
            else if (A[i] < min2) {
                min2 = A[i];
            }

            // иначе игнорируем элемент
        }

        // выбираем максимум из следующего:
        // 1. Произведение максимального элемента на второй максимальный или
        // 2. Произведение минимального и второго минимального элемента

        if (max1 * max2 > min1 * min2) {
            System.out.print("Pair is (" + max1 + ", " + max2 + ")");
        }
        else {
            System.out.print("Pair is (" + min1 + ", " + min2 + ")");
        }
    }

    public static void main (String[] args)
    {
        int[] arr = { -10, -3, 5, 6, -2 };

        findMaximumProduct(arr);
    }
}
