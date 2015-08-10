/**
 * Time: O(n)
 * Space: O(n)
 * Tags: HashMap;
 */
public class SolutionClean {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < numbers.length; i++){
            if(map.containsKey(target - numbers[i])){
                return new int[] {map.get(target - numbers[i]) + 1, i + 1};
            }
            map.put(numbers[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
