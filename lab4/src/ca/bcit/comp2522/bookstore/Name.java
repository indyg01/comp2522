package ca.bcit.comp2522.bookstore;

/**
 * Represents a person's first and last name with basic validation and convenience formatting methods.
 *
 * @author Indy Grewal
 * @version 1.0
 */
public final class Name implements Printable
{
    // Constants
    private static final int MIN_NAME_LENGTH_CHARS = 1;
    private static final int MAX_NAME_LENGTH_CHARS = 49;

    // Instance variables
    private final String firstName;
    private final String lastName;

    // Constructor
    private Name(final String firstName, final String lastName)
    {
        if (firstName == null || firstName.isBlank())
        {
            throw new IllegalArgumentException("firstName cannot be null or blank.");
        }

        if (lastName == null || lastName.isBlank())
        {
            throw new IllegalArgumentException("firstName cannot be null or blank.");
        }

        if (firstName.length() > MAX_NAME_LENGTH_CHARS || lastName.length() > MAX_NAME_LENGTH_CHARS)
        {
            throw new IllegalArgumentException("Names must be less than " + MAX_NAME_LENGTH_CHARS + " characters.");
        }

        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void display()
    {

    }



}
