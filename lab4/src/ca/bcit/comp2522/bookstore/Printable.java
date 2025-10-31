package ca.bcit.comp2522.bookstore;

/**
 * Contract for objects that can produce a Printable String.
 *
 * @author Indy Grewal
 * @version 1.0
 */

public interface Printable
{
    /**
     * Prints every instance variable (including those in parent classes) in a sentence.
     */
    void display();
}
