public class CountingSundays
{
    public static int countSundaysOnFirst(int startYear, int endYear)
    {
        int dayOfWeek = dayOfWeekOnJan1(startYear);
        int sundays = 0;

        for(int year = startYear; year <= endYear; year++)
        {
            for(int month = 0; month < 12; month++)
            {
                if(dayOfWeek == 0) sundays++;
                dayOfWeek = (dayOfWeek + daysInMonth(month, year)) % 7;
            }
        }

        return sundays;
    }

    public static int dayOfWeekOnJan1(int year)
    {
        int dayOfWeek = 1;

        for(int y = 1900; y < year; y++)
        {
            for(int month = 0; month < 12; month++) dayOfWeek = (dayOfWeek + daysInMonth(month, y)) % 7;
        }

        return dayOfWeek;
    }

    public static int daysInMonth(int month, int year)
    {
        return switch (month) {
            case 0 -> 31; //January
            case 1 -> (isLeapYear(year) ? 29 : 28); //February
            case 2 -> 31; //March
            case 3 -> 30; //April
            case 4 -> 31; //May
            case 5 -> 30; //June
            case 6 -> 31; //July
            case 7 -> 31; //August
            case 8 -> 30; //September
            case 9 -> 31; //October
            case 10 -> 30; //November
            case 11 -> 31; //December
            default -> throw new IllegalArgumentException("Invalid month");
        };
    }

    public static boolean isLeapYear(int year)
    {
        if (year % 4 != 0) return false;
        if (year % 100 != 0) return true;
        return year % 400 == 0;
    }

    public static void main(String[] args)
    {
        System.out.println(countSundaysOnFirst(1901, 2000));
    }
}
