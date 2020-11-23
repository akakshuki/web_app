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
@Table(name = "attendance_fc")
public class AttendanceStudentModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	
	public Integer attendance_id;
	public String student_id;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp check_in;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp check_out;
	public Integer minute_late;
	public Integer minute_leave_early;
	public Integer status_id;
	public String note;
	
	
	@Column(name = "id" , nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "attendance_id" , nullable = false)
	public Integer getAttendance_id() {
		return attendance_id;
	}
	public void setAttendance_id(Integer attendance_id) {
		this.attendance_id = attendance_id;
	}
	
	@Column(name = "student_id" , nullable = false)
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	
	@Column(name = "check_in" , nullable = true)
	public Timestamp getCheck_in() {
		return check_in;
	}
	public void setCheck_in(Timestamp check_in) {
		this.check_in = check_in;
	}
	
	@Column(name = "check_out" , nullable = true)
	public Timestamp getCheck_out() {
		return check_out;
	}
	public void setCheck_out(Timestamp Timestamp) {
		this.check_out = Timestamp;
	}
	
	@Column(name = "minute_late" , nullable = true)
	public Integer getMinute_late() {
		return minute_late;
	}
	public void setMinute_late(Integer minute_late) {
		this.minute_late = minute_late;
	}
	
	@Column(name = "minute_leave_early" , nullable = true)
	public Integer getMinute_leave_early() {
		return minute_leave_early;
	}
	public void setMinute_leave_early(Integer minute_leave_early) {
		this.minute_leave_early = minute_leave_early;
	}
	
	@Column(name = "status_id" , nullable = true)
	public Integer getStatus_id() {
		return status_id;
	}
	public void setStatus_id(Integer status_id) {
		this.status_id = status_id;
	}
	
	@Column(name = "note" , nullable = true)
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
//	public AttendanceStudentModel(Integer id, Integer attendance_id, String student_id, Timestamp check_in, Timestamp check_out,
//			Integer minute_late, Integer minute_leave_early, Integer status_id, String note) {
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