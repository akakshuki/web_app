package c1808g1.Models.QuanLiHoSo;

import java.sql.Date;

import lombok.Data;

@Data
public class ScoreStudentDTO {
	private Integer id;
	private Integer regis_exam_id;
	private String student_id;
	private String pass_exam;
	private Integer status_id;
	private Integer score_percent;
	private Integer score_number;
	private String type_exam;
	private String path_file;
	private String creator;
	private Date date_create;
	private String note;
	
	public ScoreStudentDTO(Integer id, Integer regis_exam_id, String student_id, String pass_exam, Integer status_id,
			Integer score_percent, Integer score_number, String type_exam, String path_file, String creator,
			Date date_create, String note) {
		super();
		this.id = id;
		this.regis_exam_id = regis_exam_id;
		this.student_id = student_id;
		this.pass_exam = pass_exam;
		this.status_id = status_id;
		this.score_percent = score_percent;
		this.score_number = score_number;
		this.type_exam = type_exam;
		this.path_file = path_file;
		this.creator = creator;
		this.date_create = date_create;
		this.note = note;
	}
	public ScoreStudentDTO() {
		super();
	}
}
