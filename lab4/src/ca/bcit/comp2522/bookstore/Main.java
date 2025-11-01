package ca.bcit.comp2522.bookstore;

public class Main
{
    public static void main(String[] args)
    {
//        Person person;
//        person = new Person(new Name("firstName", "lastName"));
        Person person = new Person(new Name("test", "test"), new Date(10, 2, 3), null);

        Person p2 = new Person(new Name("Tester", "mc testerson"), new Date(11, 5, 2), null);

        person.compareTo(p2);
    }
}
