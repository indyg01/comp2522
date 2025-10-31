package ca.bcit.comp2522.bookstore;

/**
 * Represents a book with a title, publication year, and author.
 * Implements Comparable, Printable, and Reversible interfaces.
 *
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
    private static final int MAX_TITLE_LENGTH_CHARS = 100;
    private static final int MIN_YEAR = 1;
    private static final int CURRENT_YEAR = ;

    private final String title;
    private final int yearPublished;
    private final String author;

    public Book(String title, int yearPublished, String author)
    {
        this.title = title;
        this.yearPublished = yearPublished;
        this.author = author;
    }

    public int getYearPublished()
    {
        return this.yearPublished;
    }

    public String getAuthor()
    {
        return this.author;
    }

    public String getTitle()
    {
        return this.title;
    }

    @override
    public int compareTo(Book that)
    {
        return that.getYearPublished() - this.getYearPublished();
    }

    public void display()
    {
        System.out.println("Title: " + this.getTitle() + " Year Published: " + this.getYearPublished() + " Author: " + this.getAuthor());
    }

    public void backward()
    {
        String reversedTitle;
        reversedTitle = new StringBuilder(this.getTitle()).reverse().toString();
        System.out.println("Backwards: " + reversedTitle);
    }
}

