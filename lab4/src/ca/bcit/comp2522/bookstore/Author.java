package ca.bcit.comp2522.bookstore;

public class Author extends Person implements Printable
{
    private static final int MAX_GENRE_LENGTH_CHARS = 29;

    private final String genre;

    public Author(final Name name,
                  final Date dob,
                  final Date dod,
                  final String genre)
    {
        super(name, dob, dod);

        validateGenreName(genre, "Genre");

        this.genre = genre;
    }

    private void validateGenreName(final String name,
                              final String fieldType)
    {
        if (name == null || name.isBlank())
        {
            throw new IllegalArgumentException(fieldType + " cannot be null or blank.");
        }

        if (name.length() > MAX_GENRE_LENGTH_CHARS)
        {
            throw new IllegalArgumentException(fieldType + " must be less than " + MAX_GENRE_LENGTH_CHARS + " characters.");
        }
    }

    @Override
    public void display()
    {
        System.out.println("Author: ");
        super.display();
        System.out.println("Genre: " + genre);
    }
}
