package org.example.sector.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.sector.model.Person;
import org.example.sector.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {

  private final PersonRepository personRepository;

  public List<Person> getAllPeople() {
    return personRepository.findAll();
  }

  public List<Person> getAllByFaction(final String faction) {
    return personRepository.findByFaction(faction);
  }

  public Person savePerson(final Person person) {
    return personRepository.save(person);
  }
}
