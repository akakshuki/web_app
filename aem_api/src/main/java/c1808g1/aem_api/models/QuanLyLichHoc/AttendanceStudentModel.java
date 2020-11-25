package c1808g1.aem_api.models.QuanLyLichHoc;

import java.io.Serializable;
import java.sql.Timestamp;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "attendance_student")
public class AttendanceStudentModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	public int attendance_id;
	public String student_id;
	public String checkIn;
	public String check_out;
	public int minute_late;
	public int minute_leave_early;
	public int status_id;
	public String note;
	
	
	@Column(name = "id" , nullable = false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "attendance_id" , nullable = false)
	public int getAttendance_id() {
		return attendance_id;
	}
	public void setAttendance_id(int attendance_id) {
		this.attendance_id = attendance_id;
	}
	
	@Column(name = "student_id" , nullable = false)
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	
	@Column(name = "check_in", nullable = true)
	public String getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(String check_in) {
		this.checkIn = check_in;
	}
	
	@Column(name = "check_out", nullable = true)
	public String getCheck_out() {
		return check_out;
	}
	public void setCheck_out(String String) {
		this.check_out = String;
	}
	
	@Column(name = "minute_late" , nullable = true)
	public int getMinute_late() {
		return minute_late;
	}
	public void setMinute_late(int minute_late) {
		this.minute_late = minute_late;
	}
	
	@Column(name = "minute_leave_early" , nullable = true)
	public int getMinute_leave_early() {
		return minute_leave_early;
	}
	public void setMinute_leave_early(int minute_leave_early) {
		this.minute_leave_early = minute_leave_early;
	}
	
	@Column(name = "status_id" , nullable = true)
	public int getStatus_id() {
		return status_id;
	}
	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}
	
	@Column(name = "note" , nullable = true)
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
//	public AttendanceStudentModel(int id, int attendance_id, String student_id, String check_in, String check_out,
//			int minute_late, int minute_leave_early, int status_id, String note) {
//		super();
//		this.id = id;
//		this.attendance_id = attendance_id;
//		this.student_id = student_id;
//		this.check_in = check_in;
//		this.check_out = check_out;
//		this.minute_late = minute_late;
//		this.minute_leave_early = minute_leave_early;
//		this.status_id = status_id;
//		this.note = note;
//	}
	
	
}