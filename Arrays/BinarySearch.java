public class BinarySearch {
    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid; // Target found at index 'mid'
            } else if (nums[mid] < target) {
                low = mid + 1; // Search the right half
            } else {
                high = mid - 1; // Search the left half
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        int result = search(nums, target);

        if (result != -1) {
            System.out.println("Target " + target + " found at index " + result);
        } else {
            System.out.println("Target " + target + " not found in the array.");
        }
    }
}
