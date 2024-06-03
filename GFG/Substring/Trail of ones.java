/*     Scroll below to see JAVA code and C# also  */
/*
    Company Tags                : AMAZON
    GFG Link               : https://leetcode.com/problems/append-characters-to-string-to-make-subsequence/
*/

/ C++ ********************************************************************************************************/

// Time Complexity:- O(N)
// Space Complexity:- O(1)

class Solution {
    int numberOfConsecutiveOnes(int n) {
        // code here
        if(n==2)return 1;
        int a=0,b=1,ans=1,mod=1e9+7;
        for(int i=3;i<=n;i++){
            int c = (a+b)%mod;
            a=b;
            b=c;
            ans=((ans*2)%mod+c)%mod;
        }
        return ans;
    }
}
/ Java ********************************************************************************************************/
// Time Complexity:- O(N)
// Space Complexity:- O(1)
class Solution {
    static int numberOfConsecutiveOnes(int n) {
        // code here        \
        if(n==2)return 1;
        int ans=1,a=0,b=1,mod=1000000007;
        for(int i=3;i<=n;i++){
            int c=(a+b)%mod;
            a=b;
            b=c;
            ans=((ans*2)%mod+c)%mod;
        }
        return ans;
    }
}
/ C# ********************************************************************************************************/
// Time Complexity:- O(N)
// Space Complexity:- O(1)
  public class Solution {
    static int NumberOfConsecutiveOnes(int n) {
        // Your code here
        if (n == 2) return 1;
        int ans = 1, a = 0, b = 1, mod = 1000000007;
        for (int i = 3; i <= n; i++) {
            int c = (a + b) % mod;
            a = b;
            b = c;
            ans = ((ans * 2) % mod + c) % mod;
        }
        return ans;
    }

    public static void Main(string[] args) {
        int inputNumber = 5; // Replace with your input
        int result = NumberOfConsecutiveOnes(inputNumber);
        Console.WriteLine("Result: " + result);
    }
}
