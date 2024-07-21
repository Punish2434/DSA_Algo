/*         Scroll below to see JAVA code and C# also        */

    // Company Tags                : 
    // Leetcode Link               : https://leetcode.com/problems/majority-element/


// C++ ********************************************************************************************************************************************/
//Approach (using the Boyer-Moore Voting Algorithm)
//T.C : O(n)
//S.C : O(1) 
class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int count = 0;
        int candidate = 0;
        
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        
        return candidate;
    }
};
// Java ********************************************************************************************************************************************/
//Approach (using the Boyer-Moore Voting Algorithm)
//T.C : O(n)
//S.C : O(1) 
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
// C# ********************************************************************************************************************************************/
//Approach (using the Boyer-Moore Voting Algorithm)
//T.C : O(n)
//S.C : O(1) 
public class Solution {
    public int MajorityElement(int[] nums) {
        int count = 0;
        int? candidate = null;
        
        foreach (int num in nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        
        return candidate.Value;
    }
}
// JavaScript ********************************************************************************************************************************************/
//Approach (using the Boyer-Moore Voting Algorithm)
//T.C : O(n)
//S.C : O(1) 
class Solution {
    majorityElement(nums) {
        let count = 0;
        let candidate = null;
        
        for (let num of nums) {
            if (count === 0) {
                candidate = num;
            }
            count += (num === candidate) ? 1 : -1;
        }
        
        return candidate;
    }
}
