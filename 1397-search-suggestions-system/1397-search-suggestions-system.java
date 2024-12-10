class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> ans = new ArrayList<>();
        int left = 0, right = products.length - 1;

        for (int i = 0; i < searchWord.length(); i++) {
            char c = searchWord.charAt(i);
            List<String> res = new ArrayList<>();

            while (left <= right && (products[left].length() <= i || products[left].charAt(i) < c)) left++;
            while (left <= right && (products[right].length() <= i || products[right].charAt(i) > c)) right--;

            for (int j = 0; j < 3 && left + j <= right; j++) {
                res.add(products[left + j]);
            }
            ans.add(res);
        }

        return ans;
    }
}