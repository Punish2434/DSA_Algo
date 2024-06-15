/*     Scroll below to see JAVA code and C# also    */
/*
    Company Tags                : MICROSOFT
    Leetcode Link               : https://leetcode.com/problems/ipo/description/
*/


/ C++ ************************************************************************************************************************/
//Using heap and greedily picking up projects
//T.C : O(nlogn)
//S.C : O(n)
class Solution {
public:
    int findMaximizedCapital(int k, int paissa, vector<int>& profits, vector<int>& capital) {
        int n = profits.size();
        
        vector<pair<int, int>> vec(n);
        
        for (int i = 0; i < n; i++) {
            vec[i] = {capital[i], profits[i]};
        }

        sort(vec.begin(), vec.end());

        int i = 0;

        priority_queue<int> pq;

        while (k--) {
            while (i < n && vec[i].first <= paissa) {
                pq.push(vec[i].second);
                i++;
            }
            if (pq.empty())
                break;
            paissa += pq.top();
            pq.pop();
        }
        return paissa;
    }
};


/ JAVA ************************************************************************************************************************/
//Using heap and greedily picking up projects
//T.C : O(nlogn)
//S.C : O(n)
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;

        List<int[]> projects = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            projects.add(new int[]{capital[i], profits[i]});
        }

        projects.sort(Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>(Collections.reverseOrder());

        int i = 0;

        while (k-- > 0) {
            while (i < n && projects.get(i)[0] <= w) {
                maxProfitHeap.add(projects.get(i)[1]);
                i++;
            }
            if (maxProfitHeap.isEmpty()) {
                break;
            }
            w += maxProfitHeap.poll();
        }
        return w;
    }
}
/ C# ************************************************************************************************************************/
using System;
using System.Collections.Generic;

public class Solution
{
    public int FindMaximizedCapital(int k, int w, int[] profits, int[] capital)
    {
        // Step 1: Create a list of projects with their capital and profits
        int n = profits.Length;
        Project[] projects = new Project[n];
        for (int i = 0; i < n; i++)
        {
            projects[i] = new Project(capital[i], profits[i]);
        }
        
        // Step 2: Sort the projects by their capital requirement
        Array.Sort(projects, (p1, p2) => p1.Capital.CompareTo(p2.Capital));
        
        // Step 3: Use a max-heap to store the profits of projects we can afford
        SortedSet<(int Profit, int Index)> maxHeap = new SortedSet<(int Profit, int Index)>(Comparer<(int Profit, int Index)>.Create((x, y) =>
        {
            int result = y.Profit.CompareTo(x.Profit);
            return result == 0 ? x.Index.CompareTo(y.Index) : result;
        }));
        
        // Step 4: Use a pointer to iterate over the sorted projects
        int currentProjectIndex = 0;
        
        for (int i = 0; i < k; i++)
        {
            // Step 5: Add all projects that can be started with the current capital to the max-heap
            while (currentProjectIndex < n && projects[currentProjectIndex].Capital <= w)
            {
                maxHeap.Add((projects[currentProjectIndex].Profit, currentProjectIndex));
                currentProjectIndex++;
            }
            
            // Step 6: If we cannot start any project, break the loop
            if (maxHeap.Count == 0)
            {
                break;
            }
            
            // Step 7: Select the project with the maximum profit
            var maxProfitProject = maxHeap.Min;
            maxHeap.Remove(maxProfitProject);
            w += maxProfitProject.Profit;
        }
        
        return w;
    }
    
    // Helper class to store project information
    private class Project
    {
        public int Capital { get; }
        public int Profit { get; }
        
        public Project(int capital, int profit)
        {
            Capital = capital;
            Profit = profit;
        }
    }
}
