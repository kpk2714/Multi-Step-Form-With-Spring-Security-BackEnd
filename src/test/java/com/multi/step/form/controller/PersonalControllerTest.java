package com.multi.step.form.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.multi.step.form.entities.Personal;
import com.multi.step.form.service.PersonalService;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
class PersonalControllerTest {

    @Mock
    private PersonalService personalService;

    @InjectMocks
    private PersonalController personalController;

    private MockMvc mockMvc;
    private Personal personal;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(personalController).build();

        personal = new Personal();
        personal.setUserId("student123");
        personal.setId(1);
    }

    @Test
    @DisplayName("Should return 200 OK when authorized user saves personal")
    void testSavePersonal_Authorized() throws Exception {
        // Mock SecurityContext and Authentication
        Authentication authentication = mock(Authentication.class);
        when(authentication.isAuthenticated()).thenReturn(true);
        when(authentication.getName()).thenReturn("student123");

        SecurityContext securityContext = mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);

        when(personalService.savePersonal(any(Personal.class))).thenReturn(personal);

        mockMvc.perform(post("/savePersonal")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"userId\":\"student123\"}"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.message").value("Data Saved Successfully !!!"));
    }

    @Test
    @DisplayName("Should return 401 Unauthorized when userId does not match")
    void testSavePersonal_UnauthorizedUserId() throws Exception {
        Authentication authentication = mock(Authentication.class);
        when(authentication.isAuthenticated()).thenReturn(true);
        when(authentication.getName()).thenReturn("wrongUser");

        SecurityContext securityContext = mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);

        mockMvc.perform(post("/savePersonal")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"userId\":\"student123\"}"))
            .andExpect(status().isUnauthorized())
            .andExpect(jsonPath("$.message").value("Unauthorized User"));
    }

    @Test
    @DisplayName("Should return 401 Unauthorized when no authentication present")
    void testSavePersonal_NoAuthentication() throws Exception {
        SecurityContextHolder.clearContext();

        mockMvc.perform(post("/savePersonal")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"userId\":\"student123\"}"))
            .andExpect(status().isUnauthorized())
            .andExpect(jsonPath("$.message").value("Unauthorized User"));
    }
}

