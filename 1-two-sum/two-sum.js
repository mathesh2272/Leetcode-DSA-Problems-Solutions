/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    let n = nums.length
    let arr = [];
    for(let i = 0 ; i < n ; i++){
        for(let j = i + 1 ; j < n ; j++){
            if(nums[i] + nums[j] === target){
                arr[0] = i
                arr[1] = j
                return arr 
            }
        }
    }
    return arr
};