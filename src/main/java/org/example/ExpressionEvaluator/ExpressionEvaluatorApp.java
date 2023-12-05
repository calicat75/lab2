package org.example.ExpressionEvaluator;

import java.util.*;
// lab2 made by Evgenia Sichen
public class ExpressionEvaluatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите выражение: ");
        String expression = scanner.nextLine();

        Map<String, Double> variables = new HashMap<>();

        try {
            double result = evaluateExpression(expression, variables);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static double evaluateExpression(String expression, Map<String, Double> variables) {
        List<String> tokens = Tokenizer.tokenize(expression);
        Queue<String> postfixExpression = InfixToPostfixConverter.infixToPostfix(tokens);

        return evaluatePostfix(postfixExpression, variables);
    }

    private static double evaluatePostfix(Queue<String> postfixExpression, Map<String, Double> variables) {
        Stack<Double> operandStack = new Stack<>();

        while (!postfixExpression.isEmpty()) {
            String token = postfixExpression.poll();

            if (Utilities.isNumeric(token)) {
                operandStack.push(Double.parseDouble(token));
            } else if (variables.containsKey(token)) {
                operandStack.push(variables.get(token));
            } else {
                double operand2 = operandStack.pop();
                double operand1 = operandStack.pop();

                switch (token) {
                    case "+":
                        operandStack.push(operand1 + operand2);
                        break;
                    case "-":
                        operandStack.push(operand1 - operand2);
                        break;
                    case "*":
                        operandStack.push(operand1 * operand2);
                        break;
                    case "/":
                        operandStack.push(operand1 / operand2);
                        break;
                    case "^":
                        operandStack.push(Math.pow(operand1, operand2));
                        break;
                    default:
                        throw new IllegalArgumentException("Неверный оператор: " + token);
                }
            }
        }

        return operandStack.pop();
    }
}
