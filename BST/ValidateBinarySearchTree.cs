
 Time: O(n) | Space: O(h)
   
public class Solution {
    public bool IsValidBST(TreeNode root) {

        return validate (root, long.MinValue, long.MaxValue);
       
    }
    public bool validate (TreeNode node, long minVal, long maxVal)
    {
       if(node == null)
       return true;

       if (node.val <= minVal || node.val >= maxVal) 
            return false;

       bool leftTree = validate(node.left, minVal, node.val);

       bool RightTree = validate(node.right, node.val,  maxVal);

        return leftTree && RightTree;
    }
}
