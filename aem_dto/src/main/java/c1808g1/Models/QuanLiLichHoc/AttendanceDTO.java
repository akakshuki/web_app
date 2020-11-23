package c1808g1.Models.QuanLiLichHoc;

import java.sql.Date;

import lombok.Data;

@Data
public class AttendanceDTO {
	private Integer id;	
	private Integer schedule_id;
	private Integer shift_id;
	private Integer brand_id;
	private Date date_attendance;
	private Integer status_id;
	private Boolean disable;
	private String note;
	public AttendanceDTO(Integer id, Integer schedule_id, Integer shift_id, Integer brand_id, Date date_attendance,
			Integer status_id, Boolean disable, String note) {
		super();
		this.id = id;
		this.schedule_id = schedule_id;
		this.shift_id = shift_id;
		this.brand_id = brand_id;
		this.date_attendance = date_attendance;
		this.status_id = status_id;
		this.disable = disable;
		this.note = note;
	}
	public AttendanceDTO() {
		super();
	}
}