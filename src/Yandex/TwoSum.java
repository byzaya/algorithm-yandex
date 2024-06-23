package Yandex;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] findIndices(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();

        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            if (currentSum == target) {
                return new int[]{0, i};
            }

            int complement = currentSum - target;
            if (numToIndex.containsKey(complement)) {
                return new int[]{numToIndex.get(complement) + 1, i};
            }

            numToIndex.put(currentSum, i);
        }

        return new int[]{-1, -1}; // Если такой отрезок не существует, возвращаем {-1, -1}
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] indices = twoSum.findIndices(nums, target);

        if (indices[0] != -1) {
            System.out.println("Индексы отрезка: " + indices[0] + " и " + indices[1]);
        } else {
            System.out.println("Отрезок не найден.");
        }
    }
}
