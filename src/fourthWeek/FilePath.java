package fourthWeek;

// В операционной системе Xunil информация обо всех файлах и директориях хранится в специальном файле в следующем формате:
// emoh
//  vonavi
//   a.doc
//   b.doc
//  vortep
//   .bashrc
//  vorodis
//   onrop
//    1.avi
//    2.avi
// rav
//  bil
// Имена файлов, и только они, содержат точку.
// Требуется по данному имени файла найти путь к нему. Если таких файлов несколько, вывести путь к файлу, который записан выше.

// Формат ввода
// В первой строке вводится имя искомого файла. Во второй строке вводится общее количество файлов и директорий.
// В остальных строках вводится информация о файлах и директориях в указанном выше формате
// (директория или файл, находящиеся внутри другой директории, отделяются одним дополнительным пробелом в начале строки).
// Количество строк в файле и количество символов в каждой строке не превосходит 100.

// Формат вывода
// Выведите путь к файлу в формате /директория/директория/…/файл
// Гарантируется, что такой файл есть.
// Гарантируется, что длина строки ответа не превосходит 255.

import java.util.*;

public class FilePath {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fn = scanner.nextLine(); // имя искомого файла
        int n = Integer.parseInt(scanner.nextLine()); // общее количество файлов и директорий
        List<String> filesAndFolders = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            filesAndFolders.add(scanner.nextLine()); // инфо о файлах и директориях
        }
        Map<String, String> paths = getFilePaths(filesAndFolders); //получаем искомый путь
        System.out.println(paths.get(fn));
    }

    public static Map<String, String> getFilePaths(List<String> nodes) {
        List<String> path = new ArrayList<>();
        Map<String, String> fullPaths = new HashMap<>();

        for (String node : nodes) {
            String curr = node.trim();
            int s = node.length() - node.trim().length();
            path = path.subList(0, s);
            path.add(curr);
            if (!fullPaths.containsKey(curr)) {
                fullPaths.put(curr, "/" + String.join("/", path));
            }
        }
        return fullPaths;
    }
}