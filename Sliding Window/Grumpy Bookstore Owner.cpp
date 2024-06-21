/*     Scroll below to see JAVA code also    */
/*
    Company Tags                : will soon update
    Leetcode Link               : https://leetcode.com/problems/grumpy-bookstore-owner
*/


/ C++ ***********************************************************************************************************************************************/
//Approach - Sliding Window
//T.C : O(n)
//S.C : O(1)
class Solution {
public:
    int maxSatisfied(vector<int>& customers, vector<int>& grumpy, int minutes) {
        int n = customers.size();
        int unsat = 0;

        // Calculate initial unsatisfied customers in the first 'minutes' window
        for (int i = 0; i < minutes; i++) {
            unsat += customers[i] * grumpy[i];
        }

        int maxUnsat = unsat;

        // Use two pointers i and j to define the sliding window of size 'minutes'
        int i = 0;
        int j = minutes;

        while(j < n) {
            unsat += customers[j] * grumpy[j];             // Include current element
            unsat -= customers[i] * grumpy[i];             // Remove element going out of window
            
            maxUnsat = max(maxUnsat, unsat);               // Update maxUnsat
            i++;
            j++;
        }

        int totalCustomers = maxUnsat;

        // Calculate total satisfied customers
        for (int i = 0; i < n; i++) {
            totalCustomers += customers[i] * (1 - grumpy[i]);
        }

        return totalCustomers;
    }
};



/ JAVA ***********************************************************************************************************************************************/
//Approach - Sliding Window
//T.C : O(n)
//S.C : O(1)
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int unsat = 0;

        // Calculate initial unsatisfied customers in the first 'minutes' window
        for (int i = 0; i < minutes; i++) {
            unsat += customers[i] * grumpy[i];
        }

        int maxUnsat = unsat;

        // Use two pointers i and j to define the sliding window of size 'minutes'
        int i = 0;
        int j = minutes;

        while (j < n) {
            unsat += customers[j] * grumpy[j];  // Include current element
            unsat -= customers[i] * grumpy[i];  // Remove element going out of window
            
            maxUnsat = Math.max(maxUnsat, unsat);  // Update maxUnsat
            i++;
            j++;
        }

        int totalCustomers = maxUnsat;

        // Calculate total satisfied customers
        for (int k = 0; k < n; k++) {
            totalCustomers += customers[k] * (1 - grumpy[k]);
        }

        return totalCustomers;
    }
}

/ C# ***********************************************************************************************************************************************/
//Approach - Sliding Window
//T.C : O(n)
//S.C : O(1)

public class Solution {
    public int MaxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.Length;
        int totalSatisfied = 0;
        
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                totalSatisfied += customers[i];
            }
        }
        
        int additionalSatisfied = 0;
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                additionalSatisfied += customers[i];
            }
        }
        
        int maxAdditionalSatisfied = additionalSatisfied;
        
        for (int i = minutes; i < n; i++) {
            if (grumpy[i - minutes] == 1) {
                additionalSatisfied -= customers[i - minutes];
            }
            if (grumpy[i] == 1) {
                additionalSatisfied += customers[i];
            }
            maxAdditionalSatisfied = Math.Max(maxAdditionalSatisfied, additionalSatisfied);
        }
        
        return totalSatisfied + maxAdditionalSatisfied;
    }
}


