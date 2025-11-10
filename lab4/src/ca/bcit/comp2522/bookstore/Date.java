package ca.bcit.comp2522.bookstore;

/**
 * Represents a valid calendar date, providing methods for formatting and date calculations.
 *
 * @author Abdullah Alasmy
 * @author Arshia Adamian
 * @author Rodrick Vizigro
 * @author Indy Grewal
 * @author Sukhraj Sandhar
 * @version 1.2
 */
public final class Date
{
    private static final int MINIMUM_VALID_YEAR = 1800;
    private static final int MAXIMUM_VALID_YEAR = 2025;

    private static final int YEAR_1900 = 1900;
    private static final int YEAR_2000 = 2000;

    private static final int CENTURY_CODE_FOR_1800S    = 2;
    private static final int CENTURY_CODE_FOR_2000S    = 6;
    private static final int LEAP_YEAR_ADJUSTMENT_CODE = 6;

    private static final int JANUARY   = 1;
    private static final int FEBRUARY  = 2;
    private static final int MARCH     = 3;
    private static final int APRIL     = 4;
    private static final int MAY       = 5;
    private static final int JUNE      = 6;
    private static final int JULY      = 7;
    private static final int AUGUST    = 8;
    private static final int SEPTEMBER = 9;
    private static final int OCTOBER   = 10;
    private static final int NOVEMBER  = 11;
    private static final int DECEMBER  = 12;

    private static final int MONTH_CODE_JANUARY   = 1;
    private static final int MONTH_CODE_FEBRUARY  = 4;
    private static final int MONTH_CODE_MARCH     = 4;
    private static final int MONTH_CODE_APRIL     = 0;
    private static final int MONTH_CODE_MAY       = 2;
    private static final int MONTH_CODE_JUNE      = 5;
    private static final int MONTH_CODE_JULY      = 0;
    private static final int MONTH_CODE_AUGUST    = 3;
    private static final int MONTH_CODE_SEPTEMBER = 6;
    private static final int MONTH_CODE_OCTOBER   = 1;
    private static final int MONTH_CODE_NOVEMBER  = 4;
    private static final int MONTH_CODE_DECEMBER  = 6;

    private static final int DAYS_IN_JANUARY       = 31;
    private static final int DAYS_IN_FEBRUARY      = 28;
    private static final int DAYS_IN_FEBRUARY_LEAP = 29;
    private static final int DAYS_IN_MARCH         = 31;
    private static final int DAYS_IN_APRIL         = 30;
    private static final int DAYS_IN_MAY           = 31;
    private static final int DAYS_IN_JUNE          = 30;
    private static final int DAYS_IN_JULY          = 31;
    private static final int DAYS_IN_AUGUST        = 31;
    private static final int DAYS_IN_SEPTEMBER     = 30;
    private static final int DAYS_IN_OCTOBER       = 31;
    private static final int DAYS_IN_NOVEMBER      = 30;
    private static final int DAYS_IN_DECEMBER      = 31;

    private static final int MIN_VALID_DAY = 1;

    private static final int SATURDAY_INDEX  = 0;
    private static final int SUNDAY_INDEX    = 1;
    private static final int MONDAY_INDEX    = 2;
    private static final int TUESDAY_INDEX   = 3;
    private static final int WEDNESDAY_INDEX = 4;
    private static final int THURSDAY_INDEX  = 5;
    private static final int FRIDAY_INDEX    = 6;

    private static final String SATURDAY  = "Saturday";
    private static final String SUNDAY    = "Sunday";
    private static final String MONDAY    = "Monday";
    private static final String TUESDAY   = "Tuesday";
    private static final String WEDNESDAY = "Wednesday";
    private static final String THURSDAY  = "Thursday";
    private static final String FRIDAY    = "Friday";

    private static final int NO_REMAINDER         = 0;
    private static final int YEARS_PER_CYCLE      = 12;
    private static final int LEAP_YEAR_DIVISOR    = 4;
    private static final int DAYS_PER_WEEK        = 7;
    private static final int CENTURY_DIVISOR      = 100;
    private static final int FOUR_CENTURY_DIVISOR = 400;

    private final int year;
    private final int month;
    private final int day;

    /**
     * Constructs and validates a new Date object from a given year, month, and day.
     *
     * @param year  the year.
     * @param month the month.
     * @param day   the day.
     * @throws IllegalArgumentException if any of the date is invalid.
     */
    public Date(final int year,
                final int month,
                final int day)
    {
        validateDate(year, month, day);

        this.year  = year;
        this.month = month;
        this.day   = day;
    }

