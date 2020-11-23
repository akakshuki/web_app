package c1808g1.Models.QuanLiLichHoc;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class AttendanceStudentDTO {
	public Integer id;	
	public Integer attendance_id;
	public String student_id;
	public Timestamp check_in;
	public Timestamp check_out;
	public Integer minute_late;
	public Integer minute_leave_early;
	public Integer status_id;
	public String note;
	public AttendanceStudentDTO(Integer id, Integer attendance_id, String student_id, Timestamp check_in, Timestamp check_out,
			Integer minute_late, Integer minute_leave_early, Integer status_id, String note) {
		super();
		this.id = id;
		this.attendance_id = attendance_id;
		this.student_id = student_id;
		this.check_in = check_in;
		this.check_out = check_out;
		this.minute_late = minute_late;
		this.minute_leave_early = minute_leave_early;
		this.status_id = status_id;
		this.note = note;
	}
	public AttendanceStudentDTO() {
		super();
	}
}