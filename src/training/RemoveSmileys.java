package training;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveSmileys {
    public static String removeSmileysRegex(String input) {
        String regex = ":-\\)+|:-\\(+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.replaceAll("");
    }

    enum State {
        DEFAULT, // состояние с обычными символами (где нет подозрения на смайл)
        COLON, // состояние с :
        TIRE, // состояние с -
        OPEN, // состояние с (
        CLOSED; // состояние с )
    }

    private static String removeSmileys(String input) {
        StringBuilder b = new StringBuilder(); // тут будем конструировать строку
        State state = State.DEFAULT; // начальное положение
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i); // разбираем строку по символам
            switch (state) {
                case DEFAULT -> {
                    if (c == ':') { // тк смайл начинается с :
                        state = State.COLON; // переходим в состояние двоеточия
                    } else {
                        b.append(c);
                    }
                }
                case COLON -> {
                    if (c == '-') {
                        state = State.TIRE; // тк смайл состоит из : и - и скобок, переходим в состояние скобок
                    } else {
                        b.append(':'); // если нет -, то это не смайл и добавляем : в итоговую строку
                        state = State.DEFAULT; // возвращаемся в начальное состояние, тк это оказался не смайл
                        --i;
                    }
                }
                case TIRE -> {
                    if (c == ')') {
                        state = State.CLOSED; // переходим в состояние закрытой скобки
                    } else if (c == '(') {
                        state = State.OPEN; // переходим в состояние открытой скобки
                    } else {
                        b.append(":-"); // если нет скобок, то это не смайл и добавляем :- в итоговую строку
                        --i;
                    }
                }
                case OPEN -> { // тут такая логика, что мы пропускаем все ) скобки у смайла, то есть удалится :-))))) смайл(с большим количеством ) )
                    if (c != '(') { // если это не открывающая скобка, то смайл закончился и мы возвращаемся в начальное состояние
                        state = State.DEFAULT;
                        --i;
                    }
                }
                case CLOSED -> { // тут такая логика, что мы пропускаем все ( скобки у смайла, то есть удалится :-))))) смайл(с большим количеством ) )
                    if (c != ')') { // если это не закрывающая скобка, то смайл закончился и мы возвращаемся в начальное состояние
                        state = State.DEFAULT;
                        --i;
                    }
                }
            }
        }
        return b.toString();
    }

    public static void main(String[] args) {
        String input = "\"\"\"\"Я работаю в Гугле :-)))\"\"\"\"\n" +
                "\"\"\"\"везет :-) а я туда собеседование завалил:-((\"\"\"\"\n" +
                "\"\"\"\"лол:)\"\"\"\"\n" +
                "\"\"\"\"Ааааа!!!!! :-))(())\"\"\"\"";

        String result = removeSmileys(input);
        String resultReg = removeSmileysRegex(input);
        System.out.println("Результат: \n" + result);
        System.out.println(" ");
        System.out.println("Результат regex: \n" + resultReg);
    }
}
