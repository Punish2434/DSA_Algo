#Time Complexity: O(n)
#Space Complexity: O(1)


public class Solution {
    public int MaxArea(int[] height) {
        if(height == null || height.Length < 2)
        return 0;

        int left = 0;
        int right = height.Length - 1;

        int maxArea = 0;

        while(left < right )
        {
             int width = right - left;

             int containerHeight = Math.Min(height[left], height[right]);

             int currentArea = width * containerHeight;


             maxArea = Math.Max(maxArea, currentArea);

             if(height[left] < height[right])
             {
                left++;
             }
             else
             {
                right--;
             }

        }
        return maxArea;      
    }
}

