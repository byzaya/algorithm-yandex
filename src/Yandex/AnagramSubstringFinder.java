package Yandex;

import java.util.Arrays;

public class AnagramSubstringFinder {
    public static int findAnagramSubstring(String T, String S) {
        int n = T.length();
        int m = S.length();

        char[] sortedS = S.toCharArray();
        Arrays.sort(sortedS); // Сортируем символы строки S

        for (int i = 0; i <= n - m; i++) {
            String substring = T.substring(i, i + m); // Берем подстроку T длиной m, начиная с текущего индекса

            char[] sortedSubstring = substring.toCharArray(); // Сортируем символы подстроки T
            Arrays.sort(sortedSubstring);

            if (Arrays.equals(sortedS, sortedSubstring)) { // Сравниваем отсортированные массивы символов
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String T = "reebok";
        String S = "bee";
        int index = findAnagramSubstring(T, S);
        System.out.println(index);
    }
}
