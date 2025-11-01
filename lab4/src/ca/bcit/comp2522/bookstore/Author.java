package ca.bcit.comp2522.bookstore;

public class Author extends Person implements Printable
{
    private final String genre;

    public Author(final Name name,
                  final Date dob,
                  final Date dod,
                  final String genre)
    {
        super(name, dob, dod);
        if (genre == null || genre.isBlank() || genre.length() > 30)
        {
            throw new IllegalArgumentException("Genre invalid");
        }
        this.genre = genre;
    }

    @Override
    public void display()
    {
        System.out.println("Author: ");
        super.display();
        System.out.println("Genre: " + genre);
    }
}

public class Author extends Person implements Printable
{
    private final String genre;

    public Author(final Name name,
                  final Date dob,
                  final Date dod,
                  final String genre)

    {


    }
}