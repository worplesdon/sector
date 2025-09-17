package org.example.sector.dating;

import java.time.LocalDate;
import java.time.LocalDateTime;

/** Util class for methods to help with calculating the {@link ImperialDate}. */
public class DatingUtils {
  public static int MINS_PER_DAY = 1440;
  public static int MINS_PER_HOUR = 60;
  public static int DAYS_PER_YEAR = 365;
  public static int DAYS_PER_LEAP_YEAR = 366;

  /** Gets the number of days in the year of the given {@code date} */
  public static int getDaysPerYear(final LocalDate date) {
    return date.isLeapYear() ? DAYS_PER_LEAP_YEAR : DAYS_PER_YEAR;
  }

  /**
   * Calculates the fraction of the year the given {@code LocalDate} is. The number returned is
   * expressed an int between 0 and 999
   */
  public static int getYearFraction(final LocalDate date) {
    final int dayOfYear = (date.getDayOfYear() - 1) * 1000;
    return (dayOfYear - 1) / getDaysPerYear(date);
  }

  /**
   * Calculates the fraction of the year the given {@code LocalDateTime} is. The number returned is
   * expressed an int between 0 and 999
   */
  public static int getYearFraction(final LocalDateTime date) {
    int mins = (date.getDayOfYear() - 1) * MINS_PER_DAY;
    mins += date.getHour() * MINS_PER_HOUR;
    mins += date.getMinute();

    final int daysInYear = getDaysPerYear(date.toLocalDate());
    final int minsPerYear = daysInYear * MINS_PER_DAY;

    return mins * 1000 / minsPerYear;
  }
}
