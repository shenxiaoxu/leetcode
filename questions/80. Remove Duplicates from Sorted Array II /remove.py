'''
Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.

Do not allocate extra space for another array; you must do this by modifying the input array in-place with O(1) extra memory.

Clarification:

Confused why the returned value is an integer, but your answer is an array?

Note that the input array is passed in by reference, which means a modification to the input array will be known to the caller.

Internally you can think of this:

// nums is passed in by reference. (i.e., without making a copy)
int len = removeDuplicates(nums);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
    print(nums[i]);
}
 

Example 1:

Input: nums = [1,1,1,2,2,3]
Output: 5, nums = [1,1,2,2,3]
Explanation: Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively. 
It doesn't matter what you leave beyond the returned length.
'''
class Solution(object):
	def removeDuplicates(self, nums):
		start, head, count = 1, 1, 0
		while start < len(nums):
			if nums[start - 1] == nums[start]:
				count += 1
				if count < 2:
					nums[head] = nums[start]
					head += 1
			else:
				count = 0
				nums[head]= nums[start]
				head += 1
			start += 1
		return head
if __name__ == "__main__":
	nums = [1,1,1,1,1,2,2,2,3,3,3,3,3]
	o = Solution()
	print(o.remove(nums))
