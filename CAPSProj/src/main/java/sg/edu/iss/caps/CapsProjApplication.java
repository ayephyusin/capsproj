package sg.edu.iss.caps;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sg.edu.iss.caps.model.CourseStatus;
import sg.edu.iss.caps.model.Courses;
import sg.edu.iss.caps.model.EnrolmentStatus;
import sg.edu.iss.caps.model.LecturerCourseDetails;
import sg.edu.iss.caps.model.Roles;
import sg.edu.iss.caps.model.StudentCourseDetails;
import sg.edu.iss.caps.model.Users;

import sg.edu.iss.caps.repo.CoursesRepository;
import sg.edu.iss.caps.repo.LecturerCourseDetailsRepository;
import sg.edu.iss.caps.repo.StudentCourseDetailsRepository;
import sg.edu.iss.caps.repo.UsersRepository;

@SpringBootApplication
public class CapsProjApplication {
	
	@Autowired
	UsersRepository urepo;

	@Autowired
	CoursesRepository coursesRepository;
	
	@Autowired
	StudentCourseDetailsRepository screpo;
	
	@Autowired
	LecturerCourseDetailsRepository lcrepo;
	
	public static void main(String[] args) {
		SpringApplication.run(CapsProjApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner() {
		return args -> { 
//			Users user = new Users("test@gmail.com", "1234", Roles.STUDENT);
//			urepo.save(user);
			
//			Courses cSharpProgramming = new Courses("C# Programming", LocalDate.of(2021, 6, 30), 
//					LocalDate.of(2021, 8, 10), LocalDate.of(2021, 12, 29), 15, 30, "Nice Course", CourseStatus.ONGOING, 
//					null, null);
//			
//			Courses javaProgramming = new Courses("Java Programming", LocalDate.of(2021, 6, 30), 
//					LocalDate.of(2021, 8, 10), LocalDate.of(2021, 12, 29), 15, 30, "Very Nice Course", CourseStatus.ONGOING, 
//					null, null);
//			
//			coursesRepository.save(cSharpProgramming);
//			coursesRepository.save(javaProgramming);
//		
//			List<Courses> cSharpCourses = new ArrayList<Courses>();
//			cSharpCourses.add(cSharpProgramming);
//			
//			List<Courses> javaCourses = new ArrayList<Courses>();
//			javaCourses.add(javaProgramming);
//			
//			Users user1 = new Users("Max", "Chen", "max@gmail.com", "abc", Roles.STUDENT, "999", 
//					"Blk 54 #12-123, Singapore 123456", LocalDate.of(1988, 1, 30), "Mr", null, cSharpCourses);
//			urepo.save(user1);
//
//			Users user2 = new Users("Cher Wah", "Tan", "cherwah@gmail.com", "abcde", Roles.LECTURER, "425",
//					"Blk 123, #07-31, Singapore 564123", LocalDate.of(1993, 4, 25), "Mr", null, cSharpCourses);
//			urepo.save(user2);
//			
//			Users user3 = new Users("Tri Tin", "Nguyen", "tin@gmail.com", "abcde", Roles.STUDENT, "123123",
//					"Blk 654, #12-34, Singapore 564101", LocalDate.of(2000, 5, 25), "Mr", null, javaCourses);
//			urepo.save(user3);
//			
//			Users user4 = new Users("Yuen Kwan", "Chia", "chia@gmail.com", "abcde", Roles.STUDENT, "5454",
//					"Blk 754, #11-12, Singapore 543532", LocalDate.of(2001, 6, 19), "Mr", null, javaCourses);
//			urepo.save(user4);
//			
//			Users user5 = new Users("Kevin", "Goh", "chia@gmail.com", "abcde", Roles.LECTURER, "5454",
//					"Blk 754, #11-12, Singapore 543532", LocalDate.of(2001, 6, 19), "Mr", null, cSharpCourses);
//			urepo.save(user5);
//			
//			Users user6 = new Users("Alfred", "Wang", "chia@gmail.com", "abcde", Roles.LECTURER, "5454",
//					"Blk 754, #11-12, Singapore 543532", LocalDate.of(2001, 6, 19), "Mr", null, javaCourses);
//			urepo.save(user6);
//		
//			StudentCourseDetails studentCourseDetail1 = new StudentCourseDetails(LocalDate.of(2021, 07, 21), "A", 
//				EnrolmentStatus.ACCEPTED, user1, cSharpProgramming);
//		
//			StudentCourseDetails studentCourseDetail2 = new StudentCourseDetails(LocalDate.of(2021, 12, 10), "B", 
//					EnrolmentStatus.REJECTED, user3, cSharpProgramming);
//	
//			StudentCourseDetails studentCourseDetail3 = new StudentCourseDetails(LocalDate.of(2021, 07, 19), "D", 
//					EnrolmentStatus.ACCEPTED, user4, javaProgramming);
//
//			screpo.save(studentCourseDetail1);
//			screpo.save(studentCourseDetail2);
//			screpo.save(studentCourseDetail3);
//		
//			LecturerCourseDetails lecturerCourseDetail1 = new LecturerCourseDetails(cSharpCourses, user2);
//			LecturerCourseDetails lecturerCourseDetail2 = new LecturerCourseDetails(javaCourses, user6);
//			LecturerCourseDetails lecturerCourseDetail3 = new LecturerCourseDetails(javaCourses, user5);
//			
//			lcrepo.save(lecturerCourseDetail1);
//			lcrepo.save(lecturerCourseDetail2);
//			lcrepo.save(lecturerCourseDetail3);
		};
	}

}
