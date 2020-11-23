package c1808g1.Models.QuanLyChuongTrinhHoc;

import lombok.Data;

@Data
public class CourseDTO {
	private String id_course;
	private String name_course;
	private String sort_name;
	private int price_course;
	private String course_root;
	private String note;
	public CourseDTO(String id_course, String name_course, String sort_name, int price_course, String course_root,
			String note) {
		super();
		this.id_course = id_course;
		this.name_course = name_course;
		this.sort_name = sort_name;
		this.price_course = price_course;
		this.course_root = course_root;
		this.note = note;
	}
    public CourseDTO() {
        super();
    }
}
