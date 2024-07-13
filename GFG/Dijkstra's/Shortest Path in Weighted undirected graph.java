
/*     Scroll below to see JAVA Code and C# also    */
/*
      Company Tags                : 
      Leetcode Link               : https://leetcode.com/problems/robot-collisions/description
*/


/ C++ *******************************************************************************************************************************************************/
//Using Dijkstra's algorithm
//T.C :  O(m* log(n))
//T.C : O(n+m)

#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<int> shortestPath(int n, int m, vector<vector<int>>& edges) {
        vector<vector<pair<int, int>>> graph(n + 1);
        for (const auto& edge : edges) {
            int a = edge[0], b = edge[1], w = edge[2];
            graph[a].emplace_back(b, w);
            graph[b].emplace_back(a, w);
        }

        vector<int> dist(n + 1, INT_MAX);
        dist[1] = 0;
        vector<int> prev(n + 1, -1);
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        pq.emplace(0, 1);

        while (!pq.empty()) {
            int d = pq.top().first, u = pq.top().second;
            pq.pop();
            if (d > dist[u]) continue;
            for (const auto& neighbor : graph[u]) {
                int v = neighbor.first, weight = neighbor.second;
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    prev[v] = u;
                    pq.emplace(dist[v], v);
                }
            }
        }

        if (dist[n] == INT_MAX) {
            return {-1};
        }

        vector<int> path;
        for (int at = n; at != -1; at = prev[at]) {
            path.push_back(at);
        }
        reverse(path.begin(), path.end());
        path.insert(path.begin(), dist[n]);

        return path;
    }
};

int main() {
    Solution sol;
    vector<vector<int>> edges1 = {{1, 2, 2}, {2, 5, 5}, {2, 3, 4}, {1, 4, 1}, {4, 3, 3}, {3, 5, 1}};
    vector<int> result1 = sol.shortestPath(5, 6, edges1);
    for (int num : result1) cout << num << " ";
    cout << endl;  // Output: 5 1 4 3 5

    vector<vector<int>> edges2 = {{1, 2, 2}};
    vector<int> result2 = sol.shortestPath(2, 1, edges2);
    for (int num : result2) cout << num << " ";
    cout << endl;  // Output: 2 1 2

    vector<vector<int>> edges3 = {};
    vector<int> result3 = sol.shortestPath(2, 0, edges3);
    for (int num : result3) cout << num << " ";
    cout << endl;  // Output: -1

    return 0;
}

/ Java *******************************************************************************************************************************************************/
//Using Dijkstra's algorithm
//T.C :  O(m* log(n))
//T.C : O(n+m)
class Solution {
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        // Create an adjacency list for the graph
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Populate the adjacency list with the given edges
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1], w = edge[2];
            graph[a].add(new int[]{b, w});
            graph[b].add(new int[]{a, w});
        }

        // Dijkstra's algorithm to find the shortest path from node 1 to node n
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{1, 0});
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        int[] prev = new int[n + 1];
        Arrays.fill(prev, -1);

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0];
            int d = current[1];

            if (d > dist[u]) continue;

            for (int[] neighbor : graph[u]) {
                int v = neighbor[0];
                int weight = neighbor[1];
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    prev[v] = u;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }

        // If there's no path from 1 to n
        if (dist[n] == Integer.MAX_VALUE) {
            return Collections.singletonList(-1);
        }

        // Reconstruct the path
        List<Integer> path = new LinkedList<>();
        for (int at = n; at != -1; at = prev[at]) {
            path.add(0, at);
        }
        path.add(0, dist[n]);

        return path;
    }
}

/ C# *******************************************************************************************************************************************************/
//Using Dijkstra's algorithm
//T.C :  O(m* log(n))
//T.C : O(n+m)

using System;
using System.Collections.Generic;

