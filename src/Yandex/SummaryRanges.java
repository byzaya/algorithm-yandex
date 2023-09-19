package Yandex;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 7, 8, 10, 11};
        List<String> ans = new ArrayList<>();
        int s = nums[0];
        int e;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > 1) {
                e = nums[i - 1];
                if (s == e) {
                    ans.add(String.valueOf(s));
                } else {
                    ans.add(s + "->" + e);
                }
                s = nums[i];
            }
        }

        // Добавляем последний элемент или диапазон, если он существует
        if (s == nums[nums.length - 1]) {
            ans.add(String.valueOf(s));
        } else {
            ans.add(s + "->" + nums[nums.length - 1]);
        }
    }
}
