package Yandex;

import java.util.HashSet;

public class CountNonRepeat {

    public static int countDistinctSubstrings(String s) {
        int n = s.length();
        int left = 0;
        int right = 0;
        int count = 0;
        HashSet<Character> set = new HashSet<>();

        while (right < n) {
            char charAtRight = s.charAt(right);
            while (set.contains(charAtRight)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(charAtRight);
            count += (right - left + 1);
            right++;
        }

        return count;
    }

    public static void main(String[] args) {
        String input = "abcacbabc";
        int result = countDistinctSubstrings(input);
        System.out.println("Количество пар без повторяющихся символов: " + result);
    }
}
