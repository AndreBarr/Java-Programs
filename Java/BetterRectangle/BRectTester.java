/**
 * Source code:  BRectTester.java
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
 *  Description: The purpose of this program is to test the BetterRectangle class.
 * 
 *  Input: N/A
 * 
 *  Output: Displays the toString() method of each rectangle created as well as the return values for
 *          each of the methods in the BetterRectangle class. The expected value is also displayed after
 *          each test.
 * 
 *  Process: 1. Four rectangles are constructed.
 *           2. The utility methods are tested (equals, congruent, equivalent, similar, concentric) and
 *              the expected values are printed. The toString method is not called after every test since
 *              none of the properties about the rectangles are changed and the toString method has already
 *              been called before at least once.
 *           3. The accessor methods are tested (area, perimeter, slope, midpoint) and the expected values
 *              are printed. The toString method is not called after every test since none of the properties
 *              about the rectangles are changed and the toString method has already been called before at
 *              least once.
 *           4. The mutator method is tested (scaleBy) and the expected value is printed. The toString method
 *              is called before and after each test since this method changes the properties of the rectangle
 *              and the toString method is used to see those changes being made.
 */

public class BRectTester {
    
    public static void main(String[] args) {

    BetterRectangle bRectA = new BetterRectangle(4, 3);
    System.out.println("bRectA = " + bRectA.toString());
    BetterRectangle bRectB = new BetterRectangle(bRectA);
    System.out.println("bRectB = " + bRectB.toString());
    BetterRectangle bRectC = new BetterRectangle(1, 1, 3, 4);
    System.out.println("bRectC = " + bRectC.toString());
    BetterRectangle bRectD = new BetterRectangle();
    System.out.println("bRectD = " + bRectD.toString());
    
    /*
      The toString method is not called after each one of these tests since none of the properties about the
      rectangles are changed and the toString method has already been called before at least once.
    */
    System.out.println("Equals Utility Test: " + bRectB.equals(bRectC) + "\nExpected Value: false");
    System.out.println("Congruent Utility Test: " + bRectB.congruent(bRectC) + "\nExpected Value: false");
    System.out.println("Equivalent Utility Test: " + bRectB.equivalent(bRectC) + "\nExpected Value: true");
    System.out.println("Similar Utility Test: " + bRectB.similar(bRectC) + "\nExpected Value: true");
    System.out.println("Concentric Utility Test: " + bRectB.concentric(bRectC) + "\nExpected Value: false");

    /*
      The toString method is not called after each one of these tests since none of the properties about the
      rectangles are changed and the toString method has already been called before at least once.
    */    
    System.out.println("Area Test: " + bRectA.getArea() + "\nExpected Value: 12");
    System.out.println("Perimeter Test: " + bRectA.getPerimeter() + "\nExpected Value: 14");
    System.out.println("Slope Test: " + bRectA.getSlope() + "\nExpected Value: 0.75");
    System.out.println("MidPoint Test: " + bRectA.getMidPoint() + "\nExpected Value: (2, 2)");
    
    /*
      The toString method is called before and after each test since this method changes the properties of 
      the rectangle and the toString method is used to see those changes being made.
    */
    System.out.println("bRectD Before: " + bRectD.toString());
    System.out.println("ScaleBy Test: " + bRectD.scaleBy(3)+ "\nExpected Value: true, width = 3, height = 3");
    System.out.println("bRectD After First scaleBy: " + bRectD.toString());
    System.out.println("Second ScaleBy Test: " + bRectB.scaleBy(-3) + "\nExpected Value: false");
    System.out.println("bRectD After Second scaleBy: " + bRectD.toString());
    
    }
}