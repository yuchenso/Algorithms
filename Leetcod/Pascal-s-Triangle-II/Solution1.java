public class Solution1 {
    public List<Integer> getRow(int rowIndex) {
        int length = rowIndex + 1;
        int[] array = new int[length + 2];
        for (int i = 0; i <= rowIndex; i++) {
            if (i == 0) {
                array[1] = 1;
            }
            else {
                for (int j = i + 1; j >= 1; j--) {
                    array[j] = array[j] + array[j - 1];
                }
            }
        }
        List<Integer> rst = new ArrayList<Integer>();
        for (int i = 1; i <= rowIndex + 1; i++) {
            rst.add(array[i]);
        }
        return rst;
    }
}
