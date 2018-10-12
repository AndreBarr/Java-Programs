 /*********************************************************************
 Purpose/Description: Search for an element in a matrix which rows and columns
                      are in descending order
 Author’s Panther ID: 5443095
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 Comments: In a matrix that is sorted in this fashion we can see that the most top left
           number is the greatest number and the lower right number is the smallest number.
           Starting the search at these points would not be helpful because we would either
           eliminate nothing or both the row and the column that the number we are checking is on.
           Starting the search at the other two corners would allow us to eliminate either the row
           or the column which would help us make a decision on whether to a different row or column.
 Time Complexity: Every time we go through the while loop the row or column changes value until one of them
                  is out of the bounds of the matrix. For this reason the while loop will execute at most 2N - 2
                  times for a matrix of size N X N. Starting at the bottom left corner, in the worst case you
                  would go up the the first row which would happen in N - 1 iterations of the while loop and then
                  to the last column which would also happen in N - 1 iterations. Adding these two values up we 
                  get the 2N - 2 max iterations. All the other operations occur in constant time, so this algorithm
                  has linear time complexity (O(N)).
 ********************************************************************/ 

class MatrixSearch
{
    /**
     * Starts at a point that is at the end of a row or column and the beginning of a column or row.
     * This algorithm starts at the bottom left corner. If that value is greater than the target then
     * we know it cannot be in the column so we increment column index to move to the next. If the value is
     * less than the target then we know it cannot be in that row so we decrement the row index to move
     * up a row. If the value is equal to the target returns true. If the row or column index goes out of
     * bounds then the value was not in the list.
     * @param matrix the sorted N x N matrix
     * @param target the value we are looking for
     * @return if the value is in the list or not
     */
    public boolean search(int[][] matrix, int target)
    {
        int column = 0;
        int row = matrix.length - 1;

        while ((column < matrix.length) && (row >= 0))
        {
            if (matrix[row][column] > target)
            {
                column++;
            }
            else if (matrix[row][column] < target)
            {
                row--;
            }
            else
            {
                return true;
            }
        }

        return false;
    }
}

public class Problem2
{
    public static void main(String[] args)
    {   
        int[][] numList = {{26, 22, 17, 10},
                           {19, 16, 12, 7},
                           {12, 10, 7, 4},
                           {5, 4, 2, 1}};
        MatrixSearch test = new MatrixSearch();
        if (test.search(numList, 10))
        {
            System.out.println("Target Found");
        }
        else
        {
            System.out.println("Target Not Found");
        }
    }
}
