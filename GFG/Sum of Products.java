/*        Scroll below to see JAVA , C # and Python also        */
/*
    Company Tags                      : 
    Leetcode Link                     : https://www.geeksforgeeks.org/problems/sum-of-products5049/1
*/


/ C++ ********************************************************************************************************************/
class Solution {
    long long pairAndSum(int n, long long arr[]) {
        // code here
        vector<int> bits(32,0);
        for(int i=0;i<n;i++){
            int temp = arr[i];
            int j=0;
            while(temp){
                if(temp&1)bits[j]++;
                j++;
                temp>>=1;
            }
        }
        long long ans = 0;
        for(int i=0;i<32;i++){
            long long temp = bits[i];
            temp--;
            long long pairs = (temp*(temp+1))/2;
            ans+=(pairs*(long long)pow(2,i));
        }
        return ans;
    }
}
/ Java ********************************************************************************************************************/

    class Solution {
    
    static long pairAndSum(int n, long arr[]) {
        // code here
        int bits[] = new int[32];
        Arrays.fill(bits,0);
        for(int i=0;i<n;i++){
            long temp = arr[i];
            int j=0;
            while(temp!=0){
                if((temp&1)==1)bits[j]++;
                temp>>=1;
                j++;
            }
        }
        long ans = 0;
        for(int i=0;i<32;i++){
            long temp = bits[i];
            temp--;
            long pairs = (temp*(temp+1))/2;
            ans+=(pairs*(long)Math.pow(2,i));
        }
        return ans;
    }
}
// Time Complexity:- O(N)
// Space Complexity:- O(1)


// 1. **Initialization**:
//     - We have a method called `pairAndSum` that takes two parameters: an integer `n` and an array of long integers `arr`.
//     - The goal of this method is to compute the sum of bitwise pairs for all elements in the array.

// 2. **Bit Manipulation**:
//     - We create an integer array `bits` of size 32 to store the count of set bits (1s) at each position.
//     - Initialize all elements of `bits` to 0 using `Arrays.fill(bits, 0)`.
//     - For each element `arr[i]` in the input array:
//         - Initialize a temporary variable `temp` with the value of `arr[i]`.
//         - Iterate through the bits of `temp`:
//             - If the least significant bit (LSB) of `temp` is 1 (i.e., `(temp & 1) == 1`), increment the count at position `j` in `bits`.
//             - Right-shift `temp` by 1 (`temp >>= 1`) to check the next bit.
//             - Increment `j` to move to the next position.

// 3. **Compute Pair Sums**:
//     - Initialize a variable `ans` to store the final result.
//     - For each position `i` from 0 to 31 (since we are considering 32-bit integers):
//         - Compute `temp = bits[i] - 1`.
//         - Calculate the number of pairs that can be formed using the formula: `pairs = (temp * (temp + 1)) / 2`.
//         - Multiply `pairs` by `2^i` and add it to `ans`.

// 4. **Return the Result**:
//     - Return the computed `ans`.

/ C# ********************************************************************************************************************/
  using System;

public class Solution
{
    public static long PairAndSum(int n, long[] arr)
    {
        int[] bits = new int[32];
        Array.Fill(bits, 0);

        for (int i = 0; i < n; i++)
        {
            long temp = arr[i];
            int j = 0;
            while (temp != 0)
            {
                if ((temp & 1) == 1)
                    bits[j]++;
                temp >>= 1;
                j++;
            }
        }

        long ans = 0;
        for (int i = 0; i < 32; i++)
        {
            long temp = bits[i];
            temp--;
            long pairs = (temp * (temp + 1)) / 2;
            ans += (pairs * (long)Math.Pow(2, i));
        }

        return ans;
    }
}

/ Python ********************************************************************************************************************/
def pair_and_sum(n, arr):
    bits = [0] * 32

    for i in range(n):
        temp = arr[i]
        j = 0
        while temp != 0:
            if temp & 1 == 1:
                bits[j] += 1
            temp >>= 1
            j += 1

    ans = 0
    for i in range(32):
        temp = bits[i]
        temp -= 1
        pairs = (temp * (temp + 1)) // 2
        ans += pairs * (2 ** i)

    return ans

