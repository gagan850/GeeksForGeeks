import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class InfixToPostFix {

    
    
    public static void main(final String s[]) {
        Map<Character, Integer> operPre = new HashMap<Character, Integer>();
        operPre.put('+', 2);
        operPre.put('-', 2);
        operPre.put('*', 1);
        operPre.put('/', 1);
        operPre.put('^', 0);
        
        String input="(A+B^C)*D+E";
        
        String postFix = convertInfixToPostFix(input, operPre);
        System.out.print(postFix);
        
    }

    /**
     * Convert infix to post fix.
     *
     * @param input the input
     * @param operPre the oper pre
     * @return the string
     */
    private static String convertInfixToPostFix(final String input, final Map<Character, Integer> operPre) {

        char[] arr = input.toCharArray();
        Stack stack = new Stack();
        StringBuilder postFix = new StringBuilder();
        
        
        for (char c : arr) {
            
            //if c is an operand
            if (notASymbol(c)) {
                postFix.append(c);
                
            } else if (c=='(') {   //if c is (, push it
                stack.push(c);
                
            } else if (c==')') {
                
                while ((char)stack.peek()!='(') { //If c is ) , pop all the operators till (
                    postFix.append((char)stack.pop());
                }
                stack.pop();
                
            } else { //if c is an operator

                //if operator in stack has lower precedence, process that first
                if (!stack.isEmpty() && (char) stack.peek() != '('
                    && comparePrecedance((char) stack.peek(), c, operPre)) {
                    postFix.append((char) stack.pop());
                }
                
                stack.push(c);
                
            }
            
        }
        
        while (!stack.isEmpty()) {
            postFix.append((char)stack.pop());
        }
        return postFix.toString();
    }

    /**
     * Compare precedance.
     *
     * @param op the op
     * @param op1 the op1
     * @param operPre the oper pre
     * @return true, if successful
     */
    public static boolean comparePrecedance(final char op, final char op1, final Map<Character, Integer> operPre) {
        int opPre = operPre.get(op);
        int op1Pre = operPre.get(op1);

        if (opPre <= op1Pre) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * @param c
     * @return
     */
    private static boolean notASymbol(final char c) {
        return c >= 65 && c<=90 || c >= 97 && c<=122 ||c>=49 && c<=58;
    }
}
