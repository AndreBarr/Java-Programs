/**
 * Source code:  Sequence.java
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
 * Purpose: Provides for the next() method
 * 
 * Class methods (abstract): next()
 */

public interface Sequence
{
    /**
     * Returns the next integer value, however specified
     * @return the integer value determined
     */
    long next();
}
