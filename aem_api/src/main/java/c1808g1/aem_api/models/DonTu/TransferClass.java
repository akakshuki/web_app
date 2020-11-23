package c1808g1.aem_api.models.DonTu;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="transfer_class")
public class TransferClass {
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
	
	public TransferClass() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="student_id",nullable=false)
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	@Column(name="class_transfer",nullable=false)
	public String getClasstransfer() {
		return classtransfer;
	}
	public void setClasstransfer(String classtransfer) {
		this.classtransfer = classtransfer;
	}
	@Column(name="subject_id",nullable=false)
	public String getSubjectid() {
		return subjectid;
	}
	public void setSubjectid(String subjectid) {
		this.subjectid = subjectid;
	}
	@Column(name="number_transfer",nullable=false)
	public int getNumbertransfer() {
		return numbertransfer;
	}
	public void setNumbertransfer(int numbertransfer) {
		this.numbertransfer = numbertransfer;
	}
	@Column(name="path_file",nullable=true)
	public String getPathfile() {
		return pathfile;
	}
	public void setPathfile(String pathfile) {
		this.pathfile = pathfile;
	}
	@Column(name="creator",nullable=true)
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	@Column(name="date_create",nullable=true)
	public Date getDatecreate() {
		return datecreate;
	}
	public void setDatecreate(Date datecreate) {
		this.datecreate = datecreate;
	}
	@Column(name="confirmed",nullable=true)
	public int getConfirmed() {
		return confirmed;
	}
	public void setConfirmed(int confirmed) {
		this.confirmed = confirmed;
	}
	@Column(name="creator_confirm",nullable=true)
	public String getCreatorconfirm() {
		return creatorconfirm;
	}
	public void setCreatorconfirm(String creatorconfirm) {
		this.creatorconfirm = creatorconfirm;
	}
	@Column(name="date_confirm",nullable=true)
	public Date getDateconfirm() {
		return dateconfirm;
	}
	public void setDateconfirm(Date dateconfirm) {
		this.dateconfirm = dateconfirm;
	}
}
