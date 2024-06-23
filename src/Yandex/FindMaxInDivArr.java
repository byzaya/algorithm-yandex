package Yandex;

public class FindMaxInDivArr {
    public static int findMaxElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left - 1];
    }

    public static void main(String[] args) {
        int[] rotatedArray = {4, 5, 6, 7, 8, 0, 1, 2};
        int maxElement = findMaxElement(rotatedArray);
        System.out.println("Максимальный элемент в циклически сдвинутом массиве: " + maxElement);
    }
}
