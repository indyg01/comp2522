package ca.bcit.comp2522.bookstore;

/**
 * Contract for objects that can display their information in a readable format.
 * <p>
 * Classes implementing this interface must provide a {@code display()} method
 * that prints all instance variables, including those inherited from parent classes.
 *
 * @author Sukhraj Sandhar
 * @author Arshia Adamian
 * @author Rodrick Vizigro
 * @author Indy Grewal
 * @author Abdullah Alasmy
 * @version 1.0
 */
public interface Printable
{
    /**
     * Displays every instance variable of the implementing object,
     * including those inherited from parent classes, in a complete sentence.
     */
    void display();
}