package sg.edu.iss.caps.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.caps.model.Courses;
import sg.edu.iss.caps.model.EnrolmentStatus;
import sg.edu.iss.caps.model.Roles;
import sg.edu.iss.caps.model.StudentCourseDetails;
import sg.edu.iss.caps.model.Users;
import sg.edu.iss.caps.repo.CoursesRepository;
import sg.edu.iss.caps.repo.StudentCourseDetailsRepository;
import sg.edu.iss.caps.repo.UsersRepository;

@Service
public class LecturerImplementation implements LecturerInterface {

	@Autowired
	CoursesRepository coursesRepository;
	
	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	StudentCourseDetailsRepository studentCourseDetailsRepository;

	@Transactional
	public List<Courses> getAllCourses() {
		
		return coursesRepository.findAll();
	}

	@Transactional
	public Courses getCoursesById(Long id) {

		return coursesRepository.findById(id).get();
	}

	@Transactional
	public List<Courses> getAllCoursesByRoleAndId(Roles role, Long userID) {


		return coursesRepository.findCoursesByRoleAndId(role, userID);
		return coursesRepository.findCoursesByLecturerId(id);

		//return coursesRepository.findByLecturerId(id);
		//return null;

	}

	@Transactional
	public List<Courses> getByCourseNameCourseStart(String courseName, LocalDate courseStartDate) {

		return coursesRepository.findByCourseSearch(courseName, courseStartDate);
	}

	@Transactional
	public Users getUsersById(Long id) {
		
		return usersRepository.findById(id).get();
	}

	@Transactional
	public List<Users> getAllUsers() {

		return usersRepository.findAll();
	}
	
	@Transactional
	public List<Users> getAllUsersByRole(Roles role) {
		
		return usersRepository.findByRole(role);
	}

	@Transactional
	public List<Users> getAllUsersByRoleCourseNameStartDate(Roles role, EnrolmentStatus enrolmentStatus, 
			String courseName, LocalDate courseStartDate) {
		
		return usersRepository.findByCourseNameCourseStart(role, enrolmentStatus, courseName, courseStartDate);
	}

	@Transactional
	public List<Users> getStudentResults(Long userID, Roles role) {

		return usersRepository.findUsersByRoleAndId(userID, role) ;
	}

	@Transactional
	public List<StudentCourseDetails> getGradesByStudentId(Long userID, Roles role) {
		// TODO Auto-generated method stub
		return studentCourseDetailsRepository.findGradesByStudentId(userID, role);
	}


	@Transactional
	public void addCourseTaught(Long id, Courses course) {
		Users user = this.getUsersById(id);
		Collection<Courses> userCurrentTaughtCourses = user.getCourses();
		userCurrentTaughtCourses.add(course);
		user.setCourses(userCurrentTaughtCourses);
	}
	
	@Transactional
	public void removeCourseTaught(Long id, Courses course) {
		Users user = this.getUsersById(id);
		Collection<Courses> userCurrentTaughtCourses = user.getCourses();
		userCurrentTaughtCourses.remove(course);
		user.setCourses(userCurrentTaughtCourses);
	}

	@Override
	public List<Users> getStudentsByCourseID(Long courseID) {
		return studentCourseDetailsRepository.getStudentsByCourseID(courseID);
	}

	@Override
	public List<StudentCourseDetails> getStudentCourseDetailsByCourseID(Long courseID) {
		return studentCourseDetailsRepository.getStudentCourseDetailsByCourseID(courseID);
	}

	@Override
	public StudentCourseDetails getStudentCourseDetailsByStudentIDAndCourseID(long studentID, long courseID) {
		return studentCourseDetailsRepository.getStudentCourseDetailsByStudentIDAndCourseID(studentID, courseID);
	}

	@Override
	public void saveStudentCourseDetails(StudentCourseDetails studentCourseDetails) {
		studentCourseDetailsRepository.save(studentCourseDetails);
		
	}
}
