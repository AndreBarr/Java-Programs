/**
 * Source code:  Die.java
 *      Author:  Andre Barrientos 
 *  Student ID:  5443095  
 *  Assignment:  Program #3 Craps
 *
 *      Course:  COP 3337 (Intermediate Programming)  
 *     Section:  U06  
 *  Instructor:  William Feild  
 *    Due Date:  February 16, at the beginning of class
 *    Language:  Java
 *Compile/Run:
 *      javac Analyzer.java  Craps.java Die.java
 *      java Analyzer
 * 
 *     Purpose: Simulate a dice roll with n - sides.
 *
 *Class Methods: rollDie()
 */
import java.util.Random; //Used to generate random numbers
/**
 * A class to implement an n-sided die
 */
public class Die
{
   // random number generator object
   private Random randomNum = new Random();
	 
    //Set this value to the desired number of sides [3 - 100].
    private int sides = 6;

   /**
    * Rolls one die and returns the number rolled
    * @return a random int from 1 to sides.
    */
   public int rollDie()
   {
      return randomNum.nextInt(sides) + 1;
   }
}
