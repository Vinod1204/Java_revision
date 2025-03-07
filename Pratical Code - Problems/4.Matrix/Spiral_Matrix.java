/*
 * 
Spiral Matrix

Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
 */

import java.util.ArrayList;
import java.util.List;

public class Spiral_Matrix
{
    public static void main(String[] args) {
        int[][] matrix = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12}
        };
        System.out.println(spiralOrder(matrix));
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        int size = matrix.length * matrix[0].length;
        while(result.size() < size){
            for(int i = left; i <= right && result.size() < size; i++){
                result.add(matrix[top][i]);
            }
            top++;
            for(int i = top; i <= bottom && result.size() < size; i++){
                result.add(matrix[i][right]);
            }
            right--;
            for(int i = right; i >= left && result.size() < size; i--){
                result.add(matrix[bottom][i]);
            }
            bottom--;
            for(int i = bottom; i >= top && result.size() < size; i--){
                result.add(matrix[i][left]);
            }
            left++;
        }
        return result;
    }
}