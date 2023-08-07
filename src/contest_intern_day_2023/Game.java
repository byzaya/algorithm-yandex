package contest_intern_day_2023;

// Вася придумал игру для умного телевизора: можно сколько угодно раз выбрать две произвольные буквы латинского алфавита
// и заменить в строке все вхождения первой буквы на вторую, а второй — на первую.
// Так при выборе буквы a и b строка abc превратится в bac. Если выбрать буквы a и x, то строка abc превратится в строку xbc.
// Цель игры состоит в том, чтобы получить из строки s1 строку s2.
// К сожалению, Вася умеет только генерировать гениальные идеи, но не программировать.
// Он придумал много пар строк s1 и s2. Для каждой пары определите, возможно ли получить из строки s1 строку s2 по правилам игры.

// Формат ввода
// В первой строке задано число t (1 ≤ t ≤ 100) — количество пар строк, придуманных Васей.
// В следующих 2t строках вводятся t пар слов равной длины, разделенных переводом строки и состоящих из строчных латинских букв — s1 и s2 соответственно.
// Гарантируется, что суммарная длина всех слов не превосходит 105 символов.

// Формат вывода
// Для каждой пары слов выведите YES, если из s1 можно получить s2 по правилам игры и NO в противном случае.

import java.util.HashMap;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int counter = scanner.nextInt();
        for (int i = 0; i < counter; i++) {
            String s1 = scanner.next();
            String s2 = scanner.next();
            System.out.println(checkPair(s1, s2));
        }
    }

    public static String checkPair(String s1, String s2) {
        HashMap<Character, Character> mapping1 = new HashMap<>();
        HashMap<Character, Character> mapping2 = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            if ((mapping1.containsKey(s1.charAt(i)) && mapping1.get(s1.charAt(i)) != s2.charAt(i)) || (mapping2.containsKey(s2.charAt(i)) && mapping2.get(s2.charAt(i)) != s1.charAt(i))){
                return "NO";
            } else {
                mapping1.put(s1.charAt(i), s2.charAt(i));
                mapping2.put(s2.charAt(i), s1.charAt(i));
            }
        }
        return "YES";
    }
}
