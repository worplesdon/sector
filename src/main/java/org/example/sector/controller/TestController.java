package org.example.sector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/** Spring controller to test whether the MongoDB database is running */
@RestController
public class TestController {
  @Autowired private MongoTemplate mongoTemplate;

  @GetMapping("/test-db")
  public ResponseEntity<String> testDb() {
    try {
      mongoTemplate.getDb().listCollectionNames().first();
      return ResponseEntity.ok("MongoDB is connected and working.");
    } catch (Exception e) {
      return ResponseEntity.status(500).body("MongoDB connection failed: " + e.getMessage());
    }
  }
}
