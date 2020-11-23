package c1808g1.Models.QuanLiHoSo;

import lombok.Data;

@Data
public class EmployeeDTO {
	private String id_emp;
	private String name_emp;
	private String email_emp;
	private String phone_emp;
	private String password;
	private Boolean active_account;
	private String list_role;
	private Boolean status;
	public EmployeeDTO(String id_emp, String name_emp, String email_emp, String phone_emp, String password,
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
	
	public EmployeeDTO() {
		super();
	}
}
