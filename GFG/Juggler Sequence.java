/*     Scroll below to see JAVA code and C# also     */
/*
    Company Tags                : 
    GFG Link               : https://www.geeksforgeeks.org/problems/juggler-sequence3930/1
*/

/ C++ ******************************************************************************************************************************************/

 class Solution {
    vector<long long> jugglerSequence(long long n) {
        // code here
        vector<long long> ans;
        while(n!=1){
            ans.push_back(n);
            if(n%2){
                n=pow(sqrt(n),3);
            }
            else{
                n=sqrt(n);
            }
        }
        ans.push_back(1);
        return ans;
    }
}
/ Java ******************************************************************************************************************************************/

    class Solution {
    static List<Long> jugglerSequence(long n) {
        // code here
        List<Long> ans = new ArrayList<Long>();
        while(n!=1){
            ans.add(n);
            if(n%2==1){
                n=(long)Math.pow(Math.sqrt(n),3);
            }
            else{
                n=(long)Math.sqrt(n);
            }
        }
        ans.add(1L);
        return ans;
    }
}

// Time Complexity:- O(NLogN)
// Space Complexity:- O(N)

/ C# ******************************************************************************************************************************************/

```csharp
using System;
using System.Collections.Generic;

public class Solution {
    public static List<long> JugglerSequence(long n) {
        List<long> ans = new List<long>();
        
        while (n != 1) {
            ans.Add(n);
            if (n % 2 == 1) {
                n = (long)Math.Pow(Math.Sqrt(n), 3);
            }
            else {
                n = (long)Math.Sqrt(n);
            }
        }
        
        ans.Add(1L);
        return ans;
    }
}
```

// Explanation:
// - We start with the given positive integer `n`.
// - While `n` is not equal to 1, we calculate the next term based on the Juggler formula.
// - If `n` is odd, we take the cube root of `n` and then square it.
// - If `n` is even, we take the square root of `n`.
// - We keep adding the terms to the `ans` list until we reach 1.
// - Finally, we return the entire sequence.

