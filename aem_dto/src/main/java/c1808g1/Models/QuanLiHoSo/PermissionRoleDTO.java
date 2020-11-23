package c1808g1.Models.QuanLiHoSo;


import lombok.Data;

@Data
public class PermissionRoleDTO {
	private int id;
	private int role_id;
	private String controller_id;
	private String list_action;
	public PermissionRoleDTO(int id , int role_id , String controller_id , String list_action) {
		super();
		this.id = id;
		this.role_id = role_id;
		this.controller_id = controller_id;
		this.list_action = list_action;
	}
	public PermissionRoleDTO() {
		super();
	}
	
}
