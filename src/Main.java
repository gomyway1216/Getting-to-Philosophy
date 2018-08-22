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
import java.util.Scanner;
import java.util.function.Function;

/**
 * The main class deals with user input, and makes use of the Generator class and the
 * NextWikiLInkFunction to generate a list of WikiLinks guiding the user to the Philosophy page and
 * terminating the program upon its completion.
 * 
 * @author yaguchiyudai
 */
public class Main {

    /**
     * This method takes in user input and calls methods to complete the task.
     * 
     * @param args arguments for the main, unused
     */
    public static void main(String[] args) {
        // Prompt user for input
        System.out.print("Please enter a Wikipedia topic: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        // limits results to 1000 links
        final int NUM_LINKS = 1000;
        // Trim unecessary spaces from user input
        // Replace spaces between words with underscore
        input = input.trim().replaceAll(" +", "_");
        // Append "wiki" to input
        input = "/wiki/" + input;
        // Use j to print number list
        int j = 0;
        // Loops and makes generator objects with NextWikiLinkFunction funtion's apply method
        for (String i : new Generator<String>(NUM_LINKS, input, new NextWikiLinkFunction())) {
            // Prints number plus wikiLink
            System.out.println(j + ": " + i);
            // Program terminates if user input cannot be found in wiki
            if (i.substring(0, 6).equals("FAILED"))
                break;
            // Program terminates when Psychology is reached
            // It is not going to reach Philosophy any more!
            if (i.equals("/wiki/Psychology"))
                break;
            j++;
        }
        // close scanner
        scanner.close();
    }
}


/**
 * This class applies the given function to the input Integer and returns the operated on input.
 * 
 */
class DoubleFunction implements Function<Integer, Integer> {
    /**
     * This method multiplies t by 2.
     * 
     * (non-Javadoc)
     * 
     * @see java.util.function.Function#apply(java.lang.Object)
     * @param t is the integer we want to manipulate
     * @return t is the manipulated t
     */
    @Override
    public Integer apply(Integer t) {
        t = t * 2;
        return t;
    }
}


/**
 * This class applies the given function to the input String and returns the operated on input.
 * 
 */
class AddExclamationFunction implements Function<String, String> {
    /**
     * This method adds an exclamation point to the word.
     * 
     * (non-Javadoc)
     * 
     * @see java.util.function.Function#apply(java.lang.Object)
     * @param t is the String we want to manipulate
     * @return t is the manipulated t
     */
    @Override
    public String apply(String t) {
        t = t + '!';
        return t;
    }
}
