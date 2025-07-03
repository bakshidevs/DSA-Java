 
 # Missing Number


[Link](https://leetcode.com/problems/missing-number/description/)

Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

 

Example 1:\
Input: nums = [3,0,1]\
Output: 2

Explanation:\
n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

Example 2:\
Input: nums = [0,1]\
Output: 2

Explanation:\
n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.

Example 3:\
Input: nums = [9,6,4,2,3,5,7,0,1]\
Output: 8

Explanation:\
n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums. 

## Solution Approach

From the problem description we can say this is a whole number sequence. Including the missing number the total number of elements nums.length + 1 (because 0 is a whole number and is present as lower bound). Now if we exclude 0 from the sequence it would be a natural number sequence. And the upper bound will be the length(no of elements) of the sequence.

    [0, 1, 2, 3, 4, 5] length = 6, no of natural numbers = 5
    
Because i/p will have one number missing so the length of i/p array will be same as the number of natural numbers present in that array.

There are two possible approach to the solution

1. We pick the largest number or the upper bound from the sequence and find the total supposed sum of the sequence. And find the sum of all present elements. And their differences will be the missing number. Now this will introduce a bug when the missing number is the upper bound, then we will have the wrong answer.
    ```
    Case - 1
    input = [2, 4, 1, 5, 0]
    o/p = (5 * (5 + 1)) / 2 - (2 + 4 + 1 + 5 + 0) {for/foreach loop to get the sum}
    => 15 - 12 => 3

    Case - 2
    input = [0, 2, 1]

    Now here upper bound is 3 but that is missing from the array, it will introduce a bug, wrong answer to some inputs.
    ```
    
    

2. As we have discussed before, the number of natural numbers present in the final array is same as the length of input array. So we can use this to get the actual sum. And then we calculate the sum of elements present in the input array and we will get the missing number from the sum difference.
    ```
    Case - 1
    input = [2, 4, 1, 5, 0]
    o/p = (input.length * (input.length + 1))/2 - totalSum (a for loop to get the sum)

    We are applying the formula for the sum of first n natural numbers to get the supposed total sum.

    o/p = (5 * (5 + 1)) / 2 - (2 + 4 + 1 + 5 + 0) {for/foreach loop to get the sum}
    => 15 - 12 => 3

    Case - 2
    input = [0, 2, 1]
    o/p = (3 * 4) / 2 - (0 + 2 + 1)
    => 6 - 3 => 3

    Case - 3
    input = [3, 2, 1, 4, 5];
    o/p = (5 * 6) / 2 - (3 + 2 + 1 + 4 + 5)
    => 15 - 15 => 0
    ```
    As we can see even if the only number missing is 0 then difference will be 0. There, we have our solution.