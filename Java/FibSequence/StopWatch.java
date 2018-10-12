/**
 * Source code:  StopWatch.java
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
 *  Purpose: The purpose of this class is to be able to compute the elapsed time between
 *           different moments in a program in nanoseconds.
 * 
 * Constructor: StopWatch() resets the elapsed time and stops the clock
 * 
 * Class Methods: start(), stop(), getElapsedTime(), reset()
 */

public class StopWatch
{
    //Instance Variables
    private long elapsedTime;
    private long startTime;
    private boolean isRunning;
    
    /**
     * Resets the elapsed time and stops the clock
     */
    public StopWatch()
    {
        reset();
    }
    
    /**
     * Checks if the clock is already running, if it is it does nothing. If the clock
     * is not running it starts the clock and records the system time at that instance
     */
    public void start()
    {
        if (isRunning)
        {
            return;
        }
        isRunning = true;
        startTime = System.nanoTime();
    }
    
    /**
     * Stops the clock if it was running and records the system time at that instance, then
     * calculates the elapsedTime from when the clock was started. If the clock had already
     * stopped then it does nothing.
     */
    public void stop()
    {
        if (!isRunning)
        {
            return;
        }
        isRunning = false;
        long endTime = System.nanoTime();
        elapsedTime = elapsedTime + endTime - startTime;
    }
    
    /**
     * If the clock is running it calculates the elapsedTime from when it was started
     * to that instance. If the clock has stopped running it simply returns the elapsedTime
     * value stored.
     * @return the elapse time between the start and stop of the clock
     */
    public long getElapsedTime()
    {
        if (isRunning)
        {
            long endTime = System.nanoTime();
            return elapsedTime + endTime - startTime;
        }
        else
        {
            return elapsedTime;
        }
    }
    
    /**
     * Resets the elapsed time and stops the clock
     */
    public void reset()
    {
        elapsedTime = 0;
        isRunning = false;
    }
} 