///5. **Реализовать алгоритм перевода из инфиксной записи арифметического выражения в постфиксную.
import java.util.Stack;
import java.lang.StringBuilder;

class InfixToPostfix {

    public static void main(String[] args) {
        String infix = "1 * ( 12 + 23 ) - ( 4 / 5 )";
        String postfix = convert(infix);
        System.out.println(postfix);
    }

    public static String convert(String expression) {

        StringBuilder sb = new StringBuilder();

        //  Использование стека для отслеживания операций
        Stack<Character> op = new Stack<Character>();

        // Преобразование строки выражения в массив символов
        char[] chars = expression.toCharArray();

        // Длина символа выражения
        int N = chars.length;

        for (int i = 0; i < N; i++) {
            char ch = chars[i];

            if (Character.isDigit(ch)) {

                while (Character.isDigit(chars[i])) {
                    sb.append(chars[i++]);
                }
                // Использовать пространство как разделитель
                sb.append(' ');
            } else if (ch == '(') {
                // Левая скобка, нажмите на стек
                op.push(ch);
            } else if (ch == ')') {
                // Правильная скобка, поп и добавление к результату до тех пор, пока не встретится с левой скобкой
                while (op.peek() != '(') {
                    sb.append(op.pop()).append(' ');
                }

                op.pop();
            } else if (isOperator(ch)) {
                // Оператор сначала выталкивает все операторы с более высоким приоритетом, а затем выталкивает их в стек
                while (!op.isEmpty() && priority(op.peek()) >= priority(ch)) {
                    sb.append(op.pop()).append(' ');
                }
                op.push(ch);
            }
        }

        //Наконец вынуть все, что осталось в стеке, и добавьте результат
        while(!op.isEmpty()) {
            sb.append(op.pop()).append(' ');
        }

        return sb.toString();
    }


     // Проверьте, является ли символ оператором

    private static boolean isOperator(char ch) {
        return ch == '^' || ch == '*' || ch == '/' || ch == '+' || ch == '-';
    }


     // Определить приоритет оператора

    private static int priority(char operator) {
        switch (operator) {
            case '^' : return 3;
            case '*' :
            case '/' : return 2;
            case '+' :
            case '-' : return 1;
        }
        return 0;
    }

}
