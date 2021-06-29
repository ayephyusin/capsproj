package sg.edu.iss.caps;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sg.edu.iss.caps.model.CourseStatus;
import sg.edu.iss.caps.model.Courses;
import sg.edu.iss.caps.model.EnrolmentStatus;
import sg.edu.iss.caps.model.Roles;
import sg.edu.iss.caps.model.StudentCourseDetails;
import sg.edu.iss.caps.model.Users;

import sg.edu.iss.caps.repo.CoursesRepository;
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
	
	public static void main(String[] args) {
		SpringApplication.run(CapsProjApplication.class, args);
	}
/*
	@Bean
	CommandLineRunner runner() {
		return args -> { 
//			Users user = new Users("test@gmail.com", "1234", Roles.STUDENT);
//			urepo.save(user);
			
			List<StudentCourseDetails> scCollection = new ArrayList<StudentCourseDetails>();
			List<Users> userCollection = new ArrayList<Users>();
			
			Courses cSharpProgramming = new Courses("C# Programming", LocalDate.of(2021, 6, 30), 
					LocalDate.of(2021, 8, 10), LocalDate.of(2021, 12, 29), 8, 50, "Nice Course", CourseStatus.ONGOING, 
					scCollection, userCollection);
			
			Courses digitalProductManagement = new Courses("Digital Product Management", LocalDate.of(2021, 3, 15), 
					LocalDate.of(2021, 8, 10), LocalDate.of(2021, 12, 29), 4, 60, "Nice Course", CourseStatus.ONGOING, 
					scCollection, userCollection);
			
			Courses javaProgramming = new Courses("Java Programming", LocalDate.of(2021, 6, 30), 
					LocalDate.of(2021, 8, 10), LocalDate.of(2021, 12, 29), 8, 40, "Very Nice Course", CourseStatus.ONGOING, 
					scCollection, userCollection);
			
			Courses machineLearning = new Courses("Machine Learning", LocalDate.of(1999, 5, 2), 
					LocalDate.of(2021, 8, 10), LocalDate.of(2021, 12, 29), 6, 100, "Very Nice Course", CourseStatus.ONGOING, 
					scCollection, userCollection);
			
			coursesRepository.save(cSharpProgramming);
			coursesRepository.save(digitalProductManagement);
			coursesRepository.save(javaProgramming);
			coursesRepository.save(machineLearning);

			List<Courses> cSharpCourses = new ArrayList<Courses>();
			cSharpCourses.add(cSharpProgramming);
			
			List<Courses> DPM = new ArrayList<Courses>();
			DPM.add(digitalProductManagement);
			
			List<Courses> javaCourses = new ArrayList<Courses>();
			javaCourses.add(javaProgramming);
			
			List<Courses> ML = new ArrayList<Courses>();
			ML.add(machineLearning);
			
			Users user1 = new Users("Max", "Chen", "max@gmail.com", "abc", Roles.STUDENT, "999", 
					"Blk 54 #12-123, Singapore 123456", LocalDate.of(1988, 1, 30), "Mr", scCollection, DPM);
			urepo.save(user1);

			Users user2 = new Users("Cher Wah", "Tan", "cherwah@gmail.com", "abcde", Roles.LECTURER, "425",
					"Blk 123, #07-31, Singapore 564123", LocalDate.of(1993, 4, 25), "Mr", scCollection, cSharpCourses);
			urepo.save(user2);
			
			Users user3 = new Users("Tri Tin", "Nguyen", "tin@gmail.com", "abcde", Roles.STUDENT, "123123",
					"Blk 654, #12-34, Singapore 564101", LocalDate.of(2000, 5, 25), "Mr", scCollection, javaCourses);
			urepo.save(user3);
				
			Users user4 = new Users("Yuen Kwan", "Chia", "chia@gmail.com", "abcde", Roles.STUDENT, "5454",
					"Blk 754, #11-12, Singapore 543532", LocalDate.of(2001, 6, 19), "Mr", scCollection, javaCourses);
			urepo.save(user4);
			
			Users user5 = new Users("Kevin", "Goh", "chia@gmail.com", "abcde", Roles.LECTURER, "5454",
					"Blk 754, #11-12, Singapore 543532", LocalDate.of(2001, 6, 19), "Mr", scCollection, ML);
			urepo.save(user5);
			
			Users user6 = new Users("Alfred", "Wang", "chia@gmail.com", "abcde", Roles.LECTURER, "5454",
					"Blk 754, #11-12, Singapore 543532", LocalDate.of(2001, 6, 21), "Mr", scCollection, javaCourses);
			urepo.save(user6);
			Users u6 = new Users("Cher Wah", "Tan", "Cherwah@gmail.com", "eee", 
					Roles.LECTURER, "95555555", "e street", LocalDate.of(1985, 04, 05), "Mr");
			Users u7 = new Users("Esther", "Tan", "Esther@gmail.com", "fff", 
					Roles.LECTURER, "96666666", "f street", LocalDate.of(1970, 8, 9), "Mrs");
			Users u8 = new Users("Suriya", "kanthan", "Suriya@gmail.com", "ggg", 
					Roles.LECTURER, "97777777", "g street", LocalDate.of(1972, 10, 12), "Mrs");
			Users u9 = new Users("Fan", "Liu", "Liufan@gmail.com", "hhh", 
					Roles.LECTURER, "98888888", "h street", LocalDate.of(1987, 01, 02), "Ms");
			Users u10 = new Users("Felicitas", "Tan", "felicitas@gmail.com", "iii", 
					Roles.LECTURER, "99999999", "i street", LocalDate.of(1969, 07, 28), "Mrs");
			Users u11 = new Users("Boon Kee", "Lee", "boonkee@gmail.com", "jjj", 
					Roles.LECTURER, "90000000", "j street", LocalDate.of(1974, 11, 26), "Mr");
			Users u12 = new Users("Max", "Chen", "Max@gmail.com", "kkk", 
					Roles.LECTURER, "91222222", "k street", LocalDate.of(1986, 05, 12), "Mr");
			Users u13 = new Users("Brandon", "Chia", "brandon@gmail.com", "lll", 
					Roles.LECTURER, "91333333", "l street", LocalDate.of(1991, 04, 21), "Mr");
			urepo.save(u6);urepo.save(u7);urepo.save(u8);urepo.save(u9);urepo.save(u10);urepo.save(u11);
			urepo.save(u12);urepo.save(u13);
			Users u14 = new Users("Qi", "Zhao", "zhaoqi@gmail.com", "mmm", 
					Roles.STUDENT, "91333333", "m street", LocalDate.of(1989, 9, 04), "Ms");
			
			Users u15 = new Users("Phyu Sin", "Aye", "phyusin@gmail.com", "nnn", 
					Roles.STUDENT, "91444444", "n street", LocalDate.of(1994, 02, 17), "Ms");
			
			Users u16 = new Users("Ronnie", "Fun", "Ronnie@gmail.com", "ooo", 
					Roles.STUDENT, "91555555", "o street", LocalDate.of(1986, 01, 18), "Mr");
			
			Users u17 = new Users("Willard", "Toh", "willard@gmail.com", "ppp", 
					Roles.STUDENT, "91666666", "p street", LocalDate.of(1993, 10, 14), "Mr");
			
			Users u18 = new Users("Kim Son", "Troung", "kimson@gmail.com", "qqq", 
					Roles.STUDENT, "91666666", "q street", LocalDate.of(1988, 05, 02), "Mr");
			
			Users u19 = new Users("Zerita", "Lim", "zerita@gmail.com", "rrr", 
					Roles.STUDENT, "91777777", "r street", LocalDate.of(1994, 06, 21), "Ms");
			
			Users u20 = new Users("Austin", "Ma", "Austin@gmail.com", "sss", 
					Roles.STUDENT, "91888888", "s street", LocalDate.of(1991, 02, 01), "Mr");
			
			Users u21 = new Users("John", "Tan", "John@gmail.com", "ttt", 
					Roles.LECTURER, "91999999", "t street", LocalDate.of(1960, 04, 13), "Mr");
			
			Users u22 = new Users("Tom", "Tan", "Tom@gmail.com", "uuu", 
					Roles.LECTURER, "92111111", "u street", LocalDate.of(1973, 9, 02), "Mr");
			
			Users u23 = new Users("Michelle", "Koh", "michelle@gmail.com", "vvv", 
					Roles.LECTURER, "92222222", "v street", LocalDate.of(1965, 11, 8), "Mrs");
			urepo.save(u14);urepo.save(u15);urepo.save(u16);urepo.save(u17);urepo.save(u18);urepo.save(u19);
			urepo.save(u20);urepo.save(u21);urepo.save(u22);urepo.save(u23);		
			Users u24 = new Users("Thomas", "Lim", "thomas@gmail.com", "www", 
				Roles.ADMIN, "92333333", "w street", LocalDate.of(1964, 3, 28), "Mr");
			Users u25 = new Users("Scarlet", "Johansson", "scarlet@gmail.com", "xxx", 
					Roles.ADMIN, "92444444", "x street", LocalDate.of(1985, 2, 21), "Ms");
			Users u26 = new Users("Angela", "baby", "angela@gmail.com", "yyy", 
					Roles.ADMIN, "92555555", "y street", LocalDate.of(1992, 04, 20), "Ms");
			Users u27 = new Users("Jennie", "Kim", "jennie@gmail.com", "zzz", 
					Roles.ADMIN, "92666666", "z street", LocalDate.of(1997, 5, 19), "Ms");
			urepo.save(u24);urepo.save(u25);urepo.save(u26);urepo.save(u27);

			
			Users user7 = new Users("Rurouni", "Kenshin", "Kenshin@gmail.com", "abewq", Roles.STUDENT, "1234",
					"Blk 5467, #11-12, Singapore 543532", LocalDate.of(2000, 6, 19), "Mr", scCollection, ML);
			urepo.save(user7); 
			
			Users user8 = new Users("Demon", "Slayer", "slayer@gmail.com", "abewq", Roles.STUDENT, "1234",
					"Blk 123, #11-12, Singapore 543532", LocalDate.of(2020, 6, 15), "Mr", scCollection, ML);
			urepo.save(user8);
			
			Users user9 = new Users("Naught", "Jugger", "juggernaught@gmail.com", "abewq", Roles.STUDENT, "1234",
					"Blk 854, #11-12, Singapore 5412332", LocalDate.of(2000, 6, 9), "Mr", scCollection, DPM);
			urepo.save(user9);
			
			Users user10 = new Users("Blade", "Maiden", "blademaiden@gmail.com", "abewq", Roles.STUDENT, "1234",
					"Blk 854, #11-12, Singapore 5412332", LocalDate.of(2000, 6, 9), "Mr", scCollection, cSharpCourses);
			urepo.save(user10);
			
		
			StudentCourseDetails studentCourseDetail1 = new StudentCourseDetails(LocalDate.of(2021, 01, 19), "A+", 
				EnrolmentStatus.ACCEPTED, user1, digitalProductManagement);
		
			StudentCourseDetails studentCourseDetail2 = new StudentCourseDetails(LocalDate.of(2021, 12, 10), "B", 
					EnrolmentStatus.REJECTED, user3, machineLearning);
	
			StudentCourseDetails studentCourseDetail3 = new StudentCourseDetails(LocalDate.of(2021, 01, 10), "D", 
					EnrolmentStatus.ACCEPTED, user1, javaProgramming);
			
			StudentCourseDetails studentCourseDetail4 = new StudentCourseDetails(LocalDate.of(2021, 05, 21), "B+", 
					EnrolmentStatus.ACCEPTED, user1, machineLearning);

			StudentCourseDetails studentCourseDetail5 = new StudentCourseDetails(LocalDate.of(2020, 03, 11), "B-", 
					EnrolmentStatus.ACCEPTED, user8, machineLearning);
		
			StudentCourseDetails studentCourseDetail7 = new StudentCourseDetails(LocalDate.of(2019, 03, 12), "A-", 
					EnrolmentStatus.ACCEPTED, user10, cSharpProgramming);
			
			
			screpo.save(studentCourseDetail1);
			screpo.save(studentCourseDetail2);
			screpo.save(studentCourseDetail3);
			screpo.save(studentCourseDetail4);
			screpo.save(studentCourseDetail5);
			screpo.save(studentCourseDetail7);
		};

	}
*/
}

