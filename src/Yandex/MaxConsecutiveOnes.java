package Yandex;

public class MaxConsecutiveOnes {
    public static int findMaxOnesSubinterval(int[] arr) {
        int maxCount = 0;
        int currentCount = 0;
        int previousCount = 0;
        boolean hasDeletedElement = false;

        for (int num : arr) {
            if (num == 1) {
                currentCount++;
                if (hasDeletedElement) {
                    previousCount = currentCount;
                    currentCount = 0;
                    hasDeletedElement = false;
                }
            } else {
                hasDeletedElement = true;
                maxCount = Math.max(maxCount, previousCount + currentCount + 1);
                previousCount = currentCount;
                currentCount = 0;
            }
        }

        maxCount = Math.max(maxCount, previousCount + currentCount + (hasDeletedElement ? 1 : 0));

        return maxCount;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 1, 0, 1, 1, 1};
        int result = findMaxOnesSubinterval(arr);
        System.out.println("Максимальный подинтервал единиц после удаления одного элемента: " + result);
    }
}