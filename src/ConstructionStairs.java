
// Вася занимается строительством лесенок из блоков.
// Лесенка состоит из ступенек, при этом i-ая ступенька должна состоять ровно из i блоков.
// По заданному числу блоков n определите максимальное количество ступенек в лесенке,
// которую можно построить из этих блоков.

import java.util.Scanner;

public class ConstructionStairs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // кол-во блоков для построения лестницы

        // лестница начинается с 1 блока
        // каждая следующая ступень должна быть на 1 больше предыдущего

        int countOfUsingBlocks = 1;
        int countOfStairs = 1;
        if(n == 0){
            System.out.println(0);
        }
        while(countOfUsingBlocks < n){
            if (n - countOfUsingBlocks < countOfStairs + 1) {
                break;
            }
            countOfStairs++;
            countOfUsingBlocks = countOfUsingBlocks + countOfStairs;
        }
        System.out.println(countOfStairs);
    }
}
