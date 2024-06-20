/*     Scroll below to see JAVA code and C# also    */
/*
    Company Tags                : AMAZON
    Leetcode Link               : https://leetcode.com/problems/magnetic-force-between-two-balls
*/


/ C++ ******************************************************************************************************************************************/
//Approach-1 (Using Binary Search on Answer)
//T.C : O(nlogn + n*log(max_force_diff))
//S.C : O(1)
class Solution {
public:

    bool possibleToPlace(int force, vector<int>& position, int m) {

        int prev       = position[0];
        int countBalls = 1;


        for(int i = 1; i < position.size(); i++) {
            int curr = position[i];

            if(curr - prev >= force) {
                countBalls++;
                prev = curr;
            }

            if(countBalls == m)
                break;
        }

        return countBalls == m;

    }

    int maxDistance(vector<int>& position, int m) {
        int n = position.size();
        sort(begin(position), end(position));

        int minForce = 1;
        int maxForce = position[n-1] - position[0]; //better value (comment me batao)

        int result = 0;
        while(minForce <= maxForce) {
            int midForce = minForce + (maxForce - minForce)/2;

            if(possibleToPlace(midForce, position, m)) {
                result = midForce;
                minForce = midForce+1;
            } else {
                maxForce = midForce-1;
            }
        }

        return result;
    }
};


/ JAVA ******************************************************************************************************************************************/
//Approach-1 (Using Binary Search on Answer)
//T.C : O(nlogn + n*log(max_force_diff))
//S.C : O(1)
public class Solution {
    public boolean possibleToPlace(int force, int[] position, int m) {
        int prev = position[0];
        int countBalls = 1;

        for (int i = 1; i < position.length; i++) {
            int curr = position[i];

            if (curr - prev >= force) {
                countBalls++;
                prev = curr;
            }

            if (countBalls == m) {
                break;
            }
        }

        return countBalls == m;
    }

    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);

        int minForce = 1;
        int maxForce = position[n - 1] - position[0]; // This value is the maximum possible distance

        int result = 0;
        while (minForce <= maxForce) {
            int midForce = minForce + (maxForce - minForce) / 2;

            if (possibleToPlace(midForce, position, m)) {
                result = midForce;
                minForce = midForce + 1;
            } else {
                maxForce = midForce - 1;
            }
        }

        return result;
    }
}

using System;
using System.Linq;

public class Solution {
    public int MaxDistance(int[] position, int m) {
        Array.Sort(position);
        
        bool CanPlaceBalls(int minDist) {
            int count = 1;
            int lastPlaced = position[0];
            
            for (int i = 1; i < position.Length; i++) {
                if (position[i] - lastPlaced >= minDist) {
                    count++;
                    lastPlaced = position[i];
                    if (count >= m) {
                        return true;
                    }
                }
            }
            return false;
        }
        
        int left = 1, right = position[position.Length - 1] - position[0];
        
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (CanPlaceBalls(mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        
        return left;
    }
}

/ C# ******************************************************************************************************************************************/
//Approach-1 (Using Binary Search on Answer)
//T.C : O(nlogD)
//S.C : O(1)
using System;
using System.Linq;

public class Solution {
    public int MaxDistance(int[] position, int m) {
        Array.Sort(position);
        
        bool CanPlaceBalls(int minDist) {
            int count = 1;
            int lastPlaced = position[0];
            
            for (int i = 1; i < position.Length; i++) {
                if (position[i] - lastPlaced >= minDist) {
                    count++;
                    lastPlaced = position[i];
                    if (count >= m) {
                        return true;
                    }
                }
            }
            return false;
        }
        
        int left = 1, right = position[position.Length - 1] - position[0];
        
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (CanPlaceBalls(mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        
        return left;
    }
}

// Example usage
public class Program {
    public static void Main() {
        Solution sol = new Solution();
        int[] position = {1, 2, 3, 4, 7};
        int m = 3;
        Console.WriteLine(sol.MaxDistance(position, m));  // Output: 3
    }
}
