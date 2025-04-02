public class Solution {
    public int LargestRectangleArea(int[] heights) {
        // Stack to store indices of histogram bars
        Stack<int> stack = new Stack<int>();
        int maxArea = 0; // Variable to store the maximum area
        int n = heights.Length;

        // Iterate over all histogram bars (including a virtual 0 at the end)
        for (int i = 0; i <= n; i++) {
            int currentHeight = (i == n) ? 0 : heights[i]; // Height of the current bar
            
            // While the stack is not empty and the current bar's height is less than the height of the bar at the top of the stack
            while (stack.Count > 0 && currentHeight < heights[stack.Peek()]) {
                int height = heights[stack.Pop()]; // Get the height of the bar at the top of the stack
                int width = (stack.Count == 0) ? i : i - stack.Peek() - 1; // Calculate the width of the rectangle
                maxArea = Math.Max(maxArea, height * width); // Update the maximum area
            }
            
            stack.Push(i); // Push the current index onto the stack
        }

        return maxArea; // Return the maximum area found
    }
}
