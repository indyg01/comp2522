package ca.bcit.comp2522.bookstore;

/**
 * Contract for objects that can display or return their text in reverse order.
 * <p>
 * Classes implementing this interface must define how the reversal is performed.
 *
 * @author Sukhraj Sandhar
 * @author Arshia Adamian
 * @author Rodrick Vizigro
 * @author Indy Grewal
 * @author Abdullah Alasmy
 * @version 1.0
 */
public interface Reversible
{
    /**
     * Displays or outputs a reversed textual representation of the implementing object.
     */
    void backward();
}