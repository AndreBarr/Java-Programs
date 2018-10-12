/**
 * Source code:  FibSequence.java
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
 * Purpose: Used to find the Fibonacci number requested recursively.
 * 
 * Interfaces: Sequence.java (provides for the next() method)
 * 
 * Constants: BASE_CASE_VALUE   the value of the first two Fibonacci numbers
 *            BASE_CASES        the first two base cases
 * 
 * Constructor: FibSequence(int requestedFib) sets nthFib and resets nextFib
 * 
 * Class Methods: nextFib(int nthFib), next()
 */

public class FibSequence implements Sequence
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
    public FibSequence(int requestedFib)
    {
        nthFib = requestedFib;
        nextFib = 0;
    }

    /**
     * Computes the next Fibonacci number recursively. Does this by knowing that we
     * must first know the previous two Fibonacci numbers to get the next one.
     * @param nthFib the Fibonacci number to be computed
     * @return the requested Fibonacci number
     */
    private long nextFib(int nthFib)
    {
        if (nthFib <= BASE_CASES)
        {
            return BASE_CASE_VALUE;
        }
        else
        {
            return nextFib(nthFib - 1) + nextFib(nthFib - 2);
        }
    }

    /**
     * Computes all the Fibonacci numbers starting with the first and ending with the
     * requested Fibonacci number, using the nextFib method
     * @return the next Fibonacci number
     */
    @Override
    public long next()
    {
        long nextFibNum = 0;
        if (nextFib < nthFib)
        {
            nextFibNum = nextFib(nextFib + 1);
            nextFib++;
        }
        return nextFibNum;
    }
}
