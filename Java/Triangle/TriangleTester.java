/**
 * Source code:  TriangleTester.java
 *      Author:  Andre Barrientos 
 *  Student ID:  5443095  
 *  Assignment:  Program #2 Triangle
 *
 *      Course:  COP 3337 (Intermediate Programming)  
 *     Section:  U06  
 *  Instructor:  William Feild  
 *    Due Date:  February 2, at the beginning of class
 *
 *		I hereby certify that this collective work is my own
 *		and none of it is the work of any other person or entity.
 *                  ______________________________________
 * 
 *   Language:  Java
 *Compile/Run:
 *      javac Triangle.java  TriangleTester.java
 *      java TriangleTester
 * 
 * Description: The purpose of this program is to output the length, angles,
 *              perimeter, and area of a triangle given by the user.
 * 
 *       Input: The user will input the coordinates of the three vertices of
 *              the triangle.
 * 
 *      Output: The program will display the length, angles, perimeter, and area
 *              of the triangle.
 * 
 *     Process: 1. The user will be prompted to enter the coordinates.
 *              2. A triangle is constructed.
 *              3. The values are displayed using methods in the class.
 *  
 *  Known Bugs: No input validation.
 */
import java.awt.geom.Point2D; //Used to store the coordinates as Points
import java.util.Scanner;     //For access to read and write methods

public class TriangleTester
{
    public static void main(String[] args)
    {	
        Scanner in = new Scanner(System.in);
        System.out.println("Type in the the three coordinates of your triangle; "
        		 + "each individual value separated by a return.");
        
        double x1 = in.nextDouble();
        double y1 = in.nextDouble();
        double x2 = in.nextDouble();
        double y2 = in.nextDouble();
        double x3 = in.nextDouble();
        double y3 = in.nextDouble();
		
        Triangle triangle = new Triangle (x1, y1, x2, y2, x3, y3);
        //Extracting the points for method use
	Point2D pointA = triangle.getPointA();
	Point2D pointB = triangle.getPointB();
	Point2D pointC = triangle.getPointC();
		
	System.out.printf("%10s%20s", "Length A:"
			  , triangle.round(triangle.length(pointA, pointB)) + " units\n");
	System.out.printf("%10s%20s", "Length B:"
			  , triangle.round(triangle.length(pointA, pointC)) + " units\n");
	System.out.printf("%10s%20s", "Length C:"
			  , triangle.round(triangle.length(pointB, pointC)) + " units\n");
	System.out.printf("%10s%20s", "Angle A:"
			  , triangle.round(triangle.angle(pointA, pointB, pointC)) + " degrees\n");
	System.out.printf("%10s%20s", "Angle B:"
			  , triangle.round(triangle.angle(pointB, pointA, pointC)) + " degrees\n");
	System.out.printf("%10s%20s", "Angle C:"
			  , triangle.round(triangle.angle(pointC, pointA, pointB)) + " degrees\n");
	System.out.printf("%10s%20s", "Perimeter:"
			  , triangle.round(triangle.perimeter()) + " units\n");
	System.out.printf("%10s%20s", "Area:"
			  , triangle.round(triangle.area()) + " units^2\n");
    }
}