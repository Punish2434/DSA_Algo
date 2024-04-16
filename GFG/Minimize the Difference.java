/*     Scroll below to see JAVA code and C# also        */
/*
    Company Tags  : 
    GFG Link : https://www.geeksforgeeks.org/problems/minimize-the-difference/1
*/

/ C++ *************************************************************************************/
class Solution {
    int minimizeDifference(int n, int k, vector<int> &arr) {
        // code here
        vector<int> rightmn(n,0),rightmx(n,0);
        rightmx[n-1]=arr[n-1];
        rightmn[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            rightmx[i]=max(rightmx[i+1],arr[i]);
            rightmn[i]=min(rightmn[i+1],arr[i]);
        }
        int i=0,j=k-1,mn=INT_MAX,mx=INT_MIN,ans=INT_MAX;
        while(j<n){
            if(i!=0){
                mn=min(arr[i-1],mn);
                mx=max(arr[i-1],mx);
            }
            int temp1=mn,temp2=mx;
            if(j!=n-1){
                temp1=min(temp1,rightmn[j+1]);
                temp2=max(temp2,rightmx[j+1]);
            }
            ans=min(ans,abs(temp2-temp1));
            i++;
            j++;
        }
        return ans;
    }
}

/ Java *************************************************************************************/
class Solution {
    public static int minimizeDifference(int n, int k, int[] arr) {
        // Initialize arrays to store maximum and minimum values
        int rightmx[] = new int[n];
        int rightmn[] = new int[n];
        
        // Initialize the last elements of the arrays
        rightmx[n - 1] = arr[n - 1];
        rightmn[n - 1] = arr[n - 1];
        
        // Calculate maximum and minimum values for each position
        for (int i = n - 2; i >= 0; i--) {
            rightmn[i] = Math.min(rightmn[i + 1], arr[i]);
            rightmx[i] = Math.max(rightmx[i + 1], arr[i]);
        }
        
        // Initialize pointers and answer variables
        int i = 0, j = k - 1;
        int mn = Integer.MAX_VALUE, mx = Integer.MIN_VALUE, ans = Integer.MAX_VALUE;
        
        // Sliding window approach
        while (j < n) {
            if (i != 0) {
                mn = Math.min(arr[i - 1], mn);
                mx = Math.max(arr[i - 1], mx);
            }
            
            // Update temporary maximum and minimum values
            int temp1 = mx, temp2 = mn;
            if (j != n - 1) {
                temp1 = Math.max(mx, rightmx[j + 1]);
                temp2 = Math.min(mn, rightmn[j + 1]);
            }
            
            // Calculate the absolute difference and update the answer
            ans = Math.min(ans, Math.abs(temp1 - temp2));
            i++;
            j++;
        }
        
        return ans;
    }
}

// Time Complexity:- O(N)
// Space Complexity- O(N)
/ C# *************************************************************************************/
  public class Solution
{
    public static int MinimizeDifference(int n, int k, int[] arr)
    {
        // Initialize arrays to store maximum and minimum values
        int[] rightmx = new int[n];
        int[] rightmn = new int[n];

        // Initialize the last elements of the arrays
        rightmx[n - 1] = arr[n - 1];
        rightmn[n - 1] = arr[n - 1];

        // Calculate maximum and minimum values for each position
        for (int i = n - 2; i >= 0; i--)
        {
            rightmn[i] = Math.Min(rightmn[i + 1], arr[i]);
            rightmx[i] = Math.Max(rightmx[i + 1], arr[i]);
        }

        // Initialize pointers and answer variables
        int i = 0, j = k - 1;
        int mn = int.MaxValue, mx = int.MinValue, ans = int.MaxValue;

        // Sliding window approach
        while (j < n)
        {
            if (i != 0)
            {
                mn = Math.Min(arr[i - 1], mn);
                mx = Math.Max(arr[i - 1], mx);
            }

            // Update temporary maximum and minimum values
            int temp1 = mx, temp2 = mn;
            if (j != n - 1)
            {
                temp1 = Math.Max(mx, rightmx[j + 1]);
                temp2 = Math.Min(mn, rightmn[j + 1]);
            }

            // Calculate the absolute difference and update the answer
            ans = Math.Min(ans, Math.Abs(temp1 - temp2));
            i++;
            j++;
        }

        return ans;
    }
}
