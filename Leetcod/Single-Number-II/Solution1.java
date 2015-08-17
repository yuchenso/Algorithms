public class Solution1 {
    public int singleNumber(int[] A) {
        int[] count = new int[32];
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < 32; j++){
                count[j] += (A[i] >> j) & 1;
            }
        }
        int result = 0;
        for(int i = 31; i >= 0; i--){
            result |= (count[i] % 3) << i;
        }
        return result;
    }
}
