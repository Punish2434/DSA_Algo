/*         Scroll below to see JAVA code and C# also        */

    // Company Tags                : 
    // Leetcode Link               : https://leetcode.com/problems/second-minimum-time-to-reach-destination/
// C++ ********************************************************************************************************************************************/
//Approach-1 (Using  Dijkstra's algorithm to find the shortest and the second shortest path)
// TC:𝑂((𝐸+𝑉)log⁡𝑉)
// SC:𝑂(𝐸+𝑉)

#include <vector>
#include <queue>
#include <climits>
#include <iostream>
using namespace std;

class Solution {
public:
    int secondMinimum(int n, vector<vector<int>>& edges, int time, int change) {
        vector<vector<int>> graph(n + 1);
        for (const auto& edge : edges) {
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
        }
        
        vector<vector<int>> dist(n + 1, vector<int>(2, INT_MAX));
        dist[1][0] = 0;
        
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        pq.push({0, 1});
        
        while (!pq.empty()) {
            auto [currTime, u] = pq.top(); pq.pop();
            
            for (int v : graph[u]) {
                int waitTime = 0;
                if ((currTime / change) % 2 == 1) {
                    waitTime = change - (currTime % change);
                }
                int newTime = currTime + waitTime + time;
                
                if (newTime < dist[v][0]) {
                    dist[v][1] = dist[v][0];
                    dist[v][0] = newTime;
                    pq.push({newTime, v});
                } else if (newTime > dist[v][0] && newTime < dist[v][1]) {
                    dist[v][1] = newTime;
                    pq.push({newTime, v});
                }
            }
        }
        
        return dist[n][1];
    }
};

int main() {
    Solution sol;
    vector<vector<int>> edges1 = {{1, 2}, {1, 3}, {1, 4}, {3, 4}, {4, 5}};
    cout << sol.secondMinimum(5, edges1, 3, 5) << endl; // Output: 13
    
    vector<vector<int>> edges2 = {{1, 2}};
    cout << sol.secondMinimum(2, edges2, 3, 2) << endl; // Output: 11
    
    return 0;
}

// Java ********************************************************************************************************************************************/
//Approach-1 (Using  Dijkstra's algorithm to find the shortest and the second shortest path)
// TC:𝑂((𝐸+𝑉)log⁡𝑉)
// SC:𝑂(𝐸+𝑉)

class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        // Create adjacency list for the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        // Initialize distances with large values
        int[][] dist = new int[n + 1][2];
        for (int i = 0; i <= n; i++) {
            dist[i][0] = Integer.MAX_VALUE;
            dist[i][1] = Integer.MAX_VALUE;
        }
        
        // Priority queue to store (time, vertex) pairs
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 1});
        dist[1][0] = 0;
        
        // Dijkstra's algorithm with tracking of the second minimum distance
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currTime = current[0];
            int u = current[1];
            
            for (int v : graph.get(u)) {
                int waitTime = 0;
                if ((currTime / change) % 2 == 1) {
                    waitTime = change - (currTime % change);
                }
                int newTime = currTime + waitTime + time;
                
                if (newTime < dist[v][0]) {
                    dist[v][1] = dist[v][0];
                    dist[v][0] = newTime;
                    pq.offer(new int[]{newTime, v});
                } else if (newTime > dist[v][0] && newTime < dist[v][1]) {
                    dist[v][1] = newTime;
                    pq.offer(new int[]{newTime, v});
                }
            }
        }
        
        return dist[n][1];
    }
}
// C# ********************************************************************************************************************************************/
//Approach-1 (Using  Dijkstra's algorithm to find the shortest and the second shortest path)
// TC:𝑂((𝐸+𝑉)log⁡𝑉)
// SC:𝑂(𝐸+𝑉)
public class Solution {
    public int SecondMinimum(int n, int[][] edges, int time, int change) {
        // Create adjacency list for the graph
        List<int>[] graph = new List<int>[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new List<int>();
        }
        foreach (var edge in edges) {
            graph[edge[0]].Add(edge[1]);
            graph[edge[1]].Add(edge[0]);
        }
        
        // Initialize distances with large values
        int[,] dist = new int[n + 1, 2];
        for (int i = 0; i <= n; i++) {
            dist[i, 0] = int.MaxValue;
            dist[i, 1] = int.MaxValue;
        }
        
        // Priority queue to store (time, vertex) pairs
        var pq = new SortedSet<(int time, int vertex)>();
        pq.Add((0, 1));
        dist[1, 0] = 0;
        
        // Dijkstra's algorithm with tracking of the second minimum distance
        while (pq.Count > 0) {
            var current = pq.Min;
            pq.Remove(current);
            int currTime = current.time;
            int u = current.vertex;
            
            foreach (int v in graph[u]) {
                int waitTime = 0;
                if ((currTime / change) % 2 == 1) {
                    waitTime = change - (currTime % change);
                }
                int newTime = currTime + waitTime + time;
                
                if (newTime < dist[v, 0]) {
                    dist[v, 1] = dist[v, 0];
                    dist[v, 0] = newTime;
                    pq.Add((newTime, v));
                } else if (newTime > dist[v, 0] && newTime < dist[v, 1]) {
                    dist[v, 1] = newTime;
                    pq.Add((newTime, v));
                }
            }
        }
        
        return dist[n, 1];
    }
}


