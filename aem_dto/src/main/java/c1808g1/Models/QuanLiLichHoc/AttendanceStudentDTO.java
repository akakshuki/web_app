package c1808g1.Models.QuanLiLichHoc;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class AttendanceStudentDTO {
	public int id;	
	public int attendance_id;
	public String student_id;
	public String checkIn;
	public String check_out;
	public int minute_late;
	public int minute_leave_early;
	public int status_id;
	public String note;
	public AttendanceStudentDTO(int id, int attendance_id, String student_id, String check_in, String check_out,
			int minute_late, int minute_leave_early, int status_id, String note) {
		super();
		this.id = id;
		this.attendance_id = attendance_id;
		this.student_id = student_id;
		this.checkIn = check_in;
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