//Time Complexity: O(n) — single pass through the stations

//Space Complexity: O(1) — only uses fixed extra variables

public class Solution {
    public int CanCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0;
        int currTank = 0;
        int startIndex = 0;

        for (int i = 0; i < gas.Length; i++)
        {
            int gain = gas[i] - cost[i];
            totalTank += gain;
            currTank += gain;

            if(currTank < 0)
            {
                startIndex = i + 1;
                currTank = 0;
            }
        }
        return totalTank >= 0 ? startIndex : -1;
    }
}
//Using a greedy strategy to reset the starting point only when necessary, achieving O(n) time complexity
//Python Implementation
class Solution:
    def canCompleteCircuit(self, gas, cost):
        total_tank = 0   # total net gas
        curr_tank = 0    # current gas in tank
        start_index = 0  # starting station

        for i in range(len(gas)):
            gain = gas[i] - cost[i]
            total_tank += gain
            curr_tank += gain

            # If running out of gas, reset starting point
            if curr_tank < 0:
                start_index = i + 1
                curr_tank = 0

        return start_index if total_tank >= 0 else -1
