import java.util.Stack;

class BalancingOfSymbols {
    public static void main(final String s[]) {

        String input = "(){({()})}";

        if (isValidExpression(input)) {
            System.out.println("Expression is Valid");
        } else {
            System.out.println("Expression is not Valid");

        }
    }
    
    public static boolean isValidExpression(final String input) {

        Stack stack = new Stack();
        char arr[] = input.toCharArray();
        boolean isValidExpression = true;
        
        for (char c : arr) {
            if (c==')') {
                if (!stack.isEmpty() && ((char)stack.pop()!='(')) {
                    isValidExpression = false;
                    break;
                }
            } else if (c=='}') {
                if (!stack.isEmpty() && ((char)stack.pop()!='{')) {
                    isValidExpression = false;
                    break;
                }
            } else if (c==']') {
                if (!stack.isEmpty() && ((char)stack.pop()!='[')) {
                    isValidExpression = false;
                    break;
                }
            } else {
                stack.push(c);
            }
        } 

        return isValidExpression;

    }
}
       