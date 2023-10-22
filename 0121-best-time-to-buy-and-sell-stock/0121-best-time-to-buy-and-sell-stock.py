class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        minp = 1e9
        maxp = -1
        profit = 0
        for p in prices:
            maxp = max(maxp,p)
            if p<minp:
                profit = max(profit,maxp-minp)
                minp = p
                maxp = p
        profit = max(profit,maxp-minp)  
        return profit