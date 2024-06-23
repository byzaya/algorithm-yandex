package Yandex;

public class MaxSubarray {
    public static int[] findMaxSubarray(int[] arr) {
        int maxStart = 0;
        int maxLength = 1;
        int currentStart = 0;
        int currentLength = 1;
        boolean isIncreasing = true;

        for (int i = 1; i < arr.length; i++) {
            if ((arr[i] > arr[i - 1] && isIncreasing) || (arr[i] < arr[i - 1] && !isIncreasing)) {
                currentLength++;
            } else {
                currentStart = i;
                currentLength = 1;
                isIncreasing = !isIncreasing;
            }

            if (currentLength > maxLength) {
                maxLength = currentLength;
                maxStart = currentStart;
            }
        }

        int[] result = {maxStart, maxStart + maxLength - 1};
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 1, 4, 3, 2, 1, 2, 3};
        int[] result = findMaxSubarray(arr);
        System.out.println("Индексы максимального подотрезка: [" + result[0] + ", " + result[1] + "]");
    }
}