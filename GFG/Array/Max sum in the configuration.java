/*   Scroll below to see JAVA code and C# also  */
/*
    Company Tags           : Amazon
    GFG Link               : https://www.geeksforgeeks.org/problems/max-sum-in-the-configuration/1
*/

/ C++ ************************************************************************************************************************************/
// Time Complexity: O(n).
// Auxiliary Space: O(1).
  
class Solution {
  public:
    long long max_sum(int a[], int n) {
        long long temp=0;
        long long sum=0;
        long long ans=0;
        for(long long int i=0;i<n;i++){
            temp+=i*a[i];
            sum+=a[i];
    }
    ans=temp;
    for(long long i=1;i<n;i++){
        temp=temp-sum+(long long)a[i-1]*n;
        ans=max(temp,ans);
    }
    return ans;
    }
};

/ Java ************************************************************************************************************************************/
// Time Complexity: O(n).
// Auxiliary Space: O(1).

public class Solution {
    public long maxSum(int[] a, int n) {
        long temp = 0;
        long sum = 0;
        long ans = 0;
        for (long i = 0; i < n; i++) {
            temp += i * a[(int) i];
            sum += a[(int) i];
        }
        ans = temp;
        for (long i = 1; i < n; i++) {
            temp = temp - sum + (long) a[(int) (i - 1)] * n;
            ans = Math.max(temp, ans);
        }
        return ans;
    }
}

/ C# ************************************************************************************************************************************/
// Time Complexity: O(n).
// Auxiliary Space: O(1).
  
public class Solution {
    public long MaxSum(int[] a, int n) {
        long temp = 0;
        long sum = 0;
        long ans = 0;
        for (long i = 0; i < n; i++) {
            temp += i * a[i];
            sum += a[i];
        }
        ans = temp;
        for (long i = 1; i < n; i++) {
            temp = temp - sum + (long) a[i - 1] * n;
            ans = Math.Max(temp, ans);
        }
        return ans;
    }
}
