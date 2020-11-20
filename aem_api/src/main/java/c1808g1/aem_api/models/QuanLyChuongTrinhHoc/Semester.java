package c1808g1.aem_api.models.QuanLyChuongTrinhHoc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "semester")
public class Semester {
	private static final long serialVersionUID = 1L;

	private int id;
	private String name_seme;
	private String course_id;
	private String note;

	public Semester() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "name_seme", nullable = false)
	public String getName_seme() {
		return name_seme;
	}
	public void setName_seme(String name_seme) {
		this.name_seme = name_seme;
	}
	
	@Column(name = "course_id", nullable = true)
	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	
	@Column(name = "note", nullable = true)
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
}
