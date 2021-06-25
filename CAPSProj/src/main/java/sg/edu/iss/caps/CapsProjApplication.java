package sg.edu.iss.caps;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.mapping.Collection;
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
				
			Users user1 = new Users("Max", "Chen", "max@gmail.com", "abc", Roles.STUDENT, "999", 
					"Blk 54 #12-123, Singapore 123456", LocalDate.of(1988, 1, 30), "Mr", null, null);
			urepo.save(user1);
			
			Users user2 = new Users("Kevin", "Goh", "kevin@gmail.com", "abcde", Roles.LECTURER, "123",
					"Blk 123, #07-31, Singapore 564123", LocalDate.of(1993, 4, 25), "Mr", null, null);
			urepo.save(user2);
			
			Courses course1 = new Courses("C# Programming", LocalDate.of(2021, 6, 30), 
					LocalDate.of(2021, 8, 10), 15, 30, "Nice Course", "GDipSA 52", CourseStatus.ONGOING, 
					null, null);
			
			coursesRepository.save(course1);
			
			List<Courses> courses = new ArrayList<Courses>();
			courses.add(course1);
			
			StudentCourseDetails studentCourseDetail1 = new StudentCourseDetails(LocalDate.of(2021, 07, 21), "A", 
					EnrolmentStatus.ACCEPTED, user1, courses);
			
			screpo.save(studentCourseDetail1);
			
			LecturerCourseDetails lecturerCourseDetail1 = new LecturerCourseDetails(courses, user2);
			
			lcrepo.save(lecturerCourseDetail1);
			
			
			
			
			
////			
//			Users user2 = new Users("Mark", "Zuckerberg", "mark@gmail.com", Roles.STUDENT);
//			urepo.save(user2);
//		
//			
//
////			

//			
			
//////			
//			Courses course2 = new Courses("Java by Suriya", 80, "GDipSA 52");
//			coursesRepository.save(course2);
////			
//			Courses course3 = new Courses("Android by Cher Wah", 90, "GDipSA 52");
//			coursesRepository.save(course3);
//			
//			Courses course4 = new Courses("C# Foundations by Liu Fan", 120, "GDipSA 51");
//			coursesRepository.save(course4);
//			
//			Courses course5 = new Courses("Machine Learning by Yuen Kwan", 80, "GDipSA 51");
//			coursesRepository.save(course5);
//			
//			Courses course6 = new Courses("DPM by Felicitas", 60, "GDipSA 53");
//			coursesRepository.save(course6);
//			
//			Courses course7 = new Courses("Software Design & Analysis by Esther", 70, "GDipSA 54");
//			coursesRepository.save(course7);
//			
//			Courses course8 = new Courses("Breakdance by Kevin Goh", 55, "GDipSA 50");
//			coursesRepository.save(course8);
//			
//			Courses course9 = new Courses("Trolling by Jim Ho", 45, "GDipSA 55");
//			coursesRepository.save(course8);
		};
	}

}
