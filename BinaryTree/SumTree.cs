// SumTree.cs
namespace SumTreeSolution
{
    public class Node
    {
        public int Data { get; set; }
        public Node Left { get; set; }
        public Node Right { get; set; }

        public Node(int val)
        {
            Data = val;
            Left = null;
            Right = null;
        }
    }

    public class Solution
    {
        public void ToSumTree(Node root)
        {
            _ = ConvertToSumTree(root);
        }

        private int ConvertToSumTree(Node node)
        {
            if (node == null)
            {
                return 0;
            }

            int leftSum = ConvertToSumTree(node.Left);
            int rightSum = ConvertToSumTree(node.Right);
            int originalValue = node.Data;
            node.Data = (node.Left == null && node.Right == null) ? 0 : leftSum + rightSum;
            return originalValue + leftSum + rightSum;
        }
    }
}
