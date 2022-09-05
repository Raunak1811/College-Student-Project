package com.raunak.college.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.raunak.college.entity.College;
import com.raunak.college.VO.RequestTemplate;

@Service
public interface CollegeService {
	College add(College college);

	List<College> list();

	College update(long c_id, String c_name);

	College searchById(long c_id);

	List<RequestTemplate> listWithStud();

	RequestTemplate specificCollStudent(long c_id);
}
