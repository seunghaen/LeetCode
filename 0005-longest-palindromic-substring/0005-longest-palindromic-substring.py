class Solution:
    def longestPalindrome(self, s: str) -> str:
        def check(left,right):
            v = ""
            while left>=0 and right<len(s) and s[left] == s[right]:
                v=s[left:right+1]
                left-=1
                right+=1
            return v
        
        answer = ''
        for i in range(len(s)):
            a = check(i,i)
            b = check(i,i+1)
            if len(answer) < len(a):
                answer = a
            if len(answer) < len(b):
                answer = b
        
        return answer