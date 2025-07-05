
# Search Insert Position

[Problem Link](https://leetcode.com/problems/search-insert-position/description/)

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [1,3,5,6], target = 5\
Output: 2

Example 2:

Input: nums = [1,3,5,6], target = 2\
Output: 1

Example 3:

Input: nums = [1,3,5,6], target = 7\
Output: 4

Constraints:

- 1 <= nums.length <= 104
- -104 <= nums[i] <= 104
- nums contains distinct values sorted in ascending order.
- -104 <= target <= 104

## Solution Approach

If we look at the problem it is evident that we will use the binary search algorithm (If you are unaware of the binary search algorithm check the **Day 3, Problem 2** in this repository or search **Binary Search Kunal Kuswaha** on YT). Now, if target is present in the array we just look for it then return the index (updated mid) when we find it. But, what do we do when the target is not there?

There is only two scenerios here, one the target is there in the array and target is not present in the array.

Scenerio - 1 : Target is present in the given sorted array\
Just apply the Binary Search Algorithm return the answer.

Scenerio - 2 : Target is not present in the given sorted array\
Usually we return -1 when the target is not present but as the problem suggest we need to return the possible index where the target could have been if it was in the array. Let's see some examples.

```pseudo
Example - 1
nums = [3, 6, 8, 11, 14, 24, 25, 30, 31], target = 7
low = 0, high = 8, mid = 4

Step - 1
nums[mid] > target (14 > 6)
Step - 2
low = 0, high = 3, mid = 1
nums[mid] < target (6 < 7)
Step - 3
low = 1, high = 2, mid = 1
nums[mid] < target (6 < 7)
Step - 4
low = 2, high = 1, mid = 1
Loop terminates (low > high)
If 7 was in this array it would have been in index 2.

Example - 2
nums = [3, 6, 8, 11, 14, 24, 25, 30, 31], target = 28
low = 0, high = 8, mid = 4

Step - 1
nums[mid] < target (14 < 28)
Step - 2
low = 5, high = 8, mid = 6
nums[mid] < target (25 < 28)
Step - 3
low = 6, high = 7, mid = 6
nums[mid] < target (25 < 28)
Step - 4
low = 7, high = 6, mid = 6
Loop terminates (low > high)
If 28 was in this array it would have been in index 7.
```

If we look at the both examples we can see that when loop terminates low is exactly the place where the element would have been if it was there.

As per problem specifications if the element is there we return mid value and if it is not there return the updated lower bound value.

```java
int searchInsert(int[] nums, int target) {
        int lowerBound = 0;
        int upperBound = nums.length - 1;

        while (lowerBound <= upperBound) {
            int mid = lowerBound + (upperBound - lowerBound) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                lowerBound = mid + 1;
            } else {
                upperBound = mid - 1;
            }
        }
        return lowerBound;
    }
```

This is it. This is the solution that meet the time complexity of O(logn).
