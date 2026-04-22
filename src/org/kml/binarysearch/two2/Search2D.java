package org.kml.binarysearch.two2;

public class Search2D {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = matrix[row].length - 1;
        while (row >= 0 && col >= 0) {
            if (matrix[row][col] == target) return true;
            if ( matrix[0][col] > target) {
                col--;
            } else if (matrix[row][0] > target) {
                row--;
            } else {
                if(binarySearc(matrix[row], target, 0, col)){
                    return true;
                }
                row--;
            }
        }
        return false;
    }
    static boolean binarySearc(int[] arr, int target, int low, int high){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target) return true;
            if(arr[mid] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] mat = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 5;
        System.out.println(searchMatrix(mat, target));
    }
}
