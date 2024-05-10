/*         Scroll below to see JAVA code and C# also        */
/*
    Company Tags                : 
    GFG Link               : https://www.geeksforgeeks.org/problems/combination-sum-ii-1664263832/1
*/

/ C++ ***********************************************************************************************************************************/
//Approach-1 

    void help(vector<int> &arr,int n,int k,int i,int sum,vector<int> &temp,set<vector<int>> &st){
        if(sum==k){
            st.insert(temp);
            return;
        }
        if(i==n)return;
        help(arr,n,k,i+1,sum,temp,st);
        if(sum+arr[i]<=k){
            temp.push_back(arr[i]);
            help(arr,n,k,i+1,sum+arr[i],temp,st);
            temp.pop_back();
        }
    }
    vector<vector<int>> CombinationSum2(vector<int> arr,int n,int k)
    {
        //code here
        sort(arr.begin(),arr.end());
        vector<int> temp;
        set<vector<int>> st;
        help(arr,n,k,0,0,temp,st);
        vector<vector<int>> ans(st.begin(),st.end());
        return ans;
    }


/ Java ***********************************************************************************************************************************/

//Approach-1 
  class Solution {
    void help(int arr[],int n,int k,int i,int sum,List<Integer> temp,Set<List<Integer>> st){
        if(sum==k){
            List<Integer> temp2 = new ArrayList<>();
            temp2.addAll(temp);
            st.add(temp2);
            return;
        }
        if(i==n)return;
        help(arr,n,k,i+1,sum,temp,st);
        if(sum+arr[i]<=k){
            temp.add(arr[i]);
            help(arr,n,k,i+1,sum+arr[i],temp,st);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> CombinationSum2(int arr[], int n, int k) {
        // Code Here.
        Arrays.sort(arr);
        List<Integer> temp = new ArrayList<>();
        Set<List<Integer>> st = new HashSet<List<Integer>>();
        help(arr,n,k,0,0,temp,st);
        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> lis:st){
            ans.add(lis);
        }
        Collections.sort(ans, new Comparator<List<Integer>>() {    
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                int i=0,j=0,a=o1.size(),b=o2.size();
                while(i<a && j<b){
                    if(o1.get(i)!=o2.get(j))return o1.get(i).compareTo(o2.get(j));
                    i++;
                    j++;
                }
                if(i<a)return -1;
                return 1;
                
            }               
        });
        return ans;
    }
}
//Approach-2 backtrack
class Solution {
    public List<List<Integer>> CombinationSum2(int arr[], int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr); // Sorting to ensure non-decreasing order
        
        backtrack(arr, 0, k, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int[] arr, int start, int target, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = start; i < arr.length && arr[i] <= target; i++) {
            if (i > start && arr[i] == arr[i - 1]) // Avoid duplicates
                continue;
            
            current.add(arr[i]);
            backtrack(arr, i + 1, target - arr[i], current, result);
            current.remove(current.size() - 1);
        }
    }
}
/ C# ***********************************************************************************************************************************/

```csharp
using System;
using System.Collections.Generic;
using System.Linq;

public class Solution {
    public IList<IList<int>> CombinationSum2(int[] arr, int k) {
        IList<IList<int>> result = new List<IList<int>>();
        Array.Sort(arr); // Sorting to ensure non-decreasing order

        Backtrack(arr, 0, k, new List<int>(), result);
        return result;
    }

    private void Backtrack(int[] arr, int start, int target, List<int> current, IList<IList<int>> result) {
        if (target == 0) {
            result.Add(new List<int>(current));
            return;
        }

        for (int i = start; i < arr.Length && arr[i] <= target; i++) {
            if (i > start && arr[i] == arr[i - 1]) // Avoid duplicates
                continue;

            current.Add(arr[i]);
            Backtrack(arr, i + 1, target - arr[i], current, result);
            current.RemoveAt(current.Count - 1);
        }
    }
}
```

// In the C# code, I've made the following changes:
// - Replaced `List<List<Integer>>` with `IList<IList<int>>` for consistency.
// - Used `Array.Sort(arr)` instead of `Arrays.sort(arr)` for sorting.
// - Changed method names from `CombinationSum2` and `backtrack` to `CombinationSum2` and `Backtrack`, respectively.
// - Replaced `new ArrayList<>(current)` with `new List<int>(current)` for creating a copy of the current list.
