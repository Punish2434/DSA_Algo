
/*     Scroll down to see JAVA code and C# also    */
/*
    Company Tags                : Amazon,Yatra.com
    Leetcode Link               : https://www.geeksforgeeks.org/problems/count-the-elements1529/1
*/



/ C++ ******************************************************************************************/
  class Solution
{
    vector<int> countElements(vector<int> &a, vector<int> &b, int n, vector<int> &query,
                              int q) {
        // Your code goes here;
        int mx=-1;
        for(int i=0;i<n;i++)mx=max(mx,b[i]);
        vector<int> heap(mx+1,0);
        for(int i=0;i<n;i++)heap[b[i]]++;
        for(int i=1;i<=mx;i++)heap[i]+=heap[i-1];
        vector<int> ans;
        for(int i=0;i<q;i++){
            if(a[query[i]]>mx){
                ans.push_back(n);
            }
            else ans.push_back(heap[a[query[i]]]);
        }
        return ans;
    }
}
/ Java ******************************************************************************************/

  class Solution
{
    public static int[] countElements(int a[], int b[], int n, int query[], int q)
    {
        int mx=-1;
        for(int i=0;i<n;i++)mx=Math.max(mx,b[i]);
        int heap[] = new int [mx+1];
        Arrays.fill(heap,0);
        for(int i=0; i<n;i++)heap[b[i]]++;
        for(int i=1; i<=mx; i++)heap[i]+=heap[i-1];
        int ans[] = new int[q];
        for(int i=0; i<q; i++){
            if(a[query[i]]>mx){
                ans[i]=n;
                
            }
            else ans[i]= heap[a[query[i]]];
        }
        return ans;
    }
}


// Time Complexity:- O(max(mx,n,q))
// Space Complexity:- O(mx)
/ C# ******************************************************************************************/


```csharp
public class Solution {
    public static int[] CountElements(int[] a, int[] b, int n, int[] query, int q) {
        int mx = -1;
        for (int i = 0; i < n; i++) {
            mx = Math.Max(mx, b[i]);
        }
        
        int[] heap = new int[mx + 1];
        Array.Fill(heap, 0);
        
        for (int i = 0; i < n; i++) {
            heap[b[i]]++;
        }
        
        for (int i = 1; i <= mx; i++) {
            heap[i] += heap[i - 1];
        }
        
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            if (a[query[i]] > mx) {
                ans[i] = n;
            }
            else {
                ans[i] = heap[a[query[i]]];
            }
        }
        
        return ans;
    }
}
```

// - The `CountElements` method computes the cumulative sum of elements in the `b` array based on the given queries.
// - The logic remains consistent with the original Java code.

