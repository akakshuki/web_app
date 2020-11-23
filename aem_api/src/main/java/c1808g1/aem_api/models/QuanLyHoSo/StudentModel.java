package c1808g1.aem_api.models.QuanLyHoSo;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class StudentModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id_student;
	private String first_name;
	private String last_name;
	private String full_name;
	private String first_class;
	private String current_class;
	private Boolean active_account;
	private Date date_of_doing;
	private Boolean sex;
	private Date dob;
	private String mobile_phone;
	private String home_phone;
	private String contact_phone;
	private String email_student;
	private String email_school;
	private String password;
	private String address;
	private String contact_address;
	private Date application_date;
	private String district;
	private String city;
	private String ho_so;
	private String cs;
	private String course_id;
	private String course_family;
	private String high_school;
	private String university;
	private String temp_id;
	private String image_student;
	private String centre_name;
	private String mobile_mac;
	private Integer Role_id;
	
	public StudentModel() {}

	@Column(name="id_student",nullable = false)
	public String getId_student() {
		return id_student;
	}
	
	public void setId_student(String id_student) {
		this.id_student = id_student;
	}
	
	@Column(name="first_name",nullable = true)
	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	@Column(name="last_name",nullable = true)
	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	@Column(name="full_name",nullable = true)
	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	
	@Column(name="first_class",nullable = true)
	public String getFirst_class() {
		return first_class;
	}
	
	public void setFirst_class(String first_class) {
		this.first_class= first_class;
	}
	
	@Column(name="current_class",nullable = true)
	public String getCurrent_class() {
		return current_class;
	}

	public void setCurrent_class(String current_class) {
		this.current_class = current_class;
	}
	
	@Column(name="active_account",nullable = true)
	public Boolean getActive_account() {
		return active_account;
	}

	public void setActive_account(Boolean active_account) {
		this.active_account = active_account;
	}

	@Column(name="date_of_doing",nullable = true)
	public Date getDate_of_doing() {
		return date_of_doing;
	}

	public void setDate_of_doing(Date date_of_doing) {
		this.date_of_doing = date_of_doing;
	}

	@Column(name="sex",nullable = true)
	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}
	
	@Column(name="dob",nullable = true)
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Column(name="mobile_phone",nullable = true)
	public String getMobile_phone() {
		return mobile_phone;
	}

	public void setMobile_phone(String mobile_phone) {
		this.mobile_phone = mobile_phone;
	}

	@Column(name="home_phone",nullable = true)
	public String getHome_phone() {
		return home_phone;
	}

	public void setHome_phone(String home_phone) {
		this.home_phone = home_phone;
	}

	@Column(name="contact_phone",nullable = true)
	public String getContact_phone() {
		return contact_phone;
	}

	public void setContact_phone(String contact_phone) {
		this.contact_phone = contact_phone;
	}

	@Column(name="email_student",nullable = true)
	public String getEmail_student() {
		return email_student;
	}

	public void setEmail_student(String email_student) {
		this.email_student = email_student;
	}

	@Column(name="email_school",nullable = true)
	public String getEmail_school() {
		return email_school;
	}

	public void setEmail_school(String email_school) {
		this.email_school = email_school;
	}

	@Column(name="password",nullable = true)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name="address",nullable = true)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name="contact_address",nullable = true)
	public String getContact_address() {
		return contact_address;
	}

	public void setContact_address(String contact_address) {
		this.contact_address = contact_address;
	}

	@Column(name="application_date",nullable = true)
	public Date getApplication_date() {
		return application_date;
	}

	public void setApplication_date(Date application_date) {
		this.application_date = application_date;
	}

	@Column(name="district",nullable = true)
	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	@Column(name="city",nullable = true)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name="ho_so",nullable = true)
	public String getHo_so() {
		return ho_so;
	}

	public void setHo_so(String ho_so) {
		this.ho_so = ho_so;
	}

	@Column(name="cs",nullable = true)
	public String getCs() {
		return cs;
	}

	public void setCs(String cs) {
		this.cs = cs;
	}

	@Column(name="course_id",nullable = true)
	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	@Column(name="course_family",nullable = true)
	public String getCourse_family() {
		return course_family;
	}

	public void setCourse_family(String course_family) {
		this.course_family = course_family;
	}

	@Column(name="high_school",nullable = true)
	public String getHigh_school() {
		return high_school;
	}

	public void setHigh_school(String high_school) {
		this.high_school = high_school;
	}

	@Column(name="university",nullable = true)
	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	@Column(name="temp_id",nullable = true)
	public String getTemp_id() {
		return temp_id;
	}

	public void setTemp_id(String temp_id) {
		this.temp_id = temp_id;
	}

	@Column(name="image_student",nullable = true)
	public String getImage_student() {
		return image_student;
	}

	public void setImage_student(String image_student) {
		this.image_student = image_student;
	}

	@Column(name="centre_name",nullable = true)
	public String getCentre_name() {
		return centre_name;
	}

	public void setCentre_name(String centre_name) {
		this.centre_name = centre_name;
	}

	@Column(name="mobile_mac",nullable = true)
	public String getMobile_mac() {
		return mobile_mac;
	}

	public void setMobile_mac(String mobile_mac) {
		this.mobile_mac = mobile_mac;
	}

	@Column(name="role_id",nullable = true)
	public Integer getRole_id() {
		return Role_id;
	}

	public void setRole_id(Integer role_id) {
		Role_id = role_id;
	}

	public StudentModel(String id_student, String first_name, String last_name, String full_name,String first_class, String current_class,
			Boolean active_account, Date date_of_doing, Boolean sex, Date dob, String mobile_phone, String home_phone,
			String contact_phone, String email_student, String email_school, String password, String address,
			String contact_address, Date application_date, String district, String city, String ho_so, String cs,
			String course_id, String course_family, String high_school, String university, String temp_id,
			String image_student, String centre_name, String mobile_mac, Integer role_id) {
		super();
		this.id_student = id_student;
		this.first_name = first_name;
		this.last_name = last_name;
		this.full_name = full_name;
		this.first_class = first_class;
		this.current_class = current_class;
		this.active_account = active_account;
		this.date_of_doing = date_of_doing;
		this.sex = sex;
		this.dob = dob;
		this.mobile_phone = mobile_phone;
		this.home_phone = home_phone;
		this.contact_phone = contact_phone;
		this.email_student = email_student;
		this.email_school = email_school;
		this.password = password;
		this.address = address;
		this.contact_address = contact_address;
		this.application_date = application_date;
		this.district = district;
		this.city = city;
		this.ho_so = ho_so;
		this.cs = cs;
		this.course_id = course_id;
		this.course_family = course_family;
		this.high_school = high_school;
		this.university = university;
		this.temp_id = temp_id;
		this.image_student = image_student;
		this.centre_name = centre_name;
		this.mobile_mac = mobile_mac;
		Role_id = role_id;
	}
	
}