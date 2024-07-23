/*         Scroll below to see JAVA code and C# also        */

    // Company Tags           : 
    // GFG Link               : https://www.geeksforgeeks.org/problems/merge-two-bst-s/1
// C++ ********************************************************************************************************************************************/
//Approach (using Priority Queue)
//T.C : O(m+n)
//S.C : O(HeightofBST1+HeightofBST2+m+n) 
#include <iostream>
#include <vector>
using namespace std;

struct Node {
    int data;
    Node* left;
    Node* right;

    Node(int item) : data(item), left(nullptr), right(nullptr) {}
};

class Solution {
public:
    vector<int> merge(Node* root1, Node* root2) {
        vector<int> list1, list2;

        inOrderTraversal(root1, list1);
        inOrderTraversal(root2, list2);

        return mergeSortedLists(list1, list2);
    }

private:
    void inOrderTraversal(Node* root, vector<int>& list) {
        if (!root) return;
        inOrderTraversal(root->left, list);
        list.push_back(root->data);
        inOrderTraversal(root->right, list);
    }

    vector<int> mergeSortedLists(const vector<int>& list1, const vector<int>& list2) {
        vector<int> mergedList;
        int i = 0, j = 0;

        while (i < list1.size() && j < list2.size()) {
            if (list1[i] <= list2[j]) {
                mergedList.push_back(list1[i]);
                i++;
            } else {
                mergedList.push_back(list2[j]);
                j++;
            }
        }

        while (i < list1.size()) {
            mergedList.push_back(list1[i]);
            i++;
        }

        while (j < list2.size()) {
            mergedList.push_back(list2[j]);
            j++;
        }

        return mergedList;
    }
};

// Time Complexity: O(m + n)
// Space Complexity: O(Height of BST1 + Height of BST2 + m + n)


// Java ********************************************************************************************************************************************/
//Approach (using Priority Queue)
//T.C : O(m+n)
//S.C : O(HeightofBST1+HeightofBST2+m+n) 
class Solution {
    public int[] frequencySort(int[] nums) {
        // Step 1: Create a frequency map
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Sort the array with custom comparator
        Integer[] numsArray = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(numsArray, (a, b) -> {
            int freqA = frequencyMap.get(a);
            int freqB = frequencyMap.get(b);
            if (freqA != freqB) {
                return freqA - freqB; // Increasing order of frequency
            } else {
                return b - a; // Decreasing order of value if frequencies are the same
            }
        });

        // Step 3: Convert back to int array
        for (int i = 0; i < nums.length; i++) {
            nums[i] = numsArray[i];
        }

        return nums;
    }
}

// C# ********************************************************************************************************************************************/
//Approach (using Priority Queue)
//T.C : O(m+n)
//S.C : O(HeightofBST1+HeightofBST2+m+n) 
using System;
using System.Collections.Generic;

class Node {
    public int data;
    public Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class Solution {
    public List<int> Merge(Node root1, Node root2) {
        List<int> list1 = new List<int>();
        List<int> list2 = new List<int>();

        InOrderTraversal(root1, list1);
        InOrderTraversal(root2, list2);

        return MergeSortedLists(list1, list2);
    }

    private void InOrderTraversal(Node root, List<int> list) {
        if (root == null) {
            return;
        }
        InOrderTraversal(root.left, list);
        list.Add(root.data);
        InOrderTraversal(root.right, list);
    }

    private List<int> MergeSortedLists(List<int> list1, List<int> list2) {
        List<int> mergedList = new List<int>();
        int i = 0, j = 0;

        while (i < list1.Count && j < list2.Count) {
            if (list1[i] <= list2[j]) {
                mergedList.Add(list1[i]);
                i++;
            } else {
                mergedList.Add(list2[j]);
                j++;
            }
        }

        while (i < list1.Count) {
            mergedList.Add(list1[i]);
            i++;
        }

        while (j < list2.Count) {
            mergedList.Add(list2[j]);
            j++;
        }

        return mergedList;
    }
}

// Time Complexity: O(m + n)
// Space Complexity: O(Height of BST1 + Height of BST2 + m + n)

// JavaScript ********************************************************************************************************************************************/
//Approach (using Priority Queue)
//T.C : O(m+n)
//S.C : O(HeightofBST1+HeightofBST2+m+n) 
class Solution {
    /**
    * @param Node root1
    * @param Node root2

    * @returns number[]
    */
    merge(root1, root2) {
        // code here
        const list1 = [];
        const list2 = [];

        this.inOrderTraversal(root1, list1);
        this.inOrderTraversal(root2, list2);
        
        
        return this.mergeSortedLists(list1, list2);
    }
    inOrderTraversal(root, list){
        if(root === null) return;
        this.inOrderTraversal(root.left, list);
        list.push(root.data);
        this.inOrderTraversal(root.right, list);
    }
    
     mergeSortedLists(list1, list2) {
        const mergedList = [];
        let i = 0, j = 0;

        while (i < list1.length && j < list2.length) {
            if (list1[i] <= list2[j]) {
                mergedList.push(list1[i]);
                i++;
            } else {
                mergedList.push(list2[j]);
                j++;
            }
        }

        while (i < list1.length) {
            mergedList.push(list1[i]);
            i++;
        }

        while (j < list2.length) {
            mergedList.push(list2[j]);
            j++;
        }

        return mergedList;
    }
}
