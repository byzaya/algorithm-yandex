package fivthWeek;

// Вася и Петя играют в игру «Быки и коровы». Вася загадал число состоящее из N цифр, а Петя пытается его отгадать.
// Петя называет число из N цифр, а Вася отвечает, сколько в нем «быков» и «коров».
// Количество «быков» вычисляется как количество цифр, стоящих на своем месте.
// Количество «коров» вычисляется как количество цифр, которые есть и загаданном Васей числе и в названном Петей, но стоят на разных местах.
// То есть эти цифры могут быть переставлены таким образом, чтобы стать «Быками».
// По загаданному Васей и названному Петей числам определите количество «быков» и «коров».

// Формат ввода
// Загаданное Васей и Петей числа положительные и вводятся по одному в строке.
// Количество цифр в числах не превосходит 1000. Числа не имеют ведущих нулей.

// Формат вывода
// В первой строке выведите количество «быков», а во второй — «коров».

import java.util.Scanner;

public class CowsAndBulls {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String vasyaNumber = scanner.nextLine();
        String petyaNumber = scanner.nextLine();

        int bulls = 0;
        int cows = 0;
        int[] vasyaDigitsCount = new int[10]; // массив для подсчитывания количества каждой цифры в числе,
                                              // которая стоит не на своем месте

        // высчитываем количество быков
        for (int i = 0; i < vasyaNumber.length(); i++) {
            char vasyaDigit = vasyaNumber.charAt(i);
            char petyaDigit = petyaNumber.charAt(i);

            if (vasyaDigit == petyaDigit) {
                bulls++;
            } else {
                vasyaDigitsCount[vasyaDigit - '0']++; // добавляем ++ к счетчику цифры
            }
        }

        // высчитываем количество коров
        for (int i = 0; i < petyaNumber.length(); i++) {
            char vasyaDigit = vasyaNumber.charAt(i);
            char petyaDigit = petyaNumber.charAt(i);

            // если цифра не равна цифре в изначальном числе и количество этих цифр > 0
            if (vasyaDigit != petyaDigit && vasyaDigitsCount[petyaDigit - '0'] > 0) {
                cows++;
                vasyaDigitsCount[petyaDigit - '0']--; // вычитаем из счетчика цифру, чтобы потом ее не учитывать
            }
        }
        System.out.println(bulls);
        System.out.println(cows);
    }
}
