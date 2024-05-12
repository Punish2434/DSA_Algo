/*     Scroll below to see JAVA code and C# also    */
/*
    Company Tags                :
    Leetcode Link               : https://leetcode.com/problems/largest-local-values-in-a-matrix
*/
/ C++ ***************************************************************************************************************************************/

class Solution {
    int minSteps(int d) {
        // code here
        int temp=0,ans=0;
        while(temp<d){
            ans++;
            temp+=ans;
        }
        if(temp==d)return ans;
        int diff=temp-d;
        if(diff%2==0)return ans;
        return ans%2==0?ans+1:ans+2;
    }
}
/ Java ***************************************************************************************************************************************/

//Approach1
class Solution {
    static int minSteps(int d) {
        // code here
        int temp=0,ans=0;
        while(temp<d){
            ans++;
            temp+=ans;
        }
        if(temp==d)return ans;
        int diff = temp-d;
        if(diff%2==0)return ans;
        return ans%2==0?ans+1:ans+2;
    }
}
// Time Complexity:- O(d)
// Space Complexity:- O(1)
//Approach2
class Solution {
   static int minSteps(int d) {
        // Take the absolute value of the destination
        d = Math.abs(d);

        // Initialize the sum and steps
        int sum = 0;
        int steps = 0;

        // Keep adding steps until the sum is greater than or equal to the destination
        while (sum < d || (sum - d) % 2 != 0) {
            steps++;
            sum += steps;
        }

        return steps;
    }
}

/ C# ***************************************************************************************************************************************/
//Approach1
using System;

public class Solution
{
    public static int MinSteps(int d)
    {
        int temp = 0;
        int ans = 0;
        while (temp < d)
        {
            ans++;
            temp += ans;
        }
        if (temp == d)
            return ans;
        int diff = temp - d;
        if (diff % 2 == 0)
            return ans;
        return ans % 2 == 0 ? ans + 1 : ans + 2;
    }
}

//Approach2
using System;

public class Solution
{
    public static int MinSteps(int d)
    {
        // Take the absolute value of the destination
        d = Math.Abs(d);

        // Initialize the sum and steps
        int sum = 0;
        int steps = 0;

        // Keep adding steps until the sum is greater than or equal to the destination
        while (sum < d || (sum - d) % 2 != 0)
        {
            steps++;
            sum += steps;
        }

        return steps;
    }
}


