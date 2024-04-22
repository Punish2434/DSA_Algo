/*     Scroll below to see JAVA code and C# also        */
/*
    Company Tags  : Google
    Leetcode Link : https://leetcode.com/problems/add-one-row-to-tree/
*/

/ C++ *************************************************************************************/
//Approach-1 : Using DFS
//T.C : O(n)
//S.C : O(1) Auxiliary Space, O(depth) system stack space of recursion
class Solution {
public:
    
    TreeNode* add(TreeNode* root, int val, int depth, int curr) {
        if(!root)
            return NULL;
        
        if(curr == depth-1) {
            TreeNode* lTemp = root->left;
            TreeNode* rTemp = root->right;
            
            root->left  = new TreeNode(val);
            root->right = new TreeNode(val);
            root->left->left = lTemp;
            root->right->right = rTemp;
            
            return root;
        }
        
        root->left  = add(root->left, val, depth, curr+1);
        root->right = add(root->right, val, depth, curr+1);
        
        return root;
    }
    
    TreeNode* addOneRow(TreeNode* root, int val, int depth) {
        if(depth == 1) {
            TreeNode* newRoot = new TreeNode(val);
            newRoot->left = root;
            return newRoot;
        }
        
        return add(root, val, depth, 1);
    }
};

//Approach-2 : Using BFS
//T.C : O(n)
//S.C : O(n)
class Solution {
public:
    TreeNode* addOneRow(TreeNode* root, int v, int d) {
        if(d == 1) {
            TreeNode* newRoot = new TreeNode(v);
            newRoot->left = root;
            return newRoot;
        }
        queue<TreeNode*> que;
        
        que.push(root);
        int level = 0;
        bool rowAdded = false;
        while(!que.empty()) {
            int n = que.size();
            level++;
            while(n--) {
                TreeNode* curr = que.front();
                que.pop();
                TreeNode* tempL = curr->left;
                TreeNode* tempR = curr->right;
                if(level == d-1) {
                    curr->left  = new TreeNode(v);
                    curr->right = new TreeNode(v);
                    curr->left->left   = tempL;
                    curr->right->right = tempR;
                    rowAdded = true;
                }
                if(tempL)
                    que.push(tempL);
                if(tempR)
                    que.push(tempR);
            }
            if(rowAdded)
                break;
        }
        
        return root;
    }
};


/ JAVA *****************************************************************************************/
//Approach-1 : Using DFS
//T.C : O(n)
//S.C : O(1) Auxiliary Space, O(depth) system stack space of recursion
public class Solution {
    public TreeNode add(TreeNode root, int val, int depth, int curr) {
        if (root == null)
            return null;

        if (curr == depth - 1) {
            TreeNode lTemp = root.left;
            TreeNode rTemp = root.right;

            root.left = new TreeNode(val);
            root.right = new TreeNode(val);
            root.left.left = lTemp;
            root.right.right = rTemp;

            return root;
        }

        root.left = add(root.left, val, depth, curr + 1);
        root.right = add(root.right, val, depth, curr + 1);

        return root;
    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        return add(root, val, depth, 1);
    }
}



//Approach-2 : Using BFS
//T.C : O(n)
//S.C : O(n)
public class Solution {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        boolean rowAdded = false;
        while (!queue.isEmpty()) {
            int n = queue.size();
            level++;
            while (n-- > 0) {
                TreeNode curr = queue.poll();
                TreeNode tempL = curr.left;
                TreeNode tempR = curr.right;
                if (level == d - 1) {
                    curr.left = new TreeNode(v);
                    curr.right = new TreeNode(v);
                    curr.left.left = tempL;
                    curr.right.right = tempR;
                    rowAdded = true;
                }
                if (tempL != null)
                    queue.add(tempL);
                if (tempR != null)
                    queue.add(tempR);
            }
            if (rowAdded)
                break;
        }
        return root;
    }
}
  / C# *****************************************************************************************/

  //Approach-1 : Using DFS
//T.C : O(n)
//S.C : O(1) Auxiliary Space, O(depth) system stack space of recursion
  
  public class TreeNode
{
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val)
    {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class Solution
{
    public TreeNode Add(TreeNode root, int val, int depth, int curr)
    {
        if (root == null)
            return null;

        if (curr == depth - 1)
        {
            TreeNode lTemp = root.left;
            TreeNode rTemp = root.right;

            root.left = new TreeNode(val);
            root.right = new TreeNode(val);
            root.left.left = lTemp;
            root.right.right = rTemp;

            return root;
        }

        root.left = Add(root.left, val, depth, curr + 1);
        root.right = Add(root.right, val, depth, curr + 1);

        return root;
    }

    public TreeNode AddOneRow(TreeNode root, int val, int depth)
    {
        if (depth == 1)
        {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        return Add(root, val, depth, 1);
    }
}