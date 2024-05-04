
/*  
    Company Tags                : Amazon,Microsoft,Hike,Adobe
    GFG Link               : https://www.geeksforgeeks.org/problems/tree-from-postorder-and-inorder/1
*/

/Java *************************************************************************************************************************************/

class GfG {
    int postIndex;
    
    // Function to return a tree created from postorder and inorder traversals.
    Node buildTree(int in[], int post[], int n) {
        postIndex = n - 1;
        return buildTreeHelper(in, post, 0, n - 1);
    }
    
    // Helper function to recursively build the binary tree
    Node buildTreeHelper(int in[], int post[], int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        
        Node root = new Node(post[postIndex--]);
        
        if (inStart == inEnd) {
            return root;
        }
        
        int inIndex = search(in, inStart, inEnd, root.data);
        
        root.right = buildTreeHelper(in, post, inIndex + 1, inEnd);
        root.left = buildTreeHelper(in, post, inStart, inIndex - 1);
        
        return root;
    }
    
    // Helper function to search for the index of a value in the inorder array
    int search(int arr[], int start, int end, int value) {
        int i;
        for (i = start; i <= end; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return i;
    }
}


