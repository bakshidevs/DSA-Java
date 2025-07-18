
#

Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
![alt text](PascalTriangleAnimated2.gif)

Example 1:

Input: numRows = 5\
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

Example 2:

Input: numRows = 1\
Output: [[1]]

Constraints:

1 <= numRows <= 30

## Solution Approach

If we look at the problem, each sub array has 1 in the end. So, when we are at the lower bound or upperBound we simply add a to that position.

Middle elements: Each middle element is the sum of previous array's two elements at present position the element is and the previous position (`nums[i][j] = nums[i-1][j-1] + nums[i-1][j]`).

### Algorithm

Step 1: Check if the position is 0, add 1.(`if(j==0) return 1;`)\
Step 2: Check if the position is end index, add 1.(`if(i==j) return 1;)`)\
Step 3: Else, return the sum of previous array's two elements at present position the element is and the previous position (`nums[i-1][j-1] + nums[i-1][j]`).\

### Code

```java
List<List<Integer>> pascalsTriangle(int numRows) {
    List<List<Integer>> matrix = new ArrayList<>();
    for (int i = 0; i < numRows; i++) {
        matrix.add(new ArrayList<>());
        for (int j = 0; j <= i; j++) {
            if (j == 0 || i == j) {
                matrix.get(i).add(1);
            } else {
                matrix.get(i).add(matrix.get(i - 1).get(j - 1) + matrix.get(i - 1).get(j));
            }
        }
    }
    return matrix;
}
```

That's it.
