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
 * This class generates a list of objects based on user commands and terminates when the list length
 * matches the length determined by the user input.
 * 
 * @author yaguchiyudai
 */
public class Generator<T> implements Iterable<T>, Iterator<T> {
    // The number of objects determined by the user
    private int numberOfObjects;
    // Stores the current object while incrementing
    private T currentObject;
    // Keeps track of the number of objects to complete list
    private int counter;
    // Creates function type with Generic type input and Generic type output
    private Function<T, T> function;

    /**
     * Initializes a Generator to return a single object each time it's next() method is called. The
     * first object returned in this way is firstObject. Subsequent objects returned in this way
     * will changed version of the first object returned.
     * <p>
     * After numberOfObjects objects have been generated and returned from this next() method, the
     * generator will end: its hasNext() method will return false, and its next() method will throw
     * a NoSuchElementException when called after this point.
     * 
     * @param numberOfObjects is the number of objects that can be generated
     * @param firstObject is the first object that will be generated
     */
    public Generator(int numberOfObjects, T firstObject, Function<T, T> function)
                    throws IllegalArgumentException {
        // Valid input cannot be negative
        if (numberOfObjects < 0)
            throw new IllegalArgumentException();

        // Sets fields to parameters
        this.numberOfObjects = numberOfObjects;
        this.currentObject = firstObject;
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
        if (counter < numberOfObjects)
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
    public T next() {
        // If there is no next element, throw exception
        if (!hasNext())
            throw new NoSuchElementException();
        // Increments counter
        counter++;
        // Temporary variable stores the current element
        T temp = currentObject;
        // Change current element by applying function
        currentObject = function.apply(currentObject);
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
    public Iterator<T> iterator() {
        return this;
    }
    
    
}
