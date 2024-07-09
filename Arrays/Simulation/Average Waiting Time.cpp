/*     Scroll below to see JAVA code and C# also    */
/*
      Company Tags                : 
      Leetcode Link               : https://leetcode.com/problems/average-waiting-time/description
*/


/ C++ ******************************************************************************************************************************/
//Simple Simulation
//T.C : O(n)
//S.C : O(1)
class Solution {
public:
    double averageWaitingTime(vector<vector<int>>& customers) {
        int n = customers.size();

        double totalWaitTime = 0;
        int currTime         = 0;

        for(auto &vec : customers) {
            int arrivalTime = vec[0];
            int cookTime   = vec[1];

            if(currTime < arrivalTime) {
                currTime = arrivalTime;
            }

            int waitTime = currTime + cookTime - arrivalTime;

            totalWaitTime += waitTime;

            currTime += cookTime;
        }

        return totalWaitTime/n;
    }
};



/ JAVA ******************************************************************************************************************************/
//Simple Simulation
//T.C : O(n)
//S.C : O(1)
class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;

        double totalWaitTime = 0;
        int currTime = 0;

        for (int[] customer : customers) {
            int arrivalTime = customer[0];
            int cookTime = customer[1];

            if (currTime < arrivalTime) {
                currTime = arrivalTime;
            }

            int waitTime = currTime + cookTime - arrivalTime;

            totalWaitTime += waitTime;

            currTime += cookTime;
        }

        return totalWaitTime / n;
    }
}
/ C# ******************************************************************************************************************************/
//Math function
//T.C : O(n)
//S.C : O(1)
public class Solution {
    public double AverageWaitingTime(int[][] customers) {
        int n = customers.Length;
        long totalWaitingTime = 0;
        long currentTime = 0;

        foreach (var customer in customers) {
            int arrivalTime = customer[0];
            int cookingTime = customer[1];

            currentTime = Math.Max(currentTime, arrivalTime) + cookingTime;
            totalWaitingTime += (currentTime - arrivalTime);
        }

        return (double)totalWaitingTime / n;
    }
}
/ JavaScript ******************************************************************************************************************************/
//Math function
//T.C : O(n)
//S.C : O(1)

var averageWaitingTime = function(customers) {
    let totalWaitingTime = 0;
    let currentTime = 0;

    for (let [arrivalTime, cookingTime] of customers) {
        currentTime = Math.max(currentTime, arrivalTime) + cookingTime;
        totalWaitingTime += (currentTime - arrivalTime);
    }

    return totalWaitingTime / customers.length;
};
