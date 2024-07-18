/*     Scroll below to see JAVA code and C# also    */
/*
    Company Tags                : Tiktok, Josh Techology,ByteDance
    Leetcode Link               : https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/description/
*/


/ * C++ ***************************************************************************************************/
//Approach-1 (Using Graph and BFS)
//T.C : O(n^2)
//S.C : O(n)
class Solution {
public:

    void makeGraph(TreeNode* root, TreeNode* prev, unordered_map<TreeNode*, vector<TreeNode*>>& adj, 
                    unordered_set<TreeNode*>& st) {

        if(root == NULL) {
            return;
        }

        if(root->left == NULL && root->right == NULL) { //LEAF NODE
            st.insert(root);
        }

        if(prev != NULL) {
            adj[root].push_back(prev);
            adj[prev].push_back(root);
        }

        makeGraph(root->left, root, adj, st);
        makeGraph(root->right, root, adj, st);

    }

    int countPairs(TreeNode* root, int distance) {
        unordered_map<TreeNode*, vector<TreeNode*>> adj; //Graph
        unordered_set<TreeNode*> st; //leaf nodes

        makeGraph(root, NULL, adj, st);

        int count = 0; //count of good node pairs

        for(auto &leaf : st) {

            //BFS hit karo and see if you can find another leaf nodes within distance
            queue<TreeNode*> que;
            unordered_set<TreeNode*> visited;
            que.push(leaf);
            visited.insert(leaf);


            for(int level = 0; level <= distance; level++) { //only go till level <= distance
                int size = que.size();
                while(size--) { //level processed
                    TreeNode* curr = que.front();
                    que.pop();

                    if(curr != leaf && st.count(curr)) { 
                        count++;
                    }

                    for(auto &ngbr : adj[curr]) {
                        if(!visited.count(ngbr)) {
                            que.push(ngbr);
                            visited.insert(ngbr);
                        }
                    }
                }
            }
        }
        return count/2;
    }
};

/* JAVA **************************************************************************************************/
//Approach-1 (Using Graph and BFS)
//T.C : O(n^2)
//S.C : O(n)
class Solution {
    public void makeGraph(TreeNode root, TreeNode prev, Map<TreeNode, List<TreeNode>> adj, Set<TreeNode> leafNodes) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) { // Leaf node
            leafNodes.add(root);
        }

        if (prev != null) {
            adj.computeIfAbsent(root, k -> new ArrayList<>()).add(prev);
            adj.computeIfAbsent(prev, k -> new ArrayList<>()).add(root);
        }

        makeGraph(root.left, root, adj, leafNodes);
        makeGraph(root.right, root, adj, leafNodes);
    }

    public int countPairs(TreeNode root, int distance) {
        Map<TreeNode, List<TreeNode>> adj = new HashMap<>(); // Graph
        Set<TreeNode> leafNodes = new HashSet<>(); // Leaf nodes

        makeGraph(root, null, adj, leafNodes);

        int count = 0; // Count of good node pairs

        for (TreeNode leaf : leafNodes) {
            // Perform BFS and see if you can find other leaf nodes within distance
            Queue<TreeNode> queue = new LinkedList<>();
            Set<TreeNode> visited = new HashSet<>();
            queue.add(leaf);
            visited.add(leaf);

            for (int level = 0; level <= distance; level++) { // Only go till level <= distance
                int size = queue.size();
                while (size-- > 0) { // Process level
                    TreeNode curr = queue.poll();

                    if (curr != leaf && leafNodes.contains(curr)) {
                        count++;
                    }

                    for (TreeNode neighbor : adj.getOrDefault(curr, new ArrayList<>())) {
                        if (!visited.contains(neighbor)) {
                            queue.add(neighbor);
                            visited.add(neighbor);
                        }
                    }
                }
            }
        }
        return count / 2;
    }
}


/ * C# **************************************************************************************************/
//Approach-1 (Using Graph and DFS)
//T.C : O(n^2)
//S.C : O(n)
public class Solution {

    public int CountPairs(TreeNode root, int distance) {
        if (root == null) {
            return 0;
        }
        int[] result = new int[1];
        dfs(root, distance, result);
        return result[0];
    }

    private int[] dfs(TreeNode node, int distance, int[] result) {
        if (node == null) {
            return new int[distance + 1];
        }
        
        if (node.left == null && node.right == null) {
            int[] leafDist = new int[distance + 1];
            leafDist[1] = 1; // Leaf node at distance 1
            return leafDist;
        }
        
        int[] leftDist = dfs(node.left, distance, result);
        int[] rightDist = dfs(node.right, distance, result);
        
        // Count pairs between left and right subtrees
        for (int i = 1; i <= distance; i++) {
            for (int j = 1; j <= distance; j++) {
                if (i + j <= distance) {
                    result[0] += leftDist[i] * rightDist[j];
                }
            }
        }
        
        // Update distances
        int[] currentDist = new int[distance + 1];
        for (int i = 1; i < distance; i++) {
            currentDist[i + 1] = leftDist[i] + rightDist[i];
        }
        
        return currentDist;
    }
    
   
}
