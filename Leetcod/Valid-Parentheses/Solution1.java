public class Solution1 {
    Set<Character> leftSet = new HashSet<Character>( Arrays.asList('(', '[', '{') );
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            if(leftSet.contains(s.charAt(i))) stack.push(s.charAt(i));
            else{
                if(stack.empty() || !valid(stack.pop(), s.charAt(i))) return false;
            }
        }
        return stack.empty();
    }
    
    private boolean valid(char one, char another) {
        if(one == '(' && another == ')') return true;
        if(one == '[' && another == ']') return true;
        if(one == '{' && another == '}') return true;
        return false;
    }
}
