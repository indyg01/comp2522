package ca.bcit.comp2522.bookstore;

/**
 * Represents a biography, a specialized type of book
 * that describes the life of a person.
 * <p>
 * A biography has an author who writes the book and a subject who the book is about.
 * Implements Printable to display its information in a formatted way.
 *
 * @author Sukhraj Sandhar
 * @author Arshia Adamian
 * @author Rodrick Vizigro
 * @author Indy Grewal
 * @author Abdullah Alasmy
 * @version 1.0
 */
public class Biography
    extends Book
    implements Printable
{
    private final Person subject;

    /**
     * Constructs a Biography object with the specified title, publication year,
     * author, and subject.
     *
     * @param title         the title of the biography
     * @param yearPublished the year the biography was published
     * @param author        the author who wrote the biography
     * @param subject       the person who the biography is about
     * @throws IllegalArgumentException if the subject is invalid
     */
    public Biography(final String title,
                     final int yearPublished,
                     final Author author,
                     final Person subject)
    {
        super(title, yearPublished, author);

        validateSubject(subject, "subject");

        this.subject = subject;
    }

    /**
     * Validates that the subject of the biography is not null.
     *
     * @param subject   the person subject to validate
     * @param fieldType the label for the field (for error message context)
     * @throws IllegalArgumentException if subject is null
     */
    private static void validateSubject(

        final Person subject,
        final String fieldType)
    {
        if (subject == null)
        {
            throw new IllegalArgumentException(fieldType + " cannot be null.");
        }
    }

    /**
     * Compares this biography to another biography based on their subjects.
     *
     * @param that the Biography object to compare against
     * @return true if both biographies have the same subject, otherwise false
     */
    @Override
    public boolean equals(final Object that)
    {

        if (that instanceof Biography)
        {
            final Biography thatBiography;

            thatBiography = (Biography) that;
            return this.subject == thatBiography.subject;
        }

        return false;

    }

    /**
     * Displays the details of the biography, including title, year, author, and subject.
     * <p>
     * Calls the superclass display method to print common information before printing the subject.
     */
    @Override
    public void display()
    {
        super.display();
        System.out.println("Subject: " + this.subject);
    }
}