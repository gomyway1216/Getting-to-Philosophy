//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: GeneratingPhilosophy
// Files: EvenNumberGenerator.java, NumberGenerator.java, Generator.java, NextWikiLinkFun.java,
//////////////////// Main.java
// Course: (cs300, fall, and 2017)
//
// Author: Yudai Yaguchi
// Email: yyaguchi@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Eden Schuette
// Partner Email: eschuett@wisc.edu
// Lecturer's Name: Gary Dahl
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _x_ Write-up states that pair programming is allowed for this assignment.
// _x_ We have both read and understand the course Pair Programming Policy.
// _x_ We have registered our team prior to the team registration deadline.
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

// import packages
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class generates a list of even numbers based on user commands and terminates when the list
 * length matches the length determined by the user input.
 *
 * @author yaguchiyudai
 */
public class EvenNumberGenerator implements Iterable<Integer>, Iterator<Integer> {
    // The number of numbers determined by the user
    private int numberOfEvens;
    // Stores the current number while incrementing
    private Integer currentEven;
    // Keeps track of the number of numbers to complete list
    private int counter;

    /**
     * Initializes a new EvenNumberGenerator to return a single even number each time it's next()
     * method is called. The first even number returned in this way is firstEven. Subsequent even
     * numbers returned in this way will be the smallest even number that is larger than the
     * previous.
     * <p>
     * After numberOfEvens numbers have been generated and returned from this next() method, the
     * generator will end: its hasNext() method will return false, and its next() method will throw
     * a NoSuchElementException when called after this point.
     * 
     * @param numberOfEvens is the number of evens that can be generated
     * @param firstEven is the first and smallest even that will be generated
     * @throws IllegalArgumentException is thrown when numberOfEvens is negative, or when firstEven
     *         is not an even number
     */
    public EvenNumberGenerator(int numberOfEvens, Integer firstEven)
                    throws IllegalArgumentException {
        // Valid input must be 0 or greater and even, if not throw exception
        if (numberOfEvens < 0 || firstEven % 2 != 0)
            throw new IllegalArgumentException();
        // Sets field variables to parameters
        this.numberOfEvens = numberOfEvens;
        this.currentEven = firstEven;
    }

    /**
     * This method checks if there is next element or not.
     * 
     * (non-Javadoc)
     * 
     * @see java.util.Iterator#hasNext()
     * @return true or false, based on element contents
     */
    @Override
    public boolean hasNext() {
        // If the list has not been completed, there is next element, continue
        if (counter < numberOfEvens)
            return true;
        else
            return false;
    }

    /**
     * If hasNext is true, this method takes the next element and returns the current element.
     * (non-Javadoc)
     * 
     * @see java.util.Iterator#next()
     * @return temp is current element
     */
    @Override
    public Integer next() {
        // If there is no next element, throw exception
        if (!hasNext())
            throw new NoSuchElementException();
        // Increments counter
        counter++;
        // Temporary variable stores the current element
        Integer temp = currentEven;
        // Change current element by adding 2
        currentEven = currentEven + 2;
        return temp;
    }

    /**
     * This method implements iterator
     * 
     * (non-Javadoc)
     * 
     * @see java.lang.Iterable#iterator()
     * @return this iterator
     */
    @Override
    public Iterator<Integer> iterator() {
        return this;
    }
}
