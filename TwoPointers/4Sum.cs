// Time Complexity: 𝑂 ( 𝑛 3 ) due to the nested loops and two-pointer technique. 
// Space Complexity: 𝑂 ( 𝑘 ) where  k is the number of quadruplets in the result.


using System;
using System.Collections.Generic;

public class Solution
{
    public IList<IList<int>> FourSum(int[] nums, int target)
    {
        var result = new List<IList<int>>();
        
        if (nums == null || nums.Length < 4)
            return result;

        // Sort the array to facilitate the two-pointer approach
        Array.Sort(nums);
        int n = nums.Length;

        for (int i = 0; i < n - 3; i++)
        {
            // Avoid duplicates for the first number
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            for (int j = i + 1; j < n - 2; j++)
            {
                // Avoid duplicates for the second number
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                int left = j + 1;
                int right = n - 1;

                while (left < right)
                {
                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target)
                    {
                        result.Add(new List<int> { nums[i], nums[j], nums[left], nums[right] });

                        // Move pointers to avoid duplicates
                        while (left < right && nums[left] == nums[left + 1])
                            left++;
                        while (left < right && nums[right] == nums[right - 1])
                            right--;

                        left++;
                        right--;
                    }
                    else if (sum < target)
                    {
                        left++;
                    }
                    else
                    {
                        right--;
                    }
                }
            }
        }

        return result;
    }
}
