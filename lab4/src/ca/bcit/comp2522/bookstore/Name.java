package ca.bcit.comp2522.bookstore;

/**
 * Represents a person's first and last name with basic validation and convenience formatting methods.
 *
 * @author Indy Grewal
 * @version 1.0
 */
public final class Name
    implements Printable
{
    private static final int MAX_NAME_LENGTH_CHARS = 49;

    private final String firstName;
    private final String lastName;

    public Name(final String firstName,
                 final String lastName)
    {
       validateName(firstName, "firstName");
       validateName(lastName, "lastName");

       this.firstName = firstName;
       this.lastName = lastName;
    }

    private void validateName(final String name,
                              final String fieldType)
    {
        if (name == null || name.isBlank())
        {
            throw new IllegalArgumentException(fieldType + " cannot be null or blank.");
        }

        if (name.length() > MAX_NAME_LENGTH_CHARS)
        {
            throw new IllegalArgumentException(fieldType + " must be less than " + MAX_NAME_LENGTH_CHARS + " characters.");
        }
    }

    @Override
    public void display()
    {
        System.out.println("Full Name: " + this.firstName + " " + this.lastName);
    }
}
