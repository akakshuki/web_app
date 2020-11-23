package c1808g1.Models.QuanLiHoSo;

import java.sql.Date;


import lombok.Data;

@Data
public class StatusStudentDTO {
	private int id;
	private String student_id;
	private int status_id;
	private Date start_date;
	private Date end_date;
	private String note;
	private String creator;
	private Date date_create;
	
	public StatusStudentDTO( int id , String student_id , int status_id , Date start_date , Date end_date , String note , String creator ,
			Date date_create) {
		super();
		this.id = id;
		this.status_id = status_id;
		this.start_date = start_date;
		this.end_date = end_date;
		this.note = note;
		this.creator = creator;
		this.date_create = date_create;
	}
	public StatusStudentDTO() {}
}
