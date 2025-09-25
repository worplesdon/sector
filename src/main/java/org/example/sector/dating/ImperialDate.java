package org.example.sector.dating;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @param checkNum Category of the location of the given date
 * @param year Year of the given millennium
 * @param yearFraction Fraction of the way through the given year. Expressed as an int between 0 and
 *     999
 * @param millennium The number of the given millennium e.g. 2025 is in the 3rd millennium
 */
public record ImperialDate(CheckNumber checkNum, int year, int yearFraction, int millennium) {
  /** How many years in the future. 2025 -> 41013 */
  // ToDo Make this a variable somewhere for customization.
  private static long YEARS_IN_THE_FUTURE = 38988;

  /** Construct an ImperialDate from a {@link LocalDate} and checkNum (see {@link CheckNumber} */
  public static ImperialDate of(final LocalDate localDate, int checkNum) {
    int millennium = ((localDate.getYear() - 1) / 1000) + 1; // Millennium starts in M001 so need -1
    int year = localDate.getYear() % 1000;
    int yearFraction = DatingUtils.getYearFraction(localDate);
    return new ImperialDate(CheckNumber.getCheckNumber(checkNum), year, yearFraction, millennium);
  }

  /**
   * Construct an ImperialDate from a {@link LocalDateTime} and checkNum (see {@link CheckNumber}
   */
  public static ImperialDate of(final LocalDateTime localDateTime, int checkNum) {
    int millennium =
        ((localDateTime.getYear() - 1) / 1000) + 1; // Millennium starts in M001 so need -1
    int year = localDateTime.getYear() % 1000;
    int yearFraction = DatingUtils.getYearFraction(localDateTime);
    return new ImperialDate(CheckNumber.getCheckNumber(checkNum), year, yearFraction, millennium);
  }

  /**
   * Constructs an ImperialDate using a present year and shifting it by the {@link
   * #YEARS_IN_THE_FUTURE}
   */
  public static ImperialDate futureDateOf(final LocalDateTime presentDate, final int checkNum) {
    return of(presentDate.plusYears(YEARS_IN_THE_FUTURE), checkNum);
  }

  @Override
  public String toString() {
    return String.format("%d%03d%03dM%d", checkNum.getValue(), yearFraction, year, millennium);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof ImperialDate) {
      ImperialDate otherDate = (ImperialDate) obj;
      return checkNum.equals(otherDate.checkNum)
          && year == otherDate.year
          && yearFraction == otherDate.yearFraction
          && millennium == otherDate.millennium;
    }
    return false;
  }
}
