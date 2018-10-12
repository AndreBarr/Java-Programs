 /*********************************************************************
 Purpose/Description: Search considering two dividing points.
 Author’s Panther ID: 5443095
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 Time Complexity: The size of the search is cut into about a third every time the
 *                  method is executed. T(n) = T(n/3) + c, where c is the operations
 *                  that take constant time to execute. T(n/3) = T(n/9) + 2c; so in
 *                  general T(n) = T(n/3^k) + kc. T(0) = T(1) = c so 3^k = n and 3^k > n.
 *                  k = log(n) where log is base 3. Plugging that into the general equation
 *                  we get T(n) = T(1) + log(n)c. Time complexity is logarithmic (O(log(n)))
 ********************************************************************/ 

class RecursiveSearch
{
    /**
     * If the end of the search is greater than or equal to the start then we will
     * make two diving points and determine which of the three regions created could the
     * target value be in. After this is determined, that region is search.
     * @param arr the array to be searched
     * @param l the index to start the search
     * @param r the index of the end of the search
     * @param x the target value
     * @return the position of x
     */
    public int terSearch(int[] arr, int l, int r, int x)
    {
        if (l <= r)
        {   
            int d1 = l + ((r - l) / 3);
            int d2 = d1 + ((r - l) / 3);
            
            if (arr[d1] > x)
            {
                r = d1 - 1;
            }
            else if (arr[d2] < x)
            {
                l = d2 + 1;
            }
            else
            {
                if (arr[d1] == x)
                {
                    return d1;
                }
                else if (arr[d2] == x)
                {
                    return d2;
                }
                l = d1 + 1;
                r = d2 - 1;
            }
            return terSearch(arr, l, r, x);
        }
        return -1;
    }
}

public class Problem3
{
    public static void main(String[] args)
    {
        RecursiveSearch test = new RecursiveSearch();
        int[] naturalNums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("At position " + test.terSearch(naturalNums, 0, naturalNums.length, 6));
        System.out.println("(if -1, not in list)");
    }
}
