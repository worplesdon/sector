package org.example.sector.dating;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.Getter;

/** Enum of possible Check numbers that are used within {@link ImperialDate#} */
@Getter
public enum CheckNumber {
  ON_TERRA(0),
  SOL_SYSTEM(1),
  DIRECT_CONTACT(2),
  INDIRECT_CONTACT_FIRST_DEGREE(3),
  INDIRECT_CONTACT_SECOND_DEGREE(4),
  INDIRECT_CONTACT_THIRD_DEGREE(5),
  INDIRECT_CONTACT_FOURTH_DEGREE(6),
  WITHIN_TEN_YEARS(7),
  WITHIN_TWENTY_YEARS(8),
  ESTIMATED(9);

  /** Check Number digit of Imperial date */
  private final int value;

  /** Lookup map to quickly get a CheckNumber from an integer */
  private static final Map<Integer, CheckNumber> LOOKUP =
      Arrays.stream(CheckNumber.values())
          .collect(Collectors.toMap(CheckNumber::getValue, cn -> cn));

  CheckNumber(int value) {
    this.value = value;
  }

  /** Get the CheckNumber that corresponds to {@code value} */
  public static CheckNumber getCheckNumber(final int value) {
    CheckNumber checkNumber = LOOKUP.get(value);
    if (checkNumber == null) {
      throw new IllegalArgumentException("Invalid Check Number: " + value);
    }
    return checkNumber;
  }
}
