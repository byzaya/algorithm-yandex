package secondWeek;

// Есть 10 вертикальных палочек, пронумерованных от 0 до 9 и n колец трёх цветов красного «R»,
// зеленого «G» и голубого «B», которые на надеты на палочки.
// Ваша задача по строке s, кодирующей, где находится каждое из колец определить количество палочек,
// на которое надеты кольца всех трёх цветов.
// Строка представляет из себя последовательность чётной длины, где на нечётных позициях (1,3,5 и т.д.) написан цвет кольца,
// а на чётных позициях (2,4,6 и т.д.) — номер палочки, на которую надето кольцо.
// Таким образом, кольцо номер i имеет цвет s(2i − 1) и находится на палочке номер s(2i).
// Например, строка «R2G1R1B2G2» кодирует 5 колец:
// Первое кольцо имеет красный цвет и находится на палочке 2;
// Второе кольцо имеет зеленый цвет и находится на палочке 1;
// Третье кольцо имеет красный цвет и находится на палочке 1;
// Четвертое кольцо имеет синий цвет и находится на палочке 2;
// Пятое кольцо имеет зеленый цвет и находится на палочке 2;

// Формат ввода
// Первая строка входных данных  — это непустая строка четной длины s(1≤|s|≤1000),
// состоящая из символов «R», «G» или «B» и цифр от 0 до 9.

//Формат вывода
//Выведите единственное целое число — количество палочек, на которых имеются кольца всех трёх цветов.

import java.util.Scanner;

public class MulticoloredSticks {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        String[] colors = new String[10];
        for (int i = 0; i < s.length() - 1; i = i + 2) {
            colors[Character.getNumericValue(s.charAt(i + 1))] += s.charAt(i);
        }
        int output = 0;
        for (int i = 0; i < 10; i++) {
            if(colors[i] != null) {
                if (colors[i].contains("R") && colors[i].contains("G") && colors[i].contains("B")) {
                    output++;
                }
            }
        }
        System.out.println(output);
    }
}
