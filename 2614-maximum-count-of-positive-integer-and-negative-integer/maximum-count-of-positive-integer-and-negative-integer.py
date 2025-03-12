class Solution:
    def maximumCount(self, nums: List[int]) -> int:
        n = len(nums)
        neg = pos = 0
        for i in range(n):
            if nums[i] > 0:
                pos = pos + 1
            if nums[i] < 0:
                neg = neg + 1
        return max(pos, neg)
        