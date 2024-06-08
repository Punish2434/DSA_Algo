/*     Scroll below to see JAVA code and C# also    */

/*
    Company Tags                : Amazon, Facebook, Paytm
    Leetcode Link               : https://leetcode.com/problems/continuous-subarray-sum/
*/
/ C++ ***************************************************************************************************************************************/

class Solution {
public:
    bool checkSubarraySum(vector<int>& nums, int k) {
        int n = nums.size();
        
        unordered_map<int, int> mp;
        
        mp[0] = -1;
        
        int sum = 0;
        
        for(int i = 0; i<n; i++) {
            sum += nums[i];
            
            int remainder = sum%k;
            
            if(mp.find(remainder) != mp.end()) {
                
                if(i - mp[remainder] >= 2)
                    return true;
                
            } else {
                mp[remainder] = i;
            }
        }
        return false;
    }
};
/ Java ***************************************************************************************************************************************/
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // HashMap to store the remainder of the prefix sum divided by k and its index
        HashMap<Integer, Integer> map = new HashMap<>();
        // Initialize the map with remainder 0 at index -1 to handle edge cases
        map.put(0, -1);
        
        int sum = 0; // Variable to store the running sum of the elements
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i]; // Update the running sum
            
            // If k is not 0, get the remainder of the running sum divided by k
            if (k != 0) {
                sum %= k;
            }
            
            // If the remainder is already in the map
            if (map.containsKey(sum)) {
                // Check if the subarray length is at least 2
                if (i - map.get(sum) > 1) {
                    return true;
                }
            } else {
                // Otherwise, store the remainder and the index
                map.put(sum, i);
            }
        }
        
        // If no good subarray is found, return false
        return false;
    }

   
}
/ C# ***************************************************************************************************************************************/
using System;
using System.Collections.Generic;

public class Solution
{
    public bool CheckSubarraySum(int[] nums, int k)
    {
        // Dictionary to store the remainder of the prefix sum divided by k and its index
        Dictionary<int, int> map = new Dictionary<int, int>();
        // Initialize the dictionary with remainder 0 at index -1 to handle edge cases
        map[0] = -1;

        int sum = 0; // Variable to store the running sum of the elements

        for (int i = 0; i < nums.Length; i++)
        {
            sum += nums[i]; // Update the running sum

            // If k is not 0, get the remainder of the running sum divided by k
            if (k != 0)
            {
                sum %= k;
            }

            // If the remainder is already in the dictionary
            if (map.ContainsKey(sum))
            {
                // Check if the subarray length is at least 2
                if (i - map[sum] > 1)
                {
                    return true;
                }
            }
            else
            {
                // Otherwise, store the remainder and the index
                map[sum] = i;
            }
        }

        // If no good subarray is found, return false
        return false;
    }
}
