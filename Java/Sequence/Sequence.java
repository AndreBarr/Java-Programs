/**
 * Source code:  Sequence.java
 *      Author:  Andre Barrientos 
 *  Student ID:  5443095  
 *  Assignment:  Program #5 SequenceDemo
 *
 *      Course:  COP 3337 (Intermediate Programming)  
 *     Section:  U06  
 *  Instructor:  William Feild  
 *    Due Date:  March 27, at the beginning of class
 * 
 *	Language:  Java
 *	Compile/Run:
 *      javac Sequence.java  PrimeSequence.java SequenceDemo.java
 *      java SequenceDemo (two arguments separated by at least one space)
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
    int next();
}
