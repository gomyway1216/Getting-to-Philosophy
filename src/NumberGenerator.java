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
import java.util.function.Function;

/**
 * This class generates a list of numbers based on user commands and terminates when the list length
 * matches the length determined by the user input.
 * 
 * @author yaguchiyudai
 */
public class NumberGenerator implements Iterable<Integer>, Iterator<Integer> {
    // The number of numbers determined by the user
    private int numberOfNumbers;
    // Stores the current number while incrementing
    private Integer currentNumber;
    // Keeps track of the number of numbers to complete list
    private int counter;
    // Creates function type with Integer type input and Integer type output
    private Function<Integer, Integer> function;

    /**
     * Initializes a new NumberGenerator to return a single number each time it's next() method is
     * called. The first number returned in this way is firstNumber. Subsequent numbers returned in
     * this way will be the smallest number that is larger than the previous.
     * <p>
     * After numberOfNumbers numbers have been generated and returned from this next() method, the
     * generator will end: its hasNext() method will return false, and its next() method will throw
     * a NoSuchElementException when called after this point.
     * 
     * @param numberOfNumbers is the number of numbers that can be generated
     * @param firstNumber is the first and smallest numbers that will be generated
     * @throws IllegalArgumentException is thrown when numberOfNumbers is negative
     */
    public NumberGenerator(int numberOfNumbers, Integer firstNumber,
                    Function<Integer, Integer> function) throws IllegalArgumentException {
        // Valid input cannot be negative
        if (numberOfNumbers < 0)
            throw new IllegalArgumentException();
        // Sets field variables to parameters
        this.numberOfNumbers = numberOfNumbers;
        this.currentNumber = firstNumber;
        this.function = function;
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
        if (counter < numberOfNumbers)
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
        Integer temp = currentNumber;
        // Change current element by applying function
        currentNumber = function.apply(currentNumber);
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
