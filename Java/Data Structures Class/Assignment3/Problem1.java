 /*********************************************************************
 Purpose/Description: Finding the number of integers within a certain range
 *                    (inclusive) in O(1).
 Author’s Panther ID: 5443095
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 ********************************************************************/ 

class NumbersRange
{
    int [] rank;
    
    /**
     * First bucket sort the array given. Then starting with index 1 in the "bucket"
     * add its data value with the one previous to get the amount of numbers less
     * than or equal to that index. Ex. index 5 will hold the amount of numbers less than
     * or equal to five after being preprocessed.
     * @param arr the array to be preprocessed
     * @param k   the biggest number allowed in the array
     */
    public void preProcess(int [] arr, int k)
    {
        rank = new int[k + 1];
        
        for(int i = 0; i < arr.length; i++)
        {
            rank[arr[i]]++;
        }
        
        for(int j = 1; j <= k; j++)
        {
            rank[j] = rank[j] + rank[j - 1];
        }
    }
    
    /**
     * The value in the at the right index is the amount of numbers less than or
     * equal to right. The value at left index is the amount of numbers less than
     * or equal to left. Subtracting these two would give you the amount of numbers
     * greater than left and less than or equal to right. We want it to be inclusive
     * so instead of subtracting the left index we subtract left - 1 index so that
     * we include the values equal to left as well.
     * @param left  the left range
     * @param right the right range
     * @return the amount of numbers within the given range (inclusive).
     */
    public int numInRange(int left, int right)
    {
        return rank[right] - rank[left - 1];
    }
}

public class Problem1
{
    public static void main(String[] args)
    {
        int [] arr = {1,2,3,4,5,6,7,8,9,10};
        NumbersRange test = new NumbersRange();
        test.preProcess(arr, 10);
        System.out.println(test.numInRange(1, 10));
    }
}