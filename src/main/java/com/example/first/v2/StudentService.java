package com.example.first.v2;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.example.first.v2.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {

	private final StudentRepository studentRepository;

	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

    public List<Student> getStudents() {
		return studentRepository.findAll();
		// return List.of(new Student(1L, "ZORO", "...", LocalDate.of(2000, Month.NOVEMBER, 23), 21));
	}

	public void createStudent(Student student) {
		System.out.println(student);
		Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
		if(studentByEmail.isPresent()) {
			throw new IllegalStateException("EMAIL ALREADY EXISTS");
		}
		studentRepository.save(student);
	}

	public void deleteStudent(Long studentId) {
		boolean exists = studentRepository.existsById(studentId);
		if(!exists) {
			throw new IllegalStateException("STUDENT ID " + studentId + "DOES NOT EXISTS!");
		}
		studentRepository.deleteById(studentId);
	}

	@Transactional
	public void updateStudent(Long studentId, String name, String email) {
		Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("STUDENT DOES NOT EXISTS!"));
		if(name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
			student.setName(name);
		}
		if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
			student.setEmail(email);
		}
	}

}
