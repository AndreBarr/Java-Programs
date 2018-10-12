/**
 * Source code:  BetterRectangle.java
 *      Author:  Andre Barrientos 
 *  Student ID:  5443095  
 *  Assignment:  Program #4 BetterRectangle
 *
 *      Course:  COP 3337 (Intermediate Programming) 
 *     Section:  U06  
 *  Instructor:  William Feild  
 *    Due Date:  March 6th, at the beginning of class
 *
 *	I hereby certify that this collective work is my own
 *	and none of it is the work of any other person or entity.
 * 	______________________________________
 * 
 *	Language:  Java
 *	Compile/Run:
 *      javac BRectTester.java BetterRectangle.java
 *	java BRectTester
 *
 *  Purpose: The purpose of this program is to improve the Rectangle class by adding new
 *              constructors and methods.
 *  
 * Constants: The origin is at the location (0, 0)
 *            A unit rectangle has width and height of 1 unit
 *              
 * Constructors: BetterRectangle() creates a unit rectangle (width and height both 1) at the origin
 *               BetterRectangle(int width, int height) creates a rectangle at the origin with the desired width and height
 *               BetterRectangle(int positionX, int positionY, int width, int height)
 *                  creates a rectangle with the lower left corner at the desired location and with desired width and height
 *               BetterRectangle(BetterRectangle copyRectangle) creates a rectangle with the same properties of the specified rectangle
 * 
 * Class Methods: getArea(), getPerimeter(), getSlope(), getMidPoint(), congruent(BetterRectangle anotherRectangle),
 *                equivalent(BetterRectangle anotherRectangle), similar(BetterRectangle anotherRectangle),
 *                concentric(BetterRectangle anotherRectangle), scaleBy(int scale), toString(), equals(BetterRectangle anotherRectangle)
 */

import java.awt.Rectangle; //Used to extend the BetterRectangle Class
import java.awt.geom.Point2D; //Used to store coordinates as Points

public class BetterRectangle extends Rectangle
{
    private final int ORIGIN = 0;
    private final int UNIT_RECTANGLE = 1;
    
    /**
     * Creates a unit rectangle (width and height both 1) at the origin.
     */
    public BetterRectangle()
    {
        super.setLocation(ORIGIN, ORIGIN);
        super.setSize(UNIT_RECTANGLE, UNIT_RECTANGLE);
    }
    
    /**
     * Creates a rectangle at the origin with the desired width and height
     * @param width the width of the rectangle
     * @param height the height of the rectangle
     */
    public BetterRectangle(int width, int height)
    {
        super.setLocation(ORIGIN, ORIGIN);
        super.setSize(width, height);
    }
    
    /**
     * Creates a rectangle with the lower left corner at the desired location and with desired width and height
     * @param positionX the x coordinate of the lower left corner
     * @param positionY the y coordinate of the lower left corner
     * @param width the width of the rectangle
     * @param height the height of the rectangle
     */
    public BetterRectangle(int positionX, int positionY, int width, int height)
    {
        super.setLocation(positionX, positionY);
        super.setSize(width, height);
    }
    
    /**
     * Creates a rectangle with the same properties of the specified rectangle
     * @param copyRectangle the rectangle that is copied from
     */
    public BetterRectangle(BetterRectangle copyRectangle)
    {
        super.setLocation((int)copyRectangle.getX(), (int)copyRectangle.getY());
        super.setSize((int)copyRectangle.getWidth(), (int)copyRectangle.getHeight());
    }
    
    /**
     * Computes the area of the rectangle
     * @return the area of the rectangle
     */
    public int getArea()
    {
        int area = (int) (super.getWidth() * super.getHeight());
        return area;
    }
    
    /**
     * Computes the perimeter of the rectangle
     * The perimeter of a rectangle is two times the width plus two times the height
     * @return the perimeter of the rectangle
     */
    public int getPerimeter()
    {
        //Must multiply by two since the perimter is two times the width plus two times the height
        int perimeter = (int) (super.getWidth() + super.getHeight()) * 2;
        return perimeter;
    }
    
