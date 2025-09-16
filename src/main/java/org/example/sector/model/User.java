package org.example.sector.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;

/** Class representing the users of the application */
@Document(collection = "users")
public class User {
    @Id
    private String id;
    @NotBlank(message = "Name is required")
    private String name;
}
