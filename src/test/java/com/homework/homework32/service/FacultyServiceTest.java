package com.homework.homework32.service;

import com.homework.homework32.model.Faculty;
import com.homework.homework32.repository.FacultyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FacultyServiceTest {

    @Mock
    private FacultyRepository facultyRepository;

    @InjectMocks
    private FacultyService facultyService;

    @Test
    public void shouldSuccesfullyAddFaculty() {
        Faculty faculty = new Faculty(1, "Гриффиндор", "Красный");
        when(facultyRepository.save(faculty)).thenReturn(faculty);
        Faculty expected = faculty;
        Faculty actual = facultyService.addFaculty(faculty);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findFaculty() {
        Faculty faculty = new Faculty(1, "Гриффиндор", "Красный");
        when(facultyRepository.findById(1l).get()).thenReturn(faculty);
        Faculty expected = faculty;
        Faculty actual = facultyService.findFaculty(1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSuccesfullyFindByColor() {
        List<Faculty> faculties = new ArrayList<>() {{
            new Faculty(1, "Гриффиндор", "Красный");
            new Faculty(2, "Пуффендуй", "Красный");
        }};
        when(facultyRepository.findByColorIgnoreCase("Красный")).thenReturn((ArrayList<Faculty>) faculties);
        List<Faculty> expected = faculties;
        List<Faculty> actual = facultyService.findByColor("Красный");
        Assertions.assertEquals(expected, actual);
    }
}