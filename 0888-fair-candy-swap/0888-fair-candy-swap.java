class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0, sumB = 0;
        Set<Integer> setA = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            sumA += A[i];
            setA.add(A[i]);
        }
        for (int i = 0; i < B.length; i++)
            sumB += B[i];
        int dif = (sumA - sumB) / 2;
        for (int i = 0; i < B.length; i++) {
            int targetA = B[i] + dif;
            if (setA.contains(targetA))
                return new int[]{targetA, B[i]};
        }
        return null;
    }
}