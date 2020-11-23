package c1808g1.Models.CauHinh;

import lombok.Data;

@Data
public class TagDTO {
	private String id_tag;
	private String name_tag;
	public TagDTO(String id_tag, String name_tag) {
		super();
		this.id_tag = id_tag;
		this.name_tag = name_tag;
	}
	public TagDTO() {
		super();
	}
	
	
	
}
