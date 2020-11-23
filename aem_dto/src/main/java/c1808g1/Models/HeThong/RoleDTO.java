package c1808g1.Models.HeThong;

import lombok.Data;

@Data
public class RoleDTO {
	public RoleDTO(int id, String namerole, boolean allowedit, boolean allowdelete) {
		super();
		this.id = id;
		this.namerole = namerole;
		this.allowedit = allowedit;
		this.allowdelete = allowdelete;
	}
	public RoleDTO() {
		super();
	}
	private int id;
	private String namerole;
	private boolean allowedit;
	private boolean allowdelete;
}
