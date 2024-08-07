/*         Scroll below to see C# code and JavaScript also        */

    // Company Tags                : 
    // Leetcode Link               : https://leetcode.com/problems/integer-to-english-words/
// Java ********************************************************************************************************************************************/
//Approach (Using Recusion)
// TC:𝑂(n) 
// SC:𝑂(1)
public class Solution {
    private static readonly string[] LESS_THAN_TWENTY = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", 
                                                        "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", 
                                                        "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", 
                                                        "Nineteen"};
    private static readonly string[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", 
                                             "Eighty", "Ninety"};
    private static readonly string[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public string NumberToWords(int num) {
        if (num == 0) return "Zero";

        int i = 0;
        string words = "";

        while (num > 0) {
            if (num % 1000 != 0) {
                words = Helper(num % 1000) + THOUSANDS[i] + " " + words;
            }
            num /= 1000;
            i++;
        }

        return words.Trim();
    }

    private string Helper(int num) {
        if (num == 0) return "";
        else if (num < 20) return LESS_THAN_TWENTY[num] + " ";
        else if (num < 100) return TENS[num / 10] + " " + Helper(num % 10);
        else return LESS_THAN_TWENTY[num / 100] + " Hundred " + Helper(num % 100);
    }

    public static void Main(string[] args) {
        Solution sol = new Solution();
        Console.WriteLine(sol.NumberToWords(123));        // Output: "One Hundred Twenty Three"
        Console.WriteLine(sol.NumberToWords(12345));      // Output: "Twelve Thousand Three Hundred Forty Five"
        Console.WriteLine(sol.NumberToWords(1234567));    // Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
    }
}
// C# ********************************************************************************************************************************************/
//Approach (Using Recusion)
// TC:𝑂(n) 
// SC:𝑂(1)
public class Solution {
    private static readonly string[] LESS_THAN_TWENTY = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", 
                                                        "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", 
                                                        "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", 
                                                        "Nineteen"};
    private static readonly string[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", 
                                             "Eighty", "Ninety"};
    private static readonly string[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public string NumberToWords(int num) {
        if (num == 0) return "Zero";

        int i = 0;
        string words = "";

        while (num > 0) {
            if (num % 1000 != 0) {
                words = Helper(num % 1000) + THOUSANDS[i] + " " + words;
            }
            num /= 1000;
            i++;
        }

        return words.Trim();
    }

    private string Helper(int num) {
        if (num == 0) return "";
        else if (num < 20) return LESS_THAN_TWENTY[num] + " ";
        else if (num < 100) return TENS[num / 10] + " " + Helper(num % 10);
        else return LESS_THAN_TWENTY[num / 100] + " Hundred " + Helper(num % 100);
    }

    public static void Main(string[] args) {
        Solution sol = new Solution();
        Console.WriteLine(sol.NumberToWords(123));        // Output: "One Hundred Twenty Three"
        Console.WriteLine(sol.NumberToWords(12345));      // Output: "Twelve Thousand Three Hundred Forty Five"
        Console.WriteLine(sol.NumberToWords(1234567));    // Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
    }
}

// JavaScript********************************************************************************************************************************************/
//Approach (Using Recusion)
// TC:𝑂(n) 
// SC:𝑂(1)
class Solution {
    constructor() {
        this.LESS_THAN_TWENTY = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", 
                                 "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", 
                                 "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", 
                                 "Nineteen"];
        this.TENS = ["", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", 
                     "Eighty", "Ninety"];
        this.THOUSANDS = ["", "Thousand", "Million", "Billion"];
    }

    numberToWords(num) {
        if (num === 0) return "Zero";

        let i = 0;
        let words = "";

        while (num > 0) {
            if (num % 1000 !== 0) {
                words = this.helper(num % 1000) + this.THOUSANDS[i] + " " + words;
            }
            num = Math.floor(num / 1000);
            i++;
        }

        return words.trim();
    }

    helper(num) {
        if (num === 0) return "";
        else if (num < 20) return this.LESS_THAN_TWENTY[num] + " ";
        else if (num < 100) return this.TENS[Math.floor(num / 10)] + " " + this.helper(num % 10);
        else return this.LESS_THAN_TWENTY[Math.floor(num / 100)] + " Hundred " + this.helper(num % 100);
    }
}

// Example usage:
const sol = new Solution();
console.log(sol.numberToWords(123));        // Output: "One Hundred Twenty Three"
console.log(sol.numberToWords(12345));      // Output: "Twelve Thousand Three Hundred Forty Five"
console.log(sol.numberToWords(1234567));    // Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"

