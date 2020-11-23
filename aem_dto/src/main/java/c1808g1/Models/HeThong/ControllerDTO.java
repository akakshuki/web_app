package c1808g1.Models.HeThong;

import lombok.Data;

@Data
public class ControllerDTO {
	public ControllerDTO(String idcontroller, String namecontroller, Boolean active, String menuroot) {
		super();
		this.idcontroller = idcontroller;
		this.namecontroller = namecontroller;
		this.active = active;
		this.menuroot = menuroot;
	}
	public ControllerDTO() {
		super();
	}
	private String idcontroller;
	private String namecontroller;
	private Boolean active;
	private String menuroot;
}
