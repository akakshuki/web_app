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
@Table(name = "score_fc")
public class ScoreFCModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String subject_id;
	private String fc_id;
	private Integer score_percent;
	private Integer score_number;
	private Date date_create;
	
	@Column(name = "id" , nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "subject_id" , nullable = false)
	public String getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(String subject_id) {
		this.subject_id = subject_id;
	}
	
	@Column(name = "fc_id" , nullable = false)
	public String getFc_id() {
		return fc_id;
	}
	public void setFc_id(String fc_id) {
		this.fc_id = fc_id;
	}
	
	@Column(name = "score_percent" , nullable = true)
	public Integer getScore_percent() {
		return score_percent;
	}
	public void setScore_percent(Integer score_percent) {
		this.score_percent = score_percent;
	}
	
	@Column(name = "score_number" , nullable = true)
	public Integer getScore_number() {
		return score_number;
	}
	public void setScore_number(Integer score_number) {
		this.score_number = score_number;
	}
	
	@Column(name = "date_create" , nullable = true)
	public Date getDate_create() {
		return date_create;
	}
	public void setDate_create(Date date_create) {
		this.date_create = date_create;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
//	public ScoreFCModel(Integer id, String subject_id, String fc_id, Integer score_percent, Integer score_number,
//			Date date_create) {
//		super();
//		this.id = id;
//		this.subject_id = subject_id;
//		this.fc_id = fc_id;
//		this.score_percent = score_percent;
//		this.score_number = score_number;
//		this.date_create = date_create;
//	}
	
}
