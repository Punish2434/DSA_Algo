/*     Scroll below to see JAVA and C# code  also   */
/*
    Company Tags                : ADOBE
    Leetcode Link               : https://leetcode.com/problems/maximum-total-importance-of-roads
*/


/ C++ **********************************************************************************************************************************************************/
//Approach (using degree and assiging value greedily)
//T.C : O(E + nlogn)
class Solution {
public:
    long long maximumImportance(int n, vector<vector<int>>& roads) {
        //n = total number of nodes numbered from 0 to n-1

        vector<int> degree(n, 0);

        for(auto &vec : roads) {
            int u = vec[0];
            int v = vec[1];

            degree[u]++;
            degree[v]++;
        }

        sort(begin(degree), end(degree)); //ascedning order

        long long value = 1;
        long long sum   = 0;

        for(int i = 0; i < n; i++) {
            sum += (degree[i] * value);
            value++;
        }

        return sum;
    }
};


/ JAVA **********************************************************************************************************************************************************/
//Approach (using degree and assiging value greedily)
//T.C : O(E + nlogn)
//S.C : O(n)
class Solution {
    public long maximumImportance(int n, int[][] roads) {
        // n = total number of nodes numbered from 0 to n-1

        int[] degree = new int[n];

        // Calculate the degree of each node
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];

            degree[u]++;
            degree[v]++;
        }

        // Sort the degrees in ascending order
        Arrays.sort(degree);

        long value = 1;
        long sum = 0;

        // Calculate the sum of degrees multiplied by their corresponding values
        for (int i = 0; i < n; i++) {
            sum += (degree[i] * value);
            value++;
        }

        return sum;
    }
}

/ C# **********************************************************************************************************************************************************/
//Approach (using degree and assiging value greedily)
//T.C : O(E + nlogn)
//S.C : O(n)
using System;
using System.Linq;

public class Solution {
    public long MaximumImportance(int n, int[][] roads) {
        // n = total number of nodes numbered from 0 to n-1

        int[] degree = new int[n];

        // Calculate the degree of each node
        foreach (int[] road in roads) {
            int u = road[0];
            int v = road[1];

            degree[u]++;
            degree[v]++;
        }

        // Sort the degrees in ascending order
        Array.Sort(degree);

        long value = 1;
        long sum = 0;

        // Calculate the sum of degrees multiplied by their corresponding values
        for (int i = 0; i < n; i++) {
            sum += (degree[i] * value);
            value++;
        }

        return sum;
    }

    public static void Main(string[] args) {
        Solution sol = new Solution();
        
        int n = 5;
        int[][] roads = new int[][] {
            new int[] {0, 1},
            new int[] {1, 2},
            new int[] {2, 3},
            new int[] {0, 2},
            new int[] {3, 4}
        };
        
        long result = sol.MaximumImportance(n, roads);
        Console.WriteLine(result);  // Output: 43
    }
}

