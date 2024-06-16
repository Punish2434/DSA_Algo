/*     Scroll below to see JAVA code also    */
/*
    Company Tags                : GOOGLE
    Leetcode Link               : https://leetcode.com/problems/patching-array/description/
*/


/ C++ ****************************************************************************************************/
//Approach (Greedy observation)
//T.C : O(max(l, log(n)), l = length of nums
//S.C : O(1)
class Solution {
public:
    int minPatches(vector<int>& nums, int n) {
        long maxReach = 0;
        int patch     = 0;
        int i         = 0;

        while(maxReach < n) {
            if(i < nums.size() && nums[i] <= maxReach+1) {
               maxReach += nums[i];
               i++;
            } else {
               maxReach += (maxReach + 1);
               patch++;
            }
        }
        return patch;
    }
};



/ JAVA ****************************************************************************************************/
//Approach (Greedy observation)
//T.C : O(max(l, log(n)), l = length of nums
//S.C : O(1)
class Solution {
    public int minPatches(int[] nums, int n) {
        long maxReach = 0;
        int patch = 0;
        int i = 0;

        while (maxReach < n) {
            if (i < nums.length && nums[i] <= maxReach + 1) {
                maxReach += nums[i];
                i++;
            } else {
                maxReach += (maxReach + 1);
                patch++;
            }
        }
        return patch;
    }
}
/ C# ****************************************************************************************************/
//Approach (Greedy observation)
//T.C : O(max(l, log(n)), l = length of nums
//S.C : O(1)


```csharp
using System;

public class Solution {
    public int MinPatches(int[] nums, int n) {
        long maxReach = 0;
        int patch = 0;
        int i = 0;

        while (maxReach < n) {
            if (i < nums.Length && nums[i] <= maxReach + 1) {
                maxReach += nums[i];
                i++;
            } else {
                maxReach += (maxReach + 1);
                patch++;
            }
        }
        return patch;
    }

    public static void Main(string[] args) {
        Solution solution = new Solution();
        
        // Test cases
        int[] nums1 = {1, 3};
        int n1 = 6;
        Console.WriteLine(solution.MinPatches(nums1, n1)); // Output: 1
        
        int[] nums2 = {1, 5, 10};
        int n2 = 20;
        Console.WriteLine(solution.MinPatches(nums2, n2)); // Output: 2
        
        int[] nums3 = {1, 2, 2};
        int n3 = 5;
        Console.WriteLine(solution.MinPatches(nums3, n3)); // Output: 0
    }
}
```

// ### Explanation:
// 1. **Method Signature**:
//    - The method `MinPatches` replaces `minPatches` from Java.
//    - Adjusted for C# conventions (PascalCase for method names).

// 2. **Main Method**:
//    - Equivalent to Java's `main` method, used for testing the function.

// 3. **Array Length**:
//    - `nums.Length` in C# replaces `nums.length` from Java.

// 4. **Long Data Type**:
//    - `long` in both Java and C# for the `maxReach` variable, to handle potentially large sums.

// 5. **Console Output**:
//    - `Console.WriteLine` replaces `System.out.println` for output in C#.

// This C# code replicates the functionality of the original Java code, ensuring it maintains the same logic and structure.
