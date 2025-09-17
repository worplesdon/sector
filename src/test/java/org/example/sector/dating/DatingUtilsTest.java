package org.example.sector.dating;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DatingUtilsTest {
  /**
   * Test {@link DatingUtils#getDaysPerYear(LocalDate)}.
   *
   * <p>Method under test: {@link DatingUtils#getDaysPerYear(LocalDate)}
   */
  @Test
  @DisplayName("Test getDaysPerYear(LocalDate); then return three hundred sixty-five")
  @Tag("MaintainedByDiffblue")
  void testGetDaysPerYear_thenReturnThreeHundredSixtyFive() {
    // Arrange, Act and Assert
    assertEquals(365, DatingUtils.getDaysPerYear(LocalDate.of(1970, 1, 1)));
  }

  /**
   * Test {@link DatingUtils#getDaysPerYear(LocalDate)}.
   *
   * <p>Method under test: {@link DatingUtils#getDaysPerYear(LocalDate)}
   */
  @Test
  @DisplayName(
      "Test getDaysPerYear(LocalDate); when ofYearDay zero and one; then return three hundred sixty-six")
  @Tag("MaintainedByDiffblue")
  void testGetDaysPerYear_whenOfYearDayZeroAndOne_thenReturnThreeHundredSixtySix() {
    // Arrange, Act and Assert
    assertEquals(366, DatingUtils.getDaysPerYear(LocalDate.ofYearDay(0, 1)));
  }

  /**
   * Test {@link DatingUtils#getDaysPerYear(LocalDate)}.
   *
   * <p>Method under test: {@link DatingUtils#getDaysPerYear(LocalDate)}
   */
  @Test
  @DisplayName(
      "Test getDaysPerYear(LocalDate); when ofYearDay zero and one; then return three hundred sixty-six")
  @Tag("MaintainedByDiffblue")
  void testGetDaysPerYear_whenOfYearDayTwoHundred() {
    // Arrange, Act and Assert
    assertEquals(365, DatingUtils.getDaysPerYear(LocalDate.ofYearDay(42200, 1)));
  }

  /**
   * Test {@link DatingUtils#getYearFraction(LocalDateTime)} with {@code LocalDateTime}.
   *
   * <p>Method under test: {@link DatingUtils#getYearFraction(LocalDateTime)}
   */
  @Test
  void testGetYearFractionWithLocalDateTime() {
    // Arrange, Act and Assert
    assertEquals(0, DatingUtils.getYearFraction(LocalDate.of(1970, 1, 1).atStartOfDay()));
  }

  /**
   * Test {@link DatingUtils#getYearFraction(LocalDateTime)} with {@code LocalDateTime}.
   *
   * <p>Method under test: {@link DatingUtils#getYearFraction(LocalDateTime)}
   */
  @Test
  void testGetYearFractionWithLocalDateTime_whenOfYearDayZeroAndOneAtStartOfDay() {
    assertAll(
        () -> assertEquals(0, DatingUtils.getYearFraction(LocalDateTime.of(0, 1, 1, 0, 0))),
        () -> assertEquals(481, DatingUtils.getYearFraction(LocalDateTime.of(0, 6, 25, 5, 54))),
        () -> assertEquals(481, DatingUtils.getYearFraction(LocalDateTime.of(0, 6, 25, 5, 55))),
        () -> assertEquals(482, DatingUtils.getYearFraction(LocalDateTime.of(0, 6, 25, 13, 55))),
        () -> assertEquals(482, DatingUtils.getYearFraction(LocalDateTime.of(0, 6, 25, 13, 0))),
        () -> assertEquals(680, DatingUtils.getYearFraction(LocalDateTime.of(0, 9, 5, 23, 59))),
        () -> assertEquals(680, DatingUtils.getYearFraction(LocalDateTime.of(0, 9, 6, 0, 0))),
        () -> assertEquals(999, DatingUtils.getYearFraction(LocalDateTime.of(0, 12, 31, 23, 59))),
        () -> assertEquals(0, DatingUtils.getYearFraction(LocalDateTime.of(1, 1, 1, 0, 0))));
  }

  /**
   * Test {@link DatingUtils#getYearFraction(LocalDate)} with {@code LocalDate}.
   *
   * <p>Method under test: {@link DatingUtils#getYearFraction(LocalDate)}
   */
  @Test
  void testGetYearFractionWithLocalDate_NonLeapYear() {
    // Arrange, Act and Assert
    assertAll(
        () -> assertEquals(0, DatingUtils.getYearFraction(LocalDate.of(1970, 1, 1))),
        () -> assertEquals(158, DatingUtils.getYearFraction(LocalDate.of(1970, 2, 28))),
        () -> assertEquals(161, DatingUtils.getYearFraction(LocalDate.of(1970, 3, 1))),
        () -> assertEquals(709, DatingUtils.getYearFraction(LocalDate.of(1970, 9, 17))),
        () -> assertEquals(712, DatingUtils.getYearFraction(LocalDate.of(1970, 9, 18))),
        () -> assertEquals(997, DatingUtils.getYearFraction(LocalDate.of(1970, 12, 31))));
  }

  /**
   * Test {@link DatingUtils#getYearFraction(LocalDate)} with {@code LocalDate}.
   *
   * <p>Method under test: {@link DatingUtils#getYearFraction(LocalDate)}
   */
  @Test
  void testGetYearFractionWithLocalDate_LeapYear() {
    // Arrange, Act and Assert
    assertAll(
        () -> assertEquals(0, DatingUtils.getYearFraction(LocalDate.of(42100, 1, 1))),
        () -> assertEquals(158, DatingUtils.getYearFraction(LocalDate.of(42100, 2, 28))),
        () -> assertEquals(161, DatingUtils.getYearFraction(LocalDate.of(42100, 3, 1))),
        () -> assertEquals(709, DatingUtils.getYearFraction(LocalDate.of(42100, 9, 17))),
        () -> assertEquals(712, DatingUtils.getYearFraction(LocalDate.of(42100, 9, 18))),
        () -> assertEquals(997, DatingUtils.getYearFraction(LocalDate.of(42100, 12, 31))));
  }
}
