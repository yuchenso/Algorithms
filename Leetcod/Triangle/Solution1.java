public class Solution1 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] array = new int[n + 2];
        Arrays.fill(array, Integer.MAX_VALUE);
        array[1] = 0;
        for(int i = 0; i < triangle.size(); i++){
            List<Integer> level = triangle.get(i);
            for(int j = level.size(); j >= 1; j--) {
                array[j] = Math.min(array[j], array[j - 1]) + level.get(j - 1);
            }
        }
        int result = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++) {
            result = Math.min(array[i], result);
        }
        return result;
    }
}
