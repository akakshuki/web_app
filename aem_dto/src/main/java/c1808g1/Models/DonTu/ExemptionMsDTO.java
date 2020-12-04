package c1808g1.Models.DonTu;

import java.sql.Date;

import lombok.Data;
@Data
public class ExemptionMsDTO {
	private int id;
	private String studentid;
	private Date expirationdate;
	private String monthstart;
	private String yearstart;
	private String monthend;
	private String yearend;
	private String pathfile;
	private String note;
	private String creator;
	private Date datecreate;
	private int confirmed;
	private String creatorconfirm;
	private Date dateconfirm;
	
	public ExemptionMsDTO(int id, String studentid, Date expirationdate, String monthstart, String yearstart,
			String monthend, String yearend, String pathfile, String note, String creator, Date datecreate,
			int confirmed, String creatorconfirm, Date dateconfirm) {
		super();
		this.id = id;
		this.studentid = studentid;
		this.expirationdate = expirationdate;
		this.monthstart = monthstart;
		this.yearstart = yearstart;
		this.monthend = monthend;
		this.yearend = yearend;
		this.pathfile = pathfile;
		this.note = note;
		this.creator = creator;
		this.datecreate = datecreate;
		this.confirmed = confirmed;
		this.creatorconfirm = creatorconfirm;
		this.dateconfirm = dateconfirm;
	}
	public ExemptionMsDTO() {
		super();
	}
}
