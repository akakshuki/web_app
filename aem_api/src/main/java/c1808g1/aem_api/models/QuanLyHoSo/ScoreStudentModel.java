package c1808g1.aem_api.models.QuanLyHoSo;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "score_student")
public class ScoreStudentModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int regis_exam_id;
	private String student_id;
	private String pass_exam;
	private int status_id;
	private int score_percent;
	private Double score_number;
	private String type_exam;
	private String path_file;
	private String creator;
	private Date date_create;
	private String note;
	
	@Column(name="id" ,nullable = false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="regis_exam_id" ,nullable = false)
	public int getRegis_exam_id() {
		return regis_exam_id;
	}
	public void setRegis_exam_id(int regis_exam_id) {
		this.regis_exam_id = regis_exam_id;
	}
	
	@Column(name="student_id" ,nullable = true)
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	@Column(name="pass_exam" ,nullable = true)
	public String getPass_exam() {
		return pass_exam;
	}
	public void setPass_exam(String pass_exam) {
		this.pass_exam = pass_exam;
	}

	@Column(name="status_id" ,nullable = true)
	public int getStatus_id() {
		return status_id;
	}
	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}

	@Column(name="score_percent" ,nullable = true)
	public int getScore_percent() {
		return score_percent;
	}
	public void setScore_percent(int score_percent) {
		this.score_percent = score_percent;
	}

	@Column(name="score_number" ,nullable = true)
	public Double getScore_number() {
		return score_number;
	}
	public void setScore_number(Double score_number) {
		this.score_number = score_number;
	}

	@Column(name="type_exam" ,nullable = true)
	public String getType_exam() {
		return type_exam;
	}
	public void setType_exam(String type_exam) {
		this.type_exam = type_exam;
	}

	@Column(name="path_file" ,nullable = true)
	public String getPath_file() {
		return path_file;
	}
	public void setPath_file(String path_file) {
		this.path_file = path_file;
	}

	@Column(name="creator" ,nullable = true)
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}

	@Column(name="date_create" ,nullable = true)
	public Date getDate_create() {
		return date_create;
	}
	public void setDate_create(Date date_create) {
		this.date_create = date_create;
	}
	
	@Column(name="note" ,nullable = true)
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
//	public ScoreStudentModel(int id, int regis_exam_id, String student_id, String pass_exam, int status_id,
//			int score_percent, int score_number, String type_exam, String path_file, String creator,
//			Date date_create, String note) {
//		super();
//		this.id = id;
//		this.regis_exam_id = regis_exam_id;
//		this.student_id = student_id;
//		this.pass_exam = pass_exam;
//		this.status_id = status_id;
//		this.score_percent = score_percent;
//		this.score_number = score_number;
//		this.type_exam = type_exam;
//		this.path_file = path_file;
//		this.creator = creator;
//		this.date_create = date_create;
//		this.note = note;
//	}
	
	
}