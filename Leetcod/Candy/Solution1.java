public class Solution1 {
    public int candy(int[] ratings) {
        int[] array = new int[ratings.length];
        Arrays.fill(array, 1);
        // left to right
        for (int i = 1; i < array.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                array[i] = array[i - 1] + 1;
            } 
        }
        
        // right to left
        for (int i = array.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && array[i] <= array[i + 1]) { 
                array[i] = array[i + 1] + 1;
            }
        }
        
        // get sum
        int rst = 0;
        for (int i = 0; i < array.length; i++) {
            rst += array[i];
        }
        return rst;
    }
}
