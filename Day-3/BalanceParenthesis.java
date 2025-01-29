import java.util.*;

public class BalanceParenthesis {

    public static boolean isBalanced(String str) {
        Stack <Character> stack = new Stack<>();
    
        for (char ch : str.toCharArray()) {
            if(ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if( ch == '}' || ch == ')' || ch == ']') {
                if(stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
                if( (ch==')' && top!='(') ||
                    (ch=='}' && top!='{') ||
                    (ch==']' && top!='[')) {
                        return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Give your input to check BalancedParenthesis: ");
        String str = sc.nextLine();

        System.out.println(isBalanced(str));
        
    }
}
