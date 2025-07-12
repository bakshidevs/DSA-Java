
# Find First and Last Position of Element in Sorted Array

[Problem Link](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/)

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109

## Solution Approach

We can approach this problem in two ways, one brute force or linear search and binary search. Because the question specifically asks for O(logn) time complexity, we have to solve this with Binary Search. First, let's try it with linear search.

### Approach - 1 : Linear Search

Given an array nums and target, we have to find where the value starts and where it ends. We start comparing each value with target and when find it's first appearance we save then when target doesn't match anymore we update end value as present index - 1. If the array ends before this happens we return the last index as higher bound of the range.

Example - 1\
Input: nums = [5,7,7,8,8,8], target = 8\
Output = [3, 5]

Example - 2\
Input: nums = [5,7,7,8,8,10, 12], target = 8\
Output: [3, 4]

Solving using Linear Search:\
We update the range when target occurs for the first time and again for the last time.

```java
int[] searchRangeLinear(int[] nums, int target) {
    if(nums.length < 1) {
        return new int[] {-1, -1};
    }
    int[] range = new int[2];
    int count = 0;
    for(int i = 0; i < nums.length; i++) {
        if(nums[i] == target){
            // for first occurence of the target
            if(range[0] == -1) {
                range[0] == i;
            }
            // we keep updating it untill it unmatches 
            // Because it is a sorted array we don't have to worry about 
            // the target being present after it doesn't match 
            range[1] == i;
        }
    }
    return range;
}
```

## Approach 2 - Binary Search

We search through the array for twice, once for lower bound and once for upper bound.

```java
int[] searchRange(int[] nums, int target) {
    if (nums.length < 1) {
        return new int[] { -1, -1 };
    }
    int lowerBound = 0;
    int upperBound = nums.length - 1;
    int[] range = new int[2];

    if (target > nums[upperBound] || target < nums[lowerBound]) {
        return new int[] { -1, -1 };
    }

    
    // finding the lowerBound or starting index of the target
    while (lowerBound <= upperBound) {
        int mid = (upperBound + lowerBound) / 2;
        if (nums[mid] >= target) {
            upperBound = mid - 1;
        } else if (nums[mid] < target) {
            lowerBound = mid + 1;
        }
    }
    
    if (lowerBound >= nums.length || nums[lowerBound] != target) {
        return new int[] { -1, -1 };
    }
    range[0] = lowerBound;
    lowerBound = 0;
    upperBound = nums.length - 1;
    
    // finding the upperBound or starting index of the target
    while (lowerBound <= upperBound) {
        int mid = (upperBound + lowerBound) / 2;
        if (nums[mid] <= target) {
            lowerBound = mid + 1;
        } else if (nums[mid] > target) {
            upperBound = mid - 1;
        }
    }
    range[1] = upperBound;
    return range;
}
```

That's it.
