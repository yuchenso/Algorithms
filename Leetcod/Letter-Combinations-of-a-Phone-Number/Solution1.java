public class Solution1 {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if (digits == null || digits.length() == 0) return result; 
        
        Map<Character, String> phoneNumber = new HashMap<Character, String>();
        phoneNumber.put('2', "abc");
        phoneNumber.put('3', "def");
        phoneNumber.put('4', "ghi");
        phoneNumber.put('5', "jkl");
        phoneNumber.put('6', "mno");
        phoneNumber.put('7', "pqrs");
        phoneNumber.put('8', "tuv");
        phoneNumber.put('9', "wxyz");

        StringBuilder current = new StringBuilder();
        resultBuilder(result, current, digits, 0, phoneNumber);
        return result;
    }
    
    private void resultBuilder(List<String> result, StringBuilder current, String digits, int start, Map<Character, String> phoneNumber) {
        if (digits.length() == start) {
            result.add(current.toString());
            return;
        }
        
        char c = digits.charAt(start);
        String validString = phoneNumber.get(c);
        for (int i = 0; i < validString.length(); i++) {
            current.append(validString.charAt(i));
            resultBuilder(result, current, digits, start + 1, phoneNumber);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