    /**
     * Validates the year, month, and day to ensure they form a correct calendar date.
     *
     * @param yearToValidate  the year to check (must be between 1800 and CURRENT_YEAR).
     * @param monthToValidate the month to check; must be JANUARY - DECEMBER
     * @param dayToValidate   the day to check (must be valid for the given month and year).
     * @throws IllegalArgumentException if the date is not valid.
     */
    private static void validateDate(final int yearToValidate,
                                     final int monthToValidate,
                                     final int dayToValidate)
    {
        if (yearToValidate < MINIMUM_VALID_YEAR || yearToValidate > MAXIMUM_VALID_YEAR)
        {
            throw new IllegalArgumentException("Year must be between " +
                                               MINIMUM_VALID_YEAR + " and " + MAXIMUM_VALID_YEAR + ".");
        }

        if (monthToValidate < JANUARY || monthToValidate > DECEMBER)
        {
            throw new IllegalArgumentException("Month must be between " +
                                               JANUARY + " and " + DECEMBER + ".");
        }

        final int maxDaysInMonth;
        if (monthToValidate == FEBRUARY && isLeapYear(yearToValidate))
        {
            maxDaysInMonth = DAYS_IN_FEBRUARY_LEAP;
        }
        else
        {
            maxDaysInMonth = getDaysInMonthNonLeap(monthToValidate);
        }

        if (dayToValidate < MIN_VALID_DAY || dayToValidate > maxDaysInMonth)
        {
            throw new IllegalArgumentException("Day is invalid for the given month and year.");
        }
    }

    /**
     * Determines if a given year is a leap year.
     *
     * @param yearToTest the year to check.
     * @return true if the year is a leap year, false otherwise.
     */
    private static boolean isLeapYear(final int yearToTest)
    {
        final boolean divisibleBy4;
        final boolean divisibleBy100;
        final boolean divisibleBy400;

        divisibleBy4   = (yearToTest % LEAP_YEAR_DIVISOR == NO_REMAINDER);
        divisibleBy100 = (yearToTest % CENTURY_DIVISOR == NO_REMAINDER);
        divisibleBy400 = (yearToTest % FOUR_CENTURY_DIVISOR == NO_REMAINDER);

        return (divisibleBy4 && !divisibleBy100) || divisibleBy400;
    }

    /**
     * Returns the day of the month.
     *
     * @return the day as an integer (1-31).
     */
    public int getDay()
    {
        return day;
    }

    /**
     * Returns the month of the year.
     *
     * @return the month as an integer (1-12).
     */
    public int getMonth()
    {
        return month;
    }

    /**
     * Returns the year.
     *
     * @return the year as a four-digit integer.
     */
    public int getYear()
    {
        return year;
    }

