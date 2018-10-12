/**
 * Source code:  PrimeSequence.java
 *      Author:  Andre Barrientos 
 *  Student ID:  5443095  
 *  Assignment:  Program #5 SequenceDemo
 *
 *      Course:  COP 3337 (Intermediate Programming)  
 *     Section:  U06  
 *  Instructor:  William Feild  
 *    Due Date:  March 27, at the beginning of class
 * 
 *      Language:  Java
 *	Compile/Run:
 *      javac Sequence.java  PrimeSequence.java SequenceDemo.java
 *      java SequenceDemo (two arguments separated by at least one space)
 * 
 * Purpose: Used to find the next prime after a specified number.
 * 
 * Interfaces: Sequence.java (provides for the next() method)
 * 
 * Constants: FIRST_PRIME is the first prime number
 *            ODD_NUM_START is the first odd number after 1
 * 
 * Class Methods: isPrime(int nextInt), setStart(int startValue), next()
 */

public class PrimeSequence implements Sequence
{ 
    //Constants
    private final int FIRST_PRIME = 2;
    private final int ODD_NUM_START = 3;

    //Instance Variables
    private int inputValue = 0;

    /**
     * Checks if a number is prime; first it compares it to the first prime since it is the only prime
     * that ends with the number two. Then checks if when divided by the first prime it has no remainder.
     * For the final test we get the square root of the number we are testing and cast it as an integer
     * so that we can use it for our for-loop. This is done because the square root of a number will always
     * be the middle factor (ex. for the number 36 it's factors are: 1, 2, 3, 4, 6, 9, 12, 18, 36) notice the middle
     * factor is the square root of 36, because of this there is no need to test numbers greater than the square root
     * of a number since it should have already shown a factor for it before then if it was a composite number.
     * Also the index starts at the first odd number and is incremented by two so that we do not test even numbers greater
     * than two unnecessarily since all those numbers are not prime.
     * @param nextInt the next integer to be check if it is a prime number
     * @return whether or not that integer is a prime or not (true or false)
     */
    private boolean isPrime(int nextInt)
    {
        if (nextInt == FIRST_PRIME)
        {
            return true;
        }
        else if (nextInt % FIRST_PRIME == 0)
        {
            return false;
        }
        else
        {
            int middleFactor = (int) Math.sqrt((double) nextInt);
            
            for (int index = ODD_NUM_START; index <= middleFactor; index += FIRST_PRIME)
            {
                if (nextInt % index == 0)
                {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Sets the start value for finding primes
     * @param startValue the number after which we start looking for primes
     */
    public void setStart(int startValue)
    {
        inputValue = startValue;
    }

    /**
     * Gets the next prime number by incrementing the start value and testing if its prime;
     * continues to do this until the next prime is found
     * @return the next prime number
     */
    @Override
    public int next()
    {
        do
        {
            inputValue++;
            
            if (isPrime(inputValue))
            {
                return inputValue;
            }
        } while (!isPrime(inputValue));

        return inputValue;
    }
}
