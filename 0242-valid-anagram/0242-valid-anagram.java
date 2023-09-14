class Solution {
    public boolean isAnagram(String s, String t) {
        char[] ch = s.toCharArray();
        char[] a = t.toCharArray();
        Arrays.sort(ch);
        Arrays.sort(a);
        return Arrays.equals(ch,a);   
    }
}