package org.example.sector.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "people")
public class Person {
  @Id private int id;

  // Mandatory fields

  /** Name of person */
  @NotBlank private String name;

  /** Whether the person is currently active */
  @NotNull private boolean isActive;

  // Optional fields

  /** Faction this person is part of */
  private String faction;

  /** Organization this person is affiliated with */
  private String affiliation;

  /** Rank of person */
  private String rank;

  /** Biography of person */
  private String biography;

  /** Homeworld of person */
  private String homeworld;
}
