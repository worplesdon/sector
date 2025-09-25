package org.example.sector.repository;

import java.util.List;
import org.example.sector.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {
  List<Person> findByFaction(String faction);
}
