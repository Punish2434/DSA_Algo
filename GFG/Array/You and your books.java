/*     Scroll below to see JAVA code and C# also    */
/*
        Company Tags                : Junglee Games
        GFG Link               : https://www.geeksforgeeks.org/problems/you-and-your-books/1
*/


/ C++ **************************************************************************************************************/
// Time Complexity:- O(N)
// Space Complexity:- O(1)
class Solution {
    long long max_Books(int arr[], int n, int k) {
        // Your code here
        long long ans=0,sum=0;
        for(int i=0;i<n;i++){
            if(arr[i]<=k)sum+=arr[i];
            else{
                ans=max(sum,ans);
                sum=0;
            }
        }
        ans=max(sum,ans);
        return ans;
    }
}

/ Java **************************************************************************************************************/
  // Time Complexity:- O(N)
// Space Complexity:- O(1)
class Solution {
    long max_Books(int arr[], int n, int k) {
        // Your code here
        long ans=0,sum=0;
        for(int i=0;i<n;i++){
            if(arr[i]<=k)sum+=arr[i];
            else{
                ans=Math.max(ans,sum);
                sum=0;
            }
        }
        ans=Math.max(sum,ans);
        return ans;
    }
}
/ C# **************************************************************************************************************/
// Time Complexity:- O(N)
// Space Complexity:- O(1)
public class Solution
{
    public long max_Books(int[] arr, int n, int k)
    {
        long ans = 0;
        long sum = 0;

        for (int i = 0; i < n; i++)
        {
            if (arr[i] <= k)
            {
                sum += arr[i];
            }
            else
            {
                ans = Math.Max(ans, sum);
                sum = 0;
            }
        }

        ans = Math.Max(sum, ans);
        return ans;
    }
}


