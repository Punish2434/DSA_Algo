/*     Scroll below to see JAVA code and C# also    */
/*
    Company Tags           : 
    GFG Link               : https://www.geeksforgeeks.org/problems/sum-of-prime4751/1
*/


/ C++ ****************************************************************************************************/

class Solution {
  public:
  bool isPrime(int num){
      if(num==2 || num==3) return true;
      if(num %2 ==0 || num %3 ==0)return false;
      for(int i=5;i*i<=num;i+=6){
          if(num %i ==0|| num %(i+2)==0) return false;
      }
      return true;
      
  }
    vector<int> getPrimes(int n) {
        for(int a=2;a<=n/2;++a){
            int b=n-a;
            if(isPrime(a) && isPrime(b)){
                return {a,b};
            }
        }
        return {-1,-1};
    }
};

/ Java ****************************************************************************************************/

  class Solution {
    public boolean isPrime(int num) {
        if (num == 2 || num == 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }

    public ArrayList<Integer> getPrimes(int n) {
        for (int a = 2; a <= n / 2; ++a) {
            int b = n - a;
            if (isPrime(a) && isPrime(b)) {
                ArrayList<Integer> result = new ArrayList<>();
                result.add(a);
                result.add(b);
                return result;
            }
        }
        return new ArrayList<>(Arrays.asList(-1, -1));
    }

  
}

/ C# ****************************************************************************************************/

  
```csharp
using System;
using System.Collections.Generic;

public class Solution {
    public bool IsPrime(int num) {
        if (num == 2 || num == 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }

    public List<int> GetPrimes(int n) {
        for (int a = 2; a <= n / 2; ++a) {
            int b = n - a;
            if (IsPrime(a) && IsPrime(b)) {
                List<int> result = new List<int>();
                result.Add(a);
                result.Add(b);
                return result;
            }
        }
        return new List<int> { -1, -1 };
    }

    public static void Main(string[] args) {
        Solution solution = new Solution();

        // Test cases
        int n1 = 10;
        List<int> result1 = solution.GetPrimes(n1);
        Console.WriteLine(string.Join(", ", result1)); // Expected output: [3, 7]

        int n2 = 16;
        List<int> result2 = solution.GetPrimes(n2);
        Console.WriteLine(string.Join(", ", result2)); // Expected output: [3, 13] or other prime pairs

        int n3 = 4;
        List<int> result3 = solution.GetPrimes(n3);
        Console.WriteLine(string.Join(", ", result3)); // Expected output: [2, 2]
    }
}
```

// ### Explanation:
// 1. **Method Signature**:
//    - `IsPrime` replaces `isPrime` for C# naming conventions.
//    - `GetPrimes` replaces `getPrimes` for C# naming conventions.

// 2. **List and ArrayList**:
//    - In C#, `List<int>` is used instead of `ArrayList<Integer>` from Java.

// 3. **Return Type**:
//    - The method `GetPrimes` returns a `List<int>` instead of `ArrayList<Integer>`.

// 4. **Array Initialization**:
//    - `new List<int> { -1, -1 }` is used instead of `new ArrayList<>(Arrays.asList(-1, -1))` in Java.

// 5. **Main Method**:
//    - Demonstrates usage with example inputs and prints the results.
//    - Uses `Console.WriteLine` and `string.Join` for output in C#.

