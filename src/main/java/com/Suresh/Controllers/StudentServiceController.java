package com.Suresh.Controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Suresh.Models.Student;

@RestController
public class StudentServiceController {

	static Map<String, List<Student>> map;

	static {
		map = new HashMap<String, List<Student>>();

		Student s1 = new Student("Suresh", "3rd-Class");
		Student s2 = new Student("Naresh", "5th-Class");

		Student s3 = new Student("abc", "3rd-Class");
		Student s4 = new Student("xyz", "5th-Class");

		map.put("VailSchool", Arrays.asList(s1, s2));

		map.put("Govt School", Arrays.asList(s3, s4));

	}

	@RequestMapping(value = "/getStudentDetailsForSchool/{schoolname}", method = RequestMethod.GET)
	public List<Student> getStudents(@PathVariable String schoolname) {
		System.out.println("Getting Student details for " + schoolname);

		List<Student> studentList = map.get(schoolname);
		if (studentList == null) {
			studentList = new ArrayList<Student>();
			Student std = new Student("Not Found", "N/A");
			studentList.add(std);
			System.out.println(" printing the list in student service  " +studentList);
		}
		return studentList;
	}
}
