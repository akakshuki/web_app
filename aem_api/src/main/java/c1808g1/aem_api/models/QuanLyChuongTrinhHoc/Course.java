package c1808g1.aem_api.models.QuanLyChuongTrinhHoc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
	private static final long serialVersionUID = 1L;
	
	
	private String id_course;
	private String name_course;
	private String sort_name;
	private int price_course;
	private String course_root;
	private String note;
	
	public Course() {
		
	}
	
	@Id
	@Column(name = "id_course", nullable = false)
	public String getId_course() {
		return id_course;
	}
	public void setId_course(String id_course) {
		this.id_course = id_course;
	}
	
	
	@Column(name = "name_course", nullable = false)
	public String getName_course() {
		return name_course;
	}
	public void setName_course(String name_course) {
		this.name_course = name_course;
	}
	
	
	@Column(name = "sort_name", nullable = true)
	public String getSort_name() {
		return sort_name;
	}
	public void setSort_name(String sort_name) {
		this.sort_name = sort_name;
	}
	
	
	@Column(name = "price_course", nullable = true)
	public int getPrice_course() {
		return price_course;
	}
	public void setPrice_course(int price_course) {
		this.price_course = price_course;
	}
	
	
	@Column(name = "course_root", nullable = true)
	public String getCourse_root() {
		return course_root;
	}
	public void setCourse_root(String course_root) {
		this.course_root = course_root;
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
