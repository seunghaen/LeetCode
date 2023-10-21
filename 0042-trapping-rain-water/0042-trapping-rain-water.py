class Solution:
    def trap(self, height: List[int]) -> int:
        left = 0
        right = len(height)-1
        lmax = height[left]
        rmax = height[right]
        answer = 0
        while left < right:
            if lmax>rmax:
                right-=1
                if rmax >= height[right]:
                    answer+= rmax-height[right]
                else:
                    rmax = height[right]
            else:
                left+=1
                if lmax >= height[left]:
                    answer+= lmax-height[left]
                else:
                    lmax = height[left]
        return answer

        