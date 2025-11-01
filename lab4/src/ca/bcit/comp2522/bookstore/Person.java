package ca.bcit.comp2522.bookstore;

public class Person implements Comparable<Person>,
                               Printable,
                               Reversible
{
    private final Name name;
    private final Date dateOfBirth;
    private final Date dateOfDeath;

    public Person(final Name name,
                  final Date dateOfBirth,
                  final Date dateOfDeath)
    {
        validateName(name);
        validateDateOfBirth(dateOfBirth);

        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
    }

    protected void validateName(final Name name)
    {
        if (name == null)
        {
            throw new IllegalArgumentException("Name cannot be null.");
        }
    }

    protected void validateDateOfBirth(final Date dateOfBirth)
    {
        if (dateOfBirth == null)
        {
            throw new IllegalArgumentException("Date of Birth cannot be null.");
        }
    }

    @Override
    public void display()
    {
        System.out.println("Name: " + this.name);
        System.out.println("Date of Birth: " + this.dateOfBirth);
        System.out.println("Date of Death: " + this.dateOfDeath);
    }

    @Override
    public void backward()
    {


    }

    @Override
    public int compareTo(Person that)
    {
        if (dateOfBirth.getYear() != that.dateOfBirth.getYear())
        {
            return that.dateOfBirth.getYear() - dateOfBirth.getYear();
        }

    }
}
