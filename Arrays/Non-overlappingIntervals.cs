Time Complexity: 𝑂 ( 𝑛 log ⁡ 𝑛 ) 
Space Complexity: 𝑂 ( 1 )

public class Solution {
    public int EraseOverlapIntervals(int[][] intervals) {
        if (intervals.Length == 0) return 0;
        Array.Sort(intervals, (a, b) => a[1].CompareTo(b[1]));
        int countNonOverlap = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.Length; i++) {
            if (intervals[i][0] >= end) {
                countNonOverlap++;
                end = intervals[i][1];
            }
            
        }
        return intervals.Length - countNonOverlap;
    }
}
