package ca.bcit.comp2522.bookstore;

import ca.bcit.comp2522.bookstore.Printable;

/**
 * Represents a Date with year, month, and day.
 * Arrays removed, no switch statements, and no numeric literals in logic (all via constants).
 * <p>
 * Day-of-week mapping uses if/else and named constants.
 */
public class Date implements Printable
{
    // Small numeral constants (to avoid magic numbers)
    private static final int ZERO             = 0;
    private static final int ONE              = 1;
    private static final int TWO              = 2;
    private static final int THREE            = 3;
    private static final int FOUR             = 4;
    private static final int FIVE             = 5;
    private static final int SIX              = 6;
    private static final int SEVEN            = 7;
    private static final int EIGHT            = 8;
    private static final int NINE             = 9;
    private static final int TEN              = 10;
    private static final int ELEVEN           = 11;
    private static final int TWELVE           = 12;
    private static final int THIRTY           = 30;
    private static final int THIRTY_ONE       = 31;
    private static final int TWENTY_EIGHT     = 28;
    private static final int TWENTY_NINE      = 29;
    private static final int NINETEEN_HUNDRED = 1900;
    private static final int TWO_THOUSAND     = 2000;
    private static final int ONE_HUNDRED      = 100;
    private static final int FOUR_HUNDRED     = 400;


    // Instance variables
    private final int year;
    private final int month;
    private final int day;


    // Public constraints
    public static final int MIN_YEAR = 1800;
    public static final int MAX_YEAR = 2025;

    public static final int MONTHS_IN_YEAR = TWELVE;
    public static final int DAYS_IN_WEEK   = SEVEN;

    // Month indices (1..12)
    private static final int JANUARY   = ONE;
    private static final int FEBRUARY  = TWO;
    private static final int MARCH     = THREE;
    private static final int APRIL     = FOUR;
    private static final int MAY       = FIVE;
    private static final int JUNE      = SIX;
    private static final int JULY      = SEVEN;
    private static final int AUGUST    = EIGHT;
    private static final int SEPTEMBER = NINE;
    private static final int OCTOBER   = TEN;
    private static final int NOVEMBER  = ELEVEN;
    private static final int DECEMBER  = TWELVE;

    // Leap year divisors

    private static final int LEAP_YEAR_DIVISOR    = FOUR;
    private static final int CENTURY_DIVISOR      = ONE_HUNDRED;
    private static final int FOUR_CENTURY_DIVISOR = FOUR_HUNDRED;


    // Year arithmetic helpers
    private static final int MODULUS_FOR_YEAR_PART     = ONE_HUNDRED;
    private static final int MONTH_DIVISOR_FOR_TWELVES = TWELVE;
    private static final int DIVISOR_FOR_FOURS         = FOUR;


    // Century offsets for day-of-week
    private static final int YEAR_1900 = NINETEEN_HUNDRED;
    private static final int YEAR_2000 = TWO_THOUSAND;

    private static final int OFFSET_DEFAULT        = ZERO;
    private static final int OFFSET_BEFORE_1900    = TWO;      // same as original logic
    private static final int OFFSET_2000_AND_AFTER = SIX;   // same as original logic


    // Leap-year adjustment for Jan/Feb in day-of-week calc
    private static final int LEAP_YEAR_ADJUSTMENT = ONE;

    // Day-of-week indices (Zeller-style: 0=Saturday..6=Friday)
    private static final int DOW_SATURDAY  = ZERO;
    private static final int DOW_SUNDAY    = ONE;
    private static final int DOW_MONDAY    = TWO;
    private static final int DOW_TUESDAY   = THREE;
    private static final int DOW_WEDNESDAY = FOUR;
    private static final int DOW_THURSDAY  = FIVE;
    private static final int DOW_FRIDAY    = SIX;


    // Month codes (same values as the original MONTH_CODES array)
    private static final int MONTH_CODE_JAN = ONE;
    private static final int MONTH_CODE_FEB = FOUR;
    private static final int MONTH_CODE_MAR = FOUR;
    private static final int MONTH_CODE_APR = ZERO;
    private static final int MONTH_CODE_MAY = TWO;
    private static final int MONTH_CODE_JUN = FIVE;
    private static final int MONTH_CODE_JUL = ZERO;
    private static final int MONTH_CODE_AUG = THREE;
    private static final int MONTH_CODE_SEP = SIX;
    private static final int MONTH_CODE_OCT = ONE;
    private static final int MONTH_CODE_NOV = FOUR;
    private static final int MONTH_CODE_DEC = SIX;


    // String format
    private static final String DATE_FORMAT = "%04d-%02d-%02d";

    /**
     * Constructs a Date object with validation.
     */
    public Date(final int year,
                final int month,
                final int day)
    {
        // Keep your external validation call
        Validation.validateDate(year, month, day);

        this.year  = year;
        this.month = month;
        this.day   = day;
    }


    // Getters
    public int getYear()
    {
        return year;
    }

    public int getMonth()
    {
        return month;
    }

    public int getDay()
    {
        return day;
    }

    public String getYYYYMMDD()
    {
        return String.format(DATE_FORMAT, year, month, day);
    }

