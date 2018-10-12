/*********************************************************************
 Purpose/Description: Returns the position of the "last survivor"
 Author’s Panther ID: 5443095
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 Time Complexity: The length of the array which is given as value n is subtracted
 *                  by 1 every method execution. T(n) = T(n - 1) + c, where c is the operations
 *                  that take constant time to execute.
 *                  In general T(n) = T(1) + nc. Since T(1) and T(0) are constant then we
 *                  only have nc left which gives us linear time complexity (O(n))
 ********************************************************************/ 

class LastSurvivor
{
    /**
     * The position of were the lastSurvivor would be if the array was length n - 1
     * is used to find the position of where it will be at length n.
     * Base cases:1) length of array is 1 so return 0;
     *            2) n = 1 so return 1
     * @param arr the array containing number 1 through n
     * @param n the length of the array
     * @param k the "jump" amount
     * @return the position of the last survivor
     */
    public int lastSurvivor(int [] arr, int n, int k)
    {
        if (arr.length <= 1)
        {
            return 0;
        }
        else if (n <= 1)
        {
            return 1;
        }
        int lastSurvivor = (lastSurvivor(arr, n - 1, k) + k - 1) % n;
        if (n == arr.length)
        {
            return lastSurvivor;
        }
        return lastSurvivor + 1;
    }
}

public class Problem1
{
    public static void main(String[] args)
    {
        LastSurvivor test = new LastSurvivor();
        int [] arr = {1 , 2, 3, 4, 5, 6, 7};
        System.out.println("Last survivor at position: " + (test.lastSurvivor(arr, 7, 3)));
    }
}