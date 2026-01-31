Deque (Monotonic)
  
Time Complexity : O(n)
Space Complexity O(k)
  
✅ Best approach

public class Solution {
    public int[] MaxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.Length == 0 || k <= 0)
        return new int[0];

        if( k == 1) 
        return nums;

        int n = nums.Length;
        int[] result = new int[n - k + 1];
        LinkedList<int> deque = new LinkedList<int>(); // Stores indices

        int resultIndex = 0;

        for(int i = 0; i < n; i++)
        {
            while (deque.Count > 0 && deque.First.Value < i - k + 1)
             deque.RemoveFirst();

            while(deque.Count > 0 && nums[deque.Last.Value] < nums[i] )
             deque.RemoveLast();

             deque.AddLast(i);

             if(i >= k - 1)
             {
                  result[resultIndex++]  = nums[deque.First.Value];
             }

        }

          return result;
    }
}
