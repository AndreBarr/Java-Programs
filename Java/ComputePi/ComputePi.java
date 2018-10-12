/**
 * Source code:  ComputePi.java
 *      Author:  Andre Barrientos 
 *  Student ID:  5443095  
 *  Assignment:  Program #1 - Calculating Pi
 *
 *      Course:  COP 3337 (Intermediate Programming)) 
 *     Section:  U06  
 *  Instructor:  William Feild  
 *    Due Date:  19 January 2017, at the beginning of class
 *
 *	I hereby certify that this collective work is my own
 *	and none of it is the work of any other person or entity.
 * 	______________________________________
 * 
 *	Language:  Java
 *	Compile/Run:
 *      javac ComputePi.java
 *      java ComputePi
 * 
 *  Description: The purpose of this program is to approximate the value of pi
 *              using an infinite series that is given. This program outputs the approximated 
 *              value of pi above and the actual value of pi below. 
 */

import java.lang.Math; //Used for the operator Math.pow and Math.PI

public class ComputePi 
{
    public static void main(String[] args) 
    {
        double pi = 0.0;
        double nextValue = 0.0;
        double lastPi = 0.0;
        double delta = 0.0;
        double accuracy = 0.000002; //This is the value to approximate the value of pi to six significant figures
        int counter = 0;
        
        do
        {
            double denominator = (2 * counter) + 1; //Increases to the next odd number with each iteration
            lastPi = pi;
            nextValue = Math.pow(-1, counter) * (1/denominator);
            pi = nextValue + pi;
            delta = pi - lastPi;
            counter++;
        }
        while (delta > accuracy || delta < -accuracy);
        
        double approximatedPi = pi * 4; //Our loop gives pi over 4; must multiply by 4 to get pi.
        
        System.out.println("Number of iterations: " + counter);
        System.out.println("This is the pi value approximated: " + approximatedPi);
        System.out.println("This is the actual value of pi: " + Math.PI);
    }
}