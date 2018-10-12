/**
 * Source code:  SequenceDemo.java
 *      Author:  Andre Barrientos
 *  Student ID:  5443095
 *  Assignment:  Program #6 Fibonacci Numbers
 *
 *      Course:  COP 3337 (Intermediate Programming)
 *     Section:  U06
 *  Instructor:  William Feild
 *    Due Date:  April 20, at the beginning of class
 *
 *	I hereby certify that this collective work is my own
 *	and none of it is the work of any other person or entity.
 * 	______________________________________
 *
 *    Language:  Java
 *    Compile/Run:
 *    javac Sequence.java  FibSequence.java LoopFibSequence.java FastFibSequence.java
 *          SequenceDemo.java InvalidInput.java StopWatch.java
 *    java SequenceDemo (with two arguments (input file followed by output file))
 * 
 * Description: The purpose of this program is to display the Fibonacci numbers computed by the
 *              three different methods and calculate the time taken to compute those values for
 *              each one of those methods.
 * 
 * Constants: MAX_COLUMNS           the maximum number of columns for the Fibonacci tables
 *            NUM_ARGS_ALLOWED      the required number of arguments in the command line
 *            INPUT_FILE_INDEX      the index of the input file name in the array
 *            OUTPUT_FILE_INDEX     the index of the output file name in the array
 *            SMALLEST_VALID_VALUE  the smallest valid input value
 *            LARGEST_VALID_VALUE   the largest valid input value
 * 
 * Class Methods: validateCommandLine(String[] args), readFile(String[] args),
 *                printFibTable(Sequence computFibMethod, int nthFib), main(String[] args)
 * 
 * Process: 1. The command line inputs are validated.
 *          2. The input file value is validated.
 *          3. Objects for the three different methods of computing the Fibonacci numbers
 *             are created.
 *          4. The Fibonacci numbers, and time taken to compute them are calculated and
 *             put into three tables in the output file.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SequenceDemo
{
    //Constants
    private final static int MAX_COLUMNS = 10;
    private final static int NUM_ARGS_ALLOWED = 2;
    private final static int INPUT_FILE_INDEX = 0;
    private final static int OUTPUT_FILE_INDEX = 1;
    private final static int SMALLEST_VALID_VALUE = 1;
    private final static int LARGEST_VALID_VALUE = 39;

    /**
     * 
     * @param args
     * @return
     * @throws InvalidInput 
     */
    public static boolean validateCommandLine(String [] args) throws InvalidInput
    {
        boolean argsValid = false;
        
        if (args.length != NUM_ARGS_ALLOWED)
        {
            throw new InvalidInput("Input the input file name and output file name.");
        }
        else
        {
            argsValid = true;
        }
        
        return argsValid;
    }
    
    public static int readFile(String [] fileNames) throws FileNotFoundException, InvalidInput
    {
        int nthFib = 0;
        
        try
        {
            if (validateCommandLine(fileNames))
            {
                File inFile = new File(fileNames[INPUT_FILE_INDEX]);
                Scanner inputFile = new Scanner(inFile);
                try
                {
                    nthFib = Integer.parseInt(inputFile.next());

                    if (nthFib < SMALLEST_VALID_VALUE || nthFib > LARGEST_VALID_VALUE)
                    {
                        throw new InvalidInput("Value must be between " + SMALLEST_VALID_VALUE + " and " + LARGEST_VALID_VALUE + ", inclusive.");
                    }

                    if (inputFile.hasNext())
                    {
                        throw new InvalidInput("End of file expected, only one value allowed.");
                    }
                }
                finally
                {
                    inputFile.close();
                }
            }
        }
        catch (NoSuchElementException exception)
        {
            System.out.println("Empty File.");
        }
        catch (NumberFormatException exception)
        {
            System.out.println("Not an integer value.");
        }

        return nthFib;
    }

    public static String printFibTable(Sequence computeFibMethod, int nthFib)
    {
        String listOfFibs = "";
        StopWatch elapsedTime = new StopWatch();
        long nextValue = 0;

        int columns = (int) Math.round(Math.sqrt(nthFib));

        if (columns > MAX_COLUMNS)
        {
            columns = MAX_COLUMNS;
        }

        for (int getNext = 1; getNext < nthFib + 1; getNext++)
        {
            if ((getNext % columns == 0))
            {
                elapsedTime.start();
                nextValue = computeFibMethod.next();
                elapsedTime.stop();
                listOfFibs = listOfFibs + String.format("%12d%s", nextValue, "\n");
            }
            else
            {
                elapsedTime.start();
                nextValue = computeFibMethod.next();
                elapsedTime.stop();
                listOfFibs = listOfFibs + String.format("%12d", nextValue);
            }
        }

        listOfFibs = listOfFibs + "\n" + "Total time to compute all values: "
                + String.format("%12d", elapsedTime.getElapsedTime()) + " nanoseconds";
        
        return listOfFibs;
    }

    public static void main(String[] args)
    {
        try
        {
            int numberOfFibs = readFile(args);
            PrintWriter outputFile = new PrintWriter(args[OUTPUT_FILE_INDEX]);
            try
            {
                FibSequence fibSequence = new FibSequence(numberOfFibs);
                FastFibSequence fastFib = new FastFibSequence(numberOfFibs);
                LoopFibSequence loopFib = new LoopFibSequence(numberOfFibs);
                outputFile.println("Normal Recursive Table:\n");
                outputFile.println(printFibTable(fibSequence, numberOfFibs));
                outputFile.println("\nIterative Table (Expected Values):\n");
                outputFile.println(printFibTable(loopFib, numberOfFibs));
                outputFile.println("\nFast Recursive Table:\n");
                outputFile.println(printFibTable(fastFib, numberOfFibs));
            }
            finally
            {
                outputFile.close();
            }
        }
        catch (FileNotFoundException exception)
        {
            System.out.println("File not found.");
        }
        catch (InvalidInput exception)
        {
            System.out.println(exception.getMessage());
        }
    }
}
