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
@Table(name = "schedule")
public class ScheduleModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String list_fc;
	private String subject_id;
	private String class_id;
	private int shift_id;
	private String brand_id;
	private Date start_date;
	private Date end_date;
	private String note;
	private String list_student;
	private Double coef_salary;
	private int current_session;
	private int max_session;

	@Column(name = "id" , nullable = false)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column (name = "coef_salary" , nullable = false)
	public Double getCoef_salary() {
		return coef_salary;
	}

	public void setCoef_salary(Double coef_salary) {
		this.coef_salary = coef_salary;
	}

	@Column(name = "list_fc" , nullable = false)
	public String getList_fc() {
		return list_fc;
	}
	public void setList_fc(String list_fc) {
		this.list_fc = list_fc;
	}
	
	@Column(name = "subject_id" , nullable = false)
	public String getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(String subject_id) {
		this.subject_id = subject_id;
	}
	
	@Column(name = "class_id" , nullable = false)
	public String getClass_id() {
		return class_id;
	}
	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}
	
	@Column(name = "shift_id" , nullable = true)
	public Integer getShift_id() {
		return shift_id;
	}
	public void setShift_id(Integer shift_id) {
		this.shift_id = shift_id;
	}
	
	@Column(name = "brand_id" , nullable = true)
	public String getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(String brand_id) {
		this.brand_id = brand_id;
	}
	
	@Column(name = "start_date" , nullable = true)
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	
	@Column(name = "end_date" , nullable = true)
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	
	@Column(name = "note" , nullable = true)
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	@Column(name = "list_student" , nullable = true)
	public String getList_student() {
		return list_student;
	}
	public void setList_student(String list_student) {
		this.list_student = list_student;
	}
	
	@Column(name = "current_session" , nullable = true)
	public Integer getCurrent_session() {
		return current_session;
	}
	public void setCurrent_session(Integer current_session) {
		this.current_session = current_session;
	}
	
	@Column(name = "max_session" , nullable = true)
	public Integer getMax_session() {
		return max_session;
	}
	public void setMax_session(Integer max_session) {
		this.max_session = max_session;
	}

//	public ScheduleModel(Integer id, String list_fc, String subject_id, String class_id, Integer shift_id,
//			String brand_id, Date start_date, Date end_date, String note, String list_student, Integer current_session,
//			Integer max_session) {
//		super();
//		this.id = id;
//		this.list_fc = list_fc;
//		this.subject_id = subject_id;
//		this.class_id = class_id;
//		this.shift_id = shift_id;
//		this.brand_id = brand_id;
//		this.start_date = start_date;
//		this.end_date = end_date;
//		this.note = note;
//		this.list_student = list_student;
//		this.current_session = current_session;
//		this.max_session = max_session;
//	}
	
}
