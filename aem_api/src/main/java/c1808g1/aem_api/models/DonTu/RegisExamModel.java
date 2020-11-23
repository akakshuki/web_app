package c1808g1.aem_api.models.DonTu;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "regis_exam")
public class RegisExamModel implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String class_id;
	private String subject_id;
	private Date date_exam;
	private Integer brand_id;
	private Integer shift_id;
	private String note_status;
	private Integer form_pay_id_refer;
	
	public RegisExamModel() {}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Column(name="id", nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="class_id", nullable = true)
	public String getClass_id() {
		return class_id;
	}

	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}

	@Column(name="subject_id", nullable = true)
	public String getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(String subject_id) {
		this.subject_id = subject_id;
	}

	@Column(name="date_exam", nullable = true)
	public Date getDate_exam() {
		return date_exam;
	}

	public void setDate_exam(Date date_exam) {
		this.date_exam = date_exam;
	}

	@Column(name="brnad_id", nullable = true)
	public Integer getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(Integer brand_id) {
		this.brand_id = brand_id;
	}

	@Column(name="shift_id", nullable = true)
	public Integer getShift_id() {
		return shift_id;
	}

	public void setShift_id(Integer shift_id) {
		this.shift_id = shift_id;
	}

	@Column(name="note_status", nullable = true)
	public String getNote_status() {
		return note_status;
	}

	public void setNote_status(String note_status) {
		this.note_status = note_status;
	}

	@Column(name="form_pay_id_refer", nullable = true)
	public Integer getForm_pay_id_refer() {
		return form_pay_id_refer;
	}

	public void setForm_pay_id_refer(Integer form_pay_id_refer) {
		this.form_pay_id_refer = form_pay_id_refer;
	}

	public RegisExamModel(Integer id, String class_id, String subject_id, Date date_exam, Integer brand_id,
			Integer shift_id, String note_status, Integer form_pay_id_refer) {
		super();
		this.id = id;
		this.class_id = class_id;
		this.subject_id = subject_id;
		this.date_exam = date_exam;
		this.brand_id = brand_id;
		this.shift_id = shift_id;
		this.note_status = note_status;
		this.form_pay_id_refer = form_pay_id_refer;
	}
	
}
