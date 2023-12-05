package org.example.ExpressionEvaluator;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class InfixToPostfixConverter {
    public static Queue<String> infixToPostfix(List<String> infixExpression) {
        Queue<String> postfixExpression = new LinkedList<>();
        Stack<String> operatorStack = new Stack<>();

        for (String token : infixExpression) {
            if (Utilities.isNumeric(token)) {
                postfixExpression.add(token);
            } else if (token.equals("(")) {
                operatorStack.push(token);
            } else if (token.equals(")")) {
                while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                    postfixExpression.add(operatorStack.pop());
                }
                operatorStack.pop(); // Удаляем "("
            } else {
                while (!operatorStack.isEmpty() && Utilities.getPrecedence(operatorStack.peek()) >= Utilities.getPrecedence(token)) {
                    postfixExpression.add(operatorStack.pop());
                }
                operatorStack.push(token);
            }
        }

        while (!operatorStack.isEmpty()) {
            postfixExpression.add(operatorStack.pop());
        }

        return postfixExpression;
    }
}

