package ExpressionEvaluatorTest;

import org.example.ExpressionEvaluator.Tokenizer;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
public class TokenizerTest {
    @Test
    public void testTokenization() {
        // Тест для проверки токенизации выражения "3 + 5 * ( 2 - 7 ) / 4"
        String expression = "3 + 5 * ( 2 - 7 ) / 4";
        List<String> tokens = Tokenizer.tokenize(expression);

        // Проверка количества токенов и значения каждого токена
        assertEquals(11, tokens.size());
        assertEquals("3", tokens.get(0));
        assertEquals("+", tokens.get(1));
        assertEquals("5", tokens.get(2));
        assertEquals("*", tokens.get(3));
        assertEquals("(", tokens.get(4));
        assertEquals("2", tokens.get(5));
        assertEquals("-", tokens.get(6));
        assertEquals("7", tokens.get(7));
        assertEquals(")", tokens.get(8));
        assertEquals("/", tokens.get(9));
        assertEquals("4", tokens.get(10));
    }

    @Test
    public void testTokenizationWithSpaces() {
        String expression = "3 + 5 * ( 2 - 7 ) / 4";
        List<String> tokens = Tokenizer.tokenize(expression);

        System.out.println("Actual tokens: " + tokens);  // Вывести фактические токены

        // Ожидаемые токены с учетом пробелов
        List<String> expectedTokens = Arrays.asList("3", "+", "5", "*", "(", "2", "-", "7", ")", "/", "4");

        assertEquals(expectedTokens.size(), tokens.size());
        for (int i = 0; i < expectedTokens.size(); i++) {
            assertEquals(expectedTokens.get(i), tokens.get(i));
        }
    }
}
