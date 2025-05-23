// Time Complexity: O(n) — We traverse the height array once.

// Space Complexity: O(1) — We use constant extra space.

using System;

public class Solution
{
    public int Trap(int[] height)
    {
        int left = 0;
        int right = height.Length - 1;
        int leftMax = 0, rightMax = 0;
        int totalWater = 0;

        while (left < right)
        {
            if (height[left] < height[right])
            {
                if (height[left] >= leftMax)
                {
                    leftMax = height[left];
                }
                else
                {
                    totalWater += leftMax - height[left];
                }
                left++;
            }
            else
            {
                if (height[right] >= rightMax)
                {
                    rightMax = height[right];
                }
                else
                {
                    totalWater += rightMax - height[right];
                }
                right--;
            }
        }

        return totalWater;
    }
}

// Test Example
public class Program
{
    public static void Main()
    {
        Solution solution = new Solution();

        int[] height1 = { 0,1,0,2,1,0,1,3,2,1,2,1 };
        Console.WriteLine(solution.Trap(height1)); // Output: 6

        int[] height2 = { 4,2,0,3,2,5 };
        Console.WriteLine(solution.Trap(height2)); // Output: 9
    }
}
