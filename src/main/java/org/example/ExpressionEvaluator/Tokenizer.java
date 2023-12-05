package org.example.ExpressionEvaluator;


import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
public class Tokenizer {

    public static List<String> tokenize(String expression) {
        List<String> tokens = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(expression, "+-*/^() ", true);

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().trim();

            if (!token.isEmpty()) {
                tokens.add(token);
            }
        }

        return tokens;
    }
}



