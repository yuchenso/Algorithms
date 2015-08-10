public class Solution1 {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int reversedInt = reverse(x);
        return reversedInt == x;
    }
    private int reverse(int x){
        int result = 0;
        while(x != 0){
            result = result * 10 + x % 10;
            x = x / 10;
        }   
        return result;
    }
}
