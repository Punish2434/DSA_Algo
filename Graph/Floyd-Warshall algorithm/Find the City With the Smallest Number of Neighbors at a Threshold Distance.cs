/*         Scroll below to see JAVA code and C# also        */

    // Company Tags                : Amazon, Microsoft
    // Leetcode Link               : https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
// C++ ********************************************************************************************************************************************/
//Approach (using Floyd-Warshall algorithm)
// Time Complexity: O(n^3) due to the Floyd-Warshall algorithm
// Space Complexity: O(n^2) for the distance matrix
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    int findTheCity(int n, vector<vector<int>>& edges, int distanceThreshold) {
        const int INF = 1000000000;
        vector<vector<int>> dist(n, vector<int>(n, INF));
        
        for (int i = 0; i < n; ++i) {
            dist[i][i] = 0;
        }
        
        for (const auto& edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            dist[from][to] = weight;
            dist[to][from] = weight;
        }
        
        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        
        int minReachableCities = n;
        int cityWithMinReachableCities = -1;
        
        for (int i = 0; i < n; ++i) {
            int reachableCities = 0;
            for (int j = 0; j < n; ++j) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    ++reachableCities;
                }
            }
            if (reachableCities < minReachableCities || 
                (reachableCities == minReachableCities && i > cityWithMinReachableCities)) {
                minReachableCities = reachableCities;
                cityWithMinReachableCities = i;
            }
        }
        
        return cityWithMinReachableCities;
    }
};
// Java ********************************************************************************************************************************************/
//Approach (using Floyd-Warshall algorithm)
// Time Complexity: O(n^3) due to the Floyd-Warshall algorithm
// Space Complexity: O(n^2) for the distance matrix
public class Solution {
    public int FindTheCity(int n, int[][] edges, int distanceThreshold) {
        // Initialize the distance matrix with a large value
        int[][] dist = new int[n][n];
        int INF = 1000000000; // A large number representing infinity

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = INF;
                }
            }
        }

        // Fill the distance matrix with the given edges
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            dist[from][to] = weight;
            dist[to][from] = weight;
        }

        // Floyd-Warshall algorithm to find shortest paths between all pairs of cities
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Find the city with the smallest number of reachable cities within distanceThreshold
        int minReachableCities = n;
        int cityWithMinReachableCities = -1;

        for (int i = 0; i < n; i++) {
            int reachableCities = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    reachableCities++;
                }
            }
            if (reachableCities < minReachableCities || 
                (reachableCities == minReachableCities && i > cityWithMinReachableCities)) {
                minReachableCities = reachableCities;
                cityWithMinReachableCities = i;
            }
        }

        return cityWithMinReachableCities;
    }
}


// C# ********************************************************************************************************************************************/
//Approach (using Floyd-Warshall algorithm)
// Time Complexity: O(n^3) due to the Floyd-Warshall algorithm
// Space Complexity: O(n^2) for the distance matrix
public class Solution {
    public int FindTheCity(int n, int[][] edges, int distanceThreshold) {
        int INF = 1000000000;
        int[,] dist = new int[n, n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    dist[i, j] = 0;
                } else {
                    dist[i, j] = INF;
                }
            }
        }
        
        foreach (var edge in edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            dist[from, to] = weight;
            dist[to, from] = weight;
        }
        
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i, k] + dist[k, j] < dist[i, j]) {
                        dist[i, j] = dist[i, k] + dist[k, j];
                    }
                }
            }
        }
        
        int minReachableCities = n;
        int cityWithMinReachableCities = -1;
        
        for (int i = 0; i < n; i++) {
            int reachableCities = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i, j] <= distanceThreshold) {
                    reachableCities++;
                }
            }
            if (reachableCities < minReachableCities || 
                (reachableCities == minReachableCities && i > cityWithMinReachableCities)) {
                minReachableCities = reachableCities;
                cityWithMinReachableCities = i;
            }
        }
        
        return cityWithMinReachableCities;
    }
}



