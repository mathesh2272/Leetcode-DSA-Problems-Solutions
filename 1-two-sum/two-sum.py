class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dict = {}
        n = len(nums)
        for i in range(n):
            value = target - nums[i]
            if value in dict:
                return [dict[value] ,i]
            dict[nums[i]] = i
        return []
        