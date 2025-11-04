package ca.bcit.comp2522.bookstore;

/**
 * The entry point for the COMP 2522 Bookstore application.
 *
 * @author Sukhraj Sandhar
 * @author Arshia Adamian
 * @author Rodrick Vizigro
 * @author Indy Grewal
 * @author Abdullah Alasmy
 * @version 1.0
 */
public class Main
{
    /**
     * The entry point of the program.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(final String[] args)
    {

        final Author orwell;
        final Author lee;
        final Author austen;
        final Author fitzgerald;
        final Author melville;

        final Book book1;
        final Book book2;
        final Book book3;
        final Book book4;
        final Book book5;

        final Biography bio1;
        final Biography bio2;
        final Biography bio3;
        final Biography bio4;
        final Biography bio5;

        final Author frank;
        final Author mandela;
        final Author gandhi;
        final Author angelou;
        final Author malcolm;

        final Autobiography auto1;
        final Autobiography auto2;
        final Autobiography auto3;
        final Autobiography auto4;
        final Autobiography auto5;


        System.out.println("=== BOOKSTORE SYSTEM ===\n");


        orwell = new Author(new Name("George", "Orwell"),
                            new Date(1903, 6, 25),
                            new Date(1950, 1, 21),
                            "Dystopian Fiction");

        lee = new Author(new Name("Harper", "Lee"),
                         new Date(1926, 4, 28),
                         new Date(2016, 2, 19),
                         "Southern Gothic");

        austen = new Author(new Name("Jane", "Austen"),
                            new Date(1810, 12, 16),
                            new Date(1817, 7, 18),
                            "Romance");

        fitzgerald = new Author(new Name("F. Scott", "Fitzgerald"),
                                new Date(1896, 9, 24),
                                new Date(1940, 12, 21),
                                "Tragedy");

        melville = new Author(new Name("Herman", "Melville"),
                              new Date(1819, 8, 1),
                              new Date(1891, 9, 28),
                              "Adventure");


        book1 = new Book("1984", 1949, orwell);
        book2 = new Book("To Kill a Mockingbird", 1960, lee);
        book3 = new Book("Pride and Prejudice", 1813, austen);
        book4 = new Book("The Great Gatsby", 1925, fitzgerald);
        book5 = new Book("Moby-Dick", 1851, melville);


        bio1 = new Biography("The Power Broker", 1974,
                             new Author(new Name("Robert", "Caro"),
                                        new Date(1935, 10, 30),
                                        null,
                                        "Political Biography"),
                             new Person(new Name("Robert", "Moses"),
                                        new Date(1888, 12, 18),
                                        new Date(1981, 7, 29)));

        bio2 = new Biography("Steve Jobs", 2011,
                             new Author(new Name("Walter", "Isaacson"),
                                        new Date(1952, 5, 20),
                                        null,
                                        "Technology Biography"),
                             new Person(new Name("Steve", "Jobs"),
                                        new Date(1955, 2, 24),
                                        new Date(2011, 10, 5)));

        bio3 = new Biography("Churchill: A Life", 1991,
                             new Author(new Name("Martin", "Gilbert"),
                                        new Date(1936, 10, 25),
                                        new Date(2015, 2, 3),
                                        "Historical Biography"),
                             new Person(new Name("Winston", "Churchill"),
                                        new Date(1874, 11, 30),
                                        new Date(1965, 1, 24)));

        bio4 = new Biography("Alexander Hamilton", 2004,
                             new Author(new Name("Ron", "Chernow"),
                                        new Date(1949, 3, 3),
                                        null,
                                        "Historical Biography"),
                             new Person(new Name("Alexander", "Hamilton"),
                                        new Date(1800, 1, 11),
                                        new Date(1804, 7, 12)));

        bio5 = new Biography("Einstein: His Life and Universe", 2007,
                             new Author(new Name("Walter", "Isaacson"),
                                        new Date(1952, 5, 20),
                                        null,
                                        "Science Biography"),
                             new Person(new Name("Albert", "Einstein"),
                                        new Date(1879, 3, 14),
                                        new Date(1955, 4, 18)));


        frank = new Author(new Name("Anne", "Frank"),
                           new Date(1929, 6, 12),
                           new Date(1945, 2, 1),
                           "Diary");

        mandela = new Author(new Name("Nelson", "Mandela"),
                             new Date(1918, 7, 18),
                             new Date(2013, 12, 5),
                             "Political Autobiography");

        gandhi = new Author(new Name("Mahatma", "Gandhi"),
                            new Date(1869, 10, 2),
                            new Date(1948, 1, 30),
                            "Spiritual Autobiography");

        angelou = new Author(new Name("Maya", "Angelou"),
                             new Date(1928, 4, 4),
                             new Date(2014, 5, 28),
                             "Poetic Autobiography");

        malcolm = new Author(new Name("Malcolm", "X"),
                             new Date(1925, 5, 19),
                             new Date(1965, 2, 21),
                             "Political Autobiography");

        auto1 = new Autobiography("The Diary of a Young Girl", 1947, frank);
        auto2 = new Autobiography("Long Walk to Freedom", 1994, mandela);
        auto3 = new Autobiography("The Story of My Experiments with Truth", 1927, gandhi);
        auto4 = new Autobiography("I Know Why the Caged Bird Sings", 1969, angelou);
        auto5 = new Autobiography("The Autobiography of Malcolm X", 1965, malcolm);

        // ----------------------------
        // Printing & Comparisons
        // ----------------------------
        System.out.println("=== PRINTABLE OUTPUTS ===");
        book1.display();
        bio1.display();
        auto1.display();

        System.out.println("\n=== REVERSIBLE OUTPUTS ===");
        book1.backward();
        mandela.backward();

        System.out.println("\n=== COMPARISONS ===");
        System.out.println("Compare Books by Year (1984 vs. Mockingbird): "
                           + book1.compareTo(book2));
        System.out.println("Compare Authors by Birth Year (Orwell vs. Lee): "
                           + orwell.compareTo(lee));
        System.out.println("Compare Biographies by Subject (bio1 vs. bio2): "
                           + bio1.equals(bio2));

        System.out.println("\n=== PROGRAM END ===");
    }
}