class Solution {
    public String removeKdigits(String num, int k) {
     if (num.length() == k) {
            return "0";
        }

        Stack<Character> stack = new Stack<>();

        // Iterate through each digit in the number
        for (char digit : num.toCharArray()) {
            // Remove digits from the stack if they are greater than the current digit
            // and we still have digits to remove
            while (k > 0 && !stack.isEmpty() && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        // Remove any remaining digits if k > 0
        while (k > 0) {
            stack.pop();
            k--;
        }

        // Build the result string from the stack
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        // Remove leading zeros
        int start = 0;
        while (start < result.length() && result.charAt(start) == '0') {
            start++;
        }
        result.delete(0, start);

        // If the result is empty, return "0"
        return result.length() == 0 ? "0" : result.toString();
    }
}
   
