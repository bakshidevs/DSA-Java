
# Single Element in a Sorted Array

You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]\
Output: 2

Example 2:

Input: nums = [3,3,7,7,10,11,11]\
Output: 10

Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 105

## Solution Approach

The problem requires a solution with O(log n) time complexity, which strongly suggests a binary search approach. We can leverage the unique properties of the array to implement a modified binary search.

### Key Observation

In the given sorted array, all elements appear in pairs except for one. This creates a distinct pattern based on element indices:

1. **Before the single element:** Pairs of identical numbers will always start at an even index and end at an odd index. For example, `(nums[0], nums[1])`, `(nums[2], nums[3])`, etc. So, for any even index `i` in this section, `nums[i] == nums[i+1]`.
2. **After the single element:** The presence of the single element disrupts this pattern. A pair will now start at an odd index and end at an even one. For any even index `i` in this section, `nums[i] != nums[i+1]`.

Our goal is to find the first even index `i` where `nums[i] != nums[i+1]`. This index `i` will hold the single element.

### Algorithm

We can adapt binary search to find this "break point":

1. Initialize `lowerBound = 0` and `upperBound = nums.length - 1`.
2. Loop while `lowerBound < upperBound`.
3. Calculate the `mid` index. To simplify our logic, we want to ensure `mid` always points to the first element of a potential pair. If `mid` is odd, we decrement it by one to make it even.
4. Now, with an even `mid`, we check if the pattern is intact by comparing `nums[mid]` and `nums[mid + 1]`:
    - If `nums[mid] == nums[mid + 1]`, the pattern holds true for the pair at `(mid, mid + 1)`. This implies the single element must be in the right half of the search space. We can safely discard the left half by setting `lowerBound = mid + 2`.
    - If `nums[mid] != nums[mid + 1]`, the pattern is broken. The single element is either at `mid` or in the left half. We shrink the search space to the left by setting `upperBound = mid`.
5. The loop terminates when `lowerBound` and `upperBound` converge to the same index. This index is the location of the single element, so we return `nums[lowerBound]`.

This approach guarantees finding the element in O(log n) time while using O(1) extra space.
