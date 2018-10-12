/**
 * Source code:  SequenceDemo.java
 *      Author:  Andre Barrientos 
 *  Student ID:  5443095  
 *  Assignment:  Program #5 SequencDemo
 *
 *      Course:  COP 3337 (Intermediate Programming)  
 *     Section:  U06  
 *  Instructor:  William Feild  
 *    Due Date:  March 27, at the beginning of class
 *
 *      I hereby certify that this collective work is my own
 *	and none of it is the work of any other person or entity.
 * 	______________________________________
 * 
 *		Language:  Java
 *	Compile/Run:
 *      javac Sequence.java  PrimeSequence.java SequenceDemo.java
 *      java SequenceDemo (two arguments separated by at least one space)
 * 
 *  Description: The purpose of this program is to analyze how many instances of each digit occur on the
 *               last digit of each prime number and to print out those prime numbers.
 * 
 *    Constants: FIRST_ARGUMENT     the index of the first argument
 *               SECOND_ARGUMENT    the index of the second (last) argument
 *               MIN_ARG_VALUE      the minimum argument value
 *               MAX_ARGUMENTS      the maximum number of arguments
 *               NUM_OF_DIGITS      the number of digits [0 - 9]
 *               MAX_COLUMNS        the maximum number of columns for the primes table
 *               EXTRACT_LAST_DIGIT the value necessary to extract the last digit from a number
 * 
 *  Input: Two integer values greater than or equal to one (command-line input)
 * 
 *  Output: Displays the requested primes in table as well as a histogram of the data gathered.
 * 
 *  Process: 1. The input is validated.
 *           2. The prime numbers are found and printed.
 *           3. The data is collected from the list of primes.
 *           4. The data is displayed via a histogram with a scale.
 */

import java.util.Scanner; //For access to read and write methods

public class SequenceDemo
{
    //Constants
    private final static int FIRST_ARGUMENT = 0;
    private final static int SECOND_ARGUMENT = 1;
    private final static int MIN_ARG_VALUE = 1;
    private final static int MAX_ARGUMENTS = 2;
    private final static int NUM_OF_DIGITS = 10;
    private final static int MAX_COLUMNS = 10;
    private final static int EXTRACT_LAST_DIGIT = 10;
   
    /**
     * Checks if the command line input is exactly two arguments in length, an empty
     * string is not one of the arguments, and both arguments are positive integer values
     * greater than or equal to one.
     * @param args the input stream from the command line
     * @return if the input is valid (true or false)
     */
    public static boolean validate(String[] args)
    {
        boolean argsValid = false;
        int numOfArgs = args.length;
        
        if (numOfArgs == MAX_ARGUMENTS)
        {
            int firstArgLength = 0;
            
            for (int argIndex = 0; argIndex < numOfArgs; argIndex++)
            {
                firstArgLength = args[argIndex].length();
                if (firstArgLength == 0)
                {
                    System.out.println("Please enter two values.");
                    return false;
                }
                else if (args[argIndex].charAt(FIRST_ARGUMENT) == '-')
                {
                    System.out.println("Please enter a positive value.");
                    return false;
                }
                else
                {
                    for (int argLength = 0; argLength < firstArgLength; argLength++)
                    {
                        if (Character.isDigit(args[argIndex].charAt(argLength)))
                        {
                            argsValid = true;
                        }
                        else
                        {
                            System.out.println("Must enter INTEGER values greater than or equal to 1.");
                            return false;
                        }
                    }
                }
                if ((Integer.parseInt(args[argIndex]) < MIN_ARG_VALUE))
                {
                    System.out.println("All integer values must be greater than or equal to 1.");
                    argsValid = false;
                }
            }
        }
        else
        {
            System.out.println("Input two and only two values.");
            argsValid = false;
        }
        
        return argsValid;
    }

