import java.util.Scanner;
import java.util.Stack;

public class ExpressionEvl {

    public static int evalute (String str) {
        Stack <Character> stkOperators = new Stack<>();
        Stack <Integer> stkOperands = new Stack<>();

        for (char ch : str.toCharArray()) {
            if(Character.isDigit(ch)) {
                stkOperands.push(Character.getNumericValue(ch));
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        
    }
}
