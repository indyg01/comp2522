package ca.bcit.comp2522.bookstore;

/**
 * Represents a book with a title, publication year, and author.
 * Implements Comparable, Printable, and Reversible interfaces.
 * <p>
 * Older books are considered "larger" when compared.
 *
 * @author Indy
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

    private void validateTitle(final String title,
                               final String fieldType)
    {
        if (title == null || title.isBlank())
        {
            throw new IllegalArgumentException(fieldType + " cannot be blank or null.");
        }

        if (title.length() > MAX_TITLE_LENGTH_CHARS)
        {
            throw new IllegalArgumentException(fieldType + " cannot be longer than " + MAX_TITLE_LENGTH_CHARS + ".");
        }
    }

    private void validateYearPublished(final int yearPublished,
                                       final String fieldType)
    {
        if (yearPublished < MIN_YEAR || yearPublished > CURRENT_YEAR)
        {
            throw new IllegalArgumentException(fieldType + " is not within " + MIN_YEAR + " and " + CURRENT_YEAR + ".");
        }
    }

    private void validateAuthor(final Author author,
                                final String fieldType)
    {
        if (author == null)
        {
            throw new IllegalArgumentException(fieldType + " cannot be null.");
        }
    }

    @Override
    public int compareTo(Book that)
    {
        return that.yearPublished - this.yearPublished;
    }

    @Override
    public void display()
    {
        System.out.println(
            "Title: " + this.title +
            "\nYear Published: " + this.yearPublished +
            "\nAuthor: " + this.author.toString());
    }

    @Override
    public void backward()
    {
        StringBuilder str;
        str = new StringBuilder();

        str.append(this.title);
        str.reverse();

        System.out.println(str.toString());
    }

    public abstract boolean equals(Biography that);
}
