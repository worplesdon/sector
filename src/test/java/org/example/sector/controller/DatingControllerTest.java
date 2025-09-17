package org.example.sector.controller;

import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.example.sector.service.DatingService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {DatingController.class, ValidationExceptionHandler.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class DatingControllerTest {
  @Autowired private DatingController datingController;

  @MockitoBean private DatingService datingService;

  @Autowired private ValidationExceptionHandler validationExceptionHandler;

  /**
   * Test {@link DatingController#getCurrentSectorDate(int)}.
   *
   * <p>Method under test: {@link DatingController#getCurrentSectorDate(int)}
   */
  @Test
  @DisplayName("Test getCurrentSectorDate(int)")
  void testGetCurrentSectorDate() throws Exception {
    // Arrange
    when(datingService.getCurrentSectorDate(anyInt())).thenReturn("2020-03-01");

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/date").param("checkNumber", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(datingController)
        .setControllerAdvice(validationExceptionHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(content().string("2020-03-01"));
  }
}
