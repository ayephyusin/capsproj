package sg.edu.iss.caps.model;

import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Users {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userID;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	//@NotBlank
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Roles role;
	
	private String phoneNumber;
	
	private String address;
	
	private boolean enabled;
	
	private String profilePicture;
	
	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		//this.enabled = enabled;
		this.enabled = true;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past (message = "Birthday should not be in the future.")
	private LocalDate birthday;
	
	private String salutation;
	
	private String resetPasswordToken;
	
	// One to Many relationship between Users and StudentCourseDetails
	@OneToMany(mappedBy = "student")
	//, cascade=CascadeType.REMOVE, orphanRemoval = true)
	private Collection<StudentCourseDetails> studentCourseDetail;
	

	// many to many relation between Users and Courses
	@ManyToMany
	private Collection<Courses> courses;

	//No Argument constructor
	public Users() {
		super();
	}

	//Argument constructor with all fields(without userID)
	public Users(String firstName, String lastName, String email, String password, Roles role, String phoneNumber,
			String address, LocalDate birthday, String salutation, Collection<StudentCourseDetails> studentCourseDetail,
			Collection<Courses> courses) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.birthday = birthday;
		this.salutation = salutation;
		this.studentCourseDetail = studentCourseDetail;
		this.courses = courses;
		this.enabled =true;
	}
	
	

	public Users(String firstName, String lastName, String email, String password, Roles role, String phoneNumber,
			String address, LocalDate birthday, String salutation) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.birthday = birthday;
		this.salutation = salutation;
		this.enabled =true;

	}

	//Argument constructor for testing purpose
	public Users(String email, String password, Roles role) {
		super();
		this.email = email;
		this.password = password;
		this.role = role;
	}

	
	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public Collection<StudentCourseDetails> getStudentCourseDetail() {
		return studentCourseDetail;
	}

	public void setStudentCourseDetail(Collection<StudentCourseDetails> studentCourseDetail) {
		this.studentCourseDetail = studentCourseDetail;
	}

	public Collection<Courses> getCourses() {
		return courses;
	}

	public void setCourses(Collection<Courses> courses) {
		this.courses = courses;
	}
	
	
	
	public String getResetPasswordToken() {
		return resetPasswordToken;
	}

	public void setResetPasswordToken(String resetPasswordToken) {
		this.resetPasswordToken = resetPasswordToken;
	}

	@Transient
	public String getImagePath() {
		System.out.println("/profile-pic/" + userID + "/" + profilePicture);
		if(profilePicture == null)		
			return null;
		return"/profile-pic/" + userID + "/" + profilePicture;
	}

  //	public Collection<LecturerCourseDetails> getLecturerCourseDetail() {
//		return lecturerCourseDetail;
//	}
//
//	public void setLecturerCourseDetail(Collection<LecturerCourseDetails> lecturerCourseDetail) {
//		this.lecturerCourseDetail = lecturerCourseDetail;
//	}
  
//	public Collection<LecturerCourseDetails> getLecturerCourseDetail() {
//		return lecturerCourseDetail;
//	}
//
//	public void setLecturerCourseDetail(Collection<LecturerCourseDetails> lecturerCourseDetail) {
//		this.lecturerCourseDetail = lecturerCourseDetail;
//	}
	
	
	

}
