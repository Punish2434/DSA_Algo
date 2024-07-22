/*         Scroll below to see JAVA code and C# also        */

    // Company Tags                : Adobe, Apple, Infosys
    // Leetcode Link               : https://leetcode.com/problems/sort-the-people/
// C++ ********************************************************************************************************************************************/
//Approach (using )
//T.C : O(nlogn)
//S.C : O(n) 
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    vector<string> sortPeople(vector<string>& names, vector<int>& heights) {
        vector<pair<int, string>> people;
        for (int i = 0; i < names.size(); i++) {
            people.push_back({heights[i], names[i]});
        }
        sort(people.begin(), people.end(), greater<>());
        vector<string> sortedNames;
        for (auto& person : people) {
            sortedNames.push_back(person.second);
        }
        return sortedNames;
    }
};

// Example usage
int main() {
    Solution solution;
    vector<string> names = {"Mary", "John", "Emma"};
    vector<int> heights = {180, 165, 170};
    vector<string> result = solution.sortPeople(names, heights);
    for (string name : result) {
        cout << name << " ";
    }  // Output: Mary Emma John
    return 0;
}
// Java ********************************************************************************************************************************************/
//Approach (using Comparator )
//T.C : O(nlogn)
//S.C : O(n)
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Person[] people = new Person[n];
        
        // Create an array of Person objects
        for (int i = 0; i < n; i++) {
            people[i] = new Person(names[i], heights[i]);
        }
        
        // Sort the array of Person objects based on height in descending order
        Arrays.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person a, Person b) {
                return b.height - a.height; // descending order
            }
        });
        
        // Extract the sorted names
        String[] sortedNames = new String[n];
        for (int i = 0; i < n; i++) {
            sortedNames[i] = people[i].name;
        }
        
        return sortedNames;
    }
    
    class Person {
        String name;
        int height;
        
        Person(String name, int height) {
            this.name = name;
            this.height = height;
        }
    }
}
// C# ********************************************************************************************************************************************/
//Approach (using CompareTo )
//T.C : O(nlogn)
//S.C : O(n)
using System;
using System.Collections.Generic;

public class Solution {
    public string[] SortPeople(string[] names, int[] heights) {
        var people = new List<(int, string)>();
        for (int i = 0; i < names.Length; i++) {
            people.Add((heights[i], names[i]));
        }
        people.Sort((a, b) => b.Item1.CompareTo(a.Item1));
        string[] sortedNames = new string[names.Length];
        for (int i = 0; i < people.Count; i++) {
            sortedNames[i] = people[i].Item2;
        }
        return sortedNames;
    }
}

// Example usage
public class Program {
    public static void Main() {
        Solution solution = new Solution();
        string[] names = {"Mary", "John", "Emma"};
        int[] heights = {180, 165, 170};
        string[] result = solution.SortPeople(names, heights);
        Console.WriteLine(string.Join(", ", result));  // Output: Mary, Emma, John
    }
}
