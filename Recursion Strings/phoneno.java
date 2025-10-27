// Leetcode Problem 17

class Solution {
     public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return result;

        backtrack(result, "", digits);
        return result;
    }

    private void backtrack(List<String> res, String ans, String ip) {
        if (ip.isEmpty()) {
            res.add(ans);
            return;
        }

        int digit = ip.charAt(0) - '0';

        if (digit < 2 || digit > 9) {
            backtrack(res, ans, ip.substring(1));
            return;
        }

        int i = (digit - 2) * 3;
        if (digit > 7) i += 1;
        int len = i + 3;
        if (digit == 7 || digit == 9) len += 1;

        for (; i < len; i++) {
            char ch = (char) ('a' + i);
            backtrack(res, ans + ch, ip.substring(1));
        }
    }
}
