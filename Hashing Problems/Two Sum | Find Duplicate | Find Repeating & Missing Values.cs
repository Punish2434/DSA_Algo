//1. Two Sum
//Complexity:O(n)
//Time Complexity:O(n)

using System.Collections.Generic;

public class Solution {
    public int[] TwoSum(int[] nums, int target) {
        Dictionary<int, int> map = new Dictionary<int, int>();
        
        for (int i = 0; i < nums.Length; i++) {
            int complement = target - nums[i];
            
            if (map.ContainsKey(complement)) {
                return new int[] { map[complement], i };
            }
            
            map[nums[i]] = i;
        }
        
        return null; // This line is just to satisfy return type; the problem states exactly one solution exists.
    }
}

//2965. Find Missing and Repeated Values
//Complexity:O(n2)
//Time Complexity:O(n)


using System.Collections.Generic;

public class Solution {
    public int[] FindMissingAndRepeatedValues(int[][] grid) {
        int n = grid.Length;
        int nSquared = n * n;
        
        HashSet<int> seen = new HashSet<int>();
        int actualSum = 0;
        int repeatedNumber = -1;
        
        // Find the repeated number and calculate the sum of all elements in the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = grid[i][j];
                actualSum += num;
                
                if (seen.Contains(num)) {
                    repeatedNumber = num;
                } else {
                    seen.Add(num);
                }
            }
        }
        
        // Calculate the expected sum for numbers from 1 to n^2
        int expectedSum = nSquared * (nSquared + 1) / 2;
        
        // The missing number can be derived as:
        int missingNumber = expectedSum - (actualSum - repeatedNumber);
        
        return new int[] { repeatedNumber, missingNumber };
    }
}
//287. Find the Duplicate Number
//Complexity:O(n)
//Time Complexity:O(1)



public class Solution {
    public int FindDuplicate(int[] nums) {
        // Phase 1: Detect intersection point in the cycle
        int slow = nums[0];
        int fast = nums[0];
        
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: Find the entrance to the cycle
        int ptr1 = nums[0];
        int ptr2 = slow;
        
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }
        
        return ptr1;
    }
}



### 1. **Two Sum Problem**

**Problem Recap**: Given an array of integers and a target, return indices of two numbers that add up to the target.

**Solution**: We used a hash map to store each number and its index as we iterated through the array. For each number, we checked if its complement (target - current number) existed in the hash map.

**Time Complexity**: \( O(n) \)
- We only iterate through the array once, so the time complexity is linear.

**Space Complexity**: \( O(n) \)
- In the worst case, we store each number in the hash map, resulting in a space complexity of \( O(n) \).

---

### 2. **Finding Missing and Repeated Numbers in a Matrix**

**Problem Recap**: Given an \( n \times n \) matrix with numbers ranging from 1 to \( n^2 \), where one number appears twice and another is missing, find the repeated and missing numbers.

**Solution**: We used a hash set to track the numbers and compared the actual sum with the expected sum to identify the missing number.

**Time Complexity**: \( O(n^2) \)
- We traverse each element in the \( n \times n \) matrix once, resulting in \( O(n^2) \) time complexity.

**Space Complexity**: \( O(n) \)
- The hash set stores each unique element, so in the worst case, it holds \( n^2 - 1 \) elements. However, because we are only tracking unique elements within the range \([1, n^2]\), the effective space complexity is closer to \( O(n) \).

---

### 3. **Finding the Duplicate Number using Cycle Detection (Floyd’s Tortoise and Hare)**

**Problem Recap**: Given an array of integers where numbers are in the range \([1, n]\) and one number appears twice, find the duplicate without modifying the array and using only constant extra space.

**Solution**: We applied Floyd’s Tortoise and Hare algorithm to detect a cycle in the array, which allowed us to find the duplicate in linear time and constant space.

**Time Complexity**: \( O(n) \)
- Both the cycle detection and cycle entry steps require traversing the array once, resulting in \( O(n) \) time complexity.

**Space Complexity**: \( O(1) \)
- The algorithm only uses a constant amount of extra space for pointers and variables, meeting the constraint for constant space complexity.

---

### Summary Table

| Problem                                  | Solution Technique           | Time Complexity | Space Complexity |
|------------------------------------------|------------------------------|-----------------|------------------|
| **Two Sum**                              | Hash map                     | \( O(n) \)      | \( O(n) \)       |
| **Finding Missing and Repeated Numbers** | Hash set + Sum formula       | \( O(n^2) \)    | \( O(n) \)       |
| **Finding Duplicate Number**             | Floyd’s Tortoise and Hare    | \( O(n) \)      | \( O(1) \)       |
