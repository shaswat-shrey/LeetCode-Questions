//  Letter Combination Code 

import java.util.*;

class LetterCombinations {
    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();
        
        if (digits.length() == 0) {
            return ans;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backtrack(0, digits, "", ans, map);

        return ans;
    }

    public void backtrack(int index, String digits, String current, List<String> ans, Map<Character, String> map) {

        if (index == digits.length()) {
            ans.add(current);
            return;
        }

        char digit = digits.charAt(index);

        String letter = map.get(digit);

        for (int i=0; i<letter.length(); i++) {
            char ch = letter.charAt(i);

            backtrack(index+1, digits, current + ch, ans, map);
        }
    }
}

