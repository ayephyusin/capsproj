package sg.edu.iss.caps.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.caps.model.Courses;
import sg.edu.iss.caps.model.EnrolmentStatus;
import sg.edu.iss.caps.model.Roles;
import sg.edu.iss.caps.service.LecturerInterface;

@Controller
@RequestMapping("/")
public class LecturerController {
	
	@Autowired
	LecturerInterface lectservice;
	
	@Autowired
	public void setLecturerInterface(LecturerInterface ls) {
		this.lectservice =ls;
	}
	
	@GetMapping(value = "/lecturer/coursestaught")
	public String showAllCourses(Model model) {
		model.addAttribute("coursestaught", lectservice.getAllCourses());
		
		return "lecturer/coursestaught";
	}
	
	@GetMapping(value = "/lecturer/coursestaught/{id}")
	public String showCoursesById(@PathVariable Long id, Model model) {
		
		model.addAttribute("coursestaught", lectservice.getAllCoursesByLecturerId(Roles.LECTURER, id));
		
		return "lecturer/coursestaught";
	}
	
	@GetMapping(value = "lecturer/enrolment")
	public String showCoursesByCourseNameCourseStart(Model model, String courseName,
			@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate courseStartDate, Roles role, EnrolmentStatus enrolmentStatus) {
		
		if (courseName != null && courseStartDate != null) {
			model.addAttribute("users", lectservice.getAllUsersByRoleCourseNameStartDate(
					Roles.STUDENT, 
					EnrolmentStatus.ACCEPTED, 
					courseName, 
					courseStartDate));
		} 		
		model.addAttribute("coursestaught", lectservice.getAllCourses());
		
		return "lecturer/enrolment";
	}
	
	// COMMENT BY MAX: KIV the below mapping methods. Please do not delete them for now.
	
//	@GetMapping(value = "/lecturer/enrolment")
//	public String showCoursesByCourseNameCourseStart(Model model, String courseName, 
//			@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate courseStartDate, Roles role) {
//		
//		if (courseName != null && courseStartDate != null) {
//			model.addAttribute("courses", lectservice.getByCourseNameCourseStart(courseName, courseStartDate));
//		} else {
//			model.addAttribute("courses", lectservice.getAllCourses());
//		}
//		
//		return "lecturer/enrolment";
//	}
	
//	@GetMapping(value = "/lecturer/enrolment/{id}") 
//	public String showEnrolmentsByLecturerId(@PathVariable Long id, Model model) {
//		
//		model.addAttribute("enrolmentByLecturerId", lectservice.getAllCoursesByLecturerId(Roles.LECTURER, id));
//		
//		return "lecturer/enrolment";
//	}
//	
	
//	@GetMapping(value = "/lecturer/enrolment")
//	public String showEnrolments(Model model) {
//		
//		model.addAttribute("allEnrolment", lectservice.getAllUsers());
//		model.addAttribute("studentEnrolment", lectservice.getAllUsersByRole(Roles.STUDENT));
//		model.addAttribute("lecturerEnrolment", lectservice.getAllUsersByRole(Roles.LECTURER));
//		
//		return "lecturer/enrolment";
//	}
	
	
}
