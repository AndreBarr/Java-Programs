/**
 * Source code:  LoopFibSequence.java
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
 * Purpose: Used to find the Fibonacci number requested iteratively.
 * 
 * Interfaces: Sequence.java (provides for the next() method)
 * 
 * Constants: BASE_CASE_VALUE   the value of the first two Fibonacci numbers
 *            BASE_CASES        the first two base cases
 * 
 * Constructor: LoopFibSequence(int requestedFib) sets nthFib to the requestedFib and resets nextFib
 * 
 * Class Methods: setFib(int requestedFib), loopFib(int nthFib), next()         
 */

public class LoopFibSequence implements Sequence
{
    //Constants
    private final int BASE_CASE_VALUE = 1;
    private final int BASE_CASES = 2;
    
    //Instance Variables
    private int nthFib;
    private int nextFib;

    /**
     * Sets nthFib to the requestedFib and resets nextFib
     * @param requestedFib the requested Fibonacci number
     */
    public LoopFibSequence(int requestedFib)
    {
        setFib(requestedFib);
    }

    /**
     * Sets the nthFib to a new requested value and resets the nextFib variable so that
     * the same object can be used to compute a different amount of Fibonacci numbers
     * @param requestedFib 
     */
    public void setFib(int requestedFib)
    {
        nthFib = requestedFib;
        nextFib = 0;
    }

    /**
     * Computes the next Fibonacci number iteratively. Does this by adding the previous
     * two Fibonacci numbers (starting with the first two which are both of value one)
     * until the desired Fibonacci number is reached.
     * @param nthFib the Fibonacci number to be computed
     * @return the requested Fibonacci number
     */
    private long loopFib(int nthFib)
    {
        if (nthFib <= BASE_CASES)
        {
            return BASE_CASE_VALUE;
        }
        else
        {
            long olderValue = 1;
            long oldValue = 1;
            long newValue = 1;
            //previousFib is set at 3 since that is the first Fibonacci number that does
            //not have a base case
            for (int previousFib = 3; previousFib <= nthFib; previousFib++)
            {
                newValue = oldValue + olderValue;
                olderValue = oldValue;
                oldValue = newValue;
            }
            return newValue;
        }
    }

    /**
     * Computes all the Fibonacci numbers starting with the first and ending with the
     * requested Fibonacci number, using the loopFib method
     * @return the next Fibonacci number
     */
    @Override
    public long next()
    {
        long nextFibNum = 0;
        if (nextFib < nthFib)
        {
            nextFibNum = loopFib(nextFib + 1);
            nextFib++;
        }
        return nextFibNum;
    }
}
