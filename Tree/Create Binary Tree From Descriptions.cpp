/*     Scroll below to see JAVA code and C# also    */
/*
    Company Tags                : Uber
    Leetcode Link               : https://leetcode.com/problems/create-binary-tree-from-descriptions/description
*/


/ C++ ****************************************************************************************************************/
//Simple Approach using map and set
//T.C : O(n), where n is the size of descriptions
//S.C : O(n), size of map and set
class Solution {
public:
    TreeNode* createBinaryTree(vector<vector<int>>& descriptions) {
        unordered_map<int, TreeNode*> mp;
        unordered_set<int> childSet; //they can never be root of the tree


        for(vector<int>& vec : descriptions) { //O(n)
            int parent = vec[0];
            int child  = vec[1];
            int isLeft = vec[2];

            if(mp.find(parent) == mp.end()) {
                mp[parent] = new TreeNode(parent);
            }

            if(mp.find(child) == mp.end()) {
                mp[child] = new TreeNode(child);
            }

            if(isLeft == 1) { //left child  
                mp[parent]->left = mp[child];
            } else {
                mp[parent]->right = mp[child];
            }

            childSet.insert(child);
        }


        //Find the root
        for(vector<int>& vec : descriptions) { //O(n)
            int parent = vec[0];
            if(childSet.find(parent) == childSet.end()) { //if(!mp.count(parent))
                return mp[parent];
            }
        }

        return NULL; //we will never reach here
    }
};


/ JAVA ****************************************************************************************************************/
//Simple Approach using map and set
//T.C : O(n), where n is the size of descriptions
//S.C : O(n), size of map and set
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        // Map to store the nodes by their value
        Map<Integer , TreeNode> nodeMap = new HashMap<>();
         
        // Set to store all children nodes
        Set<Integer> children = new HashSet<>();
        
        //Iterate over the descriptions to create nodes and build the tree
        for(int[] description : descriptions){
            int parentVal = description[0];
            int childVal = description[1];
            boolean isLeft = description[2] == 1;
            
            //Get or create the parent node 
            TreeNode parent = nodeMap.getOrDefault(parentVal, new TreeNode(parentVal));
            nodeMap.put(parentVal, parent);
            
             //Get or create the child node 
            TreeNode child = nodeMap.getOrDefault(childVal, new TreeNode(childVal));
            nodeMap.put(childVal, child);
            
            //Attach the child to the parent
            if(isLeft){
                parent.left = child;
            }else{
                parent.right = child;
            }
            // Record the child
            children.add(childVal);
        }
        
        //The root is the node that is never a child
        for(int[] description : descriptions){
            int parentVal = description[0];
            if(!children.contains(parentVal)){
                return nodeMap.get(parentVal);
            }
        }
        return null;//This should never happen if the input is valid
    }
}

/ C# ****************************************************************************************************************/
//Simple Approach using map and set
//T.C : O(n), where n is the size of descriptions
//S.C : O(n), size of map and set

using System;
using System.Collections.Generic;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val = 0, TreeNode left = null, TreeNode right = null) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public TreeNode CreateBinaryTree(int[][] descriptions) {
        Dictionary<int, TreeNode> nodeMap = new Dictionary<int, TreeNode>();
        HashSet<int> children = new HashSet<int>();
        
        foreach (var description in descriptions) {
            int parentVal = description[0];
            int childVal = description[1];
            bool isLeft = description[2] == 1;
            
            if (!nodeMap.ContainsKey(parentVal)) {
                nodeMap[parentVal] = new TreeNode(parentVal);
            }
            if (!nodeMap.ContainsKey(childVal)) {
                nodeMap[childVal] = new TreeNode(childVal);
            }
            
            if (isLeft) {
                nodeMap[parentVal].left = nodeMap[childVal];
            } else {
                nodeMap[parentVal].right = nodeMap[childVal];
            }
            
            children.Add(childVal);
        }
        
        foreach (var description in descriptions) {
            int parentVal = description[0];
            if (!children.Contains(parentVal)) {
                return nodeMap[parentVal];
            }
        }
        
        return null; // This should never happen if the input is valid
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)

/ JavaScript ****************************************************************************************************************/
//Simple Approach using map and set
//T.C : O(n), where n is the size of descriptions
//S.C : O(n), size of map and set
class TreeNode {
    constructor(val = 0, left = null, right = null) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    createBinaryTree(descriptions) {
        const nodeMap = new Map();
        const children = new Set();
        
        for (const [parentVal, childVal, isLeft] of descriptions) {
            if (!nodeMap.has(parentVal)) {
                nodeMap.set(parentVal, new TreeNode(parentVal));
            }
            if (!nodeMap.has(childVal)) {
                nodeMap.set(childVal, new TreeNode(childVal));
            }
            
            const parent = nodeMap.get(parentVal);
            const child = nodeMap.get(childVal);
            
            if (isLeft) {
                parent.left = child;
            } else {
                parent.right = child;
            }
            
            children.add(childVal);
        }
        
        for (const [parentVal, childVal, isLeft] of descriptions) {
            if (!children.has(parentVal)) {
                return nodeMap.get(parentVal);
            }
        }
        
        return null; // This should never happen if the input is valid
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)

