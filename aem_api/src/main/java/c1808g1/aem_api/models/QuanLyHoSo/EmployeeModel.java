package c1808g1.aem_api.models.QuanLyHoSo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class EmployeeModel{
	
	@Id
	private String id_emp;
	private String name_emp;
	private String email_emp;
	private String phone_emp;
	private String password;
	private Boolean active_account;
	private String list_role;
	private Boolean status;

	
	public EmployeeModel() {}
	
	@Column(name="id_emp",nullable = false)
	public String getId_emp() {
		return id_emp;
	}

	public void setId_emp(String id_emp) {
		this.id_emp = id_emp;
	}

	@Column(name="name_emp",nullable = false)
	public String getName_emp() {
		return name_emp;
	}

	public void setName_emp(String name_emp) {
		this.name_emp = name_emp;
	}

	@Column(name="email_emp",nullable = false)
	public String getEmail_emp() {
		return email_emp;
	}

	public void setEmail_emp(String email_emp) {
		this.email_emp = email_emp;
	}

	@Column(name="phone_emp",nullable = true)
	public String getPhone_emp() {
		return phone_emp;
	}

	public void setPhone_emp(String phone_emp) {
		this.phone_emp = phone_emp;
	}

	@Column(name="password",nullable = true)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name="active_account",nullable = true)
	public Boolean getActive_account() {
		return active_account;
	}

	public void setActive_account(Boolean active_account) {
		this.active_account = active_account;
	}

	@Column(name="list_role",nullable = true)
	public String getList_role() {
		return list_role;
	}

	public void setList_role(String list_role) {
		this.list_role = list_role;
	}

	@Column(name="status",nullable = true)
	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public EmployeeModel(String id_emp, String name_emp, String email_emp, String phone_emp, String password,
			Boolean active_account, String list_role, Boolean status) {
		super();
		this.id_emp = id_emp;
		this.name_emp = name_emp;
		this.email_emp = email_emp;
		this.phone_emp = phone_emp;
		this.password = password;
		this.active_account = active_account;
		this.list_role = list_role;
		this.status = status;
	}
	
}



