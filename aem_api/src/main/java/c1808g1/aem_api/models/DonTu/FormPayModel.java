package c1808g1.aem_api.models.DonTu;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "form_pay")
public class FormPayModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String class_id;
	private String subject_id;
	private String student_id;
	private Double money;
	private Double money_sku;
	private String type_payment;
	private int type_form;
	private String creator;
	private Date date_create;
	private String note;
	private String path_file;
	private int confirmed;
	private String creator_confirm;
	private Date date_confirm;
	
	public FormPayModel () {}

	@Column(name = "id" , nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "class_id" , nullable = true)
	public String getClass_id() {
		return class_id;
	}

	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}

	@Column(name = "subject_id" , nullable = true)
	public String getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(String subject_id) {
		this.subject_id = subject_id;
	}

	@Column(name = "student_id" , nullable = false)
	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	@Column(name = "money" , nullable = true)
	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	@Column(name = "money_sku" , nullable = true)
	public Double getMoney_sku() {
		return money_sku;
	}

	public void setMoney_sku(Double money_sku) {
		this.money_sku = money_sku;
	}

	@Column(name = "type_payment" , nullable = true)
	public String getType_payment() {
		return type_payment;
	}

	public void setType_payment(String type_payment) {
		this.type_payment = type_payment;
	}

	@Column(name = "type_form" , nullable = true)
	public int getType_form() {
		return type_form;
	}

	public void setType_form(int type_form) {
		this.type_form = type_form;
	}

	@Column(name = "creator" , nullable = true)
	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	@Column(name = "date_create" , nullable = true)
	public Date getDate_create() {
		return date_create;
	}

	public void setDate_create(Date date_create) {
		this.date_create = date_create;
	}

	@Column(name = "note" , nullable = true)
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Column(name = "path_file" , nullable = true)
	public String getPath_file() {
		return path_file;
	}

	public void setPath_file(String path_file) {
		this.path_file = path_file;
	}

	@Column(name = "confirmed" , nullable = true)
	public Integer getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(Integer confirmed) {
		this.confirmed = confirmed;
	}

	@Column(name = "creator_confirm" , nullable = true)
	public String getCreator_confirm() {
		return creator_confirm;
	}

	public void setCreator_confirm(String creator_confirm) {
		this.creator_confirm = creator_confirm;
	}

	@Column(name = "date_confirm" , nullable = true)
	public Date getDate_confirm() {
		return date_confirm;
	}

	public void setDate_confirm(Date date_confirm) {
		this.date_confirm = date_confirm;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public FormPayModel(Integer id, String class_id, String subject_id, String student_id, Double money,
			Double money_sku, String type_payment, int type_form, String creator, Date date_create, String note,
			String path_file, Integer confirmed, String creator_confirm, Date date_confirm) {
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
	
}
