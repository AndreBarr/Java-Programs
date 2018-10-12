 /*********************************************************************
 Purpose/Description: Return a list of all the possible sums from a list of numbers
 Author’s Panther ID: 5443095
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 ********************************************************************/ 

import java.util.Arrays;

class AllSumsPossible
{
    /**
     * Gets the sums of the all the numbers before the last one and then adds the last
     * number in numList to all the sums and stores all those values in an array.
     * @param numList the numbers to get the sums from
     * @return the list of all the possible sums
     */
    public int [] allSums(int [] numList)
    {
        if (numList.length <= 1)
        {
            int [] allSums = {0, numList[0]};
            return allSums;
        }
        
        int [] numsList = Arrays.copyOf(numList, numList.length - 1);
        int [] allSums = allSums(numsList);
        int [] newSums = new int [allSums.length * 2];
        
        for (int index = 0; index < newSums.length; index++)
        {
            if (index < allSums.length)
            {
                newSums[index] = allSums[index];
            }
            else
            {
                newSums[index] = numList[numsList.length] + allSums[index - allSums.length];
            }
        }
        
        return newSums;
    }
}

public class Problem1
{
    public static void main(String[] args)
    {
        int [] test = {1, 2, 4, 5};
        AllSumsPossible testing = new AllSumsPossible();
        int [] allSums = testing.allSums(test);
        for (int sum: allSums)
        {
            System.out.print(sum + " ");
        }
    }
}