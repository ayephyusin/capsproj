package sg.edu.iss.caps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.caps.service.StudentInterface;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentInterface stuservice;
	
	@Autowired
	public void setStudentInterface(StudentInterface stus) {
		this.stuservice =stus;
		
	}
	
}
