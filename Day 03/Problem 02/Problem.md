
# Binary Search

[Link](https://leetcode.com/problems/binary-search/description/)

Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9\
Output: 4\
Explanation: 9 exists in nums and its index is 4

Example 2:\
Input: nums = [-1,0,3,5,9,12], target = 2\
Output: -1
Explanation: 2 does not exist in nums so return -1
 
Constraints:
- 1 <= nums.length <= 104\
- -104 < nums[i], target < 104\
- All the integers in nums are unique.
- nums is sorted in ascending order.

## Solution Approach

Binary search is performed to find a value in a sorted array. When find the target in the array we return it's index, if it doesn't exist in the array we return -1. It is done periodically by comparing the target to middle element of the array and if it does not match target we then divide the array into two halves.

Steps to be followed:
1. If the target is equal to middle element we return the middle index.
2. If it is greater than the middle element, we divide array into two halves and discard the left half of the array. Because middle element is less, all left elements of the middle will also be less. Same way, if target is less than middle element, everything right of the middle will be always be larger than target.
    ```
    Case - 1
    input = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    target = 9
    middle = 5

    Case - 2
    input = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    target = 1
    middle = 5
    ```
    We can see everything left of the middle will always be less in Case - 1 and for Case - 2, it is the opposite, as the array is sorted in ascending order. Now we repeat these steps of comparing and dividing the array until we find the element, if the element does not exist we return -1.
3. Implementation can sometimes be tricky. To get the middle element we need middle index, for that we need start index or lowerBound of the array and end index or the higherBound. We will aslo need a while loop, for continuous repeated operation. 
    ```
    Case - 1 : When target is less than the middle element

    input = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10] (input.length = 11)
    target = 2

    Step - 1
    When the search is initiated, search space is the whole array.
    mid = (upperBound + lowerBound)/2 = (rightmost index + leftmost index)/2 = (10 + 0)/2
    mid = 5 
    target < input[mid]
    So we will discard every element from mid to the rightmost index.

    Step - 2
    In this step the searchspace has become almost half
    [0, 1, 2, 3, 4,.....]
    mid = (4 + 0)/2 = 2
    target == input[mid]

    o/p = 2

    Case - 2 : When target is greater than the middle element
    input = [9, 13, 24, 29, 36, 49, 57, 64, 72, 89, 97] (input.length = 11)
    target = 89

    Step - 1
    mid = (10 + 0)/2 = 5
    target > input[mid]
    89 > 49
    We will discard everything from 49 to the leftmost 9.

    Step - 2
    Present searchspace
    [......., 57, 64, 72, 89, 97]
    mid = (10 + 6)/2 = 8
    target > input[8] 
    89 > 72
    Everything from 72 to the first is dropped.

    Step - 3
    Present searchspace
    [......., 89, 72]
    mid = (10 + 9)/2 = 9.5 ~ 9
    target == input[mid] (89 == 89)

    o/p = 9

    Case - 3 : When target is equal to middle element
    input = [9, 13, 24, 29, 36, 49, 57, 64, 72, 89, 97] (input.length = 11)
    target = 49

    Step - 1
    mid = (10 + 0)/2 = 5
    target == input[mid] (49 == 49)

    o/p = mid = 5

    Case - 4 : When target does not exist in the array
    input = [-5, 2, 5, 9, 14, 25, 32]
    target = 13

    Step - 1
    mid = (6 + 0)/2 = 3
    target > input[mid] (13 > 9)

    Step - 2
    Present searchspace
    [....., 14, 25, 32]
    mid = (6 + 4) / 2 = 5
    target < input[mid] (13 < 25)

    Step - 3
    Present searchspace 
    [...., 14,...]
    mid = (4 + 4) / 2 = 4
    target < input[mid] (13 < 14)
    
    As we can see target does not match with the last left element, loop terminates (Because there is not searchspace left to look for) and the function returns -1

    While the loop is getting terminated let's see what are the present values
    lowerBound = 4 + 1 = 5
    upperBound = 5
    mid = 4
    So we can see that when the loop terminates lowerBound is greater than upperBound. We can say that when lowerBound is higher than upperBound there is no searchspace left and vice verse.

    
    Pseudo code
    binarySearch(nums, target)
        lowerBound = 0
        upperBound = nums.length - 1
        while (lowerBound <= upperBound)
             mid = (upperBound + lowerBound)/2
             if (target > nums[mid]) 
                lowerBound = mid + 1;
            else if (target < nums[mid]) 
                upperBound = mid - 1;
            else
                return mid;
        return -1
    ```
    The complete demonstration and pseduo code for Binary Search in 1D array.