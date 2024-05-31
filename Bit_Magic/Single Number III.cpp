/*     Scroll below to see JAVA code and C#  also  */
/*
    Company Tags                : 
    Leetcode Link               : https://leetcode.com/problems/single-number-iii/description/

*/
/ C++ ********************************************************************************************************************************/
//Approach (Optimal)
//T.C : O(n)
//S.C : O(1)
class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        long long xor_r = 0;

        for(int &num : nums) {
            xor_r ^= num;
        }

        //mask -> right most set bit search 
        int mask = (xor_r) & (-xor_r);
        /*
            It works because if you take the two's complement negation of a number, first you complement it,
            setting all zeroes to the right of the lowest set bit to one and the lowest set bit to zero,
            then you add one, setting the bits on the right to zero and the lowest set bit becomes one again, ending the carry chain.
        */

        int groupa = 0;
        int groupb = 0;

        for(int &num : nums) {
            if(num & mask) {
                groupa ^= num;
            } else {
                groupb ^= num;
            }
        }

        return {groupa, groupb};
    }
};


/ Java ********************************************************************************************************************************/
//Approach (Optimal)
//T.C : O(n)
//S.C : O(1)
class Solution {
    public int[] singleNumber(int[] nums) {
        long xor_r = 0;

        // Perform XOR for all elements to find xor_r
        for (int num : nums) {
            xor_r ^= num;
        }

        // Find the rightmost set bit (mask)
        long mask = xor_r & (-xor_r);

        int groupa = 0;
        int groupb = 0;

        // Divide the numbers into two groups and perform XOR in each group
        for (int num : nums) {
            if ((num & mask) != 0) {
                groupa ^= num;
            } else {
                groupb ^= num;
            }
        }

        // Return the two unique numbers
        return new int[]{groupa, groupb};
    }
}

/ C# ********************************************************************************************************************************/
//Approach (Optimal)
//T.C : O(n)
//S.C : O(1)
public class Solution {
    public int[] SingleNumber(int[] nums) {
        // Step 1: XOR all the numbers to get the XOR of the two unique numbers
        int xor = 0;
        foreach (int num in nums) {
            xor ^= num;
        }
        
        // Step 2: Find a bit that is set in the XOR result
        // This bit will be different for the two unique numbers
        int diffBit = xor & (-xor);
        
        // Step 3: Partition the numbers into two groups and XOR each group separately
        int[] result = new int[2];
        foreach (int num in nums) {
            if ((num & diffBit) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }
        
        return result;
    }
}
