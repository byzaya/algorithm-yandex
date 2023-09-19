package training;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Дан массив a из n целых чисел. Напишите программу, которая найдет число, которое встречается в массиве наибольшее число раз.
public class contest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        // Создаем словарь для подсчета встречаемости чисел
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Проходим по массиву и увеличиваем счетчик для каждого числа
        for (int num : a) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int maxFrequency = 0;
        int mostFrequentNumber = Integer.MIN_VALUE;

        // Находим число с максимальной встречаемостью
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int num = entry.getKey();
            int frequency = entry.getValue();

            if (frequency >= maxFrequency && num >= mostFrequentNumber) {
                maxFrequency = frequency;
                mostFrequentNumber = num;
            }
        }

        System.out.println(mostFrequentNumber);
    }
}
