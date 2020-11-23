package c1808g1.Models.DonTu;

import java.sql.Date;

import lombok.Data;

@Data
public class RegisExamDTO {
	public RegisExamDTO(int id, String class_id, String subject_id, Date date_exam, int brand_id, int shift_id,
			String note_status, int form_pay_id_refer) {
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
	public RegisExamDTO() {
		super();
	}
	private int id;	
	private String class_id;
	private String subject_id;
	private Date date_exam;
	private int brand_id;
	private int shift_id;
	private String note_status;
	private int form_pay_id_refer;
}

