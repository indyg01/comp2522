package ca.bcit.comp2522.bookstore;

/**
 * Represents a person's first and last name with basic validation and convenience formatting methods.
 *
 * @author Sukhraj Sandhar
 * @author Arshia Adamian
 * @author Rodrick Vizigro
 * @author Indy Grewal
 * @author Abdullah Alasmy
 * @version 1.0
 */
public final class Name
    implements Printable
{
    private static final int MAX_NAME_LENGTH_CHARS = 49;

    private final String firstName;
    private final String lastName;

    /**
     * Constructs a Name object after validating both first and last names.
     *
     * @param firstName the person's first name
     * @param lastName  the person's last name
     * @throws IllegalArgumentException if name is valid
     */
    public Name(final String firstName,
                final String lastName)
    {
        validateName(firstName, "firstName");
        validateName(lastName, "lastName");

        this.firstName = firstName;
        this.lastName  = lastName;
    }

    /**
     * Validates a given name field.
     *
     * @param name      the name value to validate
     * @param fieldType the name of the field (e.g., "firstName" or "lastName")
     * @throws IllegalArgumentException if the name is null, blank, or too long
     */
    private static void validateName(final String name,
                                     final String fieldType)
    {
        if (name == null || name.isBlank())
        {
            throw new IllegalArgumentException(fieldType + " cannot be null or blank.");
        }

        if (name.length() > MAX_NAME_LENGTH_CHARS)
        {
            throw new IllegalArgumentException(fieldType + " must be less than " + MAX_NAME_LENGTH_CHARS + " " +
                                               "characters.");
        }
    }

    /**
     * Displays the full name to the console in "firstName lastName" format.
     */
    @Override
    public void display()
    {
        System.out.println("Full Name: " + this.firstName + " " + this.lastName);
    }
}
