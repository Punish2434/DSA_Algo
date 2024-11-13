
// Time Complexity: 𝑂 ( 𝑛 2 ) O(n 2 ), where n is the length of the array. 
// Sorting takes 𝑂 ( 𝑛 log ⁡ 𝑛 ) O(nlogn), 
// and the two-pointer approach inside the loop takes 𝑂 ( 𝑛 2 ) O(n 2 ). 
// Space Complexity: 𝑂 ( 1 ) O(1) for extra space (excluding the space for the output list).

using System;
using System.Collections.Generic;

public class Solution {
    public IList<IList<int>> ThreeSum(int[] nums) {
        IList<IList<int>> result = new List<IList<int>>();
        Array.Sort(nums); // Sort the array first

        for (int i = 0; i < nums.Length - 2; i++) {
            // Avoid duplicate values for the first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.Length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    // Found a triplet
                    result.Add(new List<int> { nums[i], nums[left], nums[right] });

                    // Avoid duplicate values for the second and third elements
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                }
                else if (sum < 0) {
                    left++; // Move left pointer to increase sum
                }
                else {
                    right--; // Move right pointer to decrease sum
                }
            }
        }

        return result;
    }
}
