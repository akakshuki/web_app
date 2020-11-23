package c1808g1.Models.QuanLyChuongTrinhHoc;

import lombok.Data;

@Data
public class SemesterDTO {
	private int id;
	private String name_seme;
	private String course_id;
	private String note;
	public SemesterDTO(int id, String name_seme, String course_id, String note) {
		super();
		this.id = id;
		this.name_seme = name_seme;
		this.course_id = course_id;
		this.note = note;
	}
    public SemesterDTO() {
        super();
    }
}
