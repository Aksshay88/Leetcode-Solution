import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<Pair<String, Integer>> stack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int num = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                stack.push(new Pair<>(currentString.toString(), num));
                currentString.setLength(0);
                num = 0;
            } else if (c == ']') {
                Pair<String, Integer> last = stack.pop();
                StringBuilder temp = new StringBuilder(last.getKey());
                for (int i = 0; i < last.getValue(); i++) {
                    temp.append(currentString);
                }
                currentString = temp;
            } else {
                currentString.append(c);
            }
        }

        return currentString.toString();
    }
}