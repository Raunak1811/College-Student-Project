package com.raunak.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raunak.student.entity.Student;
import com.raunak.student.service.StudentService;
import com.raunak.student.VO.ResponseTemplate;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping
	public Student add(@RequestBody Student stdnt) {
		return studentService.add(stdnt);
	}

	@GetMapping
	public List<Student> listStdnt() {
		return studentService.list();
	}

	@GetMapping("/{stdId}")
	public ResponseTemplate stdntWithcllg(@PathVariable long stdId) {
		return studentService.stdWithcllg(stdId);
	}

	@PutMapping("/{stdId}/{c_Id}")
	public String updateCollege(@PathVariable long stdId, @PathVariable long c_Id) {
		Student stud = studentService.assignCollege(stdId, c_Id);
		if (stud != null) {
			return stud.toString();
		}
		return "Sorry.College or student not found";
	}

	@GetMapping("/student-with-ascname/{c_id}")
	public List<Student> nameByAscending(@PathVariable long c_id) {
		return studentService.getAscendingNameById(c_id);
	}

	@GetMapping("/student-with-desc-age/{stream}")
	public List<Student> getStudentByStreamWithDescAge(@PathVariable String stream) {
		return studentService.getStudentByStreamWithDescAge(stream);
	}
}