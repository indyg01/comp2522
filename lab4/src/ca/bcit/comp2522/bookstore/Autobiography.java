package ca.bcit.comp2522.bookstore;

/**
 * Represents an autobiography, a specialized form of biography
 * in which the author is also the subject of the book.
 * <p>
 * Implements Printable to allow formatted display of its details.
 *
 * @author Sukhraj Sandhar
 * @author Arshia Adamian
 * @author Rodrick Vizigro
 * @author Indy Grewal
 * @author Abdullah Alasmy
 * @version 1.0
 */
public class Autobiography
    extends Biography
    implements Printable
{
    /**
     * Constructs an Autobiography where the author and the subject are the same person.
     *
     * @param title         the title of the autobiography
     * @param yearPublished the year the autobiography was published
     * @param author        the author who both wrote and is featured in the book
     */
    public Autobiography(final String title,
                         final int yearPublished,
                         final Author author)
    {
        super(title, yearPublished, author, author);
    }

    /**
     * Displays the details of this autobiography by calling the superclass display method.
     */
    @Override
    public void display()
    {
        super.display();
    }
}