import java.util.PriorityQueue;

class KthLargest {
    private int k;
    private PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();

        // Add initial numbers to the min-heap
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        // If the heap has fewer than k elements, add the new value
        if (minHeap.size() < k) {
            minHeap.offer(val);
        }
        // If the new value is greater than the smallest in the heap, replace it
        else if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(val);
        }

        // The top of the min-heap is the k-th largest element
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