    /**
     * Computes the slope of the rectangle
     * The slope of the rectangle is the heigh divided by the width (rise over run)
     * @return the slope of the rectangle
     */
    public float getSlope()
    {
        float slope = ((float) super.getHeight() / (float) super.getWidth());
        return slope;
    }
    
    /**
     * Computes the midPoint of the rectangle
     * @return the midpoint of the rectangle as a Point
     */
    public Point2D getMidPoint()
    {
        int centerX = (int) Math.round(super.getCenterX());
        int centerY = (int) Math.round(super.getCenterY());
        Point2D midPoint = new Point2D.Float(centerX, centerY);
        return midPoint;
    }
    
    /**
     * Determines whether the two rectangles have the same width and height, if so returns true
     * else returns false
     * @param anotherRectangle the rectangle that it is being compared to
     * @return whether the two rectangles have the same width and height (true or false)
     */
    public boolean congruent(BetterRectangle anotherRectangle)
    {
        boolean congruent = false;
        if (super.getWidth() == anotherRectangle.getWidth() && super.getHeight() == anotherRectangle.getHeight())
        {
            congruent = true;
        }
        return congruent;
    }
    
    /**
     * Determines whether the two rectangles have the same perimeter, if so returns true
     * else returns false
     * @param anotherRectangle the rectangle that it is being compared to
     * @return whether the two rectangles have the same perimeter (true or false)
     */
    public boolean equivalent(BetterRectangle anotherRectangle)
    {
        boolean equivalent = false;
        if (getPerimeter() == anotherRectangle.getPerimeter())
        {
            equivalent = true;
        }
        return equivalent;
    }
    
    /**
     * Determines whether the two rectangles have the same area, if so returns true
     * else returns false
     * @param anotherRectangle the rectangle that it is being compared to
     * @return whether the two rectangles have the same perimeter (true or false)
     */
    public boolean similar(BetterRectangle anotherRectangle)
    {
        boolean similar = false;
        if (getArea() == anotherRectangle.getArea())
        {
            similar = true;
        }
        return similar;
    }
    
    /**
     * Determines whether the two rectangles have the same midpoint, if so returns true
     * else returns false
     * @param anotherRectangle the rectangle that it is being compared to
     * @return whether the two rectangles have the same midpoint (true or false)
     */
    public boolean concentric(BetterRectangle anotherRectangle)
    {
        boolean concentric = false;
        if (getMidPoint() == anotherRectangle.getMidPoint())
        {
            concentric = true;
        }
        return concentric;
    }
    
    /**
     * Scales the rectangle by the desired ratio only if the ratio is a positive integer value
     * If the above statement is true then the width and the height of the rectangle are multiplied
     * by the scale and returns true, else nothing is changed and returns false
     * @param scale the scale by which the dimensions of the rectangle is to be increased
     * @return whether or not the scale was performed (true or false)
     */
    public boolean scaleBy(int scale)
    {
        boolean canScale = false;
        if (scale > 0)
        {
            super.setSize(scale * (int)super.getWidth(), scale * (int)super.getHeight());
            canScale = true;
        }
        return canScale;
    }
    
    /**
     * Organizes the properties of the rectangle
     * Must be overridden since the super class method does not include area, perimeter, slope, and midpoint
     * @return the properties of the rectangle in a String
     */
    @Override
    public String toString()
    {
        return super.toString() + "[area=" + getArea() + ",perimeter=" + getPerimeter() + ",slope=" + getSlope()
                                + ",midpoint=(" + (int) getMidPoint().getX() + "," + (int) getMidPoint().getY() + ")]";
    }
    
    /**
     * Determines whether two rectangles are equal
     * No need to override since the super class already checks for the position, width, and height
     * If those three are correct then the area, perimeter, slope, and midpoint will also be the same
     * @param anotherRectangle
     * @return 
     */
    public boolean equals(BetterRectangle anotherRectangle)
    {
        return super.equals(anotherRectangle);
    }
}