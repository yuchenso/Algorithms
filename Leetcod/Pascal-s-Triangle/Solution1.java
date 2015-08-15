public class Solution1 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int itemLength = 1; itemLength <= numRows; itemLength++) {
            List<Integer> item = new ArrayList<Integer>();
            item.add(1);
            if (itemLength == 1) {
                result.add(item);
            }
            else {
                List<Integer> preItem = result.get(result.size() - 1);
                for (int i = 1; i < itemLength - 1; i++) {
                    item.add(preItem.get(i - 1) + preItem.get(i));
                }
                item.add(1);
                result.add(item);
            }
        }
        return result;
    }
}
