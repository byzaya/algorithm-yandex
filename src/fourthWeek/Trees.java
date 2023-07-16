package fourthWeek;

// Дано неориентированное дерево, подвешенное за вершину 1.
// Для каждой вершины подсчитайте, сколько вершин содержится в поддереве, подвешенном за данную вершину.

// Формат ввода
// В первой строке вводится число V — количество вершин (3 ≤ V ≤ 100000)
// В следующих V-1 строках записано по два числа: номера соединенных ребром вершин

// Формат вывода
// Выведите V чисел — размеры поддеревьев для каждой из вершин

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Trees {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // количество вершин
        List<List<Integer>> inputList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            inputList.add(new ArrayList<>()); // так как нумерация с 1
        }
        for (int i = 0; i < n - 1; i++) { // тут запись элементов в лист, айди это номер вершины,
                                          // по айди можно определить, в какие вершины ведет эта вершина
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            inputList.get(a).add(b);
            inputList.get(b).add(a);
        }

        int[] subtreeSize = new int[n + 1]; // массив размеров узлов (так как нумерация с 1)
        Arrays.fill(subtreeSize, -1); // -1 указывает, что узел не был посещен
                                          // (чтобы избежать посещения уже посещенных узлов)
        solution(1, inputList, subtreeSize); // 1, так как по условию подвешенное за вершину 1
        for (int i = 1; i <= n; i++) {
            System.out.print(subtreeSize[i] + " ");
        }
    }

    public static int solution(int node, List<List<Integer>> inputList, int[] subtreeSize) {
        subtreeSize[node] = 1;
        for (int i : inputList.get(node)) {
            if (subtreeSize[i] == -1) {
                subtreeSize[node] += solution(i, inputList, subtreeSize);
            }
        }
        return subtreeSize[node];
    }
}