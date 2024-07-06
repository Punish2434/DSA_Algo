/*     Scroll below to see JAVA code and C#  also    */
/*
    Company Tags                : Microsoft
    Leetcode Link               : https://leetcode.com/problems/pass-the-pillow/description/
*/


/ C++ ***********************************************************************************************************************/
//Approach-1 (Simple Simulation)
//T.C : O(time)
//S.C : O(1)
class Solution {
public:
    int passThePillow(int n, int time) {
        int idx  = 1;
        int dir  = 1;

        while(time > 0) {
            if(idx + dir >=1 && idx + dir <= n) {
                idx += dir;
                time--;
            } else {
                dir *= -1;
            }
        }
        return idx;
    }
};



//Approach-2 (Simple Maths)
//T.C : O(1)
//S.C : O(1)
class Solution {
public:
    int passThePillow(int n, int time) {
        
        int totalFullRounds = time / (n-1);

        int timeLeft        = time % (n-1);

        if(totalFullRounds % 2 == 0) {
            return timeLeft + 1;
        } else {
            return n - timeLeft;
        }

        return -1;
    }
};


/ JAVA ************************************************************************************************************************/
//Approach-1 (Simple Simulation)
// T.C : O(time)
// S.C : O(1)
class Solution {
    public int passThePillow(int n, int time) {
        int idx = 1;
        int dir = 1;

        while (time > 0) {
            if (idx + dir >= 1 && idx + dir <= n) {
                idx += dir;
                time--;
            } else {
                dir *= -1;
            }
        }
        return idx;
    }
}


//Approach-2 (Simple Maths)
// T.C : O(1)
// S.C : O(1)
class Solution {
    public int passThePillow(int n, int time) {
        int totalFullRounds = time / (n - 1);
        int timeLeft = time % (n - 1);

        if (totalFullRounds % 2 == 0) {
            return timeLeft + 1;
        } else {
            return n - timeLeft;
        }
    }
}
/ C# ************************************************************************************************************************/

// T.C : O(time)
// S.C : O(1)
  
  using System;

public class Solution {
    public int PassThePillow(int n, int time) {
        int position = 1;
        bool forward = true;

        for (int i = 0; i < time; i++) {
            if (forward) {
                position++;
                if (position == n) {
                    forward = false;
                }
            } else {
                position--;
                if (position == 1) {
                    forward = true;
                }
            }
        }

        return position;
    }
}

public class Program {
    public static void Main() {
        Solution solution = new Solution();
        Console.WriteLine(solution.PassThePillow(4, 5));  // Output: 2
        Console.WriteLine(solution.PassThePillow(3, 2));  // Output: 3
    }
}
