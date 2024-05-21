/*                                       Scroll down to see JAVA code and C# also                                      /*
/*
    Company Tags                : Microsoft
    Leetcode Link               : https://leetcode.com/problems/subsets/
*/

//-------- This is basically we are doing backtracking using Recursion. (I told you, Recursion is the father of many topics)




/ C++ ************************************************************************************************************************/
//Approach-1
//T.C : O(2^n)
//S.C :  O(2^n*length of each subset) to store each subset
//       The recursion stack space complexity is O(N) , the maximum depth of the recursion is N, where N is the length of the input array.
class Solution {
public:
    vector<vector<int>> result;

    void solve(vector<int>& nums, int idx, vector<int>& temp) {
        if(idx >= nums.size()) {
            result.push_back(temp);
            return;
        }

        temp.push_back(nums[idx]);
        solve(nums, idx+1, temp);
        temp.pop_back();
        solve(nums, idx+1, temp);
    }

    vector<vector<int>> subsets(vector<int>& nums) {
        vector<int> temp;

        solve(nums, 0, temp);

        return result;
    }
};



/ JAVA ************************************************************************************************************************/
//Approach-1
//T.C : O(2^n)
//S.C :  O(2^n*length of each subset) to store each subset
//       The recursion stack space complexity is O(N) , the maximum depth of the recursion is N, where N is the length of the input array.
public class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        solve(nums, 0, temp);
        return result;
    }

    private void solve(int[] nums, int idx, List<Integer> temp) {
        if (idx >= nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[idx]);
        solve(nums, idx + 1, temp);
        temp.remove(temp.size() - 1);
        solve(nums, idx + 1, temp);
    }
}
/ C# ************************************************************************************************************************/


```csharp
using System;
using System.Collections.Generic;

public class Solution
{
    private List<List<int>> result = new List<List<int>>();

    public List<List<int>> Subsets(int[] nums)
    {
        List<int> temp = new List<int>();
        Solve(nums, 0, temp);
        return result;
    }

    private void Solve(int[] nums, int idx, List<int> temp)
    {
        if (idx >= nums.Length)
        {
            result.Add(new List<int>(temp));
            return;
        }

        temp.Add(nums[idx]);
        Solve(nums, idx + 1, temp);
        temp.RemoveAt(temp.Count - 1);
        Solve(nums, idx + 1, temp);
    }
}
```

// In the C# code:
// - `List<List<int>>` corresponds to the Java `List<List<Integer>>`.
// - `List<int>` corresponds to the Java `List<Integer>`.
// - `Add` and `RemoveAt` methods are used for adding and removing elements from lists, respectively.

