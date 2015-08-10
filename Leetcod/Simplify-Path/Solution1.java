public class Solution1 {
    public String simplifyPath(String path) {
        String[] pathItems = path.split("/+");
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < pathItems.length; i++) {
            if (pathItems[i].equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else if (!pathItems[i].equals(".") && !pathItems[i].equals("")){
                stack.push(pathItems[i]);
            }
        }
        String rst = "";
        while (!stack.isEmpty()) {
            rst = "/" + stack.pop() + rst;
        }
        if (rst.length() == 0) return "/";
        return rst;
    }
}
