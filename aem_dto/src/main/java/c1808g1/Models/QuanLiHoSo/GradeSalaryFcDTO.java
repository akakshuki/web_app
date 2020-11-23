package c1808g1.Models.QuanLiHoSo;

import java.sql.Date;

import lombok.Data;

@Data
public class GradeSalaryFcDTO {
	private int id;
	private String fc_id;
	private Double hour_salary;
	private Date start_date;
	private Date date_create;
	public GradeSalaryFcDTO(int id , String fc_id , Double hour_salary , Date start_date , Date date_create) {
		super();
		this.id = id;
		this.fc_id = fc_id;
		this.hour_salary = hour_salary;
		this.start_date = start_date;
		this.date_create = date_create;
	}
		
	public GradeSalaryFcDTO() {
		super();
	}
}	
