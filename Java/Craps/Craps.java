/**
 * Source code:  Craps.java
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
 *     Purpose: Simulate Craps games with two 6-sided dice and compute
 *              probabilities of different winning and losing situations.
 *              (The sides of the dice can be change in the Die class)
 * 
 *   Constants: When dice are coming out, 7 or 11 wins, and 2,3, or 12 loses.
 *              GameLength is between [1 - 21+] so the Array always has length 21.
 *              Expected Values:
 *               winChance gotten from:
 *                  http://www.herkimershideaway.org/writings/craps.htm
 *               comingOutWinChance and comingOutLoseChance gotten from:
 *                  https://wizardofodds.com/ask-the-wizard/craps/probability/
 *        
 * 
 *Class Methods: playGame(), resetGame(), getAllGameRolls(), gameSummary(), longestGame(),
 *               getTotalRolls(), getGamesWon(), getComingOutWin(), getComingOutLose(),
 *               getResults()
 */

import java.util.ArrayList; //Used to create an ArrayList to hold all gameRoll Values

/**
 * Play x amount of Craps games with two 6-sided dice.
 * (The sides of the dice can be change in the Die class)
 */
public class Craps
{
    //Constants
        private final int value7 = 7; 
        private final int value11 = 11;
        private final int value2 = 2;
        private final int value3 = 3;
        private final int value12 = 12;
        private final int gameLengthRolls = 21;
        private final double winChance = 0.492929;
        private final double comingOutWinChance = 0.222222;
        private final double comingOutLoseChance = 0.111111;
        
    // instance variables
        private Die die;
        private int totalRolls;
        private int numOfGames;
        private int gameRolls;
        private int gamesWon;
        private int comingOutWin;
        private int comingOutLose;
        private int [] gameSummary;
        private ArrayList<Integer> allGameRolls;
    /**
     * Constructs Craps object and initializes instance variables
     */
    public Craps()
    {
        die = new Die();
	totalRolls = 0;
        numOfGames = 0;
	gameRolls = 0;
	gamesWon = 0;
	comingOutWin= 0;
	comingOutLose = 0;
	gameSummary = new int [21];
	allGameRolls = new ArrayList<Integer> ();
    }
    
    /**
     * Plays a game of Craps; increments appropriate values and stores the number
     * of game rolls in the ArrayList when necessary.
     */
    public void playGame()
    {
	//Initial roll of the two dice and their sum
	int initialRoll = die.rollDie() + die.rollDie();
	//Increments the total rolls and game rolls
	totalRolls++;
        numOfGames++;
	gameRolls++;
        if (initialRoll == value7 || initialRoll == value11)
        {
            gamesWon++;
            comingOutWin++;
        } 
        else if (initialRoll != value2 && initialRoll != value3 && initialRoll != value12)
        {
            int point = initialRoll;
            int value = 0;
            do
            {
                int reRoll = die.rollDie() + die.rollDie();
                totalRolls++;
                gameRolls++;
                value = reRoll;
            } while (value != value7 && value != point);
            if (value == point)
            {
                gamesWon++;
            }
        } 
        else
        {
            comingOutLose++;
	}
	allGameRolls.add(gameRolls);
    }
	
    /**
     * Resets game values for the next game to be played.
     */
    public void resetGame()
    {
        gameRolls = 0;
    }
    
    /**
     * Returns the ArrayList getAllGameRolls
     * @return the ArrayList with the number of rolls of each game
     */
    public ArrayList <Integer> getAllGameRolls()
    {
        return allGameRolls;
    }
    
    /**
     * Returns the Array that contains the number of games per number of rolls.
     * Rolls between 1 - 21+
     * @return the Array containing the number of games per number of rolls
     */
    public int[] gameSummary()
    {
    	for (Integer rolls: allGameRolls)
    	{
            if (rolls < gameLengthRolls)
            {
		gameSummary[rolls - 1]++;
            }
            else
            {
		gameSummary[20]++; // Last element in the gameSummary Array
            }
	}
	return gameSummary;
    }
    
    /**
     * Finds the longest game played
     * @return the longest game played
     */
    public int longestGame()
    {
        int longestGame = 0;
        for (Integer rolls: allGameRolls)
        {
            if (rolls > longestGame)
            {
                longestGame = rolls;
            }
        }
        return longestGame;
    }
    /**
     * Returns the total number of rolls
     * @return the total number of rolls
     */
    public int getTotalRolls()
    {
    	return totalRolls;
    }
    
    /**
     * Returns the number of games won
     * @return the number of games won
     */
    public int getGamesWon()
    {
        return gamesWon;
    }
    
    /**
     * Returns the amount of wins won on the first roll
     * @return the amount of wins on the first roll
     */
    public int getComingOutWin()
    {
        return comingOutWin;
    }
    
    /**
     * Returns the amount of loses that happened on the first roll
     * @return the amount of loses that happened on the first roll
     */
    public int getComingOutLose()
    {
        return comingOutLose;
    }
    
    /**
     * Returns the String that displays all the calculated statistics and
     * expected values
     * @return the String that displays all relevant information
     */
    public String getResults()
    {
        String results = String.format("%s%27d%s", "Total number of games: ", numOfGames, "\n")
                + String.format("%s%27d%s", "Total number of roles: ", getTotalRolls(), "\n")
                + String.format("%s%21.5f%s", "The average game length was: ", (double)(getTotalRolls()) / numOfGames, "\n")
                + String.format("%s%26.5f%s", "Probability of winning: ", (double)(getGamesWon()) / numOfGames, "\n")
                + String.format("%s%17.5f%s", "Expected probability of winning: ", winChance, "\n")
                + String.format("%s%15d%s", "Number of wins on coming out roll: ", getComingOutWin(), "\n")
                + String.format("%s%.5f%s", "Probability of winning on coming out roll: ", (double) (getComingOutWin()) / numOfGames, "\n")
                + String.format("%s%17.5f%s", "Expected probability of winning: ", comingOutWinChance, "\n")
                + String.format("%s%8.5f%s", "Probability of losing on coming out roll: ", (double) (getComingOutLose()) / numOfGames, "\n")
                + String.format("%s%17.5f%s", "Expected probability of winning: ", comingOutLoseChance, "\n")
                + String.format("%s%23d%s", "Longest game played: ", longestGame(), " roll(s)\n");        
        return results;
    }
}