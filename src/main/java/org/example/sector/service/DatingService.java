package org.example.sector.service;

import java.time.LocalDateTime;
import org.example.sector.dating.ImperialDate;
import org.springframework.stereotype.Service;

@Service
public class DatingService {
  public String getCurrentSectorDate(final int checkNumber) {
    return ImperialDate.futureDateOf(LocalDateTime.now(), checkNumber).toString();
  }
}
