public class Solution {
    public int[] NextGreaterElements(int[] nums) {
        int n = nums.Length;
        int[] result = new int[n];
        Stack<int> stack = new Stack<int>();

        // Initialize result array with -1
        for (int i = 0; i < n; i++) {
            result[i] = -1;
        }

        // Iterate through the array twice (circular behavior)
        for (int i = 0; i < 2 * n; i++) {
            int index = i % n; // Circular index
            while (stack.Count > 0 && nums[stack.Peek()] < nums[index]) {
                int topIndex = stack.Pop();
                result[topIndex] = nums[index];
            }
            if (i < n) {
                stack.Push(index);
            }
        }

        return result;
    }
}
