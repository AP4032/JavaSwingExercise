package part1.app;


import java.util.*;

public class EvalUtil {
    private static int precedence(String op) {
        switch (op) {
            case "+": case "-":
                return 1;
            case "*": case "/":
                return 2;
            default:
                return 0;
        }
    }

    // Check if token is operator
    private static boolean isOperator(String token) {
        return "+-*/".contains(token);
    }
    public static List<String> eval(String expression) {
        List<String> output = new ArrayList<>();
        Stack<String> operators = new Stack<>();

        StringTokenizer tokenizer = new StringTokenizer(expression, "+-*/() ", true);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().trim();
            if (token.isEmpty()) continue;

            if (token.matches("\\d+(\\.\\d+)?")) {
                output.add(token);
            } else if (isOperator(token)) {
                while (!operators.isEmpty() && isOperator(operators.peek()) &&
                        precedence(operators.peek()) >= precedence(token)) {
                    output.add(operators.pop());
                }
                operators.push(token);
            } else if (token.equals("(")) {
                operators.push(token);
            } else if (token.equals(")")) {
                while (!operators.isEmpty() && !operators.peek().equals("(")) {
                    output.add(operators.pop());
                }
                if (!operators.isEmpty() && operators.peek().equals("(")) {
                    operators.pop(); // Pop the '('
                }
            }
        }
        while (!operators.isEmpty()) {
            output.add(operators.pop());
        }
        return output;
    }

    public static String calculatePostfix(List<String> postfix) {
        Stack<Double> stack = new Stack<>();
        try {
            for (String token: postfix){
                if (token.matches("\\d+(\\.\\d+)?")) {
                    stack.push(Double.parseDouble(token));
                } else if (isOperator(token)) {
                    double b = stack.pop();
                    double a = stack.pop();
                    switch (token) {
                        case "+": stack.push(a + b); break;
                        case "-": stack.push(a - b); break;
                        case "*": stack.push(a * b); break;
                        case "/": stack.push(a / b); break;
                    }
                }
            }
            return String.valueOf(stack.pop());

        } catch (EmptyStackException e) {
            return "Error";
        }
    }
}