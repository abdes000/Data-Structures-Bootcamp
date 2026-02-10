import java.util.Stack;

public class PostfixEvaluation {
    static int evaluatePostfix(String expr){
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expr.split(" ");
        for(String token : tokens){
            if(Character.isDigit(token.charAt(0))) {
                stack.push(Integer.parseInt(token));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                switch(token){
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": stack.push(a / b); break;
                }
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        String expr1 = "2 3 1 * + 9 -";
        String expr2 = "100 200 + 2 / 5 * 7 +";
        System.out.println(evaluatePostfix(expr1));
        System.out.println(evaluatePostfix(expr2));
    }
}