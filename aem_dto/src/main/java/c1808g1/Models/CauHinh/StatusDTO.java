package c1808g1.Models.CauHinh;

import lombok.Data;

@Data
public class StatusDTO {
	private int id;
	private String name_status;
	private int group_type;
	private Boolean active;
	public StatusDTO(int id, String name_status, int group_type, Boolean active) {
		super();
		this.id = id;
		this.name_status = name_status;
		this.group_type = group_type;
		this.active = active;
	}
	public StatusDTO() {
		super();
	}
	
	
}
