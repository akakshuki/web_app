package c1808g1.aem_api.models.QuanLyLichHoc;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "attendance_fc")
public class AttendanceFCModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer attendance_id;
	private String fc_id;
	private Integer status_id;
	private String note;
	
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
	
	@Column(name = "fc_id" , nullable = false)
	public String getFc_id() {
		return fc_id;
	}
	public void setFc_id(String fc_id) {
		this.fc_id = fc_id;
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
	public AttendanceFCModel(Integer id, Integer attendance_id, String fc_id, Integer status_id, String note) {
		super();
		this.id = id;
		this.attendance_id = attendance_id;
		this.fc_id = fc_id;
		this.status_id = status_id;
		this.note = note;
	}
	
}