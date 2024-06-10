/*    Scroll below to see JAVA code and C# also  */
/*
    Company Tags                : Amazon,Hike,MakeMyTrip,MAQ Software,Adobe
    Leetcode Link               : https://www.geeksforgeeks.org/problems/nuts-and-bolts-problem0431/1
*/
/ C++ **************************************************************************************************************************/
 // Time Complexity: O(n(logn))
 // Auxiliary Space: O(log(n))

  #include <iostream>
#include <vector>

class Solution {
public:
    int partition(std::vector<char>& arr, int low, int high, char pivot) {
        int i = low;
        char temp1, temp2;
        for (int j = low; j < high; ++j) {
            if (arr[j] < pivot) {
                temp1 = arr[i];
                arr[i] = arr[j];
                arr[j] = temp1;
                ++i;
            } else if (arr[j] == pivot) {
                temp1 = arr[j];
                arr[j] = arr[high];
                arr[high] = temp1;
                --j;
            }
        }
        temp2 = arr[i];
        arr[i] = arr[high];
        arr[high] = temp2;
        return i;
    }

    void quick(std::vector<char>& nuts, std::vector<char>& bolts, int low, int high) {
        if (low < high) {
            int pivot = partition(nuts, low, high, bolts[high]);
            partition(bolts, low, high, nuts[pivot]);

            quick(nuts, bolts, low, pivot - 1);
            quick(nuts, bolts, pivot + 1, high);
        }
    }

    void matchPairs(int n, std::vector<char>& nuts, std::vector<char>& bolts) {
        quick(nuts, bolts, 0, n - 1);
    }
};

int main() {
    Solution solution;

    // Example usage
    std::vector<char> nuts = {'a', 'b', 'd', 'c'};
    std::vector<char> bolts = {'b', 'c', 'a', 'd'};
    int n = nuts.size();

    solution.matchPairs(n, nuts, bolts);

    std::cout << "Matched pairs: ";
    for (char nut : nuts) {
        std::cout << nut << " ";
    }
    std::cout << std::endl;

    return 0;
}
/ Java **************************************************************************************************************************/
 // Time Complexity: O(n(logn))
 // Auxiliary Space: O(log(n))
  class Solution {
    public int partition(char[] arr, int low, int high, char pivot) {
        int i = low;
        char temp1, temp2;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                temp1 = arr[i];
                arr[i] = arr[j];
                arr[j] = temp1;
                i++;
            } else if (arr[j] == pivot) {
                temp1 = arr[j];
                arr[j] = arr[high];
                arr[high] = temp1;
                j--;
            }
        }
        temp2 = arr[i];
        arr[i] = arr[high];
        arr[high] = temp2;
        return i;
    }

    public void quick(char[] nuts, char[] bolts, int low, int high) {
        if (low < high) {
            int pivot = partition(nuts, low, high, bolts[high]);
            partition(bolts, low, high, nuts[pivot]);

            quick(nuts, bolts, low, pivot - 1);
            quick(nuts, bolts, pivot + 1, high);
        }
    }

    public void matchPairs(int n, char[] nuts, char[] bolts) {
        quick(nuts, bolts, 0, n - 1);
    }
}
/ C# **************************************************************************************************************************/
 // Time Complexity: O(n(logn))
 // Auxiliary Space: O(log(n))
  
using System;

public class Solution {
    public int Partition(char[] arr, int low, int high, char pivot) {
        int i = low;
        char temp1, temp2;
        for (int j = low; j < high; ++j) {
            if (arr[j] < pivot) {
                temp1 = arr[i];
                arr[i] = arr[j];
                arr[j] = temp1;
                ++i;
            } else if (arr[j] == pivot) {
                temp1 = arr[j];
                arr[j] = arr[high];
                arr[high] = temp1;
                --j;
            }
        }
        temp2 = arr[i];
        arr[i] = arr[high];
        arr[high] = temp2;
        return i;
    }

    public void Quick(char[] nuts, char[] bolts, int low, int high) {
        if (low < high) {
            int pivot = Partition(nuts, low, high, bolts[high]);
            Partition(bolts, low, high, nuts[pivot]);

            Quick(nuts, bolts, low, pivot - 1);
            Quick(nuts, bolts, pivot + 1, high);
        }
    }

    public void MatchPairs(int n, char[] nuts, char[] bolts) {
        Quick(nuts, bolts, 0, n - 1);
    }

    public static void Main(string[] args) {
        Solution solution = new Solution();

        // Example usage
        char[] nuts = { 'a', 'b', 'd', 'c' };
        char[] bolts = { 'b', 'c', 'a', 'd' };
        int n = nuts.Length;

        solution.MatchPairs(n, nuts, bolts);

        Console.Write("Matched pairs: ");
        foreach (char nut in nuts) {
            Console.Write(nut + " ");
        }
        Console.WriteLine();
    }
}

