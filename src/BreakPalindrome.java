
// Палиндромом называется строка, которая читается одинаково слева-направо и справа-налево.
// В заданной строке-палиндроме необходимо заменить один символ, чтобы она перестала быть палиндромом.
// При этом полученная строка должна быть лексикографически минимальной.
// Строка A лексикографически меньше строки B (той же длины),
// если на первой различающейся позиции в строке A стоит меньший символ, чем в B.
// Например, строка adbc меньше строки adca, т.к. первые два символа в строках совпадают,
// а на третьем месте в строке adbc стоит символ b, который меньше символа c, стоящего на третьей позиции в строке adca.

//Формат ввода
//Вводится строка-палиндром, состоящая из маленьких букв латинского алфавита. Длина строки не превосходит 1000.

//Формат вывода
//Выведите лексикографически минимальную строку, не являющуюся палиндромом, полученную из исходной строки заменой одного символа.
//Если получить такую строку невозможно - выведите пустую строку.

import java.util.Scanner;

public class BreakPalindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String string = input.nextLine();
        Character[] letter = new Character[]{'a', 'b'};
        if (string.length() == 1) {
            System.out.println();
            return;
        }
        boolean flag = false;
        for (int i = 0; i < string.length() / 2; ++i) {
            if (string.charAt(i) != letter[0]) {
                string = string.substring(0, i) + letter[0] + string.substring(i + 1);
                flag = true;
                break;
            }
        }
        if (!flag) {
            string = string.substring(0, string.length() - 1) + letter[1];
        }
        System.out.println(string);
        input.close();
    }
}
