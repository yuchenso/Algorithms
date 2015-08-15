public class Solution1 {
    public boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while(start < end){
            while(!Character.isLetterOrDigit(s.charAt(start)) && start < end) start++;
            while(!Character.isLetterOrDigit(s.charAt(end)) && start < end) end--;
            if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) return false;
            start++; end--;
        }
        return true;
    }
}
