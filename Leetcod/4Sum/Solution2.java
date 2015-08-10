public class Solution2 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Map<Integer, ArrayList<ArrayList<Integer>>> map = new HashMap<Integer, ArrayList<ArrayList<Integer>>>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (!map.containsKey(sum)) {
                    ArrayList<ArrayList<Integer>> value = new ArrayList<ArrayList<Integer>>();
                    map.put(sum, value);
                }
                ArrayList<Integer> item = new ArrayList<Integer>();
                item.add(i);
                item.add(j);
                map.get(sum).add(item);
            }
        }
        
        Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>(); // store the result into set guarantees not duplicate items in result.
        for (int sum1 : map.keySet()) {
            int sum2 = target - sum1;
            if (map.containsKey(sum2)) {
                ArrayList<ArrayList<Integer>> list1 = map.get(sum1);
                ArrayList<ArrayList<Integer>> list2 = map.get(sum2);
                for (int i = 0; i < list1.size(); i++) {
                    for (int j = 0; j < list2.size(); j++) {
                        ArrayList<Integer> item1 = list1.get(i);
                        ArrayList<Integer> item2 = list2.get(j);
                        if (noDuplicate(item1, item2)) { // This guarantees that the same item will not be used more than once
                            ArrayList<Integer> item = new ArrayList<Integer>();
                            item.add(nums[item1.get(0)]);
                            item.add(nums[item1.get(1)]);
                            item.add(nums[item2.get(0)]);
                            item.add(nums[item2.get(1)]);
                            Collections.sort(item);
                            set.add(item);
                        }
                    }
                }
            }
        }
        
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        rst.addAll(set);
        return rst;
    }
    
    private boolean noDuplicate(ArrayList<Integer> item1, ArrayList<Integer> item2) {
        for (int i = 0; i < item1.size(); i++) {
            if (item2.contains(item1.get(i))) return false;
        }
        return true;
    }
}
