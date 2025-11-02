package ca.bcit.comp2522.bookstore;

public class Main
{
    public static void main(String[] args)
    {
        String first1 = "Geroge";
        String last1 = "Orwell";
        Name name1 = new Name(first1, last1);
        Date georgeDOB = new Date(1984, 12, 19);
        Date georgeDOD = new Date(2000, 9, 19);
        Author author1 = new Author(name1, georgeDOB, georgeDOD, "Suspense");
        Book book1 = new Book("1984", 1949, author1);
    }
}
