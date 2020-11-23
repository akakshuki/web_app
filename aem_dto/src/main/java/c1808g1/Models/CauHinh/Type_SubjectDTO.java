package c1808g1.Models.CauHinh;

import lombok.Data;

@Data
public class Type_SubjectDTO {
	private int id;
	private String name_type;
	private Boolean active_type;
	public Type_SubjectDTO(int id, String name_type, Boolean active_type) {
		super();
		this.id = id;
		this.name_type = name_type;
		this.active_type = active_type;
	}
	public Type_SubjectDTO() {
		super();
	}
	
	
}
