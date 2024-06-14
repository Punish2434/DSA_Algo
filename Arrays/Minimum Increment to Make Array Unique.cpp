/*     Scroll below to see JAVA code and C#    */
/*
    Company Tags                : will soon update
    Leetcode Link               : https://leetcode.com/problems/minimum-increment-to-make-array-unique/description
*/


/ C++ ****************************************************************************************************************************************/
//Approach-1 (Using sorting)
//T.C : O(nlogn)
//S.C : O(1)
class Solution {
public:
    int minIncrementForUnique(vector<int>& nums) {
        sort(begin(nums), end(nums));

        int moves = 0;

        for(int i = 1; i < nums.size(); i++) {
            if(nums[i] <= nums[i-1]) {
                moves += (nums[i-1] - nums[i] + 1);
                nums[i] = nums[i-1]+1;
            }
        }

        return moves;
    }
};


//Approach-2 (Using Counting Sort)
//T.C : O(n+maxVal)
//S.C : O(n+maxVal)
class Solution {
public:
    int minIncrementForUnique(vector<int>& nums) {
        int n = nums.size();
        int maxElement = 0;
        int moves = 0;

        for (int val : nums) {
            maxElement = max(maxElement, val);
        }

        vector<int> count(n + maxElement, 0);

        for (int val : nums) {
            count[val]++;
        }

        for (int i = 0; i < count.size(); i++) {
            if (count[i] <= 1) continue;

            int extra = count[i] - 1;
            count[i + 1] += extra;
            count[i] = 1;
            moves += extra;
        }

        return moves;
    }
};


/ JAVA ****************************************************************************************************************************************/
//Approach-1 (Using sorting)
//T.C : O(nlogn)
//S.C : O(1)
import java.util.Arrays;

public class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        
        int moves = 0;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                moves += (nums[i - 1] - nums[i] + 1);
                nums[i] = nums[i - 1] + 1;
            }
        }
        
        return moves;
    }
}


//Approach-2 (Using Counting Sort)
//T.C : O(n+maxVal)
//S.C : O(n+maxVal)
import java.util.*;

public class Solution {
    public int minIncrementForUnique(int[] nums) {
        int n = nums.length;
        int maxElement = 0;
        int moves = 0;

        for (int val : nums) {
            maxElement = Math.max(maxElement, val);
        }

        int[] count = new int[n + maxElement];

        for (int val : nums) {
            count[val]++;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] <= 1) continue;

            int extra = count[i] - 1;
            count[i + 1] += extra;
            count[i] = 1;
            moves += extra;
        }

        return moves;
    }
}
/ C# ****************************************************************************************************************************************/


### Approach 1 (Using Sorting)
```csharp
// Approach-1 (Using sorting)
// T.C : O(nlogn)
// S.C : O(1)
using System;

public class Solution {
    public int MinIncrementForUnique(int[] nums) {
        Array.Sort(nums);
        
        int moves = 0;
        
        for (int i = 1; i < nums.Length; i++) {
            if (nums[i] <= nums[i - 1]) {
                moves += (nums[i - 1] - nums[i] + 1);
                nums[i] = nums[i - 1] + 1;
            }
        }
        
        return moves;
    }
}
```

### Approach 2 (Using Counting Sort)
```csharp
// Approach-2 (Using Counting Sort)
// T.C : O(n+maxVal)
// S.C : O(n+maxVal)
using System;

public class Solution {
    public int MinIncrementForUnique(int[] nums) {
        int n = nums.Length;
        int maxElement = 0;
        int moves = 0;

        foreach (int val in nums) {
            maxElement = Math.Max(maxElement, val);
        }

        int[] count = new int[n + maxElement];

        foreach (int val in nums) {
            count[val]++;
        }

        for (int i = 0; i < count.Length; i++) {
            if (count[i] <= 1) continue;

            int extra = count[i] - 1;
            count[i + 1] += extra;
            count[i] = 1;
            moves += extra;
        }

        return moves;
    }
}
```

// ### Key Changes:
// 1. **Import Statements:** Replaced Java import statements with appropriate C# `using` statements.
// 2. **Method Names:** Changed method names to follow C# naming conventions (`MinIncrementForUnique`).
// 3. **Array Length:** Used `nums.Length` instead of `nums.length`.
// 4. **Loops and Array Indexing:** Adjusted the syntax for loops and array indexing.
// 5. **Java-Specific Constructs:** Replaced Java-specific constructs with equivalent C# constructs (e.g., enhanced for loop with `foreach`).

