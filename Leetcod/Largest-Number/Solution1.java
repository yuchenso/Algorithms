public class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        List<Integer> numList = new ArrayList<Integer>();
        for (int i : nums) {
            numList.add(i);
        }
        Collections.sort(numList, new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                String s1 = "" + num1 + num2;
                String s2 = "" + num2 + num1;
                return s2.compareTo(s1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i : numList) {
            sb.append(i);
        }
        if (sb.charAt(0) == '0') return "0";
        return sb.toString();
    }
}
