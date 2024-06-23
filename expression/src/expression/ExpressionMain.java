package expression;

import java.util.Stack;

public class ExpressionMain {

    public static int calc(int a, int b, char operator) {
        switch (operator) {
            case '$': return (int) Math.pow(a, b);
            case '*': return a * b;
            case '/': return a / b;
            case '%': return a % b;
            case '+': return a + b;
            case '-': return a - b;
        }
        return 0; 
    }

    public static int solvePostfix(String post) {
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < post.length(); i++) {
            char sym = post.charAt(i);
            if (Character.isDigit(sym)) {
                s.push(Character.getNumericValue(sym));
            } else {
                int b = s.pop();
                int a = s.pop();
                int c = calc(a, b, sym);
                s.push(c);
            }
        }
        return s.pop();
    }

    public static int solvePrefix(String pre) {
        Stack<Integer> s = new Stack<Integer>();
        for (int i = pre.length() - 1; i >= 0; i--) {
            char sym = pre.charAt(i);
            if (Character.isDigit(sym)) {
                s.push(Character.getNumericValue(sym));
            } else {
                int a = s.pop();
                int b = s.pop();
                int c = calc(a, b, sym);
                s.push(c);
            }
        }
        return s.pop();
    }

    public static void main(String[] args) {
        String postfix = "59+4862/-*-173-$+";
        String prefix = "+-+59*4-8/62$1-73";
        
        int result = solvePostfix(postfix);
        System.out.println("Postfix Result: " + result);

        result = solvePrefix(prefix);
        System.out.println("Prefix Result: " + result);
    }
}
