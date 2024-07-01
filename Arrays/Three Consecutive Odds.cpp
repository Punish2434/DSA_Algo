/*    Scroll below to see JAVA code and C#  also  */
/*
    Company Tags                : 
    Leetcode Link               : https://leetcode.com/problems/three-consecutive-odds/
*/

/ C++ **************************************************************************************************************************/
//T.C : O(n)
//S.C : O(1)

class Solution {
public:
    bool threeConsecutiveOdds(vector<int>& arr) {
        int count = 0;
        
        for (int num : arr) {
            if (num % 2 != 0) {
                count++;
                if (count == 3) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        
        return false;
    }
};




/ Java **************************************************************************************************************************/
//T.C : O(n)
//S.C : O(1)

class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        
        for (int num : arr) {
            if (num % 2 != 0) {
                count++;
                if (count == 3) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        
        return false;
    }
}




/ C# **************************************************************************************************************************/
//T.C : O(n)
//S.C : O(1)

public class Solution {
    public bool ThreeConsecutiveOdds(int[] arr) {
        int count = 0;
        
        foreach (int num in arr) {
            if (num % 2 != 0) {
                count++;
                if (count == 3) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        
        return false;
    }
}
