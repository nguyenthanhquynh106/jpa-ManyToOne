package com.example.webday10.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.webday10.entity.Faculty;
import com.example.webday10.entity.Student;
import com.example.webday10.repository.FacultyRepository;
import com.example.webday10.repository.PassportRepository;
import com.example.webday10.repository.StudentRepository;
import com.example.webday10.service.FacultyService;

@Service
public class FacultyServiceImpl implements FacultyService {

	private StudentRepository studentRepository;
	private FacultyRepository facultyRepository;
	private PassportRepository passportRepository;

	@Autowired
	public FacultyServiceImpl(StudentRepository studentRepository, FacultyRepository facultyRepository,
			PassportRepository passportRepository) {
		this.studentRepository = studentRepository;
		this.facultyRepository = facultyRepository;
		this.passportRepository = passportRepository;
	}

	@Override
	@Transactional
	public void insert(Faculty f) {
		facultyRepository.insert(f);

		Set<Student> students = f.getStudents();
		if (students != null && students.size() > 0) {
			for (Student s : students) {
				passportRepository.insert(s.getPassport());
				studentRepository.insert(s);
			}
		}
	}

}
