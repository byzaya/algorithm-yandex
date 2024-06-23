package Yandex;

public class RemoveExtraSpaces {
    // удаление лишних пробелов в строке
    public static String removeExtraSpaces(String input) {
        if (input == null || input.isEmpty()) { // проверка на пустую строку
            return input;
        }

        StringBuilder result = new StringBuilder(); //сюда складывать итоговую строку
        boolean spaceFound = false; // проверка на найденный пробел

        for (int i = 0; i < input.length(); i++) { // проходимся по всей строке
            char c = input.charAt(i);
            if (c == ' ') { // если элемент равен пробелу
                if (!spaceFound) { // и при этом до этого не было найдено пробелов
                    result.append(c); // кладем пробел
                    spaceFound = true; // пробел найден => этот флаг дает нам то, что мы остальные пробелы после первого встреченного пробела пропускаем
                }
            } else {
                result.append(c); // это НЕ пробел, добавляем его в итоговую строку
                spaceFound = false; // флаг - false, так как это не пробел
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input = "abbb           adf    ";
        String output = removeExtraSpaces(input);
        System.out.println("\"" + input + "\" -> \"" + output + "\"");
    }
}
