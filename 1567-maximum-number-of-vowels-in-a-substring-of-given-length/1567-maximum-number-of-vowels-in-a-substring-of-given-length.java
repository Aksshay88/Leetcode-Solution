class Solution {
    public int maxVowels(String s, int k) {
        int i, j, count = 0, maxCount;
        String sub;
        char ch1, ch2;
        for(i=0;i<k;i++) { //finding vowels in a window of k
            if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u') {
                count++;
            }
        }
        if(count==k) //maximum vowels can be k only
            return k;
            maxCount = count;
            j = k; //pointer to check the new character after k window
        for(i=0;i<s.length()-k;i++) {
            ch1 = s.charAt(i);
            if(ch1=='a' || ch1=='e' || ch1=='i' || ch1=='o' || ch1=='u') { //decreasing the count if the element before window contains a vowel
                count--;
            }
            ch2 = s.charAt(j++);
            if(ch2=='a' || ch2=='e' || ch2=='i' || ch2=='o' || ch2=='u') { //increasing the count if the element after window contains a vowel
                count++;
            }
            if(count > maxCount)
                maxCount = count;
            if(count==k)
                return k;
        }
        return maxCount;
    }
}