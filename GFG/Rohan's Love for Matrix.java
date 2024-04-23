/*   Scroll down to see JAVA code also and C#  */
/*
    Company Tags                : Amazon,Facebook,Google,Visa
    Leetcode Link               : https://www.geeksforgeeks.org/problems/rohans-love-for-matrix4723/1
*/


/ C++ ************************************************************************************************/
class Solution {
    int firstElement(int n) {
        // code here
        if(n==1 or n==2)return 1;
        int a=1,b=1,ans=0,mod=1e9+7;
        for(int i=3;i<=n;i++){
            ans=(a+b)%mod;
            a=b;
            b=ans;
        }
        return ans;
    }
}

/Java ************************************************************************************************/
class Solution {
    static int firstElement(int n) {
        // code here
        if(n==1 || n==2)return 1;
        int a=1,b=1,ans=0,mod=1000000007;
        for(int i=3;i<=n;i++){
            ans=(a+b)%mod;
            a=b;
            b=ans;
        }
        return ans;
    }
}


// Time Complexity:- O(N)
// Space Complexity:- O(1)
/ C# ************************************************************************************************/

using System;

public class Solution
{
    public static int FirstElement(int n)
    {
        // Initialize variables for the first two elements in the sequence
        int a = 1; // First element
        int b = 1; // Second element
        int ans = 0; // Result (nth element)
        int mod = 1000000007; // Modulo value

        // If n is 1 or 2, the result is 1
        if (n == 1 || n == 2)
            return 1;

        // Calculate the nth element of the sequence
        for (int i = 3; i <= n; i++)
        {
            // Update ans by taking the sum of the last two elements (a and b)
            ans = (a + b) % mod;

            // Update a and b for the next iteration
            a = b;
            b = ans;
        }

        // Return the final result (nth element)
        return ans;
    }

    public static void Main(string[] args)
    {
        // Example usage: Calculate the 10th element of the sequence
        int n = 10;
        int result = FirstElement(n);
        Console.WriteLine($"The {n}th element of the sequence is: {result}");
    }
}
// ```

// **Explanation**:
// - The given Java code defines a static method named `firstElement` that calculates the nth element of a Fibonacci-like sequence.
// - The sequence starts with 1, 1, and then each subsequent element is the sum of the previous two elements.
// - The method uses two variables (`a` and `b`) to keep track of the last two elements in the sequence.
// - It iterates from 3 to `n`, updating the variables `a` and `b` in each iteration.
// - The result (`ans`) is the nth element of the sequence, modulo 1000000007.
