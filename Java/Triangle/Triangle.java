/**
 * Source code:  Triangle.java
 *      Author:  Andre Barrientos 
 *  Student ID:  5443095  
 *  Assignment:  Program #2 Triangle
 *
 *      Course:  COP 3337 (Intermediate Programming)  
 *     Section:  U06  
 *  Instructor:  William Feild  
 *    Due Date:  February 2, at the beginning of class
 *    Language:  Java
 *Compile/Run:
 *      javac Triangle.java  TriangleTester.java
 *      java TriangleTester
 * 
 *     Purpose: Used to calculate and round the area, perimeter, angles, and
 *              side lengths of a triangle.
 * 
 *Class Methods: getPointA(), getPointB(), getPointC, round(double value), 
 *               length(Point2D a, Point2D b), angle(Point2D a, Point2D b, Point2D c)
 *               perimeter(), area()
 */

import java.awt.geom.Point2D; //Used to store the coordinates as Points

public class Triangle
{
    private Point2D pointA;
    private Point2D pointB;
    private Point2D pointC;
    
    /**
     * Constructs a triangle with the given coordinates.
     * @param x1 x value of the first vertex
     * @param y1 y value of the first vertex
     * @param x2 x value of the second vertex
     * @param y2 y value of the second vertex
     * @param x3 x value of the third vertex
     * @param y3 y value of the third vertex
     */
    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3)
    {
	pointA = new Point2D.Double(x1, y1);
	pointB = new Point2D.Double(x2, y2);
	pointC = new Point2D.Double(x3, y3);
    }
    
    /**
     * Returns the first vertex as a Point
     * @return the first vertex
     */
    public Point2D getPointA()
    {
	return pointA;
    }
    
    /**
     * Returns the second vertex as a Point
     * @return the second vertex
     */
    public Point2D getPointB()
    {
    	return pointB;
    }
    
    /**
     * Returns the third vertex as a Point
     * @return the third vertex
     */
    public Point2D getPointC()
    {
	return pointC;
    }
    
    /**
     * Rounds to the fourth decimal place by shift the decimal point towards
     * the right four places, rounding using the Math.round() method, then
     * moving the decimal place back to where it was.
     * @param value the value to be rounded
     * @return the rounded value
     */
    public double round(double value)
    {
	double roundedValue = value * Math.pow(10, 4);
	roundedValue = Math.round(roundedValue) / Math.pow(10, 4);
	return roundedValue;
    }
    
    /**
     * Finds the distance between two points.
     * @param a the first vertex
     * @param b the second vertex
     * @return the distance between the two points
     */
    public double length(Point2D a, Point2D b)
    {
    	double length = a.distance(b);
    	return length;
    }
    
    /**
     * Calculates the angle at vertex (a) using the law of cosines.
     * Math.PI and 180.0 is used to convert from radians to degrees
     * @param a the first vertex
     * @param b the second vertex
     * @param c the third vertex
     * @return the angle opposite side BC
     */
    public int angle(Point2D a, Point2D b, Point2D c)
    {
	double degreeOppBC = 0.0;
	double lawofcosNumerator = ((Math.pow(this.length(a, b), 2.0))
                                  + (Math.pow(this.length(a, c), 2.0)))
                		  - (Math.pow(this.length(b, c), 2.0));
	double lawofcosDenominator = 2.0 * (this.length(a, b)) * (this.length(a, c));
	degreeOppBC = Math.acos((lawofcosNumerator)/(lawofcosDenominator));
        //Converting from radians to degrees
	degreeOppBC = (degreeOppBC * 180.0) / Math.PI;
	return (int) degreeOppBC;
    }
    
    /**
     * Calculates the perimeter by adding the length of all three sides.
     * The side lengths are gotten via the length method mentioned earlier
     * @return the perimeter
     */
    public double perimeter()
    {
    	double perimeter = this.length(pointA, pointB)
                         + this.length(pointA, pointC)
		         + this.length(pointB, pointC);
	return perimeter;
    }
    
    /**
     * Calculates the area of the triangle using Heron's Formula
     * @return the area
     */
    public double area()
    {
    	double halfP = this.perimeter() / 2.0;
    	double determinent = halfP * (halfP - this.length(pointA, pointB))
				   * (halfP - this.length(pointA, pointC))
				   * (halfP - this.length(pointB, pointC));
	double area = Math.sqrt(determinent);
	return area;
    }
}