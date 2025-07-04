
# Divisible and Non-divisible Sums Difference

[Problem Link](https://leetcode.com/problems/divisible-and-non-divisible-sums-difference/description/)

You are given positive integers n and m.

Define two integers as follows:

num1: The sum of all integers in the range [1, n] (both inclusive) that are not divisible by m.
num2: The sum of all integers in the range [1, n] (both inclusive) that are divisible by m.
Return the integer num1 - num2.

Example 1:

Input: n = 10, m = 3\
Output: 19\
Explanation: In the given example:

- Integers in the range [1, 10] that are not divisible by 3 are [1,2,4,5,7,8,10], num1 is the sum of those integers = 37.
- Integers in the range [1, 10] that are divisible by 3 are [3,6,9], num2 is the sum of those integers = 18.
We return 37 - 18 = 19 as the answer.

Example 2:

Input: n = 5, m = 6\
Output: 15\
Explanation: In the given example:

- Integers in the range [1, 5] that are not divisible by 6 are [1,2,3,4,5], num1 is the sum of those integers = 15.
- Integers in the range [1, 5] that are divisible by 6 are [], num2 is the sum of those integers = 0.
We return 15 - 0 = 15 as the answer.

Example 3:

Input: n = 5, m = 1\
Output: -15\
Explanation: In the given example:

- Integers in the range [1, 5] that are not divisible by 1 are [], num1 is the sum of those integers = 0.
- Integers in the range [1, 5] that are divisible by 1 are [1,2,3,4,5], num2 is the sum of those integers = 15.
We return 0 - 15 = -15 as the answer.

Constraints:\
1 <= n, m <= 1000

## Solution Approach

Let's breakdown the problem. We have two sets of natural numbers, first is of range 1 to n (including n) [x : x is not divisible by m] and second is of range 1 to m (including m) [x : x is divisble by m] and we need to find the difference between the sum of all elements of both set.

```
Example - 1
n = 5
m = 2
set1 = {1, 3, 5}
set2 = {2, 4}
difference = (1 + 3 + 5) - (2 + 4) => 3

Example - 2
n = 15
m = 3
set1 = {1, 2, 4, 5, 7, 8, 10, 11, 13, 14}
set2 = {3, 6, 9, 12, 15}
diff = 75 - 45 = 30
```

Now, if we look into it we can see the union of set1 and set2 is a set of first n natural numbers and all elements of set2 are multiples of m. This simplifies the solution, we don't need any loop. We can calculate the difference with simple number theory.
```
Case - 1 
n = 15
m = 3
set1 = {1, 2, 4, 5, 7, 8, 10, 11, 13, 14}
set2 = {3, 6, 9, 12, 15}

U = set1 U set2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}
Sum of all elements of U = (n * (n + 1))/2 [n = 15] => 15*16 / 2 => 120
sum of all elements of set2 = 3 * (1 + 2 + 3 + 4 + 5) => (3*5*6)/2 = 90 / 2 = 45
sum of all elements of set1 = 120 - 45 (Because we included the elements of set2 while taking the union of both sets) = 75

difference = 75 - 45 => 30
```
Steps to follow to get the answer (mathematically):

1. Step - 1: Take union of both set (We get a set of first n natural numbers)
2. Step - 2: Calculate the sum using (n * (n + 1))/2 this forumla.
3. Step - 3: Calculate the sum of set2. Because all elements are multiples of m, we take m common and use the same formula [(n * (n + 1))/2].
4. Step - 4: Subtract set2 sum of from union set sum to get the sum of set1. Because while taking union we took set2 elements in.
5. Step - 5: Calculate the difference. (Sum of all elements in set1 - Sum of all elements in set2).

This is it.

## Implementation of Code

We just implement the steps in a function/method and return the value.

```
int differenceOfSums(int n, int m) {
        int sumOfU = (n * (n + 1))/2; // sum of union
        int numOfM = n/m; // no of elements in set2
        int sumOfM = ((numOfM * (numOfM + 1))/2 * m); // sum of all elements in set2
        return sumOfU - 2*sumOfM; // the difference, 2 is multiplied. Sum of set2 is subtracted twice. One for the union inclusion of set2 and one for getting the difference
    }
```
