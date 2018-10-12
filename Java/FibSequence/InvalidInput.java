/**
 * Source code:  InvalidInput.java
 *      Author:  Andre Barrientos 
 *  Student ID:  5443095  
 *  Assignment:  Program #6 Fibonacci Numbers
 *
 *      Course:  COP 3337 (Intermediate Programming)  
 *     Section:  U06  
 *  Instructor:  William Feild  
 *    Due Date:  April 20, at the beginning of classs
 * 
 *    Language:  Java
 *    Compile/Run:
 *    javac Sequence.java  FibSequence.java LoopFibSequence.java FastFibSequence.java
 *          SequenceDemo.java InvalidInput.java StopWatch.java
 *    java SequenceDemo (with two arguments (input file followed by output file))
 * 
 * Purpose: User defined exception class
 * 
 * Constructors: InvalidInput() allows the exception to be thrown
 *               InvalidInput(String errorMessage) allows the exception to be thrown with a message
 */

import java.io.IOException;

public class InvalidInput extends IOException
{
    /**
     * Allows the exception to be thrown
     */
    public InvalidInput ()
    {
		
    }
    
    /**
     * Allows the exception to be thrown with a message
     * @param errorMessage the error message
     */
    public InvalidInput (String errorMessage)
    {
    	super(errorMessage);
    }
}
