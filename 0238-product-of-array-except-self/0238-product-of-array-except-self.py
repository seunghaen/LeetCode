class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        left, right = [],[]
        l,r = 1,1
        for num in nums:
            left.append(l)
            l *= num
        for i in range(len(nums)-1,-1,-1):
            right.append(r)
            r*=nums[i]
        answer = []
        right = right[::-1]
        for i in range(len(nums)):
            answer.append(left[i]*right[i])
        return answer