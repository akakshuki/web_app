package c1808g1.Models.DonTu;

import java.sql.Date;

import lombok.Data;
@Data
public class FormPayDTO {
	private int id;
	private String class_id;
	private String subject_id;
	private String student_id;
	private int money;
	private int money_sku;
	private String type_payment;
	private String type_form;
	private String creator;
	private Date date_create;
	private String note;
	private String path_file;
	private int confirmed;
	private String creator_confirm;
	private Date date_confirm;
	
	public FormPayDTO(int id, String class_id, String subject_id, String student_id, int money, int money_sku,
			String type_payment, String type_form, String creator, Date date_create, String note, String path_file,
			int confirmed, String creator_confirm, Date date_confirm) {
		super();
		this.id = id;
		this.class_id = class_id;
		this.subject_id = subject_id;
		this.student_id = student_id;
		this.money = money;
		this.money_sku = money_sku;
		this.type_payment = type_payment;
		this.type_form = type_form;
		this.creator = creator;
		this.date_create = date_create;
		this.note = note;
		this.path_file = path_file;
		this.confirmed = confirmed;
		this.creator_confirm = creator_confirm;
		this.date_confirm = date_confirm;
	}
	public FormPayDTO() {
		super();
	}
}
