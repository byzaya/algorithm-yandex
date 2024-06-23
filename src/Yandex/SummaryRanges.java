package Yandex;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        // проверка на пустой массив
        if (nums == null || nums.length == 0) {
            return result;
        }

        int start = nums[0]; // начало текущего диапазона
        int end = nums[0];   // конец текущего диапазона

        // начинаем со 2 элемента
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == end + 1) {
                // Текущий элемент продолжает текущий диапазон
                end = nums[i];
            } else {
                // Текущий элемент не является частью текущего диапазона, завершить текущий диапазон
                if (start == end) {
                    result.add(String.valueOf(start));
                } else {
                    result.add(start + "->" + end);
                }

                // Начать новый диапазон
                start = nums[i];
                end = nums[i];
            }
        }

        // Добавить последний диапазон
        if (start == end) {
            result.add(String.valueOf(start));
        } else {
            result.add(start + "->" + end);
        }
        return result;
    }
}
