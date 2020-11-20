package c1808g1.aem_api.models.DonTu;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="registion_exemption_ms")
public class ExemptionMs {
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
	
	public ExemptionMs() {
		
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
	@Column(name="student_id",nullable=true)
	public String getStudentid() {
		return studentid;
	}
	
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	@Column(name="expiration_date",nullable=true)
	public Date getExpirationdate() {
		return expirationdate;
	}

	public void setExpirationdate(Date expirationdate) {
		this.expirationdate = expirationdate;
	}
	@Column(name="month_start",nullable=true)
	public String getMonthstart() {
		return monthstart;
	}

	public void setMonthstart(String monthstart) {
		this.monthstart = monthstart;
	}
	@Column(name="year_start",nullable=true)
	public String getYearstart() {
		return yearstart;
	}

	public void setYearstart(String yearstart) {
		this.yearstart = yearstart;
	}
	@Column(name="month_end",nullable=true)
	public String getMonthend() {
		return monthend;
	}

	public void setMonthend(String monthend) {
		this.monthend = monthend;
	}
	@Column(name="year_end",nullable=true)
	public String getYearend() {
		return yearend;
	}

	public void setYearend(String yearend) {
		this.yearend = yearend;
	}
	@Column(name="path_file",nullable=true)
	public String getPathfile() {
		return pathfile;
	}

	public void setPathfile(String pathfile) {
		this.pathfile = pathfile;
	}
	@Column(name="note",nullable=true)
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
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
