package ca.bcit.comp2522.bookstore;

/**
 * Represents a person's first and last name with basic validation and convenience formatting methods.
 *
 * @author Indy Grewal
 * @version 1.0
 */
public final class Name implements Printable
{
    private static final int MAX_NAME_LENGTH_CHARS = 49;

    private final String firstName;
    private final String lastName;

    private Name(final String firstName, final String lastName)
    {
        if (firstName == null || firstName.isBlank())
        {
            throw new IllegalArgumentException("First Name cannot be null or blank.");
        }

        if (lastName == null || lastName.isBlank())
        {
            throw new IllegalArgumentException("Last Name cannot be null or blank.");
        }

        if (firstName.length() > MAX_NAME_LENGTH_CHARS || lastName.length() > MAX_NAME_LENGTH_CHARS)
        {
            throw new IllegalArgumentException("Names must be less than " + MAX_NAME_LENGTH_CHARS + " characters.");
        }

        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Returns the full name in "First Last" format.
     *
     * @return the full name
     */
    public String getFullName()
    {
        return firstName + " " + lastName;
    }

    @Override
    public void display()
    {
        System.out.println("Full Name: " + getFullName());
    }
}
