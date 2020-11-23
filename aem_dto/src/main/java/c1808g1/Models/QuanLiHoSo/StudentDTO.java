package c1808g1.Models.QuanLiHoSo;

import java.sql.Date;

import lombok.Data;

@Data
public class StudentDTO {
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
	public StudentDTO(String id_student, String first_name, String last_name, String full_name,String first_class, String current_class,
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
	public StudentDTO() {
		super();
	}
}
