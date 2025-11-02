package ca.bcit.comp2522.bookstore;

public class Biography extends Book
    implements Printable
{
    private final Person subject;

    public Biography(final String title,
                     final int yearPublished,
                     final Author author,
                     final Person subject)
    {
        super(title, yearPublished, author);

        validateSubject(subject, "subject");

        this.subject = subject;
    }

    private void validateSubject(final Person subject,
                                 final String fieldType)
    {
        if (subject == null)
        {
            throw new IllegalArgumentException(fieldType + " cannot be null.");
        }
    }

    @Override
    public boolean equals(final Biography that)
    {
        return this.subject == that.subject;
    }

    @Override
    public void display()
    {
        super.display();
        System.out.println("Subject: " + this.subject);

    }
}
