/*     Scroll below to see JAVA code and C# also    */
/*
   
    Company Tags                : Amazon
    Leetcode Link               : https://leetcode.com/problems/maximize-happiness-of-selected-children
*/


/ C++ ****************************************************************************************************************************************/
//Approach-1 (Using Sorting)
//T.C : O(nlogn)
//S.C : O(1)
class Solution {
public:
    long long maximumHappinessSum(vector<int>& happiness, int k) {
        sort(begin(happiness), end(happiness), greater<int>());
        
        long long result = 0;
        
        int count = 0;
        
        for(int i = 0; i < k; i++) {
            
            result += max(happiness[i] - count, 0);
            
            count++;
            
        }
        
        return result;
    }
};


//Approach-2 (Using Max Heap)
//T.C : O(nlogn)
//S.C : O(n)
class Solution {
public:
    long long maximumHappinessSum(vector<int>& happiness, int k) {
        long long result = 0;
        
        int count = 0;
        
        priority_queue<int> pq; //max-heap
        
        for(int &hap : happiness) {
            pq.push(hap);
        }
        
        for(int i = 0; i < k; i++) {
            
            int hap = pq.top();
            pq.pop();
            
            result += max(hap - count, 0);
            
            count++;
            
        }
        
        return result;
    }
};


/ JAVA ****************************************************************************************************************************************/
//Approach-1 (Using Sorting)
//T.C : O(nlogn)
//S.C : O(1)
class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        reverseArray(happiness);

        long result = 0;
        int count = 0;

        for (int i = 0; i < k; i++) {
            result += Math.max(happiness[i] - count, 0);
            count++;
        }

        return result;
    }

    private void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}


//Approach-2 (Using Max Heap)
//T.C : O(nlogn)
//S.C : O(n)
class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long result = 0;
        int count = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // max-heap

        for (int hap : happiness) {
            pq.offer(hap);
        }

        for (int i = 0; i < k; i++) {
            int hap = pq.poll();
            result += Math.max(hap - count, 0);
            count++;
        }

        return result;
    }
}

/ C# ****************************************************************************************************************************************/
//Approach-1 (Using Sorting)
//T.C : O(nlogn)
//S.C : O(1)
  
public class Solution
{
    public long MaximumHappinessSum(int[] happiness, int k)
    {
        Array.Sort(happiness);
        ReverseArray(happiness);

        long result = 0;
        int count = 0;

        for (int i = 0; i < k; i++)
        {
            result += Math.Max(happiness[i] - count, 0);
            count++;
        }

        return result;
    }

    private void ReverseArray(int[] arr)
    {
        int start = 0;
        int end = arr.Length - 1;
        while (start < end)
        {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
//Approach-2 (Using Max Heap)
//T.C : O(nlogn)
//S.C : O(n)


public class Solution
{
    public long MaximumHappinessSum(int[] happiness, int k)
    {
        long result = 0;
        int count = 0;

        PriorityQueue<int> pq = new PriorityQueue<int>(Comparer<int>.Create((a, b) => b.CompareTo(a))); // max-heap

        foreach (int hap in happiness)
        {
            pq.Enqueue(hap);
        }

        for (int i = 0; i < k; i++)
        {
            int hap = pq.Dequeue();
            result += Math.Max(hap - count, 0);
            count++;
        }

        return result;
    }
}
