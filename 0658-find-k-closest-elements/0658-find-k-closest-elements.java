import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // If the length of 'arr' is the same as k, return 'arr'
        if (arr.length == k) {
            List<Integer> result = new ArrayList<>();
            for (int num : arr) {
                result.add(num);
            }
            return result;
        }

        // If target is less than or equal to the first element in 'arr', return the
        // first k elements
        if (x <= arr[0]) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                result.add(arr[i]);
            }
            return result;
        }

        // If target is greater than or equal to the last element in 'arr', return the
        // last k elements
        if (x >= arr[arr.length - 1]) {
            List<Integer> result = new ArrayList<>();
            for (int i = arr.length - k; i < arr.length; i++) {
                result.add(arr[i]);
            }
            return result;
        }

        // Find the first closest element to target using binary search
        int firstClosest = binarySearch(arr, x);

        // Initialize the sliding window pointers
        int windowLeft = firstClosest - 1;
        int windowRight = windowLeft + 1;

        // Expand the sliding window until its size becomes equal to k
        while (windowRight - windowLeft - 1 < k) {
            // If window's left pointer is going out of bounds, move the window rightward
            if (windowLeft < 0) {
                windowRight++;
                continue;
            }

            // If window's right pointer is going out of bounds OR if the element pointed to
            // by window's left
            // pointer is closer to target than the element pointed to by window's right
            // pointer, move the
            // window leftward
            if (windowRight == arr.length ||
                    Math.abs(arr[windowLeft] - x) <= Math.abs(arr[windowRight] - x)) {
                windowLeft--;
            }
            // If the element pointed to by window's right pointer is closer to target than
            // the element
            // pointed to by window's left pointer, move the window rightward
            else {
                windowRight++;
            }
        }

        // Return k closest elements present inside the window
        List<Integer> result = new ArrayList<>();
        for (int i = windowLeft + 1; i < windowRight; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    private int binarySearch(int[] array, int target) {
        // Initialize the left and right pointers
        int left = 0;
        int right = array.length - 1;

        // Find the first closest element to target while left is less than or equal to
        // right
        while (left <= right) {
            // Compute the middle index
            int mid = left + (right - left) / 2;

            // If the value at mid is equal to target, return mid
            if (array[mid] == target) {
                return mid;
            }

            // If the value at mid is less than target, move left forward
            if (array[mid] < target) {
                left = mid + 1;
            }
            // If the value at mid is greater than target, move right backward
            else {
                right = mid - 1;
            }
        }
        return left;
    }
}
