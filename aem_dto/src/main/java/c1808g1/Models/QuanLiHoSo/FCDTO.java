package c1808g1.Models.QuanLiHoSo;

import java.sql.Date;

import lombok.Data;

@Data
public class FCDTO {
	private String id_fc;
	private String name_fc;
	private String email_fc;
	private String email_school;
	private String password;
	private String phone_fc;
	private String color_css;
	private Boolean active_account;
	private String list_role;
	private String status_id;
    private Date start_date;
    private Date end_date;
    private String note_status;
    public FCDTO(String id_fc, String name_fc, String email_fc, String email_school, String password, String phone_fc,
			String color_css, Boolean active_account, String list_role, String status_id, Date start_date,
			Date end_date, String note_status) {
		super();
		this.id_fc = id_fc;
		this.name_fc = name_fc;
		this.email_fc = email_fc;
		this.email_school = email_school;
		this.password = password;
		this.phone_fc = phone_fc;
		this.color_css = color_css;
		this.active_account = active_account;
		this.list_role = list_role;
		this.status_id = status_id;
		this.start_date = start_date;
		this.end_date = end_date;
		this.note_status = note_status;
	}
    public FCDTO() {
    	super();
    }
}