class Solution {
    public List<int> ShortestPath(int n, int m, int[][] edges) {
        List<int[]>[] graph = new List<int[]>[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new List<int[]>();
        }

        foreach (var edge in edges) {
            int a = edge[0], b = edge[1], w = edge[2];
            graph[a].Add(new int[] { b, w });
            graph[b].Add(new int[] { a, w });
        }

        int[] dist = new int[n + 1];
        Array.Fill(dist, int.MaxValue);
        dist[1] = 0;
        int[] prev = new int[n + 1];
        Array.Fill(prev, -1);

        SortedSet<(int dist, int node)> pq = new SortedSet<(int dist, int node)>();
        pq.Add((0, 1));

        while (pq.Count > 0) {
            var (d, u) = pq.Min;
            pq.Remove(pq.Min);

            if (d > dist[u]) continue;

            foreach (var neighbor in graph[u]) {
                int v = neighbor[0];
                int weight = neighbor[1];
                if (dist[u] + weight < dist[v]) {
                    pq.Remove((dist[v], v));
                    dist[v] = dist[u] + weight;
                    prev[v] = u;
                    pq.Add((dist[v], v));
                }
            }
        }

        if (dist[n] == int.MaxValue) {
            return new List<int> { -1 };
        }

        List<int> path = new List<int>();
        for (int at = n; at != -1; at = prev[at]) {
            path.Insert(0, at);
        }
        path.Insert(0, dist[n]);

        return path;
    }
}

class Program {
    static void Main() {
        Solution sol = new Solution();

        int n1 = 5;
        int m1 = 6;
        int[][] edges1 = {
            new int[] { 1, 2, 2 }, new int[] { 2, 5, 5 }, new int[] { 2, 3, 4 }, 
            new int[] { 1, 4, 1 }, new int[] { 4, 3, 3 }, new int[] { 3, 5, 1 }
        };
        PrintPath(sol.ShortestPath(n1, m1, edges1)); // Output: 5 1 4 3 5

        int n2 = 2;
        int m2 = 1;
        int[][] edges2 = { new int[] { 1, 2, 2 } };
        PrintPath(sol.ShortestPath(n2, m2, edges2)); // Output: 2 1 2

        int n3 = 2;
        int m3 = 0;
        int[][] edges3 = { };
        PrintPath(sol.ShortestPath(n3, m3, edges3)); // Output: -1
    }

    static void PrintPath(List<int> path) {
        foreach (var node in path) {
            Console.Write(node + " ");
        }
        Console.WriteLine();
    }
}

/ JavaScript *******************************************************************************************************************************************************/
//Using Dijkstra's algorithm
//T.C :  O(m* log(n))
//T.C : O(n+m)
class Solution {
    shortestPath(n, m, edges) {
        const graph = Array.from({ length: n + 1 }, () => []);
        for (const [a, b, w] of edges) {
            graph[a].push([b, w]);
            graph[b].push([a, w]);
        }

        const dist = Array(n + 1).fill(Infinity);
        dist[1] = 0;
        const prev = Array(n + 1).fill(-1);
        const pq = new MinPriorityQueue({ priority: x => x[1] });
        pq.enqueue([1, 0]);

        while (!pq.isEmpty()) {
            const [u, d] = pq.dequeue().element;
            if (d > dist[u]) continue;
            for (const [v, weight] of graph[u]) {
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    prev[v] = u;
                    pq.enqueue([v, dist[v]]);
                }
            }
        }

        if (dist[n] === Infinity) {
            return [-1];
        }

        const path = [];
        for (let at = n; at !== -1; at = prev[at]) {
            path.push(at);
        }
        path.reverse();
        path.unshift(dist[n]);

        return path;
    }
}

// Example usage
const sol = new Solution();
console.log(sol.shortestPath(5, 6, [[1, 2, 2], [2, 5, 5], [2, 3, 4], [1, 4, 1], [4, 3, 3], [3, 5, 1]])); // Output: [5, 1, 4, 3, 5]
console.log(sol.shortestPath(2, 1, [[1, 2, 2]])); // Output: [2, 1, 2]
console.log(sol.shortestPath(2, 0, [])); // Output: [-1]
