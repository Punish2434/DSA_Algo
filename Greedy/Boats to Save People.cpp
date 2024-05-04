/*         Scroll down to see Different programing language code also                    */

/*  
    Company Tags                : Google
    Leetcode Link               : https://leetcode.com/problems/boats-to-save-people/
*/

/Java *************************************************************************************************************************************/


// ### Approach 1: Greedy Approach
// 1. Sort the `people` array in ascending order of weights.
// 2. Initialize two pointers: `left` at the beginning (lightest person) and `right` at the end (heaviest person).
// 3. While `left <= right`, do the following:
//    - If `people[left] + people[right] <= limit`, it means we can fit both people on the same boat. Move `left` to the next lightest person.
//    - Otherwise, move `right` to the next heaviest person.
//    - In either case, increment the boat count.
// 4. The total number of boats used is our answer.

```java
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people); // Sort the people by weight
        int left = 0;
        int right = people.length - 1;
        int boats = 0;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++; // Move to the next lightest person
            }
            right--; // Always move to the next heaviest person
            boats++; // Use a boat for this pair (or single person if no pair)
        }

        return boats;
    }
}
```

// ### Approach 2: Two-Pointer Approach (Optimized)
// 1. Sort the `people` array in ascending order of weights.
// 2. Initialize two pointers: `left` at the beginning (lightest person) and `right` at the end (heaviest person).
// 3. While `left < right`, do the following:
//    - If `people[left] + people[right] <= limit`, it means we can fit both people on the same boat. Move `left` to the next lightest person.
//    - Otherwise, move `right` to the previous heaviest person.
//    - In either case, increment the boat count.
// 4. If `left == right`, it means there's only one person left (heaviest person) who needs a separate boat. Increment the boat count.
// 5. The total number of boats used is our answer.

```java
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people); // Sort the people by weight
        int left = 0;
        int right = people.length - 1;
        int boats = 0;

        while (left < right) {
            if (people[left] + people[right] <= limit) {
                left++; // Move to the next lightest person
            }
            right--; // Move to the previous heaviest person
            boats++; // Use a boat for this pair (or single person if no pair)
        }

        if (left == right) {
            boats++; // One person left, needs a separate boat
        }

        return boats;
    }
}
```

//Both approaches have a time complexity of O(n log n) due to the sorting step. However, the second approach is slightly more optimized as it avoids unnecessary checks when `left == right`.
Certainly! Below is the provided Java code translated into five top programming languages: Python, C++, C#, JavaScript, and Ruby.

### Python:*************************************************************************************************************************************/
```python
def numRescueBoats(people, limit):
    people.sort()  # Sort the people by weight
    left, right = 0, len(people) - 1
    boats = 0

    while left <= right:
        if people[left] + people[right] <= limit:
            left += 1  # Move to the next lightest person
        right -= 1  # Always move to the next heaviest person
        boats += 1  # Use a boat for this pair (or single person if no pair)

    return boats
```

### C++:*************************************************************************************************************************************/
```cpp
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    int numRescueBoats(vector<int>& people, int limit) {
        sort(people.begin(), people.end());  // Sort the people by weight
        int left = 0, right = people.size() - 1;
        int boats = 0;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;  // Move to the next lightest person
            }
            right--;  // Always move to the next heaviest person
            boats++;  // Use a boat for this pair (or single person if no pair)
        }

        return boats;
    }
};
```

### C#:*************************************************************************************************************************************/
```csharp
public class Solution {
    public int NumRescueBoats(int[] people, int limit) {
        Array.Sort(people);  // Sort the people by weight
        int left = 0, right = people.Length - 1;
        int boats = 0;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;  // Move to the next lightest person
            }
            right--;  // Always move to the next heaviest person
            boats++;  // Use a boat for this pair (or single person if no pair)
        }

        return boats;
    }
}
```

### JavaScript:*************************************************************************************************************************************/
```javascript
function numRescueBoats(people, limit) {
    people.sort((a, b) => a - b);  // Sort the people by weight
    let left = 0, right = people.length - 1;
    let boats = 0;

    while (left <= right) {
        if (people[left] + people[right] <= limit) {
            left++;  // Move to the next lightest person
        }
        right--;  // Always move to the next heaviest person
        boats++;  // Use a boat for this pair (or single person if no pair)
    }

    return boats;
}
```

### Ruby:*************************************************************************************************************************************/
```ruby
def num_rescue_boats(people, limit)
    people.sort!  # Sort the people by weight
    left, right = 0, people.size - 1
    boats = 0

    while left <= right
        if people[left] + people[right] <= limit
            left += 1  # Move to the next lightest person
        end
        right -= 1  # Always move to the next heaviest person
        boats += 1  # Use a boat for this pair (or single person if no pair)
    end

    boats
end
```

