package c1808g1.aem_api.models.QuanLyHoSo;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fc")
public class FCModel implements Serializable {
		private static final long serialVersionUID = 1L;
		
		@Id
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
	    
	    public FCModel() {}

	    @Column(name="id_fc", nullable = false)
		public String getId_fc() {
			return id_fc;
		}

		public void setId_fc(String id_fc) {
			this.id_fc = id_fc;
		}

		@Column(name="name_fc", nullable = false)
		public String getName_fc() {
			return name_fc;
		}

		public void setName_fc(String name_fc) {
			this.name_fc = name_fc;
		}

		@Column(name="email_fc", nullable = false)
		public String getEmail_fc() {
			return email_fc;
		}

		public void setEmail_fc(String email_fc) {
			this.email_fc = email_fc;
		}

		@Column(name="email_school", nullable = true)
		public String getEmail_school() {
			return email_school;
		}

		public void setEmail_school(String email_school) {
			this.email_school = email_school;
		}

		@Column(name="password", nullable = true)
		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Column(name="phone_fc", nullable = true)
		public String getPhone_fc() {
			return phone_fc;
		}

		public void setPhone_fc(String phone_fc) {
			this.phone_fc = phone_fc;
		}

		@Column(name="color_css", nullable = true)
		public String getColor_css() {
			return color_css;
		}

		public void setColor_css(String color_css) {
			this.color_css = color_css;
		}

		@Column(name="active_account", nullable = true)
		public Boolean getActive_account() {
			return active_account;
		}

		public void setActive_account(Boolean active_account) {
			this.active_account = active_account;
		}

		@Column(name="list_role", nullable = true)
		public String getList_role() {
			return list_role;
		}

		public void setList_role(String list_role) {
			this.list_role = list_role;
		}

		@Column(name="status_id", nullable = true)
		public String getStatus_id() {
			return status_id;
		}

		public void setStatus_id(String status_id) {
			this.status_id = status_id;
		}

		@Column(name="start_date", nullable = true)
		public Date getStart_date() {
			return start_date;
		}

		public void setStart_date(Date start_date) {
			this.start_date = start_date;
		}

		@Column(name="end_date", nullable = true)
		public Date getEnd_date() {
			return end_date;
		}

		public void setEnd_date(Date end_date) {
			this.end_date = end_date;
		}

		@Column(name="note_status", nullable = true)
		public String getNote_status() {
			return note_status;
		}

		public void setNote_status(String note_status) {
			this.note_status = note_status;
		}

		public FCModel(String id_fc, String name_fc, String email_fc, String email_school, String password, String phone_fc,
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
	    
	}