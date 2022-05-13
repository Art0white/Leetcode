package Sword_to_Offer;

/**
 * @author Lovsog
 * 2022/5/10
 **/

// 错了
class Solution_04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int x = 0, y = 0;

        while(x < matrix.length && y < matrix[x].length) {
            System.out.println("1:" + x + " " + y);
            if(matrix[x][y] == target) {
                return true;
            } else if(x + 1 < matrix.length && matrix[x + 1][y] <= target){
                x++;
                continue;
            } else if(y + 1 < matrix[x].length && matrix[x][y + 1] <= target){
                y++;
                continue;
            }
            break;
        }
        x = 0;
        y = 0;
        while(x < matrix.length && y < matrix[x].length) {
            System.out.println("2:" + x + " " + y);
            if(matrix[x][y] == target) {
                return true;
            } else if(y + 1 <matrix[x].length && matrix[x][y + 1] <= target){
                y++;
                continue;
            } else if(x + 1 <matrix.length && matrix[x + 1][y] <= target){
                x++;
                continue;
            }
            break;
        }
        return false;
    }
}

class Solution_04_2 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int row = 0, column = columns - 1;
        while (row < rows && column >= 0) {
            int num = matrix[row][column];
            if (num == target) {
                return true;
            } else if (num > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }
}


public class NO_04 {
    public static void main(String[] args) {
        int[][] arr1 = new int[][]{
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        int[][] arr2 = new int[][]{
                {1,3,5,7,9},
                {2,4,6,8,10},
                {11,13,15,17,19},
                {12,14,16,18,20},
                {21,22,23,24,25}};
        System.out.println(new Solution_04_2().findNumberIn2DArray(arr2, 13));
    }
}
