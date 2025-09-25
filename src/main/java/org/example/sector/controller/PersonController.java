package org.example.sector.controller;

import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.sector.model.Person;
import org.example.sector.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/person")
@RequiredArgsConstructor
public class PersonController {
  private final PersonService personService;

  @GetMapping
  public List<Person> getAll() {
    return personService.getAllPeople();
  }

  @GetMapping("/faction")
  public List<Person> getByFaction(@RequestParam String faction) {
    return personService.getAllByFaction(faction);
  }

  @PostMapping
  public Person createPerson(@Valid @RequestBody Person person) {
    return personService.savePerson(person);
  }
}
