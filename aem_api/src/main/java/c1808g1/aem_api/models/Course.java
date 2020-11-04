package c1808g1.aem_api.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Course {
	private static final long serialVersionUID = 1L;
	
	
	private int id_course;
	private String name_sourse;
	private String sort_name;
	private String price_course;
	private String course_root;
	private String note;
	
	public Course() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_course", nullable = false)
	public int getId_course() {
		return id_course;
	}
	public void setId_course(int em)
}
