package c1808g1.Models.DonTu;

import java.sql.Date;


import lombok.Data;
@Data
public class TransferClassDTO {
	private int id;
	private String studentid;
	private String classtransfer;
	private String subjectid;
	private int numbertransfer;
	private String pathfile;
	private String creator;
	private Date datecreate;
	private int confirmed;
	private String creatorconfirm;
	private Date dateconfirm;
	public TransferClassDTO(int id, String studentid, String classtransfer, String subjectid, int numbertransfer,
			String pathfile, String creator, Date datecreate, int confirmed, String creatorconfirm, Date dateconfirm) {
		super();
		this.id = id;
		this.studentid = studentid;
		this.classtransfer = classtransfer;
		this.subjectid = subjectid;
		this.numbertransfer = numbertransfer;
		this.pathfile = pathfile;
		this.creator = creator;
		this.datecreate = datecreate;
		this.confirmed = confirmed;
		this.creatorconfirm = creatorconfirm;
		this.dateconfirm = dateconfirm;
	}

	public TransferClassDTO() {
		super();
	}
}
