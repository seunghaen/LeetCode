class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        store = collections.defaultdict(list)
        for str in strs:
            store[(''.join(sorted(str)))].append(str)
        return list(store.values())
        
        