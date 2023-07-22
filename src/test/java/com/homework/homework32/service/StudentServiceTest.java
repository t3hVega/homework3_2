package com.homework.homework32.service;

import com.homework.homework32.model.Faculty;
import com.homework.homework32.model.Student;
import com.homework.homework32.repository.FacultyRepository;
import com.homework.homework32.repository.StudentRepository;
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
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    public void shouldSuccesfullyAddStudent() {
        Student student = new Student(1, "Гарри", 11);
        when(studentRepository.save(student)).thenReturn(student);
        Student expected = student;
        Student actual = studentService.addStudent(student);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findStudent() {
        Student student = new Student(1, "Гарри", 11);
        when(studentRepository.findById(1l).get()).thenReturn(student);
        Student expected = student;
        Student actual = studentService.findStudent(1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSuccesfullyFindByColor() {
        List<Student> students = new ArrayList<>() {{
            new Student(1, "Гарри", 11);
            new Student(1, "Рон", 11);
        }};
        when(studentRepository.findByAge(11)).thenReturn((ArrayList<Student>) students);
        List<Student> expected = students;
        List<Student> actual = studentService.findByAge(11);
        Assertions.assertEquals(expected, actual);
    }
}