    /**
     * Formats the data gathered and scales it accordingly to display the data as clearly as possible.
     * @param lastDigits contains how many instances of each digit occurred on the last digit of each prime
     * @return the String containing the data collected with a scaled representation of that data
     */
    public static String histogram(int[] lastDigits)
    {
        System.out.printf("%s%10s", "Last-Digit", "Total\n");
        String data = "";
        String scale = "Scale: * = ";
        boolean shouldScale = false;
        boolean shouldScaleAlot = false;

        for (int index = 0; index < lastDigits.length; index++)
        {
            if (lastDigits[index] > 1000)
            {
                shouldScaleAlot = true;
            }
            if (lastDigits[index] > 100 && lastDigits[index] < 1000)
            {
                shouldScale = true;
            }
        }

        for (int index = 0; index < lastDigits.length; index++)
        {
            data = String.format("%s%5d%12d%5s", data, index, lastDigits[index], "");

            if (shouldScaleAlot)
            {
                for (int secondIndex = 0; secondIndex < lastDigits[index] / 100; secondIndex++)
                {
                    data = data + "*";
                }
                for (int thirdIndex = 0; thirdIndex < (lastDigits[index] % 100) / 10; thirdIndex++)
                {
                    data = data + "&";
                }
                for (int fourthIndex = 0; fourthIndex < lastDigits[index] % 10; fourthIndex++)
                {
                    data = data + "|";
                }
                if (index == lastDigits.length - 1)
                {
                    scale = scale + "100, & = 10, | = 1";
                }
            }
            else if (shouldScale)
            {
                for (int secondIndex = 0; secondIndex < lastDigits[index] / 10; secondIndex++)
                {
                    data = data + "*";
                }
                for (int thirdIndex = 0; thirdIndex < lastDigits[index] % 10; thirdIndex++)
                {
                    data = data + "|";
                }
                if (index == lastDigits.length - 1)
                {
                    scale = scale + "10, | = 1";
                }
            }
            else
            {
                for (int secondIndex = 0; secondIndex < lastDigits[index]; secondIndex++)
                {
                    data = data + "*";
                }
                if (index == lastDigits.length - 1)
                {
                    scale = scale + "1, | = 0";
                }
            }

            data = data + "\n";
        }

        return data + scale;
    }

    /**
     * Performs the analysis on all the primes numbers found. Counts the instance of each digit that occured on the last
     * digit of each prime.
     * @param numOfPrimes the number of primes that were requested
     * @param listOfPrimes the list of all the primes found
     * @return the array containing how many instances of each digit occurred on the last digit of each prime
     */
    public static int[] dataAnalysis(int numOfPrimes, String listOfPrimes)
    {
        Scanner primes = new Scanner(listOfPrimes);
        int[] lastDigits = new int[NUM_OF_DIGITS];

        for (int eachPrime = 0; eachPrime < numOfPrimes; eachPrime++)
        {
            int lastDigit = primes.nextInt() % EXTRACT_LAST_DIGIT;
            lastDigits[lastDigit]++;
        }

        return lastDigits;
    }

    /**
     * Makes a String that contains all the primes requested in a table that is as square as possible up to
     * a 10 by 10 square. If more than 100 primes are requested then the table will have 10 columns and x number
     * of rows (as many as necessary). The for-loop starts at 1 since if it started at zero anything mod zero would
     * be zero, thus always entering the if statement within through its first iteration; because of this the + 1
     * on the condition statement had to be implemented to compensate.
     * @param args the input stream from the command line
     * @return the list of all the primes numbers requested
     */
    public static String printPrimes(String[] args)
    {
        String listOfPrimes = "";

        PrimeSequence primes = new PrimeSequence();

        primes.setStart(Integer.parseInt(args[FIRST_ARGUMENT]));

        int columns = (int) Math.round(Math.sqrt(Double.parseDouble(args[1])));

        if (columns > MAX_COLUMNS)
        {
            columns = MAX_COLUMNS;
        }

        for (int index = 1; index < Integer.parseInt(args[SECOND_ARGUMENT]) + 1; index++)
        {
            if ((index % columns == 0))
            {
                listOfPrimes = String.format("%s%6s%5d%s", listOfPrimes, "", primes.next(), "\n");
            }
            else
            {
                listOfPrimes = String.format("%s%6s%5d", listOfPrimes, "", primes.next());
            }
        }
        
        return listOfPrimes;
    }

    public static void main(String[] args)
    {
        String[] s = new String[2];
        s[0] = "1";
        s[1] = "50000";
        if (validate(s))
        {
            String output = printPrimes(s);
            
            System.out.println(output);
            
            int [] data = dataAnalysis(Integer.parseInt(s[1]), output);
            
            System.out.println(histogram(data));
        }
    }
}
