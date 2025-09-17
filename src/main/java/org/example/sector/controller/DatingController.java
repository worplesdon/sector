package org.example.sector.controller;

import org.example.sector.dating.CheckNumber;
import org.example.sector.service.DatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/date")
public class DatingController {

  @Autowired private DatingService datingService;

  /**
   * Get the Imperial date based on the current date. Defaults to {@link CheckNumber#ON_TERRA} if no
   * check number provided. Note the @RequestParam does not need a name argument as the
   * maven-compiler-plugin has the "-parameter" argument supplied
   */
  @GetMapping
  public String getCurrentSectorDate(
      @RequestParam(name = "checkNumber", defaultValue = "0") final int checkNumber) {
    return datingService.getCurrentSectorDate(checkNumber);
  }
}
