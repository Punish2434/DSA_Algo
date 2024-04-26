/*     Scroll below to see JAVA code and C# also    */
/*
    Company Tags                : Samsung
   GFG Link               : https://www.geeksforgeeks.org/problems/exit-point-in-a-matrix0905/1
    
*/ 

/ C++ ******************************************************************************************************************************/


    vector<int> FindExitPoint(int n, int m, vector<vector<int>>& matrix) {
        // Code here
        int i=0,j=0,previ=0,prevj=0,face=0;
        while(i<n and i>=0 and j<m and j>=0){
            previ=i;
            prevj=j;
            if(matrix[i][j]){
                matrix[i][j]=0;
                if(face==0){
                    i++;
                    face=1;
                }
                else if(face==1){
                    j--;
                    face=2;
                }
                else if(face==2){
                    i--;
                    face=3;
                }
                else{
                    j++;
                    face=0;
                }
            }
            else{
                if(face==0)j++;
                else if(face==1)i++;
                else if(face==2)j--;
                else i--;
            }
        }
        return {previ,prevj};
    }

/ Java ******************************************************************************************************************************/
class Solution {
   public int[] FindExitPoint(int n, int m, int[][] matrix) {
        // code here
        int i=0,j=0,previ=0,prevj=0,face=0;
        while(i<n && i>=0 && j>=0 && j<m){
            previ=i;
            prevj=j;
            if(matrix[i][j]==1){
                matrix[i][j]=0;
                if(face==0){
                    i++;
                    face=1;
                }
                else if(face==1){
                    j--;
                    face=2;
                }
                else if(face==2){
                    i--;
                    face=3;
                }
                else{
                    j++;
                    face=0;
                }
            }
            else{
                if(face==0)j++;
                else if(face==1)i++;
                else if(face==2)j--;
                else i--;
            }
        }
        int ans[] = new int[2];
        ans[0]=previ;
        ans[1]=prevj;
        return ans;
    }
}
/ c#  ******************************************************************************************************************************/

using System;

public class Solution
{
    public int[] FindExitPoint(int n, int m, int[][] matrix)
    {
        int i = 0, j = 0, previ = 0, prevj = 0, face = 0;

        // Traverse the matrix until the exit point is found
        while (i < n && i >= 0 && j >= 0 && j < m)
        {
            previ = i;
            prevj = j;

            if (matrix[i][j] == 1)
            {
                // Mark the current cell as visited (set to 0)
                matrix[i][j] = 0;

                // Update the position based on the current facing direction
                if (face == 0)
                {
                    i++; // Move down
                    face = 1;
                }
                else if (face == 1)
                {
                    j--; // Move left
                    face = 2;
                }
                else if (face == 2)
                {
                    i--; // Move up
                    face = 3;
                }
                else
                {
                    j++; // Move right
                    face = 0;
                }
            }
            else
            {
                // If the cell is not 1, move in the same direction
                if (face == 0) j++; // Move right
                else if (face == 1) i++; // Move down
                else if (face == 2) j--; // Move left
                else i--; // Move up
            }
        }

        // Create an array to store the exit point coordinates
        int[] ans = new int[2];
        ans[0] = previ;
        ans[1] = prevj;
        return ans;
    }
}
```

// **Explanation**:
// - The `FindExitPoint` function calculates the exit point coordinates in a 2D matrix.
// - We maintain variables (`i`, `j`, `previ`, `prevj`, `face`) to track the current position and direction.
// - We iterate over the matrix, updating the position based on the current cell value and facing direction.
// - If the cell value is 1, we mark it as visited and update the position accordingly.
// - Otherwise, we continue moving in the same direction.
// - Finally, we return the exit point coordinates.
