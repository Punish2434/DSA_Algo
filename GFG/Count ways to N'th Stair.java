******************************************************** C++ *************************************************************
class Solution {
    long long countWays(int n) {
        // your code here
        return n/2+1;
    }
}


******************************************************** Java *************************************************************
class Solution {
    // Function to count number of ways to reach the nth stair
    // when order does not matter.
      Long countWays(int n) {
        // your code here
        return (long)n/2+1;
    }
}

// Time Complexity:- O(1)
// Space Complexity:- O(1)


******************************************************** C# *************************************************************
public class Solution {
    // Function to count the number of ways to reach the nth stair
    // when order does not matter.
    public long CountWays(int n) {
        // Calculate the number of ways using the formula (n/2) + 1
        return (long)(n / 2) + 1;
    }
}
```

// Explanation:
// - The `CountWays` function calculates the number of ways to reach the nth stair.
// - Since the order does not matter (i.e., climbing 1-2-1 is the same as 2-1-1), we can use the formula `(n/2) + 1` to find the total ways.



