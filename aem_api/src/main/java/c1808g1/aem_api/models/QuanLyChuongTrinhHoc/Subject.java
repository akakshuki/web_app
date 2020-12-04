package c1808g1.aem_api.models.QuanLyChuongTrinhHoc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subject")
public class Subject {

	private String id_subject;
	private String name_subject;
	private String sort_name;
	private Double hour_study;
	private int seme_id;
	private int number_session;
	private Double money_subject;
	private int sku_id;
	private int type_subject_id;
	private String note;
	private Double factor;
	private int point;

	public Subject() {

	}

	@Id
	@Column(name = "id_subject", nullable = false)
	public String getId_subject() {
		return id_subject;
	}

	public void setId_subject(String id_subject) {
		this.id_subject = id_subject;
	}

	
	@Column(name = "name_subject", nullable = false)
	public String getName_subject() {
		return name_subject;
	}

	public void setName_subject(String name_subject) {
		this.name_subject = name_subject;
	}

	
	@Column(name = "sort_name", nullable = true)
	public String getSort_name() {
		return sort_name;
	}

	public void setSort_name(String sort_name) {
		this.sort_name = sort_name;
	}

	
	@Column(name = "hour_study", nullable = true)
	public Double getHour_study() {
		return hour_study;
	}

	public void setHour_study(Double hour_study) {
		this.hour_study = hour_study;
	}

	
	@Column(name = "seme_id", nullable = true)
	public int getSeme_id() {
		return seme_id;
	}

	public void setSeme_id(int seme_id) {
		this.seme_id = seme_id;
	}

	
	@Column(name = "number_session", nullable = true)
	public int getNumber_session() {
		return number_session;
	}

	public void setNumber_session(int number_session) {
		this.number_session = number_session;
	}

	
	@Column(name = "money_subject", nullable = true)
	public Double getMoney_subject() {
		return money_subject;
	}

	public void setMoney_subject(Double money_subject) {
		this.money_subject = money_subject;
	}

	
	@Column(name = "sku_id", nullable = true)
	public int getSku_id() {
		return sku_id;
	}

	public void setSku_id(int sku_id) {
		this.sku_id = sku_id;
	}

	
	@Column(name = "type_subject_id", nullable = true)
	public int getType_subjcet_id() {
		return type_subject_id;
	}

	public void setType_subjcet_id(int type_subject_id) {
		this.type_subject_id = type_subject_id;
	}

	
	@Column(name = "note", nullable = true)
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	
	@Column(name = "factor", nullable = true)
	public Double getFactor() {
		return factor;
	}

	public void setFactor(Double factor) {
		this.factor = factor;
	}

	
	@Column(name = "point", nullable = true)
	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}


}
