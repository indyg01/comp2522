package ca.bcit.comp2522.bookstore;

/**
 * Validation class: Centralized validations for all constructors in the project.
 * All public static methods in this class are called inside other constructors.
 *
 * @author Arshia
 * @version 1.0
 */
public class Validation {

    // Constants for name validation
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 45;
    private static final String FORBIDDEN_SUBSTRING = "admin";

    // Constants for client ID and account number validation
    private static final int MIN_ID_LENGTH = 6;
    private static final int MAX_ID_LENGTH = 7;

    // Constants for date validation
    private static final int MIN_VALID_YEAR = 1800;
    private static final int MAX_VALID_YEAR = 2025;
    private static final int MIN_MONTH = 1;
    private static final int MAX_MONTH = 12;
    private static final int MIN_DAY = 1;
    private static final int FEBRUARY = 2;
    private static final int MAX_DAYS = 29;
    private static final int JANUARY = 1;
    private static final int DECEMBER = 12;



    /**
     * Validates parameters for a BankClient constructor.
     *
     * @param name       the client's name
     * @param birthDate  birth date
     * @param deathDate  death date (optional)
     * @param clientID   unique identifier
     * @param signupDate date the client joined
     */
    public static void validateBankClient (final Name name,
                                           final Date birthDate,
                                           final Date deathDate,
                                           final String clientID,
                                           final Date signupDate) {
        if (name == null || birthDate == null || clientID == null || signupDate == null) {
            throw new IllegalArgumentException("Name, birthDate, clientID or signupDate cannot be null.");
        }

        if (clientID.length() < MIN_ID_LENGTH || clientID.length() > MAX_ID_LENGTH) {
            throw new IllegalArgumentException("clientID must be between " + MIN_ID_LENGTH + " and " + MAX_ID_LENGTH + " characters.");
        }
    }

    /**
     * Validates first and last names.
     *
     * @param first the first name
     * @param last  the last name
     */
    public static void validateName (final String first,
                                     final String last) {
        if (first == null || last == null) {
            throw new IllegalArgumentException("First or last name cannot be null.");
        }

        if (first.length() < MIN_NAME_LENGTH || last.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException("First or last name cannot be empty.");
        }

        if (first.length() > MAX_NAME_LENGTH || last.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("First or last name cannot exceed " + MAX_NAME_LENGTH + " characters.");
        }

        if (first.contains(FORBIDDEN_SUBSTRING) || last.contains(FORBIDDEN_SUBSTRING)) {
            throw new IllegalArgumentException("Names cannot contain the word '" + FORBIDDEN_SUBSTRING + "'.");
        }
    }

    /**
     * Validates a bank account number.
     *
     * @param accountNumber the account number
     */
    public static void validateBankAccount (final String accountNumber) {
        if (accountNumber == null || accountNumber.length() < MIN_ID_LENGTH || accountNumber.length() > MAX_ID_LENGTH) {
            throw new IllegalArgumentException("Account number must be between " + MIN_ID_LENGTH + " and " + MAX_ID_LENGTH + " characters.");
        }
    }

    /**
     * Validates a date by year, month, and day.
     *
     * @param year  the year
     * @param month the month (1–12)
     * @param day   the day of the month
     */
    public static void validateDate(final int year,
                                    final int month,
                                    final int day) {

        // Year bounds
        if (year < Date.MIN_YEAR || year > Date.MAX_YEAR) {
            throw new IllegalArgumentException(
                "Invalid year. Pick a year between "
                + Date.MIN_YEAR + " and " + Date.MAX_YEAR + "."
            );
        }

        // Month bounds
        if (month < JANUARY || month > DECEMBER) {
            throw new IllegalArgumentException(
                "Invalid month. Pick a month between "
                + JANUARY + " and " + DECEMBER + "."
            );
        }

        // Max days based on month and leap-year
        final int maxDays = Date.daysInMonth(year, month);

        // Day bounds
        if (day < MIN_DAY|| day > maxDays) {
            throw new IllegalArgumentException(
                "Invalid day. Pick a day between "
                + MIN_DAY + " and " + maxDays + "."
            );
        }
    }

}