class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        int c = 0;
        int n = words.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (words[i].charAt(0) == words[j].charAt(1) && words[i].charAt(1) == words[j].charAt(0)) {
                    c++;
                }
            }
        }
        return c;
    }
}