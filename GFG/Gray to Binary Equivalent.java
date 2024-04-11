/*         Scroll down to see JAVA code and c# also        */
/*
    Company Tags  : Amazon ,Facebook ,Google ,Visa
    Leetcode Link : https://www.geeksforgeeks.org/problems/gray-to-binary-equivalent-1587115620/1
*/



/ C++ ********************************************************************************************************************************/

    int grayToBinary(int n)
    {
        
        // Your code here
        vector<int> temp;
        while(n){
            if(n&1)temp.push_back(1);
            else temp.push_back(0);
            n>>=1;
        }
        reverse(temp.begin(),temp.end());
        for(int i=1;i<temp.size();i++){
            temp[i]=temp[i-1]^temp[i];
        }
        int ans=0,j=0;
        for(int i=temp.size()-1;i>=0;i--){
            if(temp[i])ans+=pow(2,j);
            j++;
        }
        return ans;
    }

/ Java ********************************************************************************************************************************/



```java
class Solution {
    // Function to convert a given Gray equivalent n to Binary equivalent.
    public static int grayToBinary(int n) {
        // Create an ArrayList to store individual bits of the binary representation.
        ArrayList<Integer> temp = new ArrayList<>();

        // Extract individual bits from the Gray code and store them in the ArrayList.
        while (n != 0) {
            if ((n & 1) == 1)
                temp.add(1); // Add 1 if the current bit is 1.
            else
                temp.add(0); // Add 0 if the current bit is 0.
            n >>= 1; // Right shift n to process the next bit.
        }

        // Reverse the ArrayList to get the correct order of bits.
        Collections.reverse(temp);

        // Convert the Gray code to binary using XOR operation.
        for (int i = 1; i < temp.size(); i++) {
            temp.set(i, temp.get(i - 1) ^ temp.get(i));
        }

        // Calculate the decimal value of the binary representation.
        int ans = 0, j = 0;
        for (int i = temp.size() - 1; i >= 0; i--) {
            if (temp.get(i) == 1)
                ans += Math.pow(2, j); // Add 2^j if the bit is 1.
            j++;
        }

        return ans; // Return the decimal equivalent.
    }
}
```

// Explanation:
// 1. The `grayToBinary` function takes an integer `n` representing the Gray code as input.
// 2. It initializes an `ArrayList<Integer>` called `temp` to store the individual bits of the binary representation.
// 3. The `while` loop extracts each bit from the Gray code and adds it to the `temp` list.
// 4. The `Collections.reverse(temp)` reverses the order of bits to match the correct binary representation.
// 5. The `for` loop performs the XOR operation between adjacent bits to convert the Gray code to binary.
// 6. Finally, it calculates the decimal value of the binary representation and returns it.

// In summary, this code snippet converts a given Gray code to its equivalent binary representation using bitwise operations and mathematical calculations. 🚀¹²⁴
/ C# ********************************************************************************************************************************/

Certainly! Below is the equivalent C# code for the given Java code that converts a Gray code to its binary representation:

```csharp
using System;
using System.Collections.Generic;

public class Solution
{
    // Function to convert a given Gray equivalent n to Binary equivalent.
    public static int GrayToBinary(int n)
    {
        List<int> temp = new List<int>();

        // Extract individual bits from the Gray code and store them in the list.
        while (n != 0)
        {
            if ((n & 1) == 1)
                temp.Add(1); // Add 1 if the current bit is 1.
            else
                temp.Add(0); // Add 0 if the current bit is 0.
            n >>= 1; // Right shift n to process the next bit.
        }

        // Reverse the list to get the correct order of bits.
        temp.Reverse();

        // Convert the Gray code to binary using XOR operation.
        for (int i = 1; i < temp.Count; i++)
        {
            temp[i] = temp[i - 1] ^ temp[i];
        }

        // Calculate the decimal value of the binary representation.
        int ans = 0, j = 0;
        for (int i = temp.Count - 1; i >= 0; i--)
        {
            if (temp[i] == 1)
                ans += (int)Math.Pow(2, j); // Add 2^j if the bit is 1.
            j++;
        }

        return ans; // Return the decimal equivalent.
    }
}
```

// Explanation:

// - The `List<int>` replaces the `ArrayList<Integer>` for storing individual bits.
// - The `Math.Pow(2, j)` calculates the power of 2 for the binary-to-decimal conversion.


// Time Complexity:- O(Log(N))
// Space Complexity:- O(Log(N))
