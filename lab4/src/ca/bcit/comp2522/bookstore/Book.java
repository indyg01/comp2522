package ca.bcit.comp2522.bookstore;

/**
 * Represents a book with a title, publication year, and author.
 * Implements Comparable, Printable, and Reversible interfaces.
 * <p>
 * Older books are considered "larger" when compared.
 *
 * @author Sukhraj Sandhar
 * @author Arshia Adamian
 * @author Rodrick Vizigro
 * @author Indy Grewal
 * @author Abdullah Alasmy
 * @version 1.0
 */
public class Book
    implements Comparable<Book>,
               Printable,
               Reversible
{
    private static final int MAX_TITLE_LENGTH_CHARS = 99;
    private static final int MIN_YEAR               = 1;
    private static final int CURRENT_YEAR           = 2025;

    private final String title;
    private final int    yearPublished;
    private final Author author;

    /**
     * Constructs a Book object with the given title, publication year, and author.
     *
     * @param title         the title of the book
     * @param yearPublished the year the book was published
     * @param author        the author of the book
     * @throws IllegalArgumentException if any of the parameters are invalid
     */
    public Book(final String title,
                final int yearPublished,
                final Author author)
    {
        validateTitle(title, "title");
        validateYearPublished(yearPublished, "yearPublished");
        validateAuthor(author, "author");

        this.title         = title;
        this.yearPublished = yearPublished;
        this.author        = author;
    }

    /**
     * Validates that the title is not null, blank, or too long.
     *
     * @param title     the title to validate
     * @param fieldType the label used in the exception message
     * @throws IllegalArgumentException if the title is invalid
     */
    private static void validateTitle(final String title,
                                      final String fieldType)
    {
        if (title == null || title.isBlank())
        {
            throw new IllegalArgumentException(fieldType + " cannot be blank or null.");
        }

        if (title.length() > MAX_TITLE_LENGTH_CHARS)
        {
            throw new IllegalArgumentException(fieldType + " cannot be longer than "
                                               + MAX_TITLE_LENGTH_CHARS + ".");
        }
    }

    /**
     * Validates that the publication year is within the valid range.
     *
     * @param yearPublished the year to validate
     * @param fieldType     the label used in the exception message
     * @throws IllegalArgumentException if the year is not within range
     */
    private static void validateYearPublished(final int yearPublished,
                                              final String fieldType)
    {
        if (yearPublished < MIN_YEAR || yearPublished > CURRENT_YEAR)
        {
            throw new IllegalArgumentException(fieldType + " is not within "
                                               + MIN_YEAR + " and " + CURRENT_YEAR + ".");
        }
    }

    /**
     * Validates that the author is not null.
     *
     * @param author    the author to validate
     * @param fieldType the label used in the exception message
     * @throws IllegalArgumentException if the author is null
     */
    private static void validateAuthor(final Author author,
                                       final String fieldType)
    {
        if (author == null)
        {
            throw new IllegalArgumentException(fieldType + " cannot be null.");
        }
    }

    /**
     * Compares this book with another based on publication year.
     * Older books are considered "larger."
     *
     * @param that the other book to compare to
     * @return a positive number if this book is older, a negative number if newer, or zero if the same year
     */
    @Override
    public int compareTo(final Book that)
    {
        return that.yearPublished - this.yearPublished;
    }

    /**
     * Displays the book's details, including title, publication year, and author.
     */
    @Override
    public void display()
    {
        System.out.println(
            "Title: " + this.title +
            "\nYear Published: " + this.yearPublished +
            "\nAuthor: " + this.author.toString());
    }

    /**
     * Displays the book's title in reverse order.
     */
    @Override
    public void backward()
    {
        StringBuilder str;
        str = new StringBuilder();

        str.append(this.title);
        str.reverse();

        System.out.println(str.toString());
    }
}