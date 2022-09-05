package com.raunak.student.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.raunak.student.entity.Student;
import com.raunak.student.repository.StudentRepository;
import com.raunak.student.service.StudentService;
import com.raunak.student.VO.College;
import com.raunak.student.VO.ResponseTemplate;

@Component
public class StudentImple implements StudentService {

	@Autowired
	private StudentRepository studentRepo;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Student add(Student emp) {
		return studentRepo.save(emp);
	}

	@Override
	public List<Student> list() {
		return studentRepo.findAll();
	}

	@Override
	public Student searchById(long id) {
		return studentRepo.findById(id);
	}

	@Override
	public ResponseTemplate stdWithColl(long stdId) {
		return stdWithcllg(stdId);
	}

	@Override
	public ResponseTemplate stdWithcllg(long stdId) {
		ResponseTemplate RT = new ResponseTemplate();
		Student std = studentRepo.findById(stdId);

		long c_id = std.getC_id();
		College college = restTemplate.getForObject("http://COLLEGE-SERVICE/college/" + c_id, College.class);
		RT.setCollege(college);
		RT.setStudent(std);
		return RT;
	}

	@Override
	public Student assignCollege(long studentId, long c_Id) {
		Student stud = studentRepo.findById(studentId);
		Student dept = restTemplate.getForObject("http://COLLEGE-SERVICE/college/" + c_Id, Student.class);
		if (stud == null || dept == null) {
			return null;
		}
		stud.setC_id(c_Id);
		studentRepo.save(stud);
		return stud;
	}

	@Override
	public List<Student> getAscendingNameById(long c_id) {
		return studentRepo.ascendingName(c_id);
	}

	@Override
	public List<Student> getStudentByStreamWithDescAge(String stream) {
		return studentRepo.getStudentByStreamWithDescAge(stream);
	}

}
