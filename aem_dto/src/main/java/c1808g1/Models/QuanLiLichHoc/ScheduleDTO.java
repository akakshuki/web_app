package c1808g1.Models.QuanLiLichHoc;

import java.sql.Date;

import lombok.Data;

@Data
public class ScheduleDTO {
	private Integer id;	
	private String list_fc;
	private String subject_id;
	private String class_id;
	private Integer shift_id;
	private String brand_id;
	private Date start_date;
	private Date end_date;
	private String note;
	private String list_student;
	private Double coef_salary;
	private Integer current_session;
	private Integer max_session;
	public ScheduleDTO(Integer id, String list_fc, String subject_id, String class_id, Integer shift_id,
			String brand_id, Date start_date, Date end_date, String note, String list_student, Double coef_salary,
			Integer current_session, Integer max_session) {
		super();
		this.id = id;
		this.list_fc = list_fc;
		this.subject_id = subject_id;
		this.class_id = class_id;
		this.shift_id = shift_id;
		this.brand_id = brand_id;
		this.start_date = start_date;
		this.end_date = end_date;
		this.note = note;
		this.list_student = list_student;
		this.coef_salary = coef_salary;
		this.current_session = current_session;
		this.max_session = max_session;
	}
	public ScheduleDTO() {
		super();
	}
}