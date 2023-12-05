package ExpressionEvaluatorTest;

import org.example.ExpressionEvaluator.InfixToPostfixConverter;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.Assert.assertEquals;


public class InfixToPostfixConverterTest {
    @Test
    public void testInfixToPostfixConversion() {
        // Тест для проверки преобразования инфиксного выражения в постфиксное

        // Входное инфиксное выражение: 3 + 5 * ( 2 - 7 ) / 4
        List<String> infixExpression = Arrays.asList("3", "+", "5", "*", "(", "2", "-", "7", ")", "/", "4");
        Queue<String> expectedPostfixExpression = new LinkedList<>(Arrays.asList("3", "5", "2", "7", "-", "*", "4", "/", "+"));
        Queue<String> actualPostfixExpression = InfixToPostfixConverter.infixToPostfix(infixExpression);

        // Сравнение ожидаемого и фактического поэлементно
        assertEquals(expectedPostfixExpression.size(), actualPostfixExpression.size());
        while (!expectedPostfixExpression.isEmpty()) {
            assertEquals(expectedPostfixExpression.poll(), actualPostfixExpression.poll());
        }
    }
}