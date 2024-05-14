/*     Scroll below to see JAVA code and C# also    */
/*
    Company Tags                : 
    GFG Link               : https://www.geeksforgeeks.org/problems/path-with-minimum-effort/1
*/


/ C++ ******************************************************************************************************************************/

  
class Solution {

    int MinimumEffort(int rows, int columns, vector<vector<int>> &heights) {
        // code here
        queue<pair<int,pair<int,int>>> q;
        vector<vector<int>> vis(rows,vector<int> (columns,INT_MAX));
        q.push({0,{0,0}});
        int x[]={-1,0,1,0};
        int y[]={0,1,0,-1};
        while(q.size()){
            auto temp = q.front();
            q.pop();
            int i=temp.second.first;
            int j=temp.second.second;
            int dis=temp.first;
            for(int k=0;k<4;k++){
                int newi=i+x[k];
                int newj=j+y[k];
                if(newi>=0 and newj>=0 and newi<rows and newj<columns){
                    int newd = max(dis,abs(heights[i][j]-heights[newi][newj]));
                    if(newd<vis[newi][newj]){
                        vis[newi][newj]=newd;
                        q.push({newd,{newi,newj}});
                    }
                }
            }
        }
        return vis[rows-1][columns-1]!=INT_MAX?vis[rows-1][columns-1]:0;
    }
}
/ Java ******************************************************************************************************************************/

class Solution {
    public static int MinimumEffort(int rows, int columns, int[][] heights) {
        // code here
        Queue<int[]> q=new LinkedList<>();
        int vis[][] = new int[rows][columns];
        for(int temp[]:vis){
            Arrays.fill(temp,Integer.MAX_VALUE);
        }
        int x[]={-1,0,1,0};
        int y[]={0,1,0,-1};
        int temp[]={0,0,0};
        q.add(temp);
        while(q.size()!=0){
            temp = q.remove();
            int i=temp[1];
            int j = temp[2];
            int dis = temp[0];
            for(int k=0;k<4;k++){
                int newi=i+x[k];
                int newj=j+y[k];
                if(newi>=0 && newi<rows && newj>=0 && newj<columns){
                    int newd=Math.max(dis,Math.abs(heights[newi][newj]-heights[i][j]));
                    if(newd<vis[newi][newj]){
                        int newArray[] = {newd,newi,newj};
                        q.add(newArray);
                        vis[newi][newj]=newd;
                    }
                }
            }
        }
        return vis[rows-1][columns-1]!=Integer.MAX_VALUE?vis[rows-1][columns-1]:0;
    }
}
// Time Complexity:- O(Rows*Columns)
// Space Complexity:- O(Rows*Columns)
/ C# ******************************************************************************************************************************/
using System;
using System.Collections.Generic;

public class Solution
{
    public static int MinimumEffort(int rows, int columns, int[][] heights)
    {
        Queue<int[]> q = new Queue<int[]>();
        int[,] vis = new int[rows, columns];
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                vis[i, j] = int.MaxValue;
            }
        }

        int[] x = { -1, 0, 1, 0 };
        int[] y = { 0, 1, 0, -1 };
        int[] temp = { 0, 0, 0 };
        q.Enqueue(temp);

        while (q.Count != 0)
        {
            temp = q.Dequeue();
            int i = temp[1];
            int j = temp[2];
            int dis = temp[0];

            for (int k = 0; k < 4; k++)
            {
                int newi = i + x[k];
                int newj = j + y[k];

                if (newi >= 0 && newi < rows && newj >= 0 && newj < columns)
                {
                    int newd = Math.Max(dis, Math.Abs(heights[newi][newj] - heights[i][j]));

                    if (newd < vis[newi, newj])
                    {
                        int[] newArray = { newd, newi, newj };
                        q.Enqueue(newArray);
                        vis[newi, newj] = newd;
                    }
                }
            }
        }

        return vis[rows - 1, columns - 1] != int.MaxValue ? vis[rows - 1, columns - 1] : 0;
    }
}
