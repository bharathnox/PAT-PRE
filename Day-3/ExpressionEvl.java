import java.util.Scanner;
import java.util.Stack;

public class ExpressionEvl {

    public static int evalute (String str) {
        Stack <Character> stkOperators = new Stack<>();
        Stack <Integer> stkOperands = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(Character.isDigit(ch)) {
                int num = 0;
                while(i < str.length() && Character.isDigit(str.charAt(i))) {
                    num = num*10 + (str.charAt(i)-'0');
                    i++;
                }
                i--;
                stkOperands.push(num);
            }
            else if(ch == '(') {
                stkOperators.push(ch);
            }
            else if(ch == ')') {
                while (!stkOperators.isEmpty() && stkOperators.peek() != '(') {
                    processStack(stkOperands, stkOperators);
                }
                stkOperators.pop();
            }
            else if(ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (!stkOperators.isEmpty() && precedence(stkOperators.peek()) >= precedence(ch)) {
                    processStack(stkOperands, stkOperators);
                }
                stkOperators.push(ch);
            }
        }
        while (!stkOperators.isEmpty()) {
            processStack(stkOperands, stkOperators);
        }
        return stkOperands.pop();
    }

    private static int precedence(char op) {
        if(op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }

    private static void processStack(Stack<Integer> operands, Stack<Character> operators) {
        if (operands.size() < 2) return;

        int opd2 = operands.pop();
        int opd1 = operands.pop();
        char op = operators.pop();

        int res = 0;
        switch (op) {
            case '+': res = opd1 + opd2; break;
            case '-': res = opd1 - opd2; break;
            case '*': res = opd1 * opd2; break;
            case '/': if(opd2 != 0) res = opd1 / opd2; break;
        }
        operands.push(res);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an expression: ");
        String str = sc.nextLine();
        sc.close();
        System.out.println("Result: "+evalute(str));
    }
}
