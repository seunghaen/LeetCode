# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        a = collections.deque()
        if not head:
            return True
        
        node = head
        while node is not None:
            a.append(node.val)
            node = node.next

        while len(a)>=2:
            if a.popleft() != a.pop():
                return False
        return True
        