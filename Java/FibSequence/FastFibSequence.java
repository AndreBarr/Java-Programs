/**
 * Source code:  FastFibSequence.java
 *      Author:  Andre Barrientos 
 *  Student ID:  5443095  
 *  Assignment:  Program #6 Fibonacci Numbers
 *
 *      Course:  COP 3337 (Intermediate Programming)  
 *     Section:  U06  
 *  Instructor:  William Feild  
 *    Due Date:  April 20, at the beginning of class
 * 
 *    Language:  Java
 *    Compile/Run:
 *    javac Sequence.java  FibSequence.java LoopFibSequence.java FastFibSequence.java
 *          SequenceDemo.java InvalidInput.java StopWatch.java
 *    java SequenceDemo (with two arguments (input file followed by output file))
 * 
 * Purpose: Used to find the Fibonacci number requested quickly and recursively.
 * 
 * Interfaces: Sequence.java (provides for the next() method)
 * 
 * Constants: BASE_CASE_VALUE   the value of the first two Fibonacci numbers
 *            BASE_CASES        the first two base cases
 * 
 * Constructor: FastFibSequence(int requestedFib) creates an array with the requested length,
 *                                                sets nthFib to the requestedFib and resets nextFib
 * 
 * Class Methods: setFib(int requestedFib), fastFib(int nthFib), next()         
 */

public class FastFibSequence implements Sequence
{
    //Constants
    private final int BASE_CASE_VALUE = 1;
    private final int BASE_CASES = 2;
    
    //Instance Variables
    private long[] fibNums;
    private int nthFib;
    private int nextFib;

    
    /**
     * Creates an array with the requested length, sets nthFib to the requestedFib, and resets nextFib
     * @param requestedFib the requested Fibonacci number
     */
    public FastFibSequence(int requestedFib)
    {
        setFib(requestedFib);
    }

    /**
     * Creates a new array with the requested length, sets the nthFib to a new requested value
     * and resets the nextFib variable so that the same object can be used to compute a
     * different amount of Fibonacci numbers
     * @param requestedFib 
     */
    public void setFib(int requestedFib)
    {
        fibNums = new long[requestedFib];
        nthFib = requestedFib;
        nextFib = 0;
    }

    /**
     * Computes the next Fibonacci number quickly and recursively. Does this by saving
     * the already computed Fibonacci values in an array, so that the same work is not
     * being done twice. The Fibonacci number computed is stored at the index that is
     * one less than that numbers position in the Fibonacci Sequence (ex. 3rd Fibonacci
     * number is stored at index 2). This is because the first value in an array is stored
     * at index 0 and not 1.
     * @param nthFib the Fibonacci number to be computed
     * @return the requested Fibonacci number
     */
    private long fastFib(int nthFib)
    {
        if (nthFib <= BASE_CASES)
        {
            if (nthFib == BASE_CASES)
            {
                fibNums[1] = BASE_CASE_VALUE;
            }
            fibNums[0] = BASE_CASE_VALUE;
        }
        else
        {
            //The 'oldest' value is stored at the index that is 3 less than the
            //desired Fibonacci number instead of 2, since arrays start at position
            //0 not 1
            fibNums[nthFib - 1] = fastFib(nthFib - 1) + fibNums[nthFib - 3];
        }
        return fibNums[nthFib - 1];
    }

    /**
     * Computes all the Fibonacci numbers starting with the first and ending with the
     * requested Fibonacci number, using the fastFib method
     * @return the next Fibonacci number
     */
    @Override
    public long next()
    {
        long nextFibNum = 0;
        if (nextFib < nthFib)
        {
            nextFibNum = fastFib(nextFib + 1);
            nextFib++;
        }
        return nextFibNum;
    }
}
