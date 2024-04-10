/*     Scroll down to see JAVA code and C# also     */
/*
    Company Tags                : will update soon
    Leetcode Link               : https://leetcode.com/problems/reveal-cards-in-increasing-order/description/
*/


/ C++ ***********************************************************************************************************/
//Approach-1 (Simulation) 
//T.C : O(nlogn)
//S.C : O(1)
class Solution {
public:
    vector<int> deckRevealedIncreasing(vector<int>& deck) {
        int n = deck.size();
        vector<int> result(n, 0);
        
        bool skip = false;
        
        int i = 0; //deck
        int j = 0; //result
        
        sort(begin(deck), end(deck));
        
        while(i < n) {
            
            if(result[j] == 0) { //khali hai
                
                if(skip == false) {
                    result[j] = deck[i];
                    i++;
                }
                
                skip = !skip; //alternate
                
            }
            
            j = (j+1)%n;
            
        }
        
        return result;
    }
};



//Approach-2 (Simulation using Queue) 
//T.C : O(nlogn)
//S.C : O(n)
class Solution {
public:
    vector<int> deckRevealedIncreasing(vector<int>& deck) {
        int n = deck.size();
        
        queue<int> que;
        vector<int> result(n);
        
        for(int i = 0; i < n; i++) {
            que.push(i);
        }
        
        sort(begin(deck), end(deck));
        
        for(int i = 0; i < n; i++) {
            
            int idx = que.front();
            que.pop();
            
            result[idx] = deck[i];
            
            if(!que.empty()) {
                que.push(que.front());
                que.pop();
            }
            
        }
        
        return result;
    }
};


/ JAVA ***********************************************************************************************************/
//Approach-1 (Simulation) 
//T.C : O(nlogn)
//S.C : O(1)
class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        int[] result = new int[n];
        
        boolean skip = false;
        
        int i = 0; // deck
        int j = 0; // result
        
        Arrays.sort(deck);
        
        while (i < n) {
            if (result[j] == 0) { // khali hai
                if (!skip) {
                    result[j] = deck[i];
                    i++;
                }
                
                skip = !skip; // alternate
            }
            
            j = (j + 1) % n;
        }
        
        return result;
    }
}



//Approach-2 (Simulation using Queue) 
//T.C : O(nlogn)
//S.C : O(n)
class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        
        Queue<Integer> que = new LinkedList<>();
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            que.offer(i);
        }
        
        Arrays.sort(deck);
        
        for (int i = 0; i < n; i++) {
            int idx = que.poll();
            result[idx] = deck[i];
            
            if (!que.isEmpty()) {
                que.offer(que.peek());
                que.poll();
            }
        }
        
        return result;
    }
}

// 1. **Initialization**:
//     - The code defines a class named `Solution`.
//     - Inside this class, there is a method called `deckRevealedIncreasing`.
//     - The method takes an integer array `deck` as input.

// 2. **Queue Initialization**:
//     - A `Queue<Integer>` named `que` is created using the `LinkedList` implementation.
//     - The queue will store indices (positions) of the `result` array.

// 3. **Array Initialization**:
//     - An integer array `result` of size `n` (same as the input `deck`) is initialized to store the final result.

// 4. **Queue Population**:
//     - The `que` is populated with indices from `0` to `n-1`.

// 5. **Sorting the Input Array**:
//     - The `deck` array is sorted in ascending order.

// 6. **Revealing the Cards**:
//     - For each element in the sorted `deck`, we reveal the card at the corresponding index in `result`.
//     - The `idx` is obtained by dequeuing an index from `que`.
//     - The value of `deck[i]` is assigned to `result[idx]`.

// 7. **Alternate Queuing**:
//     - If the queue is not empty, we alternate between enqueuing the next index and dequeuing the front index.
//     - This ensures that the revealed cards are in increasing order.

// 8. **Final Result**:
//     - The `result` array contains the cards in the order they should be revealed.

// In summary, this code simulates revealing cards from a shuffled deck in increasing order, 
// using a queue to keep track of the indices. The sorted `deck` provides the order in which the 
// cards should be revealed. 🃏🔢

/ C# ***********************************************************************************************************/
//Approach-1 (Simulation) 
//T.C : O(nlogn)
//S.C : O(1)


```csharp
public class Solution
{
    public int[] DeckRevealedIncreasing(int[] deck)
    {
        int n = deck.Length;
        int[] result = new int[n];

        bool skip = false;

        int i = 0; // deck
        int j = 0; // result

        Array.Sort(deck);

        while (i < n)
        {
            if (result[j] == 0) // khali hai
            {
                if (!skip)
                {
                    result[j] = deck[i];
                    i++;
                }

                skip = !skip; // alternate
            }

            j = (j + 1) % n;
        }

        return result;
    }
}
```

// In this C# version, I've made the following changes:
// - Replaced `public int[] deckRevealedIncreasing` with `public int[] DeckRevealedIncreasing`.
// - Changed `deck.length` to `deck.Length`.
// - Used `Array.Sort(deck)` instead of `Arrays.sort(deck)`.
// - Adjusted the comments and variable names to match C# conventions.

//Approach-2 (Simulation using Queue) 
//T.C : O(nlogn)
//S.C : O(n)

```csharp
public class Solution
{
    public int[] DeckRevealedIncreasing(int[] deck)
    {
        int n = deck.Length;
        Queue<int> que = new Queue<int>();
        int[] result = new int[n];

        for (int i = 0; i < n; i++)
        {
            que.Enqueue(i);
        }

        Array.Sort(deck);

        for (int i = 0; i < n; i++)
        {
            int idx = que.Dequeue();
            result[idx] = deck[i];

            if (que.Count > 0)
            {
                que.Enqueue(que.Peek());
                que.Dequeue();
            }
        }

        return result;
    }
}
```

// In this C# version:
// - I've replaced `Queue<Integer>` with `Queue<int>`.
// - Used `Enqueue` and `Dequeue` methods instead of `offer` and `poll`.
// - Adjusted the variable names to match C# conventions.


