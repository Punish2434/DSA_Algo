/*     Scroll below to see JAVA code and C# also     */
/*
    Company Tags                : Google
    Leetcode Link               : https://leetcode.com/problems/find-the-maximum-sum-of-node-values/description/
*/


/ C++ ****************************************************************************************************************/
//Approach-1 (Greedily picking nodes to xor)
//T.C : O(n)
//S.C : O(1)
class Solution {
public:
    typedef long long ll;

    long long maximumValueSum(vector<int>& nums, int k, vector<vector<int>>& edges) {
        ll  sum        = 0;
        int count      = 0;
        int minNukasan = INT_MAX;

        for (ll num : nums) {

            if((num^k) > num) {
                count++;
                sum += (num^k);
            } else {
                sum += num;
            }

            minNukasan = min((long long)minNukasan, abs(num - (num ^ k)));
        }

        if(count%2 == 0)
            return sum;

        return sum - minNukasan;
    }
};


//Approach-2(Greedy  + Sorting)
//T.C : O(nlogn)
//S.C : O(n)
class Solution {
public:
    typedef long long ll;
    ll maximumValueSum(vector<int>& nums, int k,
                              vector<vector<int>>& edges) {
        vector<int> fayda;
        ll normalSum = 0;
        
        for (int i = 0; i < nums.size(); i++) {
            fayda.push_back((nums[i] ^ k) - nums[i]);
            normalSum += 1ll * nums[i];
        }
        
        sort(fayda.begin(), fayda.end(), greater<int>());
        
        for (int i = 0; i < fayda.size()-1; i += 2) {

            ll pairSum = fayda[i] + fayda[i + 1];
            
            if (pairSum > 0) {
                normalSum += pairSum;
            }
        }
        return normalSum;
    }
};





/ JAVA ****************************************************************************************************************/
//Approach-1 (Greedily picking nodes to xor)
//T.C : O(n)
//S.C : O(1)
class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long sum = 0;
        int count = 0;
        int minNukasan = Integer.MAX_VALUE;

        for (int num : nums) {
            if ((num ^ k) > num) {
                count++;
                sum += (num ^ k);
            } else {
                sum += num;
            }

            minNukasan = Math.min(minNukasan, Math.abs(num - (num ^ k)));
        }

        if (count % 2 == 0)
            return sum;

        return sum - minNukasan;
    }
}


//Approach-2(Greedy  + Sorting)
//T.C : O(nlogn)
//S.C : O(n)
class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        List<Integer> fayda = new ArrayList<>();
        long normalSum = 0;

        for (int num : nums) {
            fayda.add((num ^ k) - num);
            normalSum += (long) num;
        }

        Collections.sort(fayda, Collections.reverseOrder());

        for (int i = 0; i < fayda.size() - 1; i += 2) {
            long pairSum = fayda.get(i) + fayda.get(i + 1);

            if (pairSum > 0) {
                normalSum += pairSum;
            }
        }
        return normalSum;
    }
}

/ C# ****************************************************************************************************************/
//Approach-1 (Greedily picking nodes to xor)
//T.C : O(n)
//S.C : O(1)
```csharp
public class Solution {
    public long MaximumValueSum(int[] nums, int k, int[][] edges) {
        long sum = 0;
        int count = 0;
        int minNukasan = int.MaxValue;

        foreach (int num in nums) {
            if ((num ^ k) > num) {
                count++;
                sum += (num ^ k);
            } else {
                sum += num;
            }

            minNukasan = Math.Min(minNukasan, Math.Abs(num - (num ^ k)));
        }

        if (count % 2 == 0)
            return sum;

        return sum - minNukasan;
    }
}
```

// In this C# version:
// - We use `int.MaxValue` instead of `Integer.MAX_VALUE`.
// - The `foreach` loop iterates over the `nums` array.
// - The bitwise XOR operation is represented as `^`.
// - The `Math.Min` function is used to find the minimum value.

//Approach-2(Greedy  + Sorting)
//T.C : O(nlogn)
//S.C : O(n)
```csharp
using System;
using System.Collections.Generic;

public class Solution {
    public long MaximumValueSum(int[] nums, int k, int[][] edges) {
        List<int> fayda = new List<int>();
        long normalSum = 0;

        foreach (int num in nums) {
            fayda.Add((num ^ k) - num);
            normalSum += (long)num;
        }

        fayda.Sort((a, b) => b.CompareTo(a));

        for (int i = 0; i < fayda.Count - 1; i += 2) {
            long pairSum = fayda[i] + fayda[i + 1];

            if (pairSum > 0) {
                normalSum += pairSum;
            }
        }
        return normalSum;
    }
}
```

// In this C# version:
// - We use `List<int>` instead of `ArrayList`.
// - The bitwise XOR operation is represented as `^`.
// - We sort the `fayda` list in descending order using a custom comparison function.
// - The loop processes pairs of elements from the sorted list.

  
