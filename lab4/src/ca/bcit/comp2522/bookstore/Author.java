package ca.bcit.comp2522.bookstore;

/**
 * Represents an author, which is a specialized type of person.
 * <p>
 * Each author has a name, date of birth, date of death (optional), and a literary genre.
 * Implements Printable to display the author's information in a readable format.
 *
 * @author Sukhraj Sandhar
 * @author Arshia Adamian
 * @author Rodrick Vizigro
 * @author Indy Grewal
 * @author Abdullah Alasmy
 * @version 1.0
 */
public class Author
    extends Person
    implements Printable
{
    private static final int MAX_GENRE_LENGTH_CHARS = 29;

    private final String genre;

    /**
     * Constructs an Author object with the given personal and genre details.
     *
     * @param name  the author's name
     * @param dob   the author's date of birth
     * @param dod   the author's date of death (may be null if still alive)
     * @param genre the author's literary genre
     * @throws IllegalArgumentException if genre is valid
     */
    public Author(final Name name,
                  final Date dob,
                  final Date dod,
                  final String genre)
    {
        super(name, dob, dod);

        validateGenreName(genre, "Genre");

        this.genre = genre;
    }

    /**
     * Validates a genre name to ensure it is non-null, non-blank, and within the maximum allowed length.
     *
     * @param name      the genre name to validate
     * @param fieldType the field label (for exception message context)
     * @throws IllegalArgumentException if the genre is null, blank, or too long
     */
    private static void validateGenreName(final String name,
                                          final String fieldType)
    {
        if (name == null || name.isBlank())
        {
            throw new IllegalArgumentException(fieldType + " cannot be null or blank.");
        }

        if (name.length() > MAX_GENRE_LENGTH_CHARS)
        {
            throw new IllegalArgumentException(fieldType + " must be less than " +
                                               MAX_GENRE_LENGTH_CHARS + " characters.");
        }
    }

    /**
     * Displays the author's full details, including their name, life dates, and genre.
     * <p>
     * Calls the superclass display method to print inherited information before printing the genre.
     */
    @Override
    public void display()
    {
        System.out.println("Author:");
        super.display();
        System.out.println("Genre: " + genre);
    }
}