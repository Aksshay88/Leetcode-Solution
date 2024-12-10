class Solution {
    private List<Integer> runningSums;
    private int totalSum;

    public Solution(int[] weights) {

        runningSums = new ArrayList<>();
        int runningSum = 0;

        for (int w : weights) {
            runningSum += w;
            runningSums.add(runningSum);
        }

        totalSum = runningSum;
    }

    public int pickIndex() {
        Random random = new Random();
        int target = random.nextInt(totalSum) + 1;
        int low = 0;
        int high = runningSums.size();

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (target > runningSums.get(mid)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}