    /**
     * Day-of-week as lowercase text.
     */
    public String getDayOfTheWeek()
    {
        int centuryOffset = OFFSET_DEFAULT;
        if (year >= YEAR_2000)
        {
            centuryOffset = OFFSET_2000_AND_AFTER;
        }
        else if (year < YEAR_1900)
        {
            centuryOffset = OFFSET_BEFORE_1900;
        }

        final boolean leap = isLeapYear(year);
        final boolean adjustForLeap = leap && (month == JANUARY || month == FEBRUARY);

        final int y = year % MODULUS_FOR_YEAR_PART;
        final int numTwelves = y / MONTH_DIVISOR_FOR_TWELVES;
        final int remainder = y % MONTH_DIVISOR_FOR_TWELVES;
        final int numFours = remainder / DIVISOR_FOR_FOURS;

        final int monthCode = monthCodeFor(month);
        int total = numTwelves + remainder + numFours + day + monthCode + centuryOffset;

        if (adjustForLeap)
        {
            total = total - LEAP_YEAR_ADJUSTMENT;
        }

        final int dayIndex = total % DAYS_IN_WEEK;
        return dayNameFor(dayIndex);
    }

    /**
     * Month name as English word.
     */
    public String getMonthName()
    {
        return monthNameFor(month);
    }

    /**
     * Leap year check.
     */
    public static boolean isLeapYear(final int y)
    {
        final boolean divisibleBy4 = (y % LEAP_YEAR_DIVISOR) == ZERO;
        final boolean divisibleBy100 = (y % CENTURY_DIVISOR) == ZERO;
        final boolean divisibleBy400 = (y % FOUR_CENTURY_DIVISOR) == ZERO;
        return (divisibleBy4 && !divisibleBy100) || divisibleBy400;
    }

    /**
     * Days in month without arrays/switch.
     */
    public static int daysInMonth(final int y,
                                  final int m)
    {
        if (m == JANUARY)
        {
            return THIRTY_ONE;
        }
        else if (m == FEBRUARY)
        {
            if (isLeapYear(y))
            {
                return TWENTY_NINE;
            }
            else
            {
                return TWENTY_EIGHT;
            }
        }
        else if (m == MARCH)
        {
            return THIRTY_ONE;
        }
        else if (m == APRIL)
        {
            return THIRTY;
        }
        else if (m == MAY)
        {
            return THIRTY_ONE;
        }
        else if (m == JUNE)
        {
            return THIRTY;
        }
        else if (m == JULY)
        {
            return THIRTY_ONE;
        }
        else if (m == AUGUST)
        {
            return THIRTY_ONE;
        }
        else if (m == SEPTEMBER)
        {
            return THIRTY;
        }
        else if (m == OCTOBER)
        {
            return THIRTY_ONE;
        }
        else if (m == NOVEMBER)
        {
            return THIRTY;
        }
        else if (m == DECEMBER)
        {
            return THIRTY_ONE;
        }
        else
        {
            // Safe default if invalid month slips through external validation
            return THIRTY_ONE;
        }
    }

    // -----------------------
    // Internal helpers (no arrays, no switch)
    // -----------------------

    private static int monthCodeFor(final int m)
    {
        if (m == JANUARY)
        {
            return MONTH_CODE_JAN;
        }
        else if (m == FEBRUARY)
        {
            return MONTH_CODE_FEB;
        }
        else if (m == MARCH)
        {
            return MONTH_CODE_MAR;
        }
        else if (m == APRIL)
        {
            return MONTH_CODE_APR;
        }
        else if (m == MAY)
        {
            return MONTH_CODE_MAY;
        }
        else if (m == JUNE)
        {
            return MONTH_CODE_JUN;
        }
        else if (m == JULY)
        {
            return MONTH_CODE_JUL;
        }
        else if (m == AUGUST)
        {
            return MONTH_CODE_AUG;
        }
        else if (m == SEPTEMBER)
        {
            return MONTH_CODE_SEP;
        }
        else if (m == OCTOBER)
        {
            return MONTH_CODE_OCT;
        }
        else if (m == NOVEMBER)
        {
            return MONTH_CODE_NOV;
        }
        else if (m == DECEMBER)
        {
            return MONTH_CODE_DEC;
        }
        else
        {
            return MONTH_CODE_JAN; // safe default
        }
    }

    private static String dayNameFor(final int dayIndex)
    {
        if (dayIndex == DOW_SATURDAY)
        {
            return "saturday";
        }
        else if (dayIndex == DOW_SUNDAY)
        {
            return "sunday";
        }
        else if (dayIndex == DOW_MONDAY)
        {
            return "monday";
        }
        else if (dayIndex == DOW_TUESDAY)
        {
            return "tuesday";
        }
        else if (dayIndex == DOW_WEDNESDAY)
        {
            return "wednesday";
        }
        else if (dayIndex == DOW_THURSDAY)
        {
            return "thursday";
        }
        else if (dayIndex == DOW_FRIDAY)
        {
            return "friday";
        }
        else
        {
            return "saturday"; // safe default
        }
    }

    private static String monthNameFor(final int m)
    {
        if (m == JANUARY)
        {
            return "January";
        }
        else if (m == FEBRUARY)
        {
            return "February";
        }
        else if (m == MARCH)
        {
            return "March";
        }
        else if (m == APRIL)
        {
            return "April";
        }
        else if (m == MAY)
        {
            return "May";
        }
        else if (m == JUNE)
        {
            return "June";
        }
        else if (m == JULY)
        {
            return "July";
        }
        else if (m == AUGUST)
        {
            return "August";
        }
        else if (m == SEPTEMBER)
        {
            return "September";
        }
        else if (m == OCTOBER)
        {
            return "October";
        }
        else if (m == NOVEMBER)
        {
            return "November";
        }
        else if (m == DECEMBER)
        {
            return "December";
        }
        else
        {
            return "";
        }
    }

    @Override
    public void display()
    {
        System.out.println("Date: " + getYYYYMMDD());
    }
}