package ca.bcit.comp2522.bookstore;

/**
 * Represents a person with a name, a date of birth, and an optional date of death.
 * <p>
 * Implements Comparable, Printable, and Reversible.
 * Persons are compared based on their year of birth; older persons are considered "larger."
 *
 * @author Sukhraj Sandhar
 * @author Arshia Adamian
 * @author Rodrick Vizigro
 * @author Indy Grewal
 * @author Abdullah Alasmy
 * @version 1.0
 */
public class Person implements Comparable<Person>,
                               Printable,
                               Reversible
{
    private final Name name;
    private final Date dateOfBirth;
    private final Date dateOfDeath;

    /**
     * Constructs a Person object with a name, date of birth, and an optional date of death.
     *
     * @param name        the name of the person
     * @param dateOfBirth the date the person was born
     * @param dateOfDeath the date the person died, or null if still alive
     * @throws IllegalArgumentException if name or dateOfBirth is valid
     */
    public Person(final Name name,
                  final Date dateOfBirth,
                  final Date dateOfDeath)
    {
        validateName(name);
        validateDateOfBirth(dateOfBirth);

        this.name        = name;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
    }

    /**
     * Validates that the provided name is not null.
     *
     * @param name the name to validate
     * @throws IllegalArgumentException if name is null
     */
    private static void validateName(final Name name)
    {
        if (name == null)
        {
            throw new IllegalArgumentException("Name cannot be null.");
        }
    }

    /**
     * Validates that the provided date of birth is not null.
     *
     * @param dateOfBirth the date of birth to validate
     * @throws IllegalArgumentException if dateOfBirth is null
     */
    private static void validateDateOfBirth(final Date dateOfBirth)
    {
        if (dateOfBirth == null)
        {
            throw new IllegalArgumentException("Date of Birth cannot be null.");
        }
    }

    /**
     * Displays the person's details including name, date of birth, and date of death.
     */
    @Override
    public void display()
    {
        System.out.println(
            "Name: " + this.name +
            "\nDate of Birth: " + this.dateOfBirth +
            "\nDate of Death: " + this.dateOfDeath);
    }

    /**
     * Displays the person's name in reverse order.
     */
    @Override
    public void backward()
    {
        StringBuilder str;
        str = new StringBuilder();

        str.append(this.name);
        str.reverse();

        System.out.println(str.toString());
    }

    /**
     * Compares this person to another based on their year of birth.
     * Older persons are considered "larger."
     *
     * @param that the Person to compare to
     * @return a positive number if this person is older, a negative number if younger, or zero if born the same year
     */
    @Override
    public int compareTo(Person that)
    {
        return that.dateOfBirth.getYear() - this.dateOfBirth.getYear();
    }
}