package c1808g1.Models.QuanLyChuongTrinhHoc;

import lombok.Data;

@Data
public class SubjectDTO {
	private String id_subject;
	private String name_subject;
	private String sort_name;
	private int hour_study;
	private int seme_id;
	private int number_session;
	private String money_subject;
	private String sku_id;
	private String type_subject_id;
	private String note;
	private String factor;
	private int point;
	public SubjectDTO(String id_subject, String name_subject, String sort_name, int hour_study, int seme_id,
			int number_session, String money_subject, String sku_id, String type_subject_id, String note, String factor,
			int point) {
		super();
		this.id_subject = id_subject;
		this.name_subject = name_subject;
		this.sort_name = sort_name;
		this.hour_study = hour_study;
		this.seme_id = seme_id;
		this.number_session = number_session;
		this.money_subject = money_subject;
		this.sku_id = sku_id;
		this.type_subject_id = type_subject_id;
		this.note = note;
		this.factor = factor;
		this.point = point;
	}
	public SubjectDTO() {
		super();
	}
}
