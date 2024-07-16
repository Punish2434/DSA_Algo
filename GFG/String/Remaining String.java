/*     Scroll below to see JAVA code and C# also    */
/*
      Company Tags           : Zoho,Oracle
      GFG Link               : https://www.geeksforgeeks.org/problems/remaining-string3515/1
*/
/ C++ ************************************************************************************************************************/

//T.C :  O(|s|)
//S.C : O(1)

#include <iostream>
#include <string>
using namespace std;

string printString(const string& s, char ch, int count) {
    int occurrence = 0;
    
    for (size_t i = 0; i < s.length(); i++) {
        if (s[i] == ch) {
            occurrence++;
        }
        if (occurrence == count) {
            return s.substr(i + 1);
        }
    }
    return "";
}

int main() {
    cout << printString("Thisisdemostring", 'i', 3) << endl; // Output: "ng"
    cout << printString("Thisisdemostri", 'i', 3) << endl;   // Output: ""
    cout << printString("abcd", 'x', 2) << endl;             // Output: ""
    return 0;
}

/ Java ************************************************************************************************************************/

//T.C :  O(|s|)
//S.C : O(1)
  class Solution {
    public String printString(String s, char ch, int count) {
        // code here
        //Initialize a variable to keep track of the number of occurrences of ch
        int occurrence = 0;
        
        //Loop through the string to find the count-th occourrence of ch
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ch)
            {
               occurrence++; 
            }
            // When the count-th occurrence is found , return the remaining substring
            if(occurrence == count){
                return s.substring(i + 1);
            }
        }
        // If count-th occurrence of ch is not found, return an empty string 
        return "";
    }
}

/ C# ************************************************************************************************************************/

//T.C :  O(|s|)
//S.C : O(1)
using System;

class Solution {
    public string PrintString(string s, char ch, int count) {
        int occurrence = 0;

        for (int i = 0; i < s.Length; i++) {
            if (s[i] == ch) {
                occurrence++;
            }
            if (occurrence == count) {
                return s.Substring(i + 1);
            }
        }
        return "";
    }

    static void Main() {
        Solution sol = new Solution();
        Console.WriteLine(sol.PrintString("Thisisdemostring", 'i', 3)); // Output: "ng"
        Console.WriteLine(sol.PrintString("Thisisdemostri", 'i', 3)); // Output: ""
        Console.WriteLine(sol.PrintString("abcd", 'x', 2)); // Output: ""
    }
}

/ JavaScript ************************************************************************************************************************/

//T.C :  O(|s|)
//S.C : O(1)

function printString(s, ch, count) {
    let occurrence = 0;
    
    for (let i = 0; i < s.length; i++) {
        if (s[i] === ch) {
            occurrence++;
        }
        if (occurrence === count) {
            return s.substring(i + 1);
        }
    }
    return "";
}

// Example usage:
console.log(printString("Thisisdemostring", 'i', 3)); // Output: "ng"
console.log(printString("Thisisdemostri", 'i', 3)); // Output: ""
console.log(printString("abcd", 'x', 2)); // Output: ""

