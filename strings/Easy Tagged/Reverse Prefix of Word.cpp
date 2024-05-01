/*     Scroll below to see JAVA code and C# also   */
/*
    Company Tags                : Amazon (Need to double confirm on this)
    Leetcode Link               : https://leetcode.com/problems/reverse-prefix-of-word/
*/


/ C++ ************************************************************************************************************/
//Using simple loop and swap
//T.C : O(n)
//S.C : O(1)
class Solution {
public:
    string reversePrefix(string word, char ch) {
        int i = 0;
        int j = word.find(ch);
        
        while(i < j) {
            swap(word[i], word[j]);
            i++;
            j--;
        }
        
        return word;
        
    }
};


//Using Library Functions
//T.C : O(n)
//S.C : O(1)
class Solution {
public:
    string reversePrefix(string word, char ch) {
        reverse(begin(word), word.begin()+word.find(ch)+1);
        return word;
        
    }
};



/ JAVA ************************************************************************************************************/
//Using simple loop and swap
//T.C : O(n)
//S.C : O(1)
class Solution {
    public String reversePrefix(String word, char ch) {
        int i = 0;
        int j = word.indexOf(ch);
        
        char[] chars = word.toCharArray();
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        
        return new String(chars);
    }
}


//Using Library Functions
//T.C : O(n)
//S.C : O(1)
class Solution {
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        if (index != -1) {
            return new StringBuilder(word.substring(0, index + 1)).reverse().toString() + word.substring(index + 1);
        }
        return word;
    }
}
/C# ************************************************************************************************************/

```csharp
using System;

public class Solution
{
    public string ReversePrefix(string word, char ch)
    {
        int i = 0;
        int j = word.IndexOf(ch);

        char[] chars = word.ToCharArray();
        while (i < j)
        {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }

        return new string(chars);
    }
}
```

// 1. **Method Signature**:
//    - The method `ReversePrefix` takes two parameters:
//      - `word`: A string representing the input word.
//      - `ch`: A character that determines the prefix to be reversed.

// 2. **Initialization**:
//    - We initialize two variables:
//      - `i`: Starting index for the prefix (initialized to 0).
//      - `j`: Index of the character `ch` in the word (using `IndexOf` method).

// 3. **Character Array Conversion**:
//    - We convert the input `word` into a character array using `ToCharArray()` method.

// 4. **Reversing the Prefix**:
//    - We swap characters from the beginning (`i`) to the middle (`j`) of the prefix.
//    - The `while` loop continues until `i` is less than `j`.
//    - In each iteration, we swap `chars[i]` with `chars[j]` and update `i` and `j`.

// 5. **Returning the Result**:
//    - Finally, we create a new string from the modified character array using `new string(chars)` and return it.



//Using Library Functions
//T.C : O(n)
//S.C : O(1)
using System;
using System.Text;

public class Solution
{
    public string ReversePrefix(string word, char ch)
    {
        int index = word.IndexOf(ch);
        if (index != -1)
        {
            // Create a StringBuilder with the prefix up to the specified character
            StringBuilder prefixBuilder = new StringBuilder(word.Substring(0, index + 1));

            // Reverse the prefix using the StringBuilder's Reverse method
            prefixBuilder.Reverse();

            // Combine the reversed prefix with the remaining part of the word
            return prefixBuilder.ToString() + word.Substring(index + 1);
        }

        // If the character is not found, return the original word
        return word;
    }
}


