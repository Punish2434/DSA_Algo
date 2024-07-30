/*         Scroll below to see JAVA code and C# also        */

    // Company Tags                : Amazon,Microsoft
    // Leetcode Link               : https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
// C++ ********************************************************************************************************************************************/
//Approach (Using Backtracking)
// TC:𝑂(3n^2)
// SC:𝑂(n2)
#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

class Solution {
public:
    std::vector<std::string> findPath(std::vector<std::vector<int>> &mat) {
        int n = mat.size();
        if (mat[0][0] == 0 || mat[n - 1][n - 1] == 0) {
            return {"-1"};
        }

        std::vector<std::string> paths;
        std::vector<std::vector<bool>> visited(n, std::vector<bool>(n, false));
        
        std::function<void(int, int, std::string)> backtrack = [&](int x, int y, std::string path) {
            if (x == n - 1 && y == n - 1) {
                paths.push_back(path);
                return;
            }

            visited[x][y] = true;
            
            const std::vector<std::tuple<int, int, char>> directions = {{1, 0, 'D'}, {0, 1, 'R'}, {-1, 0, 'U'}, {0, -1, 'L'}};
            for (auto [i, j, direction] : directions) {
                int nx = x + i, ny = y + j;
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && mat[nx][ny] == 1 && !visited[nx][ny]) {
                    backtrack(nx, ny, path + direction);
                }
            }

            visited[x][y] = false;
        };

        backtrack(0, 0, "");
        
        if (paths.empty()) {
            return {"-1"};
        }

        std::sort(paths.begin(), paths.end());
        return paths;
    }
};

// Example usage
int main() {
    Solution solution;
    std::vector<std::vector<int>> mat1 = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};
    auto result1 = solution.findPath(mat1);
    for (const auto &path : result1) {
        std::cout << path << " ";
    }
    std::cout << std::endl; // Output: DDRDRR DRDDRR

    std::vector<std::vector<int>> mat2 = {{1, 0}, {1, 0}};
    auto result2 = solution.findPath(mat2);
    for (const auto &path : result2) {
        std::cout << path << " ";
    }
    std::cout << std::endl; // Output: -1

    return 0;
}


// Java ********************************************************************************************************************************************/
//Approach (Using Backtracking)
// TC:𝑂(3n^2)
// SC:𝑂(n2)
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public ArrayList<String> findPath(int[][] mat) {
        ArrayList<String> paths = new ArrayList<>();
        int n = mat.length;

        // Check if the starting point is blocked
        if (mat[0][0] == 0 || mat[n - 1][n - 1] == 0) {
            paths.add("-1");
            return paths;
        }

        boolean[][] visited = new boolean[n][n];
        findPathsUtil(mat, 0, 0, n, "", paths, visited);

        if (paths.isEmpty()) {
            paths.add("-1");
        } else {
            Collections.sort(paths);
        }
        return paths;
    }

    private void findPathsUtil(int[][] mat, int i, int j, int n, String path, ArrayList<String> paths, boolean[][] visited) {
        // If destination is reached, add path to the list
        if (i == n - 1 && j == n - 1) {
            paths.add(path);
            return;
        }

        // Check boundary conditions and if the cell is blocked or already visited
        if (i < 0 || i >= n || j < 0 || j >= n || mat[i][j] == 0 || visited[i][j]) {
            return;
        }

        // Mark the cell as visited
        visited[i][j] = true;

        // Move Down
        findPathsUtil(mat, i + 1, j, n, path + "D", paths, visited);

        // Move Right
        findPathsUtil(mat, i, j + 1, n, path + "R", paths, visited);

        // Move Up
        findPathsUtil(mat, i - 1, j, n, path + "U", paths, visited);

        // Move Left
        findPathsUtil(mat, i, j - 1, n, path + "L", paths, visited);

        // Backtrack: unmark the cell as visited
        visited[i][j] = false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] mat1 = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}
        };
        System.out.println(solution.findPath(mat1)); // Output: [DDRDRR, DRDDRR]

        int[][] mat2 = {
            {1, 0},
            {1, 0}
        };
        System.out.println(solution.findPath(mat2)); // Output: [-1]
    }
}


// C# ********************************************************************************************************************************************/
//Approach (Using Backtracking)
// TC:𝑂(3n^2)
// SC:𝑂(n2)
using System;
using System.Collections.Generic;

public class Solution {
    public IList<string> FindPath(int[][] mat) {
        int n = mat.Length;
        if (mat[0][0] == 0 || mat[n - 1][n - 1] == 0) {
            return new List<string> { "-1" };
        }

        var paths = new List<string>();
        var visited = new bool[n, n];

        void Backtrack(int x, int y, string path) {
            if (x == n - 1 && y == n - 1) {
                paths.Add(path);
                return;
            }

            visited[x, y] = true;

            foreach (var (i, j, direction) in new (int, int, char)[] { (1, 0, 'D'), (0, 1, 'R'), (-1, 0, 'U'), (0, -1, 'L') }) {
                int nx = x + i, ny = y + j;
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && mat[nx][ny] == 1 && !visited[nx, ny]) {
                    Backtrack(nx, ny, path + direction);
                }
            }

            visited[x, y] = false;
        }

        Backtrack(0, 0, "");

        if (paths.Count == 0) {
            return new List<string> { "-1" };
        }

        paths.Sort();
        return paths;
    }
}

// Example usage
public class Program {
    public static void Main() {
        var solution = new Solution();

        int[][] mat1 = {
            new int[] { 1, 0, 0, 0 },
            new int[] { 1, 1, 0, 1 },
            new int[] { 1, 1, 0, 0 },
            new int[] { 0, 1, 1, 1 }
        };
        Console.WriteLine(string.Join(" ", solution.FindPath(mat1))); // Output: DDRDRR DRDDRR

        int[][] mat2 = {
            new int[] { 1, 0 },
            new int[] { 1, 0 }
        };
        Console.WriteLine(string.Join(" ", solution.FindPath(mat2))); // Output: -1
    }
}
