/*        Scroll below to see JAVA code  and C# also        */
/*
    Company Tags  : Amazon,Cisco,Qualcomm,HCL,Nvidia
  GFG : https://www.geeksforgeeks.org/problems/reverse-bits3556/1
*/

/ C++ *********************************************************************************************************/

  class Solution {
    long long reversedBits(long long x) {
        // code here
        long long ans = 0,i=31;
        while(x){
            ans+=(long long)pow(2,i)*(x&1);
            i--;
            x>>=1;
        }
        return ans;
    }
}

/ Java *********************************************************************************************************/

// Time Complexity:- O(log(N))
// Space Complexity:- O(1)
   class Solution {
    static Long reversedBits(Long x) {
        // code here
        long ans = 0, i = 31;
        while(x!=0){
            ans+=(long)Math.pow(2,i)*(x&1);
            x>>=1;
            i--;
        }
        return ans;
    }
};

/ C# *********************************************************************************************************/


```csharp
using System;

public class Solution
{
    public static long ReversedBits(long x)
    {
        long ans = 0;
        int i = 31;
        
        while (x != 0)
        {
            ans += (long)Math.Pow(2, i) * (x & 1);
            x >>= 1;
            i--;
        }
        
        return ans;
    }
}
```

// 1. **Method Signature**:
//     - The code defines a class named `Solution`.
//     - Inside this class, there is a static method called `ReversedBits` that takes a `long` input `x` and returns a `long`.

// 2. **Method Explanation**:
//     - The purpose of the `ReversedBits` method is to reverse the bits of the input number `x`.
//     - It calculates the reversed bits by iterating through each bit of `x` from the most significant bit (leftmost) to the least significant bit (rightmost).
//     - The reversed bits are stored in the variable `ans`.

// 3. **Algorithm**:
//     - Initialize `ans` to 0.
//     - Start with the most significant bit (bit at position 31) and move towards the least significant bit (bit at position 0).
//     - For each bit:
//         - If the current bit of `x` is 1 (i.e., `(x & 1)` is 1), add the value of `2^i` to `ans`.
//         - Right-shift `x` by 1 to move to the next bit.
//         - Decrement `i` to move to the next position.
//     - Repeat this process until all bits of `x` have been processed.
//     - The final value of `ans` represents the reversed bits of `x`.

// 4. **Example**:
//     - Let's say `x` is 10 (binary: 1010).
//     - Iteration:
//         - `i = 31`, `ans = 0`
//         - Bit 3 (1): `ans += 2^3 = 8`
//         - Bit 2 (0): No change
//         - Bit 1 (1): `ans += 2^1 = 2`
//         - Bit 0 (0): No change
//     - Final result: `ans = 10` (binary: 1010)

// 5. **Usage**:
//     - You can call this method with any positive integer `x` to get its reversed bits.

