package org.example.sector.dating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImperialDateTest {
  /**
   * Test {@link ImperialDate#toString()}.
   *
   * <p>Method under test: {@link ImperialDate#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("0001001M3", new ImperialDate(CheckNumber.ON_TERRA, 1, 1, 3).toString());
  }

  /** Test the different factory methods all create equal objects */
  @Test
  @DisplayName("Test of() methods")
  void testOfMethods() {
    ImperialDate fromLocalDate = ImperialDate.of(LocalDate.of(42121, 4, 8), 5);
    ImperialDate fromLocalDateTime = ImperialDate.of(LocalDateTime.of(42121, 4, 8, 0, 0), 5);
    ImperialDate fromPresentLocalDateTime =
        ImperialDate.futureDateOf(LocalDateTime.of(3033, 4, 8, 0, 0), 5);

    assertTrue(fromLocalDate.equals(fromLocalDateTime));
    assertTrue(fromPresentLocalDateTime.equals(fromLocalDateTime));
    assertTrue(
        fromLocalDate.equals(fromPresentLocalDateTime)); // Not strictly needed but for completeness
  }

  /** Test the different factory methods all create equal objects */
  @Test
  @DisplayName("Test not equals()")
  void testNotEquals() {
    LocalDateTime localDateTime = LocalDateTime.of(42121, 4, 8, 0, 0);
    ImperialDate fromLocalDateTime = ImperialDate.of(localDateTime, 5);
    ImperialDate fromPresentLocalDateTime =
        ImperialDate.futureDateOf(LocalDateTime.of(42121, 4, 8, 0, 0), 5);

    assertFalse(fromPresentLocalDateTime.equals(fromLocalDateTime));
    assertFalse(fromPresentLocalDateTime.equals(localDateTime));
  }
}
