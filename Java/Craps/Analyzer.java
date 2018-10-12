/**
 * Source code:  Analyzer.java
 *      Author:  Andre Barrientos 
 *  Student ID:  5443095  
 *  Assignment:  Program #3 Craps
 *
 *      Course:  COP 3337 (Intermediate Programming)  
 *     Section:  U06  
 *  Instructor:  William Feild  
 *    Due Date:  February 16, at the beginning of class
 *
 *		I hereby certify that this collective work is my own
 *		and none of it is the work of any other person or entity.
 *                  ______________________________________
 * 
 *   Language:  Java
 *Compile/Run:
 *      javac Analyzer.java  Craps.java Die.java
 *      java Analyzer
 * 
 * Description: The purpose of this program is to play Craps x amount of times
 *              and display the results as well as statistics about the game.
 * 
 *       Input: The user will input the number of Craps games to play.
 * 
 *      Output: The program will display the game summary and statistics.
 * 
 *     Process: 1. The user will be prompted to enter the number of games.
 *              2. Those Craps games are played.
 *              3. The results and statistics from those games is displayed.
 *  
 */
import java.util.Scanner ; //For access to read and write methods
/**
 * A test class for the Craps class. Plays x number of game and prints results.
 */
public class Analyzer
{ 
    public static void main(String[] args)
    {
        Craps game = new Craps();
        int validNumGames = 0;
        int [] gameSummary = new int [21]; //GameLength is between [1 - 21+];
        Scanner input = new Scanner (System.in);
        do
        {	
            if (input.hasNextInt())
            {
                validNumGames = input.nextInt();
                /* Input must be between [1 - 1000000] */
                if (validNumGames < 1 || validNumGames > 1000000)
                {
                System.out.println("Please enter a positive integer. [1 - 1000000]");
                input = new Scanner (System.in);
                }
            }               
            else
            {
                System.out.println("Please enter a positive integer. [1 - 1000000]");
                input = new Scanner (System.in);
            }
        } while (validNumGames < 1 || validNumGames > 1000000); // Input must be between [1 - 1000000]

        for (int index = 0; index < validNumGames; index++)
        {
            game.playGame();
            game.resetGame();
        }
        gameSummary = game.gameSummary();
        System.out.printf("%s%20s", "Length of Game", "Number of Games\n");
        
        for (int index = 0; index < gameSummary.length; index++)
        {
            if (gameSummary[index] != 0)
            {
                if (index == 20) //Last element in the Array
                {
                    System.out.printf("%4s%2d%s%16s%5d%s", "", (index + 1), "+"
                                    ,"", gameSummary[index], "\n");
                }
                else
                {
                    System.out.printf("%4s%2d%17s%5d%s", "", (index + 1), ""
                                    , gameSummary[index], "\n");
                }
            }
        }
        System.out.println(game.getResults());
   }
}