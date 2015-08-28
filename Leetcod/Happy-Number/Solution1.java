public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        while(n != 1) {
            if (set.contains(n)) return false; 
            set.add(n);
            n = updateNumber(n);
        }
        return true;
    }
    
    private int updateNumber(int n) {
        int rst = 0;
        while(n != 0) {
            rst += Math.pow(n % 10, 2);
            n = n / 10;
        }
        return rst;
    }
}
