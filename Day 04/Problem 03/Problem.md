# Single Number

[Problem Link](https://leetcode.com/problems/single-number/description/)

Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:\
Input: nums = [2,2,1]\
Output: 1

Example 2:\
Input: nums = [4,1,2,1,2]\
Output: 4

Example 3:\
Input: nums = [1]\
Output: 1

Constraints:\
1 <= nums.length <= 3 *104
-3* 104 <= nums[i] <= 3 * 104
Each element in the array appears twice except for one element which appears only once.

## Solution Approach

Given an array where each number is repeated twice except one, we need to find the unique no. Catch is we have to do it in linear time and constant space.

Let's try the options without meeting the requirements.

1. Approach - 1 : We create a nested for loop and check each number individually and save it somewhere else. This neither satisfies time requirement nor the space requirement.
2. Approach - 2 : We can sort the array and check the adjacent value if it matches we move on, otherwise we continue untill we find the value. Now, here we are matching space requirement but not time. Even the most optimal sorting algorithm takes nlogn time.

If we go through internet we can find few more solutions that doesn't meet the requirements.

### The One & Only Solution

We have studied log gates in school and also in college in digital electronics and computer architectur classes. This is where it comes to resque.

Because we need the value that is unique. We know from our logic gates knowledge XOR provides us what we are lookinng for.

### XOR Truth Table

| A | B | A ⊕ B |
|---|---|-------|
| 0 | 0 |   0   |
| 0 | 1 |   1   |
| 1 | 0 |   1   |
| 1 | 1 |   0   |

Now if we put 4 ⊕ 4 together it will be 0. Explanation:

1 0 0 ⊕ 1 0 0 = 0 0 0

4 + 4 + 5 = 1 0 0 + 1 0 0 + 1 0 1 = 1 0 1 (Because four and four cancels out)

Now if we apply this iteratively to our given array we will get the only unique number and repeated numbers will cancel each other.

### Java Method

```java
int singleNumber(int[] nums) {
        int singleNum = 0;
        for (int num : nums) {
                singleNum ^= num;
            }
        return singleNum;
    }
```

This is it. This is the solution that satisfies the conditions provided.
