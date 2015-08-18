public class Solution {
    Set<String> set = new HashSet<String>(Arrays.asList("+", "-", "*", "/"));
    
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < tokens.length; i++){
            if(!this.set.contains(tokens[i])) stack.push(Integer.valueOf(tokens[i]));
            else{
                Integer operand2 = stack.pop();
                Integer operand1 = stack.pop();
                stack.push(operate(tokens[i], operand1, operand2));
            }
        }
        return stack.peek();
    }
    
    private int operate(String op, Integer operand1, Integer operand2) {
        switch (op) {
            case "+" : return operand1 + operand2;
            case "*" : return operand1 * operand2;
            case "-" : return operand1 - operand2;
            default  : return operand1 / operand2;
        }
    }
}
