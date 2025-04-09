using System;
using System.Collections.Generic;
					
public class Solution
{
	//sample data matrix (adjacency matrix where knowsMatrix[a][b] = true means a knows b)
	private bool[,] knowsMatrix;
	
	public Solution(bool[,] matrix)
	{
	  knowsMatrix = matrix;
	}
	
	// Simulates the API call to check if person a knows person b
	
	private bool Knows(int a, int b)
	{
	  return knowsMatrix[a, b];
	}
	
	public int FindCelebrity(int n)
	{
	  Stack<int> stack = new Stack<int>();
		
		// Step 1: Push everyone onto the stack
		for(int i = 0; i < n; i++)
		{
		  stack.Push(i);
		}
		// Step 2: Find potential candidate
		while (stack.Count > 1)
		{
		   int a = stack.Pop();
		   int b = stack.Pop();
			
			if(Knows(a, b))
			   {
			    // a connot be a celebrity
				   stack.Push(b);
			   
			   }
			   else
			   {
			    // b cannot be a celebrity
				   stack.Push(a);
			   }
		}
	   // step 3: Validate the condidate
			   int candidate = stack.Pop();
			   for(int i = 0; i < n; i++)
			   {
			     if(i != candidate)
				 {
				   if(Knows(candidate, i) || !Knows(i, candidate))
				   {
				    return -1; // not a celebrity
				   }
				 }
			   }
		return candidate;
	}
	public static void Main()
	{
		// 3 People: 0 knows 1 and 2, 1 knows 2, 2 knows nobody
		// 2 is the celebrity
		bool[,] matrix = {
			{false, true, true},
			{false, false, true},
			{false, false, false}
		};
		Solution solution = new Solution(matrix);
		int result = solution.FindCelebrity(3);
		Console.WriteLine("Celebrity Index : " + result); // Output: 2
	}
}