    /**
     * Formats the date as a string in "YYYY-MM-DD" format.
     *
     * @return a formatted string representation of the date.
     */
    public String getYyyyMmDd()
    {
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    /**
     * Calculates and returns the day of the week for this date.
     * <p>
     * The method determines the weekday (Saturday–Friday) using
     * an arithmetic sequence of operations involving century codes,
     * leap year adjustments, and month codes.
     * <p>
     * Calculation steps:
     * 1. Add a century code: +2 for 1800s, +6 for 2000s, none for 1900s.
     * 2. Add +6 if the date is in a leap year and the month is January or February.
     * 3. Take the last two digits of the year and find how many full twelves fit in.
     * 4. Add the remainder after removing twelves.
     * 5. Add the number of fours that fit into the remainder.
     * 6. Add the day of the month and the month code.
     * 7. Take the total modulo 7 to get the weekday index (0 = Saturday, 1 = Sunday, etc.).
     * <p>
     * The calculation returns a numeric index that corresponds to a weekday name.
     * The mapping between numbers and days is handled by getDayName().
     *
     * @return the name of the day, for example "Monday"
     */
    public String getDayOfWeek()
    {
        int total;
        total = 0;

        if (year >= YEAR_2000)
        {
            total += CENTURY_CODE_FOR_2000S;
        }
        else if (year < YEAR_1900)
        {
            total += CENTURY_CODE_FOR_1800S;
        }

        if (isLeapYear(year) && (month == JANUARY || month == FEBRUARY))
        {
            total += LEAP_YEAR_ADJUSTMENT_CODE;
        }

        final int lastTwoDigitsOfYear;
        final int twelvesInYear;
        final int remainderFromTwelves;
        final int foursInRemainder;
        final int dayOfMonth;
        final int monthCode;
        final int dayIndex;

        lastTwoDigitsOfYear  = year % CENTURY_DIVISOR;
        twelvesInYear        = lastTwoDigitsOfYear / YEARS_PER_CYCLE;
        remainderFromTwelves = lastTwoDigitsOfYear % YEARS_PER_CYCLE;
        foursInRemainder     = remainderFromTwelves / LEAP_YEAR_DIVISOR;
        dayOfMonth           = this.day;
        monthCode            = getMonthCode(this.month);

        total += twelvesInYear + remainderFromTwelves + foursInRemainder + dayOfMonth + monthCode;
        dayIndex = total % DAYS_PER_WEEK;

        return getDayName(dayIndex);
    }

    /**
     * Returns the number of days in a given month for a non-leap year.
     * <p>
     * The method is used during date validation to ensure that
     * the day value is within a valid range for the given month.
     * February always returns 28 days here, since leap-year logic
     * is handled separately in other methods.
     *
     * @param monthValue the month number between 1 and 12
     * @return the number of days in that month
     * @throws IllegalArgumentException if monthValue is outside 1–12
     */
    private static int getDaysInMonthNonLeap(final int monthValue)
    {
        if (monthValue < JANUARY || monthValue > DECEMBER)
        {
            throw new IllegalArgumentException("Month must be between 1 and 12.");
        }

        if (monthValue == JANUARY)
        {
            return DAYS_IN_JANUARY;
        }
        if (monthValue == FEBRUARY)
        {
            return DAYS_IN_FEBRUARY;
        }
        if (monthValue == MARCH)
        {
            return DAYS_IN_MARCH;
        }
        if (monthValue == APRIL)
        {
            return DAYS_IN_APRIL;
        }
        if (monthValue == MAY)
        {
            return DAYS_IN_MAY;
        }
        if (monthValue == JUNE)
        {
            return DAYS_IN_JUNE;
        }
        if (monthValue == JULY)
        {
            return DAYS_IN_JULY;
        }
        if (monthValue == AUGUST)
        {
            return DAYS_IN_AUGUST;
        }
        if (monthValue == SEPTEMBER)
        {
            return DAYS_IN_SEPTEMBER;
        }
        if (monthValue == OCTOBER)
        {
            return DAYS_IN_OCTOBER;
        }
        if (monthValue == NOVEMBER)
        {
            return DAYS_IN_NOVEMBER;
        }
        return DAYS_IN_DECEMBER;
    }

    /**
     * Returns the numeric code assigned to each month.
     * <p>
     * Month codes are constants that contribute to the
     * weekday calculation. Each month has its own value
     * determined by the standard pattern used in the formula.
     *
     * @param monthValue the month number between 1 and 12
     * @return the month code for the given month
     * @throws IllegalArgumentException if monthValue is outside 1–12
     */
    private static int getMonthCode(final int monthValue)
    {
        if (monthValue < JANUARY || monthValue > DECEMBER)
        {
            throw new IllegalArgumentException("Month must be between 1 and 12.");
        }

        if (monthValue == JANUARY)
        {
            return MONTH_CODE_JANUARY;
        }
        if (monthValue == FEBRUARY)
        {
            return MONTH_CODE_FEBRUARY;
        }
        if (monthValue == MARCH)
        {
            return MONTH_CODE_MARCH;
        }
        if (monthValue == APRIL)
        {
            return MONTH_CODE_APRIL;
        }
        if (monthValue == MAY)
        {
            return MONTH_CODE_MAY;
        }
        if (monthValue == JUNE)
        {
            return MONTH_CODE_JUNE;
        }
        if (monthValue == JULY)
        {
            return MONTH_CODE_JULY;
        }
        if (monthValue == AUGUST)
        {
            return MONTH_CODE_AUGUST;
        }
        if (monthValue == SEPTEMBER)
        {
            return MONTH_CODE_SEPTEMBER;
        }
        if (monthValue == OCTOBER)
        {
            return MONTH_CODE_OCTOBER;
        }
        if (monthValue == NOVEMBER)
        {
            return MONTH_CODE_NOVEMBER;
        }
        return MONTH_CODE_DECEMBER;
    }

    /**
     * Returns the English name of the day corresponding to a numeric index.
     * <p>
     * The mapping between index values and day names is as follows:
     * 0 = Saturday
     * 1 = Sunday
     * 2 = Monday
     * 3 = Tuesday
     * 4 = Wednesday
     * 5 = Thursday
     * 6 = Friday
     * <p>
     * The index value is calculated using modulo 7 logic in getDayOfWeek().
     *
     * @param dayIndex the weekday index from 0 to 6
     * @return the English name of the weekday
     * @throws IllegalArgumentException if dayIndex is outside 0–6
     */
    private static String getDayName(final int dayIndex)
    {
        if (dayIndex < SATURDAY_INDEX || dayIndex > FRIDAY_INDEX)
        {
            throw new IllegalArgumentException("Day index must be between 0 and 6.");
        }

        if (dayIndex == SATURDAY_INDEX)
        {
            return SATURDAY;
        }
        if (dayIndex == SUNDAY_INDEX)
        {
            return SUNDAY;
        }
        if (dayIndex == MONDAY_INDEX)
        {
            return MONDAY;
        }
        if (dayIndex == TUESDAY_INDEX)
        {
            return TUESDAY;
        }
        if (dayIndex == WEDNESDAY_INDEX)
        {
            return WEDNESDAY;
        }
        if (dayIndex == THURSDAY_INDEX)
        {
            return THURSDAY;
        }
        return FRIDAY;
    }

}
