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
@Table(name = "attendance")
public class AttendanceModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer schedule_id;
	private Integer shift_id;
	private Integer brand_id;
	private Date date_attendance;
	private Integer status_id;
	private Boolean disable;
	private String note;
	
	@Column(name = "id" , nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "schedule_id" , nullable = false)
	public Integer getSchedule_id() {
		return schedule_id;
	}
	public void setSchedule_id(Integer schedule_id) {
		this.schedule_id = schedule_id;
	}
	
	@Column(name = "shift_id" , nullable = true)	
	public Integer getShift_id() {
		return shift_id;
	}
	public void setShift_id(Integer shift_id) {
		this.shift_id = shift_id;
	}
	
	@Column(name = "brand_id" , nullable = true)	
	public Integer getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(Integer brand_id) {
		this.brand_id = brand_id;
	}
	
	@Column(name = "date_attendance" , nullable = true)	
	public Date getDate_attendance() {
		return date_attendance;
	}
	public void setDate_attendance(Date date_attendance) {
		this.date_attendance = date_attendance;
	}
	
	@Column(name = "status_id" , nullable = true)	
	public Integer getStatus_id() {
		return status_id;
	}
	public void setStatus_id(Integer status_id) {
		this.status_id = status_id;
	}
	
	@Column(name = "disable" , nullable = true)	
	public Boolean getDisable() {
		return disable;
	}
	public void setDisable(Boolean disable) {
		this.disable = disable;
	}
	
	@Column(name = "note" , nullable = true)	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
//	public AttendanceModel(Integer id, Integer schedule_id, Integer shift_id, Integer brand_id, Date date_attendance,
//			Integer status_id, Boolean disable, String note) {
//		super();
//		this.id = id;
//		this.schedule_id = schedule_id;
//		this.shift_id = shift_id;
//		this.brand_id = brand_id;
//		this.date_attendance = date_attendance;
//		this.status_id = status_id;
//		this.disable = disable;
//		this.note = note;
//	}
	
	
}