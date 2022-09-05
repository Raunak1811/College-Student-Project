package com.raunak.student;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.raunak.student.entity.Student;
import com.raunak.student.repository.StudentRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class StudentApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private StudentRepository studentRepository;

	@BeforeEach
	void setup() {
		studentRepository.deleteAll();
	}

	@Test
	public void givenListOfEmployees_whenGetAllEmployees_thenReturnEmployeesList() throws Exception {
		// Setting precondition or setup
		List<Student> listOfEmployees = new ArrayList<>();
		listOfEmployees.add(new Student(1, "Raunak Mitra", "Male", 25, 3, "Science"));
		listOfEmployees.add(new Student(2, "Jyot Roy", "Male", 42, 4, "Science"));
		listOfEmployees.add(new Student(3, "Pritam Santra", "Malee", 43, 5, "Arts"));
		listOfEmployees.add(new Student(4, "Nilanjan Mitra", "Male", 32, 1, "Science"));
		listOfEmployees.add(new Student(5, "Sambhunath Pal", "Male", 32, 1, "Commerce"));
		listOfEmployees.add(new Student(6, "Moumita Sen", "Female", 32, 1, "Arts"));

		studentRepository.saveAll(listOfEmployees);
		// when - action or the behavior that we are going test
		ResultActions response = mockMvc.perform(get("http://localhost:9091/student"));

		// then - verify the output
		response.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.size()", is(listOfEmployees.size())));

	}
}
