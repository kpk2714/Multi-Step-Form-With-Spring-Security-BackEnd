package com.multi.step.form.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.multi.step.form.entities.Personal;
import com.multi.step.form.repository.PersonalRepository;

@ExtendWith(MockitoExtension.class)
public class PersonalServiceSecurityTest {

	@Mock
    private PersonalRepository personalRepository;

    @InjectMocks
    private PersonalService personalService;

    private Personal personal;
    
    @BeforeEach
    void setUp() {
        personal = new Personal();
        personal.setId(1);
        personal.setUserId("student123");
    }
    
    @Test
    @DisplayName("savePersonal() should save and return Personal entity")
    void testSavePersonal() {
        // Arrange
        when(personalRepository.save(any(Personal.class))).thenReturn(personal);

        // Act
        Personal saved = personalService.savePersonal(personal);
        System.out.println(saved);

        ArgumentCaptor<Personal> captor = ArgumentCaptor.forClass(Personal.class);
        verify(personalRepository, times(1)).save(captor.capture());
        Personal captured = captor.getValue();
        System.out.println(captured);

        assertNotNull(saved);
        assertEquals("student123", saved.getUserId());
        assertEquals("student123", captured.getUserId());
    }
}
