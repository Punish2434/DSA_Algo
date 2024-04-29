/*    Scroll below to see JAVA code and C# also    */
/*
    Compnay Tags                - Amazon
    Leetcode Link               - https://leetcode.com/problems/minimum-number-of-operations-to-make-array-xor-equal-to-k/description/
*/


/ C++ ******************************************************************************************/
//T.C : O(n)
//S.C : O(1)
class Solution {
public:
    int minOperations(vector<int>& nums, int k) {
        int totalXor = 0;
        
        for(int &num : nums) {
            totalXor ^= num;
        }
        
        
        int diff = (totalXor ^ k);
        
        return __builtin_popcount(diff);
        
    }
};



/ JAVA ******************************************************************************************/
//T.C : O(n)
//S.C : O(1)
public class Solution {
    public int MinOperations(int[] nums, int k) {
        int totalXor = 0;
        foreach (int num in nums) {
            totalXor ^= num;
        }
        
        int diff = (totalXor ^ k);
        return System.Numerics.BitOperations.PopCount((uint)diff);
    }
}

```

// 1. **Method Signature:**
//    - The method `minOperations` takes two parameters:
//      - `nums`: An integer array.
//      - `k`: An integer value.

// 2. **Initialization:**
//    - We initialize an integer variable `totalXor` to 0. This variable will store the XOR of all elements in the `nums` array.
//    - The `for` loop iterates through each element `num` in the `nums` array.

// 3. **XOR Operation:**
//    - Inside the loop, we perform the XOR operation between `totalXor` and the current element `num`.
//    - This effectively calculates the cumulative XOR of all elements in the array.

// 4. **Calculate Difference:**
//    - After the loop, we calculate the XOR of `totalXor` and `k` and store it in the variable `diff`.
//    - This represents the difference between the cumulative XOR of the array and the given value `k`.

// 5. **Count Set Bits:**
//    - Finally, we use the `Integer.bitCount(diff)` method to count the number of set bits (1s) in the binary representation of `diff`.
//    - The result of this count is returned as the output.

// 6. **Explanation:**
//    - The purpose of this code is to find the minimum number of operations needed to transform the cumulative XOR of the array into the value `k`.
//    - By counting the set bits in the XOR difference, we determine how many bits need to be flipped to achieve the desired result.

// For example, if `nums = [3, 4, 5]` and `k = 7`, the cumulative XOR of the array is `2`, and the XOR difference with `k` is `5`. The binary representation of `5` has two set bits (1s), so the output will be `2`.
