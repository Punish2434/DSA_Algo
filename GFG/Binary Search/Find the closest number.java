/*     Scroll below to see JAVA code and C# also     */
/*
    Company Tags                : 
    GFG Link               : https://www.geeksforgeeks.org/problems/find-the-closest-number5513/1
*/


/ C++ ****************************************************************************************************************/
// Time Complexity:- O(Log(N))
// Space Complexity:- O(1)
  class Solution {
    int findClosest( int n, int k,int arr[]) 
    { 
        // Complete the function
        int low=0,high=n-1,mid=0,mn=INT_MAX,ans=-1;
        while(low<=high){
            mid=(low+high)/2;
            int diff = abs(arr[mid]-k);
            ans = diff<=mn?(diff==mn?ans=max(arr[mid],ans):ans=arr[mid]):ans;
            mn=min(mn,diff);
            if(arr[mid]<=k)low=mid+1;
            else high=mid-1;
        }
        return ans;
    } 
}
/ Java ****************************************************************************************************************/
//Approach-1 
class Solution {
    public static int findClosest(int n, int k, int[] arr) {
        // code here
        int low=0,high=n-1,mid=0,mn=Integer.MAX_VALUE,ans=-1;
        while(low<=high){
            mid=(low+high)/2;
            int diff = Math.abs(arr[mid]-k);
            if(diff<=mn){
                if(diff==mn)ans=Math.max(ans,arr[mid]);
                else ans=arr[mid];
                mn=diff;
            }
            if(arr[mid]<=k)low=mid+1;
            else high=mid-1;
        }
        return ans;
    }
}
//Approach-2
class Solution {
    public static int findClosest(int n, int k, int[] arr) {
        int left = 0;
        int right = n - 1;
        int closest = arr[left]; // Initialize closest to the first element
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Update closest if the current element is closer to k
            if (Math.abs(arr[mid] - k) < Math.abs(closest - k) ||
                (Math.abs(arr[mid] - k) == Math.abs(closest - k) && arr[mid] > closest)) {
                closest = arr[mid];
            }
            
            // If the current element is equal to k, return k
            if (arr[mid] == k) {
                return k;
            }
            
            // If k is less than the current element, search in the left half
            if (arr[mid] > k) {
                right = mid - 1;
            }
            // If k is greater than the current element, search in the right half
            else {
                left = mid + 1;
            }
        }
        
        return closest;
    }
}

/ C# ****************************************************************************************************************/

```csharp
public class Solution {
    public static int FindClosest(int n, int k, int[] arr) {
        int left = 0;
        int right = n - 1;
        int closest = arr[left]; // Initialize closest to the first element
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Update closest if the current element is closer to k
            if (Math.Abs(arr[mid] - k) < Math.Abs(closest - k) ||
                (Math.Abs(arr[mid] - k) == Math.Abs(closest - k) && arr[mid] > closest)) {
                closest = arr[mid];
            }
            
            // If the current element is equal to k, return k
            if (arr[mid] == k) {
                return k;
            }
            
            // If k is less than the current element, search in the left half
            if (arr[mid] > k) {
                right = mid - 1;
            }
            // If k is greater than the current element, search in the right half
            else {
                left = mid + 1;
            }
        }
        
        return closest;
    }
}
```

// In this C# version:
// - We use `Math.Abs` for absolute value.
// - The bitwise XOR operation is represented as `^`.
// - The loop performs a binary search to find the closest element to `k`.

