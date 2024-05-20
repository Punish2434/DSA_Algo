/*   Scroll below to see JAVA code and C# also  */
/*
    Company Tags                : Google, Meta
    Leetcode Link               : https://leetcode.com/problems/sum-of-all-subset-xor-totals
*/


/ C++ **************************************************************************************************************/
// Time Complexity:- O(Log(N))
// Space Complexity:- O(1)
class Solution {
	long long int PowMod(long long int x,long long int n,long long int M)
	{
	    // Code here
	    long long int ans=1;
	    while(n){
		if(n%2)ans=(ans*x)%M;
		x=(x*x)%M;
		n/=2;
	    }
	    return ans;
	}
}
/ Java **************************************************************************************************************/
// Time Complexity:- O(Log(N))
// Space Complexity:- O(1)
//Approach-1 
class Solution {
    public long PowMod(long x, long n, long m)
    {
        // Code here
        long ans =1;
	    while(n>0){
	        if(n%2==1)ans=(ans*x)%m;
	        x=(x*x)%m;
	        n/=2;
	    }
	    return ans;
    }
}



//Approach-2
class Solution {
    public long PowMod(long x, long n, long m) {
        if (n == 0)
            return 1 % m;

        long result = 1;
        x = x % m;

        while (n > 0) {
            if (n % 2 == 1)
                result = (result * x) % m;
            x = (x * x) % m;
            n /= 2;
        }

        return result;
    }
}

/ C# **************************************************************************************************************/

// Time Complexity:- O(Log(N))
// Space Complexity:- O(1)
using System;

public class Solution
{
    public long PowMod(long x, long n, long m)
    {
        if (n == 0)
            return 1 % m;

        long result = 1;
        x = x % m;

        while (n > 0)
        {
            if (n % 2 == 1)
                result = (result * x) % m;
            x = (x * x) % m;
            n /= 2;
        }

        return result;
    }

    // Example usage:
    static void Main()
    {
        long x = 2;
        long n = 10;
        long m = 1000000007;
        Solution solution = new Solution();
        Console.WriteLine(solution.PowMod(x, n, m)); // Output: 1024
    }
